package binarynumber;

import java.util.Arrays;

/**
 *
 * @author Ben Rose
 * Homework 1
 * CS 284 Section B
 *
 */

public class BinaryNumber {

	// Variables

	private int data[];
	private static boolean overflow=false;

	// Constructors

	BinaryNumber(int length) {
		data = new int[length];
	}


	BinaryNumber(String s) {
		data = new int[s.length()];
		for (int i=0;i<s.length();i++) {
		data[i] = ((int) s.charAt(i))-48;
		}

	}

	// Methods

	public int getLength() {
		return data.length;
	}

	public int getDigit(int index) {
		return data[index];
	}

	public int toDecimal() {
		int result = 0;
		for (int i=0; i<data.length; i++) {
			if (data[i] == 1) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}

	public void shiftR(int amount) {
		data = reallocate(data,data.length+amount);
	}

	private int[] reallocate(int[] original, int newLength) {
		return java.util.Arrays.copyOf(original, newLength);
	}

	public void add(BinaryNumber bNum) {
		if (data.length != bNum.getLength()) {
			System.out.println("Error: Binary numbers are of different lengths");
		} else {
			String finalString = "";
			int carry = 0;
			for (int i = 0; i<data.length; i++) {
				if ((data[i] + bNum.getDigit(i) + carry) % 2 == 1) {
					carry = 1;
					if (data[i]==bNum.getDigit(i) && data[i] == carry) {
						finalString += "1";
					} else {
						finalString += "0";
					}
				} else {
					carry = 0;
					if (data[i] + bNum.getDigit(i) + carry == 1) {
						finalString += "1";
					} else {
					finalString += "0";
					}
				}
			}
			BinaryNumber result = new BinaryNumber(finalString);
			if (result.getLength() != data.length) {
				overflow = true;
			}
			System.out.println(result);
		}
	}

	public BinaryNumber finalNumber(BinaryNumber bNum) {
		String finalString = "";
		int carry = 0;
		for (int i = 0; i<data.length; i++) {
			if ((data[i] + bNum.getDigit(i) + carry) % 2 == 1) {
				carry = 1;
				if (data[i]==bNum.getDigit(i) && data[i] == carry) {
					finalString += "1";
				} else {
					finalString += "0";
				}
			} else {
				carry = 0;
				if (data[i] + bNum.getDigit(i) + carry == 1) {
					finalString += "1";
				} else {
				finalString += "0";
				}
			}
		}

		BinaryNumber result = new BinaryNumber(finalString);
		return result;
	}

	public void clearOverflow() {
		overflow = false;
	}

	@Override
	public String toString() {
		String finalString = "";
		for (int n:data) {
			finalString += n;
		}
		if (overflow == true) {
			return "Overflow";
		} else {
			return finalString;
		}
	}

	public static void main(String[] args) {
		BinaryNumber b = new BinaryNumber(5);
		b.shiftR(12);
		BinaryNumber bstr = new BinaryNumber("10110");
		BinaryNumber bstr2 = new BinaryNumber("11101");
		BinaryNumber c = new BinaryNumber(6);
		bstr2.add(bstr);
		}

}
