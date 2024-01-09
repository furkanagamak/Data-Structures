
/**
 * Date: 4/5/2022
 * This class extends the Exception class and is used to throw exceptions when the cursor is at an illegal index.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class IllegalCursorException extends Exception {
	
	/**
	 * This is a default constructor that allows the user to display an error message for IllegalCursorException when the exception is thrown.
	 * @param message
	 * 		A String representing the error message that the user wants to show.
	 */
	public IllegalCursorException(String message) {
		super(message);
	}
}
