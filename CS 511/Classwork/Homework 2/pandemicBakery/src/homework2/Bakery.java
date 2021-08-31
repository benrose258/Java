package homework2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Bakery implements Runnable {
    private static final int TOTAL_CUSTOMERS = 200;
    private static final int ALLOWED_CUSTOMERS = 50;
    private static final int FULL_BREAD = 20;
    private Map<BreadType, Integer> availableBread;
    private ExecutorService executor;
    private float sales = 0;

    public Semaphore shelfAccess = new Semaphore(1); // Create a new semaphore to control access to the bread shelf
    public Semaphore cashiers = new Semaphore(4); // Allow four cashiers to be available for checkout

    /**
     * Remove a loaf from the available breads and restock if necessary
     */
    public void takeBread(BreadType bread) {
    	int breadLeft = availableBread.get(bread);
        if (breadLeft > 0) {
    		availableBread.put(bread, breadLeft - 1);
        } else {
            System.out.println("No " + bread + " bread left! Restocking...");
            // restock by preventing access to the bread stand for some time
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds == 1 second
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            availableBread.put(bread, FULL_BREAD - 1);
        }
        addSales(bread.getPrice()); // Add the value of the purchased bread to the total sales
    }



    /**
     * Add to the total sales
     */
    public void addSales(float value) {
        sales += value;
    }

    public void checkout(float cartValue) { // Check out with the cat value
    	addSales(cartValue); // Add the amount of money obtained from the customer checking out to the total sales
    }

    /**
     * Run all customers in a fixed thread pool
     */
    public void run() {

        availableBread = new ConcurrentHashMap<BreadType, Integer>();
        availableBread.put(BreadType.RYE, FULL_BREAD);
        availableBread.put(BreadType.SOURDOUGH, FULL_BREAD);
        availableBread.put(BreadType.WONDER, FULL_BREAD);

        executor = Executors.newFixedThreadPool(ALLOWED_CUSTOMERS); // Create the executor service with ALLOWED_CUSTOMERS allowed threads running concurrently
        for (int i = 0; i < TOTAL_CUSTOMERS; i++) { // For each of the total customers allowed that day
        	executor.execute(new Customer(this)); // Execute one customer thread
        }

        executor.shutdown(); // Shut down the executor service
        try {
			if (executor.awaitTermination(60, TimeUnit.SECONDS)) { // Wait for all threads to terminate
				// Print total sales for the day and the Bakery's closing message.
				System.out.println("\nThe total money made is \"$" + sales + "\".\nThe bakery is now closed for the day. Thanks for visiting!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
}
