
/**
 * Date: 3/8/2022
 * This class extends the Exception class and is used to throw exceptions when the stack is empty.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class EmptyStackException extends Exception {
	
	/**
	 * This is a default constructor that allows the user to display an error message for EmptyStackException when the exception is thrown.
	 * @param message
	 * 		A String representing the error message that the user wants to show.
	 */
	public EmptyStackException(String message) {
		super(message);
	}
}
