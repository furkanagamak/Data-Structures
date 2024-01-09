
/**
 * Date: 3/22/2022
 * This class describes a PassengerQueue which constructs a queue made up of passengers. It extends LinkedList
 * which is a Java API class. It contains all the regular queue methods.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.LinkedList;

public class PassengerQueue extends LinkedList<Passenger> {
	
	/**
	 * A LinkedList of type Passenger representing the queue.
	 */
	private LinkedList<Passenger> l = new LinkedList<Passenger>();
	
	/**
	 * This is a method that removes the passenger who is in front of the PassengerQueue. 
	 * @return
	 * 		A Passenger object representing the passenger who we removed from the PassengerQueue.
	 */
	public Passenger dequeue() {
		Passenger removedPassenger = this.peek();
		this.removeFirst();
		return removedPassenger;
	}
	
	/**
	 * This is a method that adds the specified passenger to end of the PassengerQueue.
	 * @param p
	 * 		A Passenger object representing the passenger that will be added to the PassengerQueue.
	 */
	public void enqueue(Passenger p) {
		this.addLast(p);
	}
	
	/**
	 * This is a method that gets the passenger who is first in the PassengerQueue.
	 * @return
	 * 		A Passenger object representing the passenger who is first in the PassengerQueue.
	 */
	public Passenger peek() {
		return this.peekFirst();
	}
	
	/**
	 * This is a method that returns whether or not the PassengerQueue is empty.
	 * @return
	 * 		A boolean variable representing whether the PassengerQueue is empty or not.
	 */
	public boolean isEmpty() {
		boolean flag;
		flag = (this.size() == 0) ? true : false;
		return flag;
	}
	
	/**
	 * This is a String representation of the PassengerQueue class. It displays the PassengerQueue with 
	 * each one of the passengers in the queue.
	 * @return
	 * 		A String variable representing the PassengerQueue class.
	 */
	public String toString() {
		String str = "[";
		if (this.size() == 0) {
			str = str + "empty]";
		} 
		else {
			int j = 0;
			while(j < this.size()) {
				str = str + this.get(j).toString();
				str = (j < this.size() - 1) ? (str + ",") : str;
				j++;
			}
		}
		return str;
	}
}
