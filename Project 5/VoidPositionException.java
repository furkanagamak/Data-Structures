
/**
 * Date: 4/5/2022
 * This class extends the Exception class and is used to throw exceptions when the tree has a void position.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class VoidPositionException extends Exception {
	
	/**
	 * This is a default constructor that allows the user to display an error message for VoidPositionException when the exception is thrown.
	 * @param message
	 * 		A String representing the error message that the user wants to show.
	 */
	public VoidPositionException(String message) {
		super(message);
	}
}
