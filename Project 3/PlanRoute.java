
/**
 * Date: 3/8/2022
 * This class describes a PlanRoute which implements the Command interface. It represents the “P: Plan a route” 
 * command for the Maps application. The class includes the location of the source (String) and the location of the 
 * destination (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class PlanRoute implements Command {
	
	/**
	 * A String representing the location of the source.
	 */
	private String source;
	/**
	 * A String representing the location of the destination.
	 */
	private String destination;
	
	/**
	 * This is a constructor that creates this PlanRoute instance accordingly after reading input from the scanner.
	 * @param scanner
	 * 		A Scanner object representing the Strings that will be inputted as the location of the source and 
	 * 		the location of the destination.
	 */
	public PlanRoute(Scanner scanner) {
		System.out.print("Please enter a source: ");
		this.source = scanner.nextLine();
		System.out.print("Please enter a destination: ");
		this.destination = scanner.nextLine();
	}
	
	/**
	 * This method returns whether or not pushing this PlanRoute command will be valid for the given stack.
	 * @return
	 * 		True if pushing the PlanRoute command is valid for the stack. If not, it returns false.
	 */
	public boolean validCommand(CommandStack stack) {
		if(iCatchUp.option.equals("M")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the destination for this PlanRoute.
	 * @return
	 * 		A String representing the destination.
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * Gets the source for this PlanRoute.
	 * @return
	 * 		A String representing the source.
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing PlanRoute in a long format for the current screen display.
	 */
	public String toString() {
		String str = "Current Screen: Planning route from " + this.source + " to " + this.destination;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing PlanRoute in a short format for the stack display.
	 */
	public String toShortString() {
		String str = "P:" + this.source + "-" + this.destination;
		return str;
	}
}
