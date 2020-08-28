package longestPalindrome;

public class Solution {

	public static String longestPalindrome(String s) {
		String longest = new String();
		while (s.length() > 0) {
			String current = new String();
			for (int i = 0; i < s.length(); i++) {
				current += s.charAt(i);
				if (isPalindrome(current)) {
					if (current.length() > longest.length()) {
						longest = current;
					}
				}
			}
			current = new String();
			String reducedS = new String();
			for (int i = 1; i < s.length(); i++) {
				reducedS += s.charAt(i);
			}
			s = reducedS;
		}
		return longest;
	}

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
		String s1 = "babad";
		String s2 = "cbbd";
		System.out.println(longestPalindrome(s1));
		System.out.println(longestPalindrome(s2));
	}
}
