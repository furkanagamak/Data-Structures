
/**
 * Date: 2/22/2022
 * This DeliveryDriver class creates two instances of the DeliveryList class and provides an interface for a user to manipulate 
 * the list by adding, and removing Deliveries.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class DeliveryDriver {
	
		/**
		 * An instance of the DeliveryList class which represents the first driver, Biz Billy.
		 */
		static DeliveryList driver1 = new DeliveryList();
		/**
		 * An instance of the DeliveryList class which represents the second driver, Money Mike.
		 */
		static DeliveryList driver2 = new DeliveryList();
		
		/**
		 * The main method runs a menu driven application which first creates an empty DeliveryList and then prompts the user 
		 * for a menu command selecting the operation. The required information is then requested from the user based on the 
		 * selected operation. 
		 * @param args
		 */
		public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in); // Creates a Scanner object to accept input from the user.
			Delivery d = null;
			String input;
			DeliveryList driver = driver1;
			
			
			System.out.println("Welcome to the Delinquent Dollar Delivery Scheduler.\n");
			
			do {
				System.out.println("Menu:\n     "
						+ "A) Add a Delivery After Cursor\n     "
						+ "R) Remove Delivery At Cursor\n     "
						+ "X) Cut Cursor\n     "
						+ "V) Paste After Cursor\n     "
						+ "H) Cursor to Head\n     "
						+ "T) Cursor to Tail\n     "
						+ "F) Cursor Forward\n     "
						+ "B) Cursor Backward\n     "
						+ "S) Switch Delivery Lists\n     "
						+ "P) Print current List\n     "
						+ "Q) Quit\n");
				System.out.print("Please select an option: ");
				
				input = keyboard.nextLine();
				switch(input.toUpperCase()) {
				
					case "A": // Adds a delivery after the cursor.
						System.out.print("Please enter a source: ");
						String source = keyboard.nextLine();
						System.out.print("Please enter a destination: ");
						String destination = keyboard.nextLine();
						System.out.print("Please enter any special instructions: ");
						String instructions = keyboard.nextLine();
						System.out.println();
						
						try {
							driver.insertAfterCursor(new Delivery(source, destination, instructions));
							System.out.println("Order inserted.\n");
						} catch(IllegalArgumentException e) {
							System.out.println("The order doesn't exist.\n");
						}
						break;
					
					case "R": // Removes the delivery at the cursor.
						try {
							Delivery removedDelivery = driver.removeCursor();
							String str = removedDelivery.getDest();
							System.out.println("\nDelivery to " + str + " removed.\n");
						} catch(EndOfListException e) {
							System.out.println("The cursor is invalid.\n");
						}
						break;
						
					case "X": // Cuts the cursor.
						try {
							d = driver.removeCursor();
							System.out.println("\nThe cursor is cut.\n");
						} catch(IllegalArgumentException e) {
							System.out.println("The cursor is invalid.\n");
						} catch(EndOfListException e) {
							System.out.println("The cursor is invalid.\n");
						}
						break;
					
					case "V": // Pastes after the cursor. Inserts the last object to be cut after the cursor - there is a nothing 
							  // to paste message in case the user tries to paste a delivery without first doing a cut operation.
						try {
							driver.insertAfterCursor(d);
							d = null;
						} catch(IllegalArgumentException e) {
							System.out.println("Nothing to paste.\n");
						}
						break;
					
					case "H": // Moves the cursor to the head.
						driver.resetCursorToHead();
						if(driver.getCursor() == null) {
							System.out.println("The head doesn't exist.\n");
						}
						else {
							System.out.println("The cursor is at the head.\n");
						}
						break;
					
					case "T": // Moves the cursor to the tail.
						driver.resetCursorToTail();
						if(driver.getCursor() == null) {
							System.out.println("The tail doesn't exist.\n");
						}
						else {
							System.out.println("The cursor is at the tail.\n");
						}
						break;
					
					case "F": // Moves the cursor forward.
						try {
							driver.cursorForward();
							System.out.println("\nThe cursor moved forward.\n");
						} catch(EndOfListException e) {
							System.out.println("The cursor is at the tail.\n");
						}
						break;
					
					case "B": // Moves the cursor backward.
						try {
							driver.cursorBackward();
							System.out.println("\nThe cursor moved backward.\n");
						} catch(EndOfListException e) {
							System.out.println("The cursor is at the head.\n");
						}
						break;
					
					case "S": // Switches the delivery lists.
						driver = (driver == driver1) ? driver2 : driver1;
						System.out.println((driver == driver1) ? "\nBiz Billy's list is selected.\n" : "\nMoney Mike's list is selected.\n");
						break;
					
					case "P": // Prints the current delivery list.
						System.out.println((driver == driver1) ? "\nBiz Billy's Deliveries: " : "\nMoney Mike's Deliveries: ");
						System.out.println("----------------------------------------------------------");
						System.out.print(driver);
						System.out.println("----------------------------------------------------------");
						System.out.println();
						break;
					
					case "Q": // Exits the menu.
						System.out.print("\nNext time, try UPS!");
						break;
					
					default: // Displays an error message in case the user does not enter one of the valid menu options.
						System.out.println("The option that you entered is invalid.\n");
				}
			} while(!input.equalsIgnoreCase("q"));
		}
}
