package anagrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CS 284 Section B
 * Homework 6
 *
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 *
 * @author Ben Rose
 *
 */

public class Anagrams {

	private final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	protected Map<Character, Integer> letterTable;
	protected Map<Long, ArrayList<String>> anagramTable;

	public Anagrams() {
		letterTable = new HashMap<Character, Integer>(); // Initializes letterTable
		anagramTable = new HashMap<Long, ArrayList<String>>(); // Initializes anagramTable
		buildLetterTable();
	}

	public void buildLetterTable() { // Builds letterTable.
		// The keys to which the primes will be associated with \/
		Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		for (int i = 0; i < alphabet.length; i++) { // For the indices in both the prime and alphabet arrays
			letterTable.put(alphabet[i], primes[i]); // Build the letterTable at that value
		}
	}

	public void addWord(String s) {
		Long hash = myHashCode(s); // Get hash of provided word
		if (!anagramTable.containsKey(hash)) { // If the hash code for the word in question doesn't yet exist
			anagramTable.put(hash, new ArrayList<String>()); // Create a blank entry for the given hash
		}
		anagramTable.get(hash).add(s); // Add the word to the ArrayList at the word's hash
	}

	public Long myHashCode(String s) {
		Integer finalKey = 1; // Initialize the key
		for (int i = 0; i < s.length(); i++) { // Search each letter in the string
			finalKey *= letterTable.get(s.charAt(i)); // Multiply the value of the final key by s(i)'s corresponding key's value
		}
		return new Long(finalKey.hashCode()); // Return the hashed value of the final key as the type long
	}

	public ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
		int maxLength = 0; // Initialize comparison of longest list
		ArrayList<Map.Entry<Long, ArrayList<String>>> result = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
			int entryLength = entry.getValue().size();
			if (entryLength > maxLength) { // If the length of the list of values in entry exceeds the current maximum length
				maxLength = entryLength; // Replace the max length with entry's length
				result.clear(); // Remove previous max
				result.add(entry); // Insert entry
			} else if (entryLength == maxLength) { // If there is a tie in the lengths between the current max entry
				result.add(entry); // Add the tied entry
			} // Otherwise, you don't need to do anything
		}
		return result; // And return the result
	}

	public void processFile(String s) throws IOException { // Processes file, given in assignment
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
	}

	public static void main(String[] args) { // Main method, given in assignment
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		try {
			a.processFile("anagram_dict_test.txt"); // Testing with an alternate dictionary
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime / 1000000000);
		System.out.println("Elapsed Time: "+ seconds);
		if (maxEntries.size() > 1) { // If there are multiple maximum anagrams, this fixes the print statement for the keys.
			ArrayList<Long> keys = new ArrayList<Long>();
			for (int i = 0; i < maxEntries.size(); i++) { // For each of the tying hashes
				keys.add(maxEntries.get(i).getKey()); // Add the keys
			}
			System.out.println("Keys of max anagrams: " + keys); // Prints out the list of keys with max lengths.
		} else {
			System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey()); // Otherwise, the key is cleaner like this.
		}
		System.out.println("List of max anagrams: " + maxEntries); // Displays ArrayList with the anagrams corresponding to their keys.
		System.out.println("Length of list of max anagrams: " + maxEntries.get(0).getValue().size()); // Whether it's a tie or just one, the length of the list will be equal.
	}
}
