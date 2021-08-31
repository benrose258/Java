package exbook2;

/*
 * The outer loop will run n times, however the inner loop will only be run when i is an even
 * number, and itself runs n times, which can be denoted by n/2, making the overall notation
 * n * (n)/2, or (n^2)/2.
 */

public class Exercise7 {
	
	public static void test(int n) {
		for(int i=0; i<n; i++) {
			if (i%2==0) {
				for (int j=0; j<n; j++) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		test(7);
	}
}
