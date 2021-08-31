// Ben Rose
// I pledge my honor that I have abided by the Stevens Honor System.
package homework1;

import java.io.*;
import java.util.*;

public class TextSwap {

    private static String readFile(String filename) throws Exception {
        // Create the temporary storage for each line of the file
        String line;
        // Create the buffer that the file will be read into
        StringBuilder buffer = new StringBuilder();
        // Set the File to be the current directory plus the filename
        File file = new File(System.getProperty("user.dir") + filename);
        // Create the buffered reader for "file"
        BufferedReader br = new BufferedReader(new FileReader(file));
        // While the file has not been completely read, read the next line of the file into the variable "line"
        while ((line = br.readLine()) != null) {
            // Add the current line of the file into the buffer
            buffer.append(line);
        }
        // Close the BufferedReader br
        br.close();
        // Return the string form of the read file
        return buffer.toString();
    }

    private static Interval[] getIntervals(int numChunks, int chunkSize) {
      // The final list of intervals
    	Interval[] myIntervals = new Interval[numChunks];
      // For each interval in the input
    	for (int i = 0; i < numChunks; i++) {
        // Creating i * chunkSize to avoid duplicate calculations
    		int i_times_chunkSize = i * chunkSize;
    		// One of the intervals in the input, from i_times_chunkSize to i_times_chunkSize-1
    		// For example, in an input with chunkSize 4 and file size 20, the intervals would be:
    		// 0 to 3, 4 to 7, 8 to 11, 12 to 15, and 16 to 19. This totals 20, from 0-19 inclusive.
    		Interval oneInterval = new Interval(i_times_chunkSize, (i_times_chunkSize + chunkSize) - 1);
        // (myIntervals at the index i) = (the created interval oneInterval)
    		myIntervals[i] = oneInterval;
    	}
      // Return the final list of intervals
    	return myIntervals;
    }

    private static List<Character> getLabels(int numChunks) {
        Scanner scanner = new Scanner(System.in);
        List<Character> labels = new ArrayList<Character>();
        int endChar = numChunks == 0 ? 'a' : 'a' + numChunks - 1;
        System.out.printf("Input %d character(s) (\'%c\' - \'%c\') for the pattern.\n", numChunks, 'a', endChar);
        for (int i = 0; i < numChunks; i++) {
            labels.add(scanner.next().charAt(0));
        }
        scanner.close();
        System.out.println(labels);
        return labels;
    }

    private static char[] runSwapper(String content, int chunkSize, int numChunks) {
        List<Character> labels = getLabels(numChunks);
        Interval[] intervals = getIntervals(numChunks, chunkSize);
        // 4Order the intervals properly, then run the Swapper instances.
        char[] originalMessage = content.toCharArray();
        char[] swappedMessage = new char[content.length()]; // Creating the final char array of equal length to the content string
        int largestChar = numChunks == 0 ? 'a' : 'a' + numChunks - 1; // Adding largestChar to see if an error should be thrown because the string is out of the char bounds
        for (int i = 0; i < numChunks; i++) {
        	char labelsAtI = labels.get(i); // Initializing a char variable to reduce computations
        	if (labelsAtI > largestChar) { // If the label for the chunk is greater than the potentially allowed labels
        		// Print an error message indicating that the scanned label is invalid, as it would be out of range
        		System.out.printf("Error: the character \"" + labelsAtI + "\" at index " + i + " is larger than the greatest allowed character, \"%c\".\nPlease try again.", largestChar);
        		System.exit(1); // Exit the program indicating that the execution failed.
        	}
        	int whichInterval = labelsAtI - 97; // whichInterval in the list of intervals we should use in our swapped chunks. 97 is the numerical value of the char 'a'.
        	Interval selectedInterval = intervals[whichInterval]; // Creating a variable to store the relevant interval for the used chunk in the swap
        	for (int j = selectedInterval.getX(); j <= selectedInterval.getY(); j++) { // For each value from the lower bound of the selected interval (=x) up to and including the upper bound of the selected interval (=y)
        		swappedMessage[(i * chunkSize) + (j - selectedInterval.getX())] = originalMessage[j]; // Run this line that has its function documented below.
        		// swappedMessage at (i * the size of a chunk) +
        		//					(j, which starts at the beginning of the interval and incremented by 1, - the beginning of the interval)
        		//					= the original message at the "j"th position.
        		// For example, in an input with chunkSize 4, file size 20, and numChunks = 5, the intervals would be:
        		// 0 to 3, 4 to 7, 8 to 11, 12 to 15, and 16 to 19. This totals 20, from 0-19 inclusive.
        		// i would start at 0, and let's assume the selected interval is 12 to 15.
        		// (i * chunkSize) = 0 * 4 = 0, (j - selectedInterval.getX()) = 12 - 12 = 0.
        		// So, swappedMessage at 0 + 0 = swappedMessage[0], which now equals originalMessage[12].
        		// increment j for next iteration. j now equals 13.
        		// (i * chunkSize) = 0 * 4 = 0, (j - selectedInterval.getX()) = 13 - 12 = 1.
        		// So, swappedMessage at 0 + 1 = swappedMessage[1], which now equals originalMessage[13].
        		// Let's go to a different value of i.
        		// Now, in this new case, the intervals and the chunk and file size are the same, but
        		// now i = 2. The selected interval is 16 to 19.
        		// (i * chunkSize) = 2 * 4 = 8, (j - selectedInterval.getX()) = 16 - 16 = 0
        		// So, swappedMessage at 8 + 0 = swappedMessage[8], which now equals originalMessage[16].
        		// increment j for next iteration. j now equals 17.
        		// (i * chunkSize) = 2 * 4 = 8, (j - selectedInterval.getX()) = 17 - 16 = 1
        		// So, swappedMessage at 8 + 1 = swappedMessage[9], which now equals originalMessage[17].
        		// increment j for next iteration. j now equals 18.
        		// (i * chunkSize) = 2 * 4 = 8, (j - selectedInterval.getX()) = 18 - 16 = 2
        		// So, swappedMessage at 8 + 2 = swappedMessage[10], which now equals originalMessage[18].
        		// increment j for next iteration. j now equals 18.
        		// (i * chunkSize) = 2 * 4 = 8, (j - selectedInterval.getX()) = 19 - 16 = 3
        		// So, swappedMessage at 8 + 3 = swappedMessage[11], which now equals originalMessage[19].
        		// Let's go to the edge value of i.
        		// Now, in this new case, the intervals and the chunk and file size are the same, but
        		// now i = 4. The selected interval is 4 to 7.
        		// (i * chunkSize) = 4 * 4 = 16, (j - selectedInterval.getX()) = 4 - 4 = 0
        		// So, swappedMessage at 16 + 0 = swappedMessage[16], which now equals originalMessage[4].
        		// increment j for next iteration. j now equals 5.
        		// (i * chunkSize) = 4 * 4 = 16, (j - selectedInterval.getX()) = 5 - 4 = 1
        		// So, swappedMessage at 16 + 1 = swappedMessage[17], which now equals originalMessage[5].
        		// increment j for next iteration. j now equals 6.
        		// (i * chunkSize) = 4 * 4 = 16, (j - selectedInterval.getX()) = 6 - 4 = 2
        		// So, swappedMessage at 16 + 2 = swappedMessage[18], which now equals originalMessage[6].
        		// increment j for next iteration. j now equals 7.
        		// (i * chunkSize) = 4 * 4 = 16, (j - selectedInterval.getX()) = 7 - 4 = 3
        		// So, swappedMessage at 16 + 3 = swappedMessage[19], which now equals originalMessage[7].
        		// After that value of i, the for loop is complete and the swappedMessage char array will be returned.

        	}
        }
        // Return the text-swapped message
        return swappedMessage;
    }

    private static void writeToFile(String contents, int chunkSize, int numChunks) throws Exception {
        char[] buff = runSwapper(contents, chunkSize, contents.length() / chunkSize);
        System.out.println("Original string (for debugging and visualization): \"" + contents + "\"");
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        writer.print(buff);
        writer.close();
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TextSwap <chunk size> <filename>\n\nNote: filename must be in current working directory with a preceding\n\"\\\" in Windows and a proceeding \"/\" in macOS.");
            return;
        }
        String contents = "";
        int chunkSize = Integer.parseInt(args[0]);
        if (chunkSize < 1) { // If argv[0] is not positive
        	System.out.println("Error: Chunk size must be positive.");
        	return;
        }
        if (chunkSize > 26) { // If argv[0] is greater than 26
        	System.out.println("Error: Chunk size is too large.");
        	return;
        }
        try {
            contents = readFile(args[1]);
            if (contents.length() % chunkSize != 0) { // If the chunk size is not a multiple of the string found in the file
            	System.out.println("Error: The size of the file's string must be a multiple of the chunk size.");
            	return;
            }
            writeToFile(contents, chunkSize, contents.length() / chunkSize);
        } catch (Exception e) {
            System.out.println("Error with IO. Did you check the updated usage message with notes on how to specify the file?");
            return;
        }
    }
}
