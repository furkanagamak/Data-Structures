
/**
 * Date: 3/8/2022
 * This class describes a FollowLink which implements the Command interface. It represents the 
 * “L: FollowLink” command for the Safari application. The class includes the link (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class FollowLink implements Command {
	
	/**
	 * A String representing the link.
	 */
	private String link;
	
	/**
	 * This is a constructor that creates this FollowLink instance accordingly after reading input from the scanner.
	 * @param scanner
	 * 		A Scanner object representing the String that will be inputted as the link.
	 */
	public FollowLink(Scanner scanner) {
		System.out.print("Please enter a link: ");
		this.link = scanner.nextLine();
	}
	
	/**
	 * This method returns whether or not pushing this FollowLink command will be valid for the given stack. The 
	 * FollowLink command cannot be placed on top of an empty stack.
	 * @return
	 * 		True if pushing the FollowLink command is valid for the stack. If not, it returns false.
	 */
	public boolean validCommand(CommandStack stack) {
		if(iCatchUp.option.equals("S")) {
			if(stack.isEmpty()) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Gets the link for this FollowLink.
	 * @return
	 * 		A String representing the link.
	 */
	public String getLink() {
		return this.link;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing FollowLink in a long format for the current screen display.
	 */
	public String toString() {
		String str = "Current Screen: " + this.link;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing FollowLink in a short format for the stack display.
	 */
	public String toShortString() {
		String str = "L:" + this.link;
		return str;
	}
}
