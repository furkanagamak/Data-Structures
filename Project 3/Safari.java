
/**
 * Date: 3/8/2022
 * This class describes a Safari which extends the Application class. It serves as the application for the Safari menu
 * and includes the menu options for Safari.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class Safari extends Application {
	
	/**
	 * This void method reads in input from the scanner then creates a Command and adds it to the CommandStack. After 
	 * determining the type of command, the method uses the command's built-in method to read from the scanner to populate the 
	 * data fields. This method does not return anything.
	 * @param
	 * 		A Scanner object representing user input for the menu options.
	 * @throws InvalidCommandException
	 * 		Throws this exception if the Command is not valid given the current state of the stack.
	 * @throws EmptyStackException
	 * 		Throws this exception when the stack is empty.
	 */
	public void readCommand(Scanner keyboard) throws InvalidCommandException, EmptyStackException {
		Command newCommand = null;
		String input = keyboard.nextLine();
		
		switch(input.toUpperCase()) {
			case "F": // Goes to a favorite bookmark.
				newCommand = new GoToBookmark(keyboard);
				stk.pushCommand(newCommand);
				break;
			
			case "G": // Googles something.
				newCommand = new GoogleSomething(keyboard);
				stk.pushCommand(newCommand);
				break;
			
			case "L": // Follows a link.
				newCommand = new FollowLink(keyboard);
				stk.pushCommand(newCommand);
				break;
				
			case "S": // Switches to Maps.
				iCatchUp.option = "M";
				break;
			
			case "H": // Switches to Home Screen.
				iCatchUp.option = "H";
				break;
			
			case "B": // Goes Back.
				if(!stk.isEmpty()) {
					this.goBack();
				}
				else {
					iCatchUp.option = "H";
				}
				break;
			
			default: 
				throw new InvalidCommandException("");
		}
		
	}
	
	/**
	 * This void method returns the application to the state it was before the last Command. This method does not 
	 * return anything.
	 * @throws EmptyStackException
	 * 		Throws this exception if there was no Command entered.
	 */
	public void goBack() throws EmptyStackException {
		stk.popCommand();
	}
}
