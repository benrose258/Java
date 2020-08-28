package exbook2;

public class Exercise9 {

	private static int runs=0;

	public static void test(int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i%2==0) {
					runs++;
//					System.out.println(i + " " + j);
//					System.out.println(runs);
				}
			}
		}
		System.out.println(runs);
		runs=0;
	}

	public static void main(String[] args) {
		for (int i=2; i<7; i++) {
			System.out.println(i + ": ");
			test(i);
			System.out.println();
		}
	}
}
