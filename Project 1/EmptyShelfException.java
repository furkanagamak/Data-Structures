/**
 * Date: 2/8/22
 * This class extends the Exception class and is used to throw exceptions when the shelf is empty.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class EmptyShelfException extends Exception {
	/**
	 * This is a default constructor that allows the user to display an error message for EmptyShelfException when the exception is thrown.
	 * @param message
	 * 		The error message that the user wants to show.
	 */
	public EmptyShelfException(String message) {
		super(message);
	}
}
