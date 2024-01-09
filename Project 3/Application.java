
/**
 * Date: 3/8/2022
 * This abstract class, Application, acts as a base class for the two extending classes Maps and Safari and 
 * contains their member variable(CommandStack stk) and outlines the methods(readCommand(Scanner keyboard) and goBack()) but
 * does not implement them.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public abstract class Application {
	
	/**
	 * An instance of the CommandStack class which represents the stack for the application.
	 */
	CommandStack stk = new CommandStack();
	
	/**
	 * This abstract void method reads in input from the scanner then creates a Command and adds it to the CommandStack. After 
	 * determining the type of command, the method uses the command's built-in method to read from the scanner to populate the 
	 * data fields. This method does not return anything.
	 * @param keyboard
	 * 		A Scanner object representing the inputted String that will be utilized for the Command.
	 * @throws InvalidCommandException
	 * 		Throws this exception if the Command is not valid given the current state of the stack.
	 * @throws EmptyStackException
	 * 		Throws this exception when the stack is empty.
	 */
	public abstract void readCommand(Scanner keyboard) throws InvalidCommandException, EmptyStackException;
	
	/**
	 * This abstract void method returns the application to the state it was before the last Command. This method does not 
	 * return anything.
	 * @throws EmptyStackException
	 * 		Throws this exception if no Command was entered.
	 */
	public abstract void goBack() throws EmptyStackException;
}
