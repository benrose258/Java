/* start the simulation */

// Ben Rose
// I pledge my honor that I have abided by the Stevens Honor System.
package homework2;

public class Assignment2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Bakery());
        thread.start();
        
        System.out.println("Opening bakery for business!\n");

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
