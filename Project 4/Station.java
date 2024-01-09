
/**
 * Date: 3/22/2022
 * This class describes a Station that simulates a station and creates an object that contains two queues, two boolean source 
 * instances - one to generate arrivals for first class, and one to generate arrivals for second class.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Station {
	
	/**
	 * A PassengerQueue object representing the queue of the first class passengers that have been handled.
	 */
	private PassengerQueue theFirstClass = new PassengerQueue();
	/**
	 * A PassengerQueue object representing the queue of the second class passengers that have been handled.
	 */
	private PassengerQueue theSecondClass = new PassengerQueue();
	/**
	 * An int variable representing the time of the simulation. This is innitialized to 0.
	 */
	private int time = 0;
	/**
	 * A PassengerQueue object representing the queue of the first class passengers.
	 */
	private PassengerQueue firstClass = new PassengerQueue();
	/**
	 * A PassengerQueue object representing the queue of the second class passengers.
	 */
	private PassengerQueue secondClass = new PassengerQueue();
	/**
	 * A BooleanSource object representing the arrival of the first class passengers.
	 */
	private BooleanSource firstArrival;
	/**
	 * A BooleanSource object representing the arrival of the second class passengers.
	 */
	private BooleanSource secondArrival;
	/**
	 * A String variable representing the name of the station.
	 */
	private String stationName;
	/**
	 * A boolean variable representing whether the first class passengers arrived or not.
	 */
	private boolean theFirstArrival;
	/**
	 * A boolean variable representing whether the second class passengers arrived or not.
	 */
	private boolean theSecondArrival;
	/**
	 * An int variable representing the id. This is initialized to 1.
	 */
	private int theId = 1;
	
	/**
	 * This is a constructor which constructs a Station object with the specified station name.
	 * @param stationName
	 * 		A String variable representing the name of the station.
	 */
	public Station(String stationName) {
		this.stationName = stationName;
	}
	
	/**
	 * This method handles the arrival of passengers to the stations. It does not have any parameters
	 * and it does not return anything.
	 */
	public void simulateTimeStep() {
		this.theFirstArrival = false;
		this.theSecondArrival = false;
		
		if(this.firstArrival.occurs()) {
			this.theFirstArrival = true;
			Passenger newPassenger = new Passenger();
			newPassenger.setId(this.theId);
			newPassenger.setArrivalTime(this.time);
			newPassenger.setFirstClass(true);
			this.firstClass.enqueue(newPassenger);
			this.theId = this.theId + 1;
		}
		
		if(this.secondArrival.occurs()) {
			this.theSecondArrival = true;
			Passenger newPassenger = new Passenger();
			newPassenger.setId(this.theId);
			newPassenger.setArrivalTime(this.time);
			newPassenger.setFirstClass(false);
			this.secondClass.enqueue(newPassenger);
			this.theId = this.theId + 1;
		}
		
		this.time = this.time + 1;
	}
	
	/**
	 * This is an overloaded method that handles the arrival of passengers to the stations. 
	 * @param stations
	 * 		A Stations object representing a queue of the stations.
	 */
	public void simulateTimeStep(Stations stations) {
		this.theFirstArrival = false;
		this.theSecondArrival = false;
		
		if(this.firstArrival.occurs()) {
			this.theFirstArrival = true;
			Passenger newPassenger = new Passenger();
			this.theId = stations.getId();
			newPassenger.setId(this.theId);
			newPassenger.setArrivalTime(this.time);
			newPassenger.setFirstClass(true);
			this.firstClass.enqueue(newPassenger);
			stations.setId(this.theId + 1);
		}
		
		if(this.secondArrival.occurs()) {
			this.theSecondArrival = true;
			Passenger newPassenger = new Passenger();
			this.theId = stations.getId();
			newPassenger.setId(this.theId);
			newPassenger.setArrivalTime(this.time);
			newPassenger.setFirstClass(false);
			this.secondClass.enqueue(newPassenger);
			stations.setId(this.theId + 1);
		}
		
		this.time = this.time + 1;
	}
	
	/**
	 * This is a method that gets the queue of the first class passengers that have been handled.
	 * @return
	 * 		A PassengerQueue object representing the queue of the first class passengers that have been handled.
	 */
	public PassengerQueue getTheFirstClass() {
		return this.theFirstClass;
	}
	
	/**
	 * This is a method that sets the queue of the first class passengers that have been handled.
	 * @param theFirstClass
	 * 		A PassengerQueue object representing the queue of the first class passengers that have been handled.
	 */
	public void setTheFirstClass(PassengerQueue theFirstClass) {
		this.theFirstClass = theFirstClass;
	}
	
	/**
	 * This is a method that gets the queue of the second class passengers that have been handled.
	 * @return
	 * 		A PassengerQueue object representing the queue of the second class passengers that have been handled.
	 */
	public PassengerQueue getTheSecondClass() {
		return this.theSecondClass;
	}
	
	/**
	 * This is a method that sets the queue of the second class passengers that have been handled.
	 * @param theSecondClass
	 * 		A PassengerQueue object representing the queue of the second class passengers that have been handled.
	 */
	public void setTheSecondClass(PassengerQueue theSecondClass) {
		this.theSecondClass = theSecondClass;
	}
	
	/**
	 * This is a method that gets the time of the simulation.
	 * @return
	 * 		An int variable representing the time.
	 */
	public int getTime() {
		return this.time;
	}
	
	/**
	 * This is a method that sets the time of the simulation.
	 * @param time
	 * 		An int variable representing the time.
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * This is a method that gets the queue of the first class passengers.
	 * @return
	 * 		A PassengerQueue object representing the queue of the first class passengers.
	 */
	public PassengerQueue getFirstClass() {
		return this.firstClass;
	}
	
	/**
	 * This is a method that sets the queue of the first class passengers.
	 * @param firstClass
	 * 		A PassengerQueue object representing the queue of the first class passengers.
	 */
	public void setFirstClass(PassengerQueue firstClass) {
		this.firstClass = firstClass;
	}
	
	/**
	 * This is a method that gets the queue of the second class passengers.
	 * @return
	 * 		A PassengerQueue object representing the queue of the second class passengers.
	 */
	public PassengerQueue getSecondClass() {
		return this.secondClass;
	}
	
	/**
	 * This is a method that sets the queue of the second class passengers.
	 * @param secondClass
	 * 		A PassengerQueue object representing the queue of the second class passengers.
	 */
	public void setSecondClass(PassengerQueue secondClass) {
		this.secondClass = secondClass;
	}
	
	/**
	 * This is a method that gets the arrival of the first class passengers.
	 * @return
	 * 		A BooleanSource object representing the arrival of the first class passengers.
	 */
	public BooleanSource getFirstArrival() {
		return this.firstArrival;
	}
	
	/**
	 * This is a method that sets the arrival of the first class passengers based on the specified probability.
	 * @param probability
	 * 		A double variable representing the probability.
	 */
	public void setFirstArrival(double probability) {
		this.firstArrival = new BooleanSource(probability);
	}
	
	/**
	 * This is a method that gets the arrival of the second class passengers.
	 * @return
	 * 		A BooleanSource object representing the arrival of the second class passengers.
	 */
	public BooleanSource getSecondArrival() {
		return this.secondArrival;
	}
	
	/**
	 * This is a method that sets the arrival of the second class passengers based on the specified probability.
	 * @param probability
	 * 		A double variable representing the probability.
	 */
	public void setSecondArrival(double probability) {
		this.secondArrival = new BooleanSource(probability);
	}
	
	/**
	 * This is a method that gets the name of the station.
	 * @return
	 * 		A String variable representing the name of the station.
	 */
	public String getStationName() {
		return this.stationName;
	}
	
	/**
	 * This is a method that sets the name of the station.
	 * @param stationName
	 * 		A String variable representing the name of the station.
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	/**
	 * This is a method that gets whether the first class passengers arrived or not.
	 * @return
	 * 		A boolean variable representing whether the first class passengers arrived or not.
	 */
	public boolean getTheFirstArrival() {
		return this.theFirstArrival;
	}
	
	/**
	 * This is a method that sets whether the first class passengers arrived or not.
	 * @param theFirstArrival
	 * 		A boolean variable representing whether the first class passengers arrived or not.
	 */
	public void setTheFirstArrival(boolean theFirstArrival) {
		this.theFirstArrival = theFirstArrival;
	}
	
	/**
	 * This is a method that gets whether the second class passengers arrived or not.
	 * @return
	 * 		A boolean variable representing whether the second class passengers arrived or not.
	 */
	public boolean getTheSecondArrival() {
		return this.theSecondArrival;
	}
	
	/**
	 * This is a method that sets whether the second class passengers arrived or not.
	 * @param theSecondArrival
	 * 		A boolean variable representing whether the second class passengers arrived or not.
	 */
	public void setTheSecondArrival(boolean theSecondArrival) {
		this.theSecondArrival = theSecondArrival;
	}
	
	/**
	 * This is a method that gets the id.
	 * @return
	 * 		A String variable representing the id.
	 */
	public int getTheId() {
		return this.theId;
	}
	
	/**
	 * This is a method that sets the id.
	 * @param theId
	 * 		A String variable representing the id.
	 */
	public void setTheId(int theId) {
		this.theId = theId;
	}
	
	/**
	 * This is a String representation of the Station class. It displays the Station with 
	 * the passengers who are arriving and the first class passengers and the second class passengers.
	 * @return
	 * 		A String variable representing the PassengerQueue class.
	 */
	public String toString() {
		String str = "";
		str = (this.theFirstArrival == true) ? str + "First Class Passenger ID " + 
		this.firstClass.peekLast().getId() + " arrives." : str + "No first class passenger arrives.";
		str += "\n";
		str = (this.theSecondArrival == true) ? str + "Second Class Passenger ID " + 
		this.secondClass.peekLast().getId() + " arrives." : str + "No second class passenger arrives.";
		str += "\n";
		str = str + "Queues:\nFirst " + this.firstClass + "\nSecond " + this.secondClass + "\n";
		return str;
	}

}


