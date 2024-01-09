
/**
 * Date: 3/22/2022
 * This class describes a Stations which constructs a queue made up of stations. It extends LinkedList
 * which is a Java API class. It contains all the regular queue methods.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.LinkedList;

public class Stations extends LinkedList<Station> {
	
	/**
	 * A LinkedList of type Station representing the queue.
	 */
	private LinkedList<Station> l = new LinkedList<Station>();
	/**
	 * An int variable representing the id. This is initialized to 1.
	 */
	private int id = 1;
	
	/**
	 * This is a method that gets the id.
	 * @return
	 * 		An int variable representing the id.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * This is a method that sets the id.
	 * @param id
	 * 		An int variable representing the id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This is a method that removes the station that is in front of the Stations. 
	 * @return
	 * 		A Station object representing the station that we removed from the Stations.
	 */
	public Station dequeue() {
		return this.removeFirst();
	}
	
	/**
	 * This is a method that adds the specified station to end of the Stations.
	 * @param station
	 * 		A Station object representing the station that will be added to the Stations.
	 */
	public void enqueue(Station station) {
		this.addLast(station);
	}
	
	/**
	 * This is a method that gets the station which is first in the Stations.
	 * @return
	 * 		A Station object representing the passenger which is first in the Stations.
	 */
	public Station peek() {
		return this.peekFirst();
	}
	
	/**
	 * This is a method that returns whether or not the Stations is empty.
	 * @return
	 * 		A boolean variable representing whether the Stations is empty or not.
	 */
	public boolean isEmpty() {
		boolean flag;
		flag = (this.getFirst() == null) ? true : false;
		return flag;
	}
}
