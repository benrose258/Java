package exbook2;

/*
 * The outer loop will run n times. The inner loop will only run half the time (when i is even)
 * and will run n-1 times when it does, because i runs from 0 to n-1, so the maximum number of
 * times the inner loop will run is n-1 times. The overall formula for this will be
 * n * ((n-1)/2) or ((n^2 - n)/2).
 */

public class Exercise8 {
	
	public static void test(int n) {
		for(int i=0; i<n; i++) {
			if (i%2==0) {
				for (int j=0; j<i; j++) {
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		test(5);
	}
}
