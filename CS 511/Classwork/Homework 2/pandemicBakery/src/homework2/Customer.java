package homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Customer implements Runnable {
    private Bakery bakery;
    private Random rnd;
    private List<BreadType> shoppingCart;
    private long shopTime; // Changing to long to properly record time in nanoseconds
    private long checkoutTime; // Changing to long to properly record time in nanoseconds

    /**
     * Initialize a customer object and randomize its shopping cart
     */
    public Customer(Bakery bakery) {
    	this.bakery = bakery; // Set this.bakery equal to bakery
    	rnd = new Random(); // Initialize the new Random for the shopping cart
    	shoppingCart = new ArrayList<BreadType>(); // Initialize the shoppingCart List
    }

    /**
     * Run tasks for the customer
     */
    public void run() {

    	Customer zin = new Customer(bakery); // Initialize the customer
    	long shoppingStartTime = System.nanoTime(); // Start the amount of time it takes to shop
    	zin.fillShoppingCart(); // Fill the shopping cart
    	long shoppingEndTime = System.nanoTime(); // End the amount of time it takes to shop in nanoseconds, since milliseconds always returned 0, since the operation was too fast
    	zin.shopTime = shoppingEndTime - shoppingStartTime; // Set the shopping time equal to however long it takes to shop in nanoseconds, since milliseconds always returned 0, since the operation was too fast
    	long checkoutStartTime = System.nanoTime(); // Start of checkout time in nanoseconds, since milliseconds always returned 0, since the operation was too fast
    	try {
    		zin.bakery.cashiers.acquire(); // Try to get a cashier and wait until one is free
    		System.out.println("Hash code \"" + hashCode() + "\" is checking out."); // Mention that this customer thread is checking out
    	} catch (InterruptedException ie) {
    		ie.printStackTrace();
    	}

    	zin.bakery.checkout(zin.getItemsValue()); // Checkout in the bakery

    	zin.bakery.cashiers.release(); // Cashier is freed up
    	System.out.println("Hash code \"" + hashCode() + "\" is finished checking out.");

    	long checkoutEndTime = System.nanoTime(); // End of checkout time in nanoseconds, since milliseconds always returned 0, since the operation was too fast
    	zin.checkoutTime = checkoutEndTime - checkoutStartTime; // Checkout time total in nanoseconds

    }

    /**
     * Return a string representation of the customer
     */
    public String toString() {
        return "Customer " + hashCode() + ": shoppingCart=" + Arrays.toString(shoppingCart.toArray()) + ", shopTime=" + shopTime + " ms, checkoutTime=" + checkoutTime + "ms";
    }

    /**
     * Add a bread item to the customer's shopping cart
     */
    private boolean addItem(BreadType bread) {
        // do not allow more than 3 items, addItem() does not call more than 3 times
        if (shoppingCart.size() >= 3) {
            return false;
        }
        try {
			bakery.shelfAccess.acquire(); // Restrict access to the shelf while grabbing bread by subtracting 1 from the shelfAccess semaphore (i.e. using acquire())
			System.out.println("Hash code \"" + hashCode() + "\" is accessing the shelf."); // Print message that we are accessing the shelf
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        bakery.takeBread(bread); // Take a piece of bread from the shelf
        bakery.shelfAccess.release(); // Now that access to the shelf is no longer required, allow access to be taken again.
        shoppingCart.add(bread); // Add the taken bread to the shopping cart
        bakery.shelfAccess.release(); // Give access to the shelf back
        System.out.println("Hash code \"" + hashCode() + "\" grabbed a loaf of " + bread + " and has stopped accessing the shelf.");// + " The new sales total is " + sales);
        return true;
    }

    /**
     * Fill the customer's shopping cart with 1 to 3 random breads
     */
    private void fillShoppingCart() {
        int itemCnt = 1 + rnd.nextInt(3);
        while (itemCnt > 0) {
            addItem(BreadType.values()[rnd.nextInt(BreadType.values().length)]);
            itemCnt--;
        }
    }

    /**
     * Calculate the total value of the items in the customer's shopping cart
     */
    private float getItemsValue() {
        float value = 0;
        for (BreadType bread : shoppingCart) {
            value += bread.getPrice();
        }
        return value;
    }
}
