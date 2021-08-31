package stacks;

import java.util.*;

public class PalindromeChecker {
	private String inputString;
	private Stack<Character> charStack = new Stack<Character>();
	
	public PalindromeChecker(String str) {
		inputString = str;
		fillStack();
	}
	
	private void fillStack() {
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) != ' ') {
				charStack.push(inputString.charAt(i));
			}
		}
	}
	
	private String buildReverse() {
		StringBuilder result = new StringBuilder();
		while (!charStack.empty()) {
			result.append(charStack.pop());
		}
		return result.toString();
	}
	
	public boolean isPalindrome() {
		return inputString.equalsIgnoreCase(this.buildReverse());
	}
	
	public static void main(String[] args) {
		
	}
}
