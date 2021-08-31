package exbook2;

public class Exercise1 {
	
	/*
	 * Answer: (n - 1) * log2(n)
	 * The outer loop runs n-1 times, and for each iteration of the outer loop,
	 * the inner loop runs with j counting in iterations of 2^x where 2^x is
	 * less than n. The form for this loop can be expressed as log2(n).
	 */
	public static void test(int n) {
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j*=2) {
				System.out.println(i + " " + j);
			}
		}
	}
	
	public static void main(String[] args) {
		test(17);
		
	}

}