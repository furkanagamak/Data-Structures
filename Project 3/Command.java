
/**
 * Date: 3/8/2022
 * This interface, Command, represents each command that is entered on the phone application.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public interface Command {
	/**
	 * This method returns whether this Command is valid and can be added to the given CommandStack. Specific behavior 
	 * will be outlined in the following classes.
	 * @param stack
	 * 		A CommandStack object representing the given stack.
	 * @return
	 * 		Returns true if this Command is valid and can be added to the given CommandStack. If not, it returns false.
	 */
	public boolean validCommand(CommandStack stack);
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing the Command in a longer format for the current screen display.
	 */
	public String toString();
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing the Command in a shorter format for the stack display.
	 */
	public String toShortString();
}
