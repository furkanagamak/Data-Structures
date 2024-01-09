
/**
 * Date: 3/22/2022
 * This is the main driver class which imitates the LIRR. It simulates trains that arrive at stations based on the probabilities
 * and other values that the user inputs. It displays the time steps of the simulation and a summary of the simulation at the end.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class LIRRSimulator {
	
	/**
	 * A static boolean variable representing a flag.
	 */
	private static boolean flag = true;
	/**
	 * A static int variable representing the capacity of the first class passengers.
	 */
	private static int theFirstCapacity = 0;
	/**
	 * A static int variable representing the capacity of the second class passengers.
	 */
	private static int theSecondCapacity = 0;
	/**
	 * A static int variable representing the number of passengers.
	 */
	private static int passengerCounter = 0;
	/**
	 * A static int variable representing the number of trains.
	 */
	private static int trains = 0;
	/**
	 * A static int variable that represents the last arrival time of passengers.
	 */
	private static int time = 0;
	/**
	 * An array of type Train representing the trains.
	 */
	private static Train[] t;
	/**
	 * A Station object representing the station of Mineola.
	 */
	private static Station m = new Station("Mineola");
	/**
	 * A Station object representing the station of Hicksville.
	 */
	private static Station hi = new Station("Hicksville");
	/**
	 * A Station object representing the station of Syosset.
	 */
	private static Station s = new Station("Syosset");
	/**
	 * A Station object representing the station of Huntington.
	 */
	private static Station hu = new Station("Huntington");
	
	/**
	 * The main method which takes in user input and makes the simulation of LIRR happen.
	 * @param args
	 */
	public static void main(String[] args) {
		Stations stations = new Stations();
		stations.enqueue(hu);
		stations.enqueue(s);
		stations.enqueue(hi);
		stations.enqueue(m);
		
		System.out.print("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");
		System.out.println();
		java.util.Scanner keyboard = new java.util.Scanner(System.in); // Creating a Scanner object to take input from the user.
		int j = stations.size() - 1;
		while(j >= 0) { // Asks the user for valid probability values.
			System.out.println();
			System.out.println(stations.get(j).getStationName() + ":");
			
			double p1 = 0;
			boolean f1 = false;
			while(!f1) {
				System.out.print("Please enter first class arrival probability: ");
				p1 = keyboard.nextDouble();
				if(p1 > 0.0 && p1 < 1.0) {
					f1 = true;
				}
				else {
					System.out.println();
					System.out.println("Invalid probability entered.");
					System.out.println();
				}
			}
			
			try {
				stations.get(j).setFirstArrival(p1);
			} catch(IllegalArgumentException e) {
				System.out.println();
				System.out.println("Invalid probability entered.");
				System.out.println();
			}
			
			double p2 = 0;
			boolean f2 = false;
			while(!f2) {
				System.out.print("Please enter second class arrival probability: ");
				p2 = keyboard.nextDouble();
				if(p2 > 0.0 && p2 < 1.0) {
					f2 = true;
				}
				else {
					System.out.println();
					System.out.println("Invalid probability entered.");
					System.out.println();
				}
				try {
					stations.get(j).setSecondArrival(p2);
				} catch(IllegalArgumentException e) {
					System.out.println();
					System.out.println("Invalid probability entered.");
					System.out.println();
				}
			}
			j = j - 1;
		}
		System.out.println();
		boolean flag1 = false;
		while(!flag1) { // Asks the user for a valid first class capacity value.
			System.out.print("Please enter first class capacity: ");
			theFirstCapacity = keyboard.nextInt();
			if(theFirstCapacity > 0) {
				flag1 = true;
			}
			else {
				System.out.println();
				System.out.println("Invalid capacity entered.");
				System.out.println();
			}
		}
		System.out.println();
		boolean flag2 = false;
		while(!flag2) { // Asks the user for a valid second class capacity value.
			System.out.print("Please enter second class capacity: ");
			theSecondCapacity = keyboard.nextInt();
			if(theSecondCapacity > 0) {
				flag2 = true;
			}
			else {
				System.out.println();
				System.out.println("Invalid capacity entered.");
				System.out.println();
			}
		}
		System.out.println();
		boolean flag3 = false;
		while(!flag3) { // Asks the user for a valid value for the number of trains.
			System.out.print("Please enter number of trains: ");
			trains = keyboard.nextInt();
			if(trains > 1) {
				flag3 = true;
			}
			else {
				System.out.println();
				System.out.println("Invalid number of trains entered.");
				System.out.println();
			}
		}
		
		t = new Train[trains + 1];
		int i = 0;
		int num = 1;
		while(num <= trains) {
			String str = "Train " + num;
			i = (num == 1) ? 0 : i - 5;
			t[num] = new Train(stations, str, i);
			t[num].setSecondCapacity(theSecondCapacity);
			t[num].setFirstCapacity(theFirstCapacity);
			num++;
		}
		System.out.println();
		
		boolean flag4 = false;
		while(!flag4) { // Asks the user for a valid time for the last arrival of passengers.
			System.out.print("Please enter last arrival time of passengers: ");
			time = keyboard.nextInt();
			if(time > 0) {
				flag4 = true;
			}
			else {
				System.out.println();
				System.out.println("Invalid time entered.");
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Begin Simulation:");
		System.out.println("---------------------------------------------");
		int l = 0;
		while(!t[t.length - 1].getFlag()) { // Runs the simulation until the last train arrives at Mineola.
			System.out.println("Time " + l + ":");
			System.out.println();
			System.out.println("Station overview:");
			int m = stations.size() - 1;
			while(m >= 0) {
				System.out.println();
				System.out.println(stations.get(m).getStationName() + ":");
				if(l > time) {
					stations.get(m).setSecondArrival(0);
					stations.get(m).setFirstArrival(0);
				}
				System.out.println();
				stations.get(m).simulateTimeStep(stations);
				System.out.println();
				System.out.println(stations.get(m));
				m--;
			}
			System.out.println();
			System.out.println("Trains:");
			System.out.println();
			int a = 1;
			while(a <= trains) {
				t[a].simulateTimeStep();
				System.out.println(t[a]);
				a++;
			}
			System.out.println();
			System.out.println("-------");
			l++;
		}
		System.out.println();
		System.out.println("At the end of the simulation: ");
		int f1 = 0;
		int s1 = 0;
		int u = 1;
		while(u <= trains) {
			s1 = s1 + t[u].getSecondPassengers().size();
			f1 = f1 + t[u].getFirstPassengers().size();
			u++;
		}
		int f2 = 0;
		int s2 = 0;
		int n = 0;
		while(n < stations.size()) {
			s2 = s2 + stations.get(n).getSecondClass().size();
			f2 = f2 + stations.get(n).getFirstClass().size();
			n++;
		}
		passengerCounter = f1 + s1;
		System.out.println();
		System.out.print("A total of " + passengerCounter + " passengers were served, "); 
		System.out.print(f2 + " first class passengers were left without a seat, ");
		System.out.print(s2 + " second class passengers were left without a seat.");
		System.out.println();
		System.out.println();
		int g = stations.size() - 1;
		while(g >= 0) { // Displays a summary at the end of the simulation.
			Station newStation = stations.get(g);
			int firstTotal = 0;
			int z = 0;
			while(z < newStation.getTheFirstClass().size()) {
				firstTotal += newStation.getTheFirstClass().get(z).getInterval();
				z++;
			}
			int secondTotal = 0;
			int c = 0;
			while(c < newStation.getTheSecondClass().size()) {
				secondTotal += newStation.getTheSecondClass().get(c).getInterval();
				c++;
			}
			int time1 = 0;
			time1 = (newStation.getTheFirstClass().size() > 0) ? firstTotal / newStation.getTheFirstClass().size() : time1;
			int time2 = 0;
			time2 = (newStation.getTheSecondClass().size() > 0) ? secondTotal / newStation.getTheSecondClass().size() : time2;
			System.out.print("At " + newStation.getStationName() + " " + newStation.getTheFirstClass().size() + " "); 
			System.out.print("first class passengers were served with an average wait time of " + time1 + " min, "); 
			System.out.print(newStation.getTheSecondClass().size() + " second class passengers were served with an average wait time of "); 
			System.out.print(time2 + " min. " + newStation.getFirstClass().size() + " first class passengers and ");
			System.out.print(newStation.getSecondClass().size() + " second class passengers were left without a seat.");
			System.out.println();
			System.out.println();
			g = g - 1;
		}
	}
}