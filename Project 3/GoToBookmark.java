
/**
 * Date: 3/8/2022
 * This class describes a GoToBookmark which implements the Command interface. It represents the 
 * “F: Go to favorite/bookmark” command for the Safari application. The class includes the bookmark (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class GoToBookmark implements Command {
	
	/**
	 * A String representing the bookmark.
	 */
	private String bookmark;
	
	/**
	 * This is a constructor that creates this GoToBookmark instance accordingly after reading input from the scanner.
	 * @param scanner
	 * 		A Scanner object representing the String that will be inputted as the bookmark.
	 */
	public GoToBookmark(Scanner scanner) {
		System.out.print("Please enter bookmark name: ");
		this.bookmark = scanner.nextLine();
	}
	
	/**
	 * This method returns whether or not pushing this GoToBookmark command will be valid for the given stack.
	 * @return
	 * 		True if pushing the GoToBookmark command is valid for the stack. If not, it returns false.
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
	 * Gets the bookmark for this GoToBookmark.
	 * @return
	 * 		A String representing the bookmark.
	 */
	public String getBookmark() {
		return this.bookmark;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing GoToBookmark in a long format for the current screen display.
	 */
	public String toString() {
		String str = "Current Screen: Showing results for " + this.bookmark;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing GoToBookmark in a short format for the stack display.
	 */
	public String toShortString() {
		String str = "F:" + this.bookmark;
		return str;
	}
}
