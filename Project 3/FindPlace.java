
/**
 * Date: 3/8/2022
 * This class describes a FindPlace which implements the Command interface. It represents the “F: Find a place” 
 * command for the Maps application. The class includes the location of the destination (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class FindPlace implements Command {
	
	/**
	 * A String representing the location of the destination.
	 */
	private String destination;
	
	/**
	 * This is a constructor that creates this FindPlace instance accordingly using the Scanner object.
	 * @param scanner
	 * 		A Scanner object representing the String that will be inputted as the location.
	 */
	public FindPlace(Scanner scanner) {
		System.out.print("Please enter a location: ");
		this.destination = scanner.nextLine();
	}
	
	/**
	 * This method returns whether or not pushing this FindPlace command will be valid for the given stack.
	 * @return
	 * 		True if pushing the FindPlace command is valid for the stack. If not, it returns false.
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
	 * Gets the destination for this FindPlace.
	 * @return
	 * 		A String representing the destination.
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing FindPlace in a long format for the current screen display.
	 */
	public String toString() {
		String str = "Current Screen: Showing results for " + this.destination;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing FindPlace in a short format for the stack display.
	 */
	public String toShortString() {
		String str = "F:" + this.destination;
		return str;
	}
}
