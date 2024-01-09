
/**
 * Date: 3/22/2022
 * This class describes a Train that simulates trains and creates an object that contains a queue of 
 * the stations the train has to visit (at time%5==0, a new station is dequeued, the list of stations is initialized to contain 
 * all the stations on the line, in order). It also contains a method to simulate station arrival, where passengers are dequeued.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Train {
	
	/**
	 * A PassengerQueue object representing the first class passengers that are on board.
	 */
	private PassengerQueue firstPassengersOnBoard = new PassengerQueue();
	/**
	 * A PassengerQueue object representing the second class passengers that are on board.
	 */
	private PassengerQueue secondPassengersOnBoard = new PassengerQueue();
	/**
	 * A Station object that represents the station.
	 */
	private Station theStation;
	/**
	 * An int variable representing the capacity of the first class passengers.
	 */
	public int firstCapacity;
	/**
	 * An int variable representing the capacity of the second class passengers.
	 */
	public int secondCapacity;
	/**
	 * An int variable representing the time until the next arrival.
	 */
	public int timeUntilNextArrival;
	/**
	 * A String variable representing the name of the station.
	 */
	private String sName = "";
	/**
	 * An int variable representing a counter to assist with the simulateTimeStep() method.
	 */
	private int i = 0;
	/**
	 * An int variable representing the time of the simulation.
	 */
	private int time = 0;
	/**
	 * An int variable representing a counter to assist with the simulateTimeStep() method.
	 */
	private int j = 0;
	/**
	 * A boolean variable that represents a flag which is initialized to false.
	 */
	private boolean flag = false;
	/**
	 * A Stations object which represents the queue of the stations.
	 */
	private Stations st = new Stations();
	/**
	 * A PassengerQueue object which represents the queue of the first passengers.
	 */
	private PassengerQueue firstPassengers = new PassengerQueue();
	/**
	 * A PassengerQueue object which represents the queue of the second passengers.
	 */
	private PassengerQueue secondPassengers = new PassengerQueue();
	
	/**
	 * This is a constructor that constructs a Train object with the specified Stations.
	 * @param st
	 * 		A Stations object representing the queue of stations.
	 */
	public Train(Stations st) {
		this.st = st;
		this.theStation = st.peek();
	}
	
	/**
	 * This is a constructor that constructs a Train object with the specified Stations and
	 * name of the station.
	 * @param st
	 * 		A Stations object representing the queue of stations.
	 * @param sName
	 * 		A String variable representing the name of the station.
	 */
	public Train(Stations st, String sName) {
		this.st = st;
		this.sName = sName;
		this.theStation = this.st.peek();
	}
	
	/**
	 * This is a constructor that creates a Train object with the specified Stations, name
	 * of the station, and counter for the simulation.
	 * @param st
	 * 		A Stations object representing the queue of stations.
	 * @param sName
	 * 		A String variable representing the name of the station.
	 * @param j
	 * 		An int variable representing a counter for the simulation.
	 */
	public Train(Stations st, String sName, int j) {
		this.st = st;
		this.sName = sName;
		this.j = j;
		this.theStation = st.peek();
	}
	
	/**
	 * This is a method that Simulates the passing of one time step, and dequeues passengers from stations when 
	 * appropriate. This method does not return anything and it does not take any parameters.
	 */
	public void simulateTimeStep() {
		if(this.j >= 0 && this.i < this.st.size()) {
			this.theStation = this.st.get(this.i);
			if(this.time % 5 == 0) { 
				this.firstPassengersOnBoard.clear();
				this.secondPassengersOnBoard.clear();
				while((this.firstPassengers.size() < this.firstCapacity) && !(this.theStation.getFirstClass().isEmpty())) { 
					Passenger p = this.theStation.getFirstClass().peek();
					this.firstPassengers.enqueue(p);
					p.setInterval(this.time - p.getArrivalTime());
					this.theStation.getTheFirstClass().enqueue(p);
					this.firstPassengersOnBoard.enqueue(p);
					this.theStation.getFirstClass().dequeue();
				}
				while((this.firstPassengers.size() >= this.firstCapacity && !(this.theStation.getFirstClass().isEmpty())) 
						&& (this.secondPassengers.size() < this.secondCapacity)) {
					Passenger p = this.theStation.getFirstClass().peek();
					this.secondPassengers.enqueue(p);
					p.setInterval(this.time - p.getArrivalTime());
					this.theStation.getTheFirstClass().enqueue(p);
					this.secondPassengersOnBoard.enqueue(p);
					this.theStation.getFirstClass().dequeue();
				}
				while((this.secondPassengers.size() < this.secondCapacity) && !(this.theStation.getSecondClass().isEmpty())) {
					Passenger p = this.theStation.getSecondClass().peek();
					p.setInterval(this.time - p.getArrivalTime());
					this.theStation.getTheSecondClass().enqueue(p);
					this.secondPassengersOnBoard.enqueue(p);
					this.secondPassengers.enqueue((this.theStation.getSecondClass()).dequeue());
				}
				this.i = this.i + 1;
			} 
			else { 
				this.timeUntilNextArrival = 5 - (this.time % 5);
			}
		} 
		else if(this.j < 0) { 
			this.timeUntilNextArrival = this.j;
			this.j = this.j + 1;
		} 
		else if(this.i == this.st.size()) { 
			this.flag = true;
		}
		this.time = this.time + 1;
	}
	
	/**
	 * This is a method that gets the queue of the first class passengers.
	 * @return
	 * 		A PassengerQueue object representing the queue of the first class passengers.
	 */
	public PassengerQueue getFirstPassengers() {
		return this.firstPassengers;
	}
	
	/**
	 * This is a method that sets the queue of the first class passengers.
	 * @param firstPassengers
	 * 		A PassengerQueue object representing the queue of the first class passengers.
	 */
	public void setFirstPassengers(PassengerQueue firstPassengers) {
		this.firstPassengers = firstPassengers;
	}
	
	/**
	 * This is a method that gets the queue of the second class passengers.
	 * @return
	 * 		A PassengerQueue object representing the queue of the second class passengers.
	 */
	public PassengerQueue getSecondPassengers() {
		return this.secondPassengers;
	}
	
	/**
	 * This is a method that sets the queue of the second class passengers.
	 * @param secondPassengers
	 * 		A PassengerQueue object representing the queue of the second class passengers.
	 */
	public void setSecondPassengers(PassengerQueue secondPassengers) {
		this.secondPassengers = secondPassengers;
	}
	
	/**
	 * This is a method that gets the queue of the first class passengers who are on board.
	 * @return
	 * 		A PassengerQueue object representing the queue of the first class passengers who are on board.
	 */
	public PassengerQueue getFirstPassengersOnBoard() {
		return this.firstPassengersOnBoard;
	}
	
	/**
	 * This is a method that sets the queue of the first class passengers who are on board.
	 * @param firstPassengersOnBoard
	 * 		A PassengerQueue object representing the queue of the first class passengers who are on board.
	 */
	public void setFirstPassengersOnBoard(PassengerQueue firstPassengersOnBoard) {
		this.firstPassengersOnBoard = firstPassengersOnBoard;
	}
	
	/**
	 * This is a method that gets the queue of the second class passengers who are on board.
	 * @return
	 * 		A PassengerQueue object representing the queue of the second class passengers who are on board.
	 */
	public PassengerQueue getSecondPassengersOnBoard() {
		return this.secondPassengersOnBoard;
	}
	
	/**
	 * This is a method that sets the queue of the second class passengers who are on board.
	 * @param secondPassengersOnBoard
	 * 		A PassengerQueue object representing the queue of the second class passengers who are on board.
	 */
	public void setSecondPassengersOnBoard(PassengerQueue secondPassengersOnBoard) {
		this.secondPassengersOnBoard = secondPassengersOnBoard;
	}
	
	/**
	 * This is a method that gets the capacity of the first class passengers.
	 * @return
	 * 		An int variable representing the capacity of the first class passengers.
	 */
	public int getFirstCapacity() {
		return this.firstCapacity;
	}
	
	/**
	 * This is a method that sets the capacity of the first class passengers.
	 * @param firstCapacity
	 * 		An int variable representing the capacity of the first class passengers.
	 */
	public void setFirstCapacity(int firstCapacity) {
		this.firstCapacity = firstCapacity;
	}
	
	/**
	 * This is a method that gets the capacity of the second class passengers.
	 * @return
	 * 		An int variable representing the capacity of the second class passengers.
	 */
	public int getSecondCapacity() {
		return this.secondCapacity;
	}
	
	/**
	 * This is a method that sets the capacity of the second class passengers.
	 * @param secondCapacity
	 * 		An int variable representing the capacity of the second class passengers.
	 */
	public void setSecondCapacity(int secondCapacity) {
		this.secondCapacity = secondCapacity;
	}
	
	/**
	 * This is a method that gets the flag.
	 * @return
	 * 		A boolean representing the flag.
	 */
	public boolean getFlag() {
		return this.flag;
	}
	
	/**
	 * This is a String representation of the Train class. It displays the Train with the stations,
	 * the passengers who are boarding and details about the trains picking up passengers.
	 * @return
	 * 		A String variable representing the Train class.
	 */
	public String toString() {
		if(this.flag == true) {
			String str = sName + " has stopped picking up passengers.";
			str += "\n";
			return str;
		}
		
		if(this.timeUntilNextArrival + 1 >= 0 && (this.time - 1) % 5 == 0) {
			String str1 = "";
			String str2 = "";
			
			if(firstPassengersOnBoard.isEmpty()) {
				str1 = "none";
			}
			else {
				int k = 0;
				while(k < this.firstPassengersOnBoard.size()) {
					str1 += "P" + (this.firstPassengersOnBoard.get(k)).getId();
					str1 = (k < this.firstPassengersOnBoard.size() - 1) ? str1 + ", " : str1;
					k++;
				}
			}
			if(secondPassengersOnBoard.isEmpty()) {
				str2 = "none";
			}
			else {
				int k = 0;
				while(k < this.secondPassengersOnBoard.size()) {
					str2 += "P" + (this.secondPassengersOnBoard.get(k)).getId();
					str2 = (k < this.secondPassengersOnBoard.size() - 1) ? str2 + ", " : str2;
					k++;
				}
			}
			int num1 = this.firstPassengers.size() - this.firstPassengersOnBoard.size();
			int num2 = this.secondPassengers.size() - this.secondPassengersOnBoard.size();
			String str3 = sName + " arrives at " + theStation.getStationName() + ", there are " + 
			num1 + " passengers in first class and " + num2 + " in second class.\n" + "Passengers embarking in first class: " +
					str1 + "\n" + "Passengers embarking in second class: " + str2 + "\n";
			return str3;
			
		}
		else {
			int t = this.timeUntilNextArrival;
			if(this.timeUntilNextArrival < 0) {
				t *= -1;
			}
			String str4 = sName + " will arrive at " + theStation.getStationName() + " in " + t + " minutes.";
			str4 += "\n";
			return str4;
		}
	}
}

