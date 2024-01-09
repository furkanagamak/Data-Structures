
/**
 * Date: 2/8/22
 * This class creates three instances of the Bookshelf object and provides an interface for a user to manipulate the list.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;

public class RipoffRental {
	private static Bookshelf shelfA;
	private static Bookshelf shelfB;
	private static Bookshelf shelfC;
	
	/**
	 * The main method runs a menu driven application which first creates three empty Bookshelves and 
	 * then prompts the user for a menu command selecting the operation. The required information is then 
	 * requested from the user based on the selected operation. 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Creates a Scanner object to take input from the user.
		
		shelfA = new Bookshelf();
		shelfB = new Bookshelf();
		shelfC = new Bookshelf();
		
		String userInput;
		Bookshelf selectedShelf = shelfA;
		System.out.println("Welcome to Jack's aMAzin' Textbook Rentals, highest price guaranteed!");
		System.out.println();
		
		do {
			System.out.println("Menu:");
			System.out.println("     A) Add Book");
			System.out.println("     S) Swap Books");
			System.out.println("     L) Loan Book");
			System.out.println("     R) Remove Book");
			System.out.println("     D) Duplicate Book");
			System.out.println("     C) Change Shelf");
			System.out.println("     O) Overwrite shelf with clone of current shelf");
			System.out.println("     E) Check if two shelves are equal");
			System.out.println("     P) Print current bookshelf");
			System.out.println("     Q) Quit");
			
			System.out.print("Please select an option: ");
			userInput = input.nextLine();
			
			if(userInput.equalsIgnoreCase("A")) {  // Adds a specified book to the specified shelf based on user input.
				System.out.print("Please enter a title: ");
				String title = input.nextLine();
				System.out.print("Please enter an author: ");
				String author = input.nextLine();
				System.out.print("Please enter condition (1-5): ");
				int condition = Integer.parseInt(input.nextLine());
				
				try {
					if (condition < 1 || condition > 5) {
						System.out.println("The number of the condition that you entered is invalid.");
					} 
					else {
						Book b = new Book(title, author, condition);
						System.out.print("Please enter position on shelf: ");
						int position = Integer.parseInt(input.nextLine()) - 1;
						selectedShelf.addBook(position, b);
						System.out.println("Book added!");
						System.out.println();
					}
				} catch (IllegalArgumentException e) {
					System.out.println("The position that you entered would create an empty space in the bookshelf.");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The position that you entered is invalid.");
				} catch (FullShelfException e) {
					System.out.println("The shelf is full, please consider visiting IKEA to get another shelf.");
				}
			} 
			else if(userInput.equalsIgnoreCase("S")) {    // Swaps the specified books on the shelf at the indices 
														  // based on user input. 
				System.out.print("Please enter an index: ");
				int index1 = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter another index: ");
				int index2 = Integer.parseInt(input.nextLine()) - 1;
				
				try {
					selectedShelf.swapBooks(index1, index2);
					Book book1 = selectedShelf.getBook(index1);
					Book book2 = selectedShelf.getBook(index2);
					System.out.println(book2.getTitle() + " has swapped with " + book1.getTitle() + ".");
					System.out.println();
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The position that you entered is invalid.");
				}
			} 
			else if(userInput.equalsIgnoreCase("L")) {   // Loans the book at the specified
														 // index to the specific borrower based on user input.
				System.out.print("Please enter an index: ");
				int index = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter a recipient: ");
				String recipient = input.nextLine();
				System.out.print("Please enter condition (1-5): ");
				int condition = Integer.parseInt(input.nextLine());
				
				try {
					if (condition < 1 || condition > 5) {
						System.out.println("The number of the condition that you entered is invalid.");
					}
					else {
						Book b = selectedShelf.getBook(index);
						b.setBorrower(recipient);
						b.setCondition(condition);
						System.out.println(b.getTitle() + " has been loaned to " + recipient + ".");
						System.out.println();
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The position that you entered is invalid.");
				}
			} 
			else if(userInput.equalsIgnoreCase("R")) {  // Removes the book at the specified index based on user input.
				System.out.print("Please enter an index: ");
				int index = Integer.parseInt(input.nextLine()) - 1;
				
				try {
					selectedShelf.removeBook(index);
				} catch (EmptyShelfException e) {
					System.out.println("The bookshelf is empty.");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The position that you entered is invalid.");
				}
			} 
			else if(userInput.equalsIgnoreCase("D")) {   // Duplicates the book at the specified source index to destination
				                                         // based on user input.
				System.out.print("Please enter a source index: ");
				int sourceIndex = Integer.parseInt(input.nextLine()) - 1;
				System.out.print("Please enter a destination index: ");
				int destinationIndex = Integer.parseInt(input.nextLine()) - 1;
				
				try {
					Book b = selectedShelf.getBook(sourceIndex);
					Book bClone = b.clone();
					selectedShelf.addBook(destinationIndex, bClone);
					System.out.println("A new copy of " + b.getTitle() + " is in index " + destinationIndex + ".");
				} catch (IllegalArgumentException e) {
					System.out.println("The position that you entered would create an empty space in the bookshelf.");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("The position that you entered is invalid.");
				} catch (FullShelfException e) {
					System.out.println("The shelf is full, please consider visiting IKEA to get another shelf.");
				}
			} 
			else if(userInput.equalsIgnoreCase("C")) {  // Changes the shelf that the user is looking at based on user input.
				System.out.print("Please select a shelf to look at: ");
				String shelf = input.nextLine();
				
				if(shelf.equalsIgnoreCase("A")) {
					Bookshelf newSelectedShelf = shelfA;
					selectedShelf = newSelectedShelf;
					System.out.println("Shelf A Selected.");
				}
				
				else if(shelf.equalsIgnoreCase("B")) {
					Bookshelf newSelectedShelf = shelfB;
					selectedShelf = newSelectedShelf;
					System.out.println("Shelf B Selected.");
				}
				
				else if(shelf.equalsIgnoreCase("C")) {
					Bookshelf newSelectedShelf = shelfC;
					selectedShelf = newSelectedShelf;
					System.out.println("Shelf C Selected.");
				}
				
				else {
					System.out.println("The shelf that you selected does not exist in your library.");
				}
			} 
			else if(userInput.equalsIgnoreCase("O")) {  // Overwrites the shelf with the clone of the shelf that the user is
				                                        // looking at.
				String shelf = "";
				
				if (selectedShelf == shelfA) {
					shelf = "Shelf A";
				} 
				else if (selectedShelf == shelfB) {
					shelf = "Shelf B";
				} 
				else if (selectedShelf == shelfC) {
					shelf = "Shelf C";
				}
				
				System.out.print("Please select a shelf to overwrite with the shelf that you are looking at: ");
				String newShelf = input.nextLine();
				
				try {
					if(newShelf.equalsIgnoreCase("A")) {
						if(selectedShelf == shelfA) {
							throw new DuplicateShelfException("The shelf you entered is the same as the shelf you are looking at.");
						}
						shelfA = (Bookshelf) selectedShelf.clone();
					}
					else if(newShelf.equalsIgnoreCase("B")) {
						if(selectedShelf == shelfB) {
							throw new DuplicateShelfException("The shelf you entered is the same as the shelf you are looking at.");
						}
						shelfB = (Bookshelf) selectedShelf.clone();
					}
					else if(newShelf.equalsIgnoreCase("C")) {
						if(selectedShelf == shelfC) {
							throw new DuplicateShelfException("The shelf you entered is the same as the shelf you are looking at.");
						}
						shelfC = (Bookshelf) selectedShelf.clone();
					}
					else {
						throw new FalseShelfException("The shelf that you entered is not one of the shelves.");
					}
					System.out.println("Shelf " + newShelf.toUpperCase() + " was overwritten with a copy of " + shelf + ".");
				} catch (FalseShelfException e) {
					System.out.println("The shelf does not exist.");
				} catch (DuplicateShelfException e) {
					System.out.println("The shelf you entered is the same as the shelf you are looking at.");
				}
			} 
			else if(userInput.equalsIgnoreCase("E")) { // Compares two shelves based on user input.
				System.out.print("Please select a shelf: ");
				String shelf1 = input.nextLine();
				System.out.print("Please select another shelf: ");
				String shelf2 = input.nextLine();
				
				Bookshelf bookshelf1 = new Bookshelf();
				Bookshelf bookshelf2 = new Bookshelf();
				
				if(shelf1.equalsIgnoreCase("A")) {
					bookshelf1 = shelfA;
				}
				
				else if(shelf1.equalsIgnoreCase("B")) {
					bookshelf1 = shelfB;
				}
				
				else if(shelf1.equalsIgnoreCase("C")) {
					bookshelf1 = shelfC;
				}
				else {
					bookshelf1 = null;
					System.out.println("The first shelf that you selected does not exist.");
					System.out.println();
				}
				
				if(shelf2.equalsIgnoreCase("A")) {
					bookshelf2 = shelfA;
				}
				
				else if(shelf2.equalsIgnoreCase("B")) {
					bookshelf2 = shelfB;
				}
				
				else if(shelf2.equalsIgnoreCase("C")) {
					bookshelf2 = shelfC;
				}
				else {
					bookshelf2 = null;
					System.out.println("The second shelf that you selected does not exist.");
					System.out.println();
				}
				if(bookshelf1.equals(bookshelf2)) {
					System.out.println("The shelves are equal.");
				}
				else {
					System.out.println("The shelves are not equal.");
				}
					System.out.println();
			} 
			else if(userInput.equalsIgnoreCase("P")) {  // Prints the bookshelf that the user is looking at.
				String str = "";
				if(selectedShelf == shelfA) {
					str = "Bookshelf A: ";
				}
				else if(selectedShelf == shelfB) {
					str = "Bookshelf B: ";
				}
				else if(selectedShelf == shelfC) {
					str = "Bookshelf C: ";
				}
				System.out.println(str);
				
				String header = String.format("%-6s %-50s %-26s %-5s %s%n", "Spot", "Title", "Author", "Cond.", "Borrower");
				System.out.print(header);
				
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				
				System.out.print(selectedShelf.toString());
			}  
			else if (!userInput.equalsIgnoreCase("Q")) {
				System.out.println("The menu option that you chose is not valid.");
				System.out.println();
				}
		} while(!userInput.equalsIgnoreCase("Q")); // Exits the GUI.
		
		System.out.println();
		System.out.println("Goodbye!");
	}
}