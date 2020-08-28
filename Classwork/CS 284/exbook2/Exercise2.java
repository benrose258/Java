package exbook2;

/*
 * This code will run n-1 times. The outer loop runs n-1 times, and the inner loop
 * just breaks, and doesn't do anything.
 */

public class Exercise2 {
	
	public static void test(int n) {
		for(int i=1; i<n; i++) {
			System.out.println("hi");
			for(int j=1; j<n; j*=2) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		test(5);
	}
}
