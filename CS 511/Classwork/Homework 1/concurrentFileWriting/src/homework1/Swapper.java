package homework1;

public class Swapper implements Runnable {
    private int offset;
    private Interval interval;
    private String content;
    private char[] buffer;
	private boolean waiting;

    public Swapper(Interval interval, String content, char[] buffer, int offset, boolean waiting) {
        this.offset = offset;
        this.interval = interval;
        this.content = content;
        this.buffer = buffer;
        this.waiting = waiting;
    }

    @Override
    public void run() {
      // For each value from the lower bound of the selected interval (i.e. x) up to and including the upper bound of the selected interval (i.e. y)
    	for (int j = interval.getX(); j <= interval.getY(); j++) {
        // Run this line that has its function documented below.
    		buffer[(offset * interval.getY() - interval.getX()) + (j - interval.getX())] = content.charAt(j);
     		// swappedMessage at (offset * the size of a chunk (i.e. the size of an interval)) +
     		//					(j, which starts at the beginning of the interval and incremented by 1, - the beginning of the interval)
     		//					= the original message at the "j"th position.
     		// Now, since this was written for TextSwap.java's runSwapper function, define the following variables
    		// provided to the statement as follows:
    		// "offset" = "i", "interval" = "selectedInterval", "content.charAt(j)" = "originalMessage[j]",
    		// and "buffer" = "swappedMessage".

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
      // Set the variable equal to false
    	waiting = false;
    }
}
