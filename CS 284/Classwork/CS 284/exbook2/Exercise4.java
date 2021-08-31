package exbook2;

/*
 * This loop will run 9n times. The outer loop runs n times, with the final case being i=0, and the inner
 * loop runs 9 times when executed, j=9, j=8... to j=1.
 */

public class Exercise4 {
	
	public static void test(int n) {
		for(int i=n-1; i>=0; i--) {
			for(int j=9; j>0; j--) {
				System.out.println(i + " " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		test(2);
	}
}
