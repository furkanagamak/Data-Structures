
/**
 * Date: 3/22/2022
 * This class describes a Passenger which creates an object that has an integer interval, an integer id, an integer 
 * arrival time, and a boolean for isFirstClass. The class has methods that allow the user to manipulate 
 * the instance variables (such as getters and setters).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Passenger {
	
	/**
	 * An int variable representing the interval that the passenger waits. This is initialized to -1.
	 */
	private int interval = -1;
	/**
	 * An int variable representing the id of the passenger.
	 */
	private int id;
	/**
	 * An int variable representing the arrival time of the passenger.
	 */
	private int arrivalTime;
	/**
	 * A boolean variable representing whether the passenger is first class or not.
	 */
	private boolean isFirstClass;
	
	/**
	 * This is a method that gets the interval that the passenger waits.
	 * @return
	 * 		An int variable representing the interval.
	 */
	public int getInterval() {
		return this.interval;
	}
	
	/**
	 * This is a method that sets the interval that the passenger waits.
	 * @param interval
	 * 		An int variable representing the interval.
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	/**
	 * This is a method that gets the id of the passenger.
	 * @return
	 * 		An int variable representing the id.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * This is a method that sets the id of the passenger.
	 * @param id
	 * 		An int variable representing the id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This is a method that gets the arrival time of the passenger.
	 * @return
	 * 		An int variable representing the arrival time.
	 */
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * This is a method that sets the arrival time of the passenger.
	 * @param arrivalTime
	 * 		An int variable representing the arrival time.
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * This is a method that returns a boolean based on whether the passenger is first class or not.
	 * @return
	 * 		A boolean variable representing whether the passenger is first class or not.
	 */
	public boolean getIsFirstClass() {
		return this.isFirstClass;
	}
	
	/**
	 * This is a method that sets whether the passenger is first class or not.
	 * @param isFirstClass
	 * 		A boolean variable representing whether the passenger is first class or not.
	 */
	public void setFirstClass(boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}
	
	/**
	 * This is a String representation of the Passenger class. It displays the Passenger with its id
	 * and arrival time.
	 * @return
	 * 		A String variable representing the Passenger class.
	 */
	public String toString() {
		String str = "P" + this.id + "@T" + this.arrivalTime;
		return str;
	}
}