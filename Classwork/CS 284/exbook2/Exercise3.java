package exbook2;

/*
 * The outer loop will run n-1 times, and the inner loop will run n-2 times. When i=n-2, the
 * inner loop runs once. When i=n-3, the loop runs twice, and so on. Therefore, this loop runs
 * (n-1)(n-2) times, better expressed as n^2 - 3n + 2 times.
 */

public class Exercise3 {
	
	public static void test(int n) {
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>i; j--) {
				System.out.println(i + " " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		test(5);
	}
}