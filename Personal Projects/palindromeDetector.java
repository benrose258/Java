
public class Temp<E extends Comparable<E>> {

	private static boolean isPalindrome(String s) {
		String checkAgainst = new String();
		for (int i = s.length() - 1; i >= 0; i--) {
			checkAgainst += s.charAt(i);
		}
		return stringEqual(s,checkAgainst);
	}

	private static boolean stringEqual(String s1, String s2) {
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "aba";
		System.out.println(isPalindrome(s1));
	}
}
