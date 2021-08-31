package queues;

import java.util.*;

public class Passenger {
	
	/* Data Fields */
	
	// The Passenger's ID number
	private int passengerId;
	// Time needed to process this passenger
	private int processingTime;
	// Time this passenger arrives
	private int arrivalTime;
	// The maximum time to process a passenger
	private static int maxProcessingTime;
	// The sequence number for passengers
	private static int idNum=0;
	
	/** Create a new passenger.
	@param arrivalTime: The time this passenger arrives*/
	public Passenger(int arrivalTime) {
		this.arrivalTime = arrivalTime;
		processingTime = 1+(new Random()).nextInt(maxProcessingTime);
		passengerId = idNum++;
	}
	
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	public int getProcessingTime() {
		return this.processingTime;
	}
	
	public int getId() {
		return this.passengerId;
	}
	
	public static void setMaxProcessingTime(int maxProcessTime) {
		maxProcessingTime = maxProcessTime;
	}
}
