
/**
 * Date: 3/8/2022
 * This class describes a StartNavigation which implements the Command interface. It represents the 
 * “N: Start Navigation” command for the Maps application. The class includes the location of the source (String) 
 * and the location of the destination (String), which are both initially null since there is no source
 * or destination entered.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class StartNavigation implements Command {
	
	/**
	 * A String representing the location of the source.
	 */
	private String source = null;
	/**
	 * A String representing the location of the destination.
	 */
	private String destination = null;
	
	/**
	 * This is a constructor that creates this StartNavigation instance accordingly after grabbing 
	 * navigation information from the last instruction.
	 * @param commandStack
	 * 		A CommandStack object representing the stack that the command will be pushed to.
	 * @throws EmptyStackException
	 * 		Throws this exception when the stack is empty.
	 */
	public StartNavigation(CommandStack commandStack) throws EmptyStackException {
		if(commandStack.peekCommand() != null) {
			if(commandStack.peekCommand() instanceof PlanRoute) {
				this.destination = ((PlanRoute)commandStack.peekCommand()).getDestination();
				this.source = ((PlanRoute)commandStack.peekCommand()).getSource();
				
			}
			else if(commandStack.peekCommand() instanceof FindPlace) {
				this.destination = ((FindPlace)commandStack.peekCommand()).getDestination();
			}
		}
	}
	
	/**
	 * This method returns whether or not pushing this StartNavigation command will be valid for the given 
	 * stack. The StartNavigation command cannot be placed on top of another StartNavigation command or an 
	 * empty stack.
	 * @return
	 * 		True if pushing the StartNavigation command is valid for the stack. If not, it returns false.
	 */
	public boolean validCommand(CommandStack stack) {
		try {
			if(iCatchUp.option.equals("M")) {
				if(stack.peekCommand() instanceof StartNavigation) {
					return false;
				} 
				else {
					return true;
				}
			}
			else {
				return false;
			}
		} catch(EmptyStackException e){
			return false;
		}
	}
	
	/**
	 * Gets the destination for this StartNavigation.
	 * @return
	 * 		A String representing the destination.
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * Gets the source for this StartNavigation.
	 * @return
	 * 		A String representing the source.
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * This method returns a String representation of this Command in a long form for the current screen display.
	 * @return
	 * 		A String representing StartNavigation in a long format for the current screen display.
	 */
	public String toString() {
		String str = (this.source == null) ? "Current Screen: Navigating to " + this.destination : 
			"Current Screen: Navigating from " + this.source + " to " + this.destination;
		return str;
	}
	
	/**
	 * This method returns a String representation of this Command in a short form for the stack display.
	 * @return
	 * 		A String representing StartNavigation in a short format for the stack display.
	 */
	public String toShortString() {
		String str = (this.source == null) ? "N:" + this.destination : "N:" + this.source + "-" + this.destination;
		return str;
	}
}
