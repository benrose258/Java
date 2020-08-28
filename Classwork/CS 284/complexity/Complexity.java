package complexity;

public class Complexity {

	private int n;

	Complexity(int n) {
		this.n = n;
	}

	public int method1() {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				counter++;
				System.out.println("Operation "+counter);
			}
		}
		System.out.println();
		return counter;
	}

	public int method2() {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					counter++;
					System.out.println("Operation "+counter);
				}
			}
		}
		System.out.println();
		return counter;
	}

	// log2(n)
	public int method3() {
		int counter = 0;
		for (int i=1; i<n; i*=2) {
			counter++;
		}
		return counter;
	}

	public int method4() {
		int counter = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 1; j < n; j *= 2) {
				counter++;
				System.out.println("Operation "+counter);
			}
		}
		System.out.println();
		return counter;
	}

	// log2(log2(n))
	public int method5() {
		int counter = 0;
		for (int i = 1; i<this.method3(); i*=2) {
			counter++;
			System.out.println("Operation "+counter);
		}
		System.out.println();
		return counter;
	}

	public static void main(String[] args) {
		Complexity test = new Complexity(256);
		System.out.println(test.method5());
	}

}
