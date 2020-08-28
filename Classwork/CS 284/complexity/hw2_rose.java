package complexity;

/*
 * Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

public class hw2_rose {

	// O(n^2)
	public static void method1(int n) {
		int counter=0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				counter++;
				System.out.println("Operation "+counter);
			}
		}
	}

	// O(log n)
	// Log base: 2
	public static void method2(int n) {
		int counter=0;
		for (int i=1; i<n; i *= 2) {
			counter++;
			System.out.println("Operation "+counter);
		}
	}

	// O(n log n)
	// Log base: 2
	public static void method3(int n) {
		int counter=0;
		for (int i=0; i<n; i++) {
			for (int j=1; j<n; j *= 2) {
				counter++;
				System.out.println("Operation "+counter);
			}
		}
	}

	// O(n^3)
	public static void method4(int n) {
		int counter=0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					counter++;
					System.out.println("Operation "+counter);
				}
			}
		}
	}

	// O(log log n)
	// Log base: 2
	public static void method5(int n) {
		int counter=0;
		for (int i=1; i*i<n; i *= 2) {
			counter++;
			System.out.println("Operation "+counter);
		}
	}

	// O(2^n)
	public static void method6(int n) {
		int counter=0;
		for (int i=0; i<Math.pow(2, n); i++) {
			counter++;
			System.out.println("Operation "+counter);
		}
	}

	public static void main(String[] args) {
		method1(3);
		method2(8);
		method3(5);
		method4(7);
		method5(8);
		method6(4);
	}
}
