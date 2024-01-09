
/**
 * Date: 2/22/2022
 * This class extends the Exception class and is used to throw exceptions when the end of the list is reached.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class EndOfListException extends Exception {
	
	/**
	 * This is a default constructor that allows the user to display an error message for EndOfListException when the exception is thrown.
	 * @param message
	 * 		A String representing the error message that the user wants to show.
	 */
	public EndOfListException(String message) {
		super(message);
	}
}
