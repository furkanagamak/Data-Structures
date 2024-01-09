
/**
 * Date: 3/8/2022
 * This class describes a GoogleSomething which implements the Command interface. It represents the 
 * “G: Google something” command for the Safari application. The class includes the query (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class GoogleSomething implements Command {
	
	/**
	 * A String representing the query.
	 */
	private String query;
	
	/**
	 * This is a constructor that creates this GoogleSomething instance accordingly after reading input from the scanner.
	 * @param scanner
	 * 		A Scanner object representing the String that will be inputted as the query.
	 */
	public GoogleSomething(Scanner scanner) {
		System.out.print("Please enter a query: ");
		this.query = scanner.nextLine();
	}
	
	/**
	 * This method returns whether or not pushing this GoogleSomething command will be valid for the given stack.
	 * @return
	 * 		True if pushing the GoogleSomething command is valid for the stack. If not, it returns false.
	 */
	public boolean validCommand(CommandStack stack) {
		if(iCatchUp.option.equals("S")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the query for this GoogleSomething.
	 * @return
	 * 		A String representing the query.
	 */
	public String getQuery() {
		return this.query;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing GoogleSomething in a long format for the current screen display.
	 */
	public String toString() {
		String str = "Current Screen: Google: " + this.query;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing GoogleSomething in a short format for the stack display.
	 */
	public String toShortString() {
		String str = "G:" + this.query;
		return str;
	}
}
