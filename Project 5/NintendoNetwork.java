
/**
 * Date: 4/5/2022
 * This class describes a NintendoNetwork which takes in a text file, generates a NetworkTree and provides an 
 * interface for a user to manipulate the tree.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class NintendoNetwork {
	
	/**
	 * A NetworkTree object representing the tree of the NintendoNetwork.
	 */
	public static NetworkTree t = new NetworkTree();
	
	/**
	 * The main method runs a menu driven application which first creates a NetworkTree based on the passed in file 
	 * and then prompts the user for a menu command selecting the operation. The required information is then requested 
	 * from the user based on the selected operation.
	 * @param args
	 */
	public static void main(String[] args) {
		NetworkNode n = null;
		String input = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Nintendo Network Manager.");
		System.out.println("\nMenu:");
		System.out.println("\tL) Load from file");
		System.out.println("\tP) Print tree");
		System.out.println("\tC) Move cursor to a child node");
		System.out.println("\tR) Move cursor to root");
		System.out.println("\tU) Move cursor up to parent");
		System.out.println("\tA) Add a child");
		System.out.println("\tX) Remove/Cut Cursor and its subtree");
		System.out.println("\tV) Paste Cursor and its subtree");
		System.out.println("\tS) Save to file");
		System.out.println("\tQ) Quit");
		System.out.println();
		do {
			System.out.print("Please select an option: ");
			input = keyboard.nextLine();
			switch(input.toUpperCase()) {
			
				case "L": // Loads from a file specified by the user.
					System.out.println();
					System.out.print("Please enter the file name: ");
					String name = keyboard.nextLine();
					try {
						System.out.println();
						t = t.readFromFile(name);
						System.out.println(name + " was loaded.");
						System.out.println();
					} catch(InvalidTreeException ex) {
						System.out.println();
						System.out.println("The tree does not exist.");
						System.out.println();
					} catch(InvalidChildException ex) {
						System.out.println();
						System.out.println("The children are invalid.");
						System.out.println();
					} catch(IllegalArgumentException ex) {
						System.out.println();
						System.out.println("The tree is invalid.");
						System.out.println();
					} catch(MaximumTreeException ex) {
						System.out.println();
						System.out.println("The tree is full.");
						System.out.println();
					} catch(FileNotFoundException ex) {
						System.out.println();
						System.out.println(name + " could not be found.");
						System.out.println();
					} catch(VoidPositionException ex) {
						System.out.println();
						System.out.println("There is a void position in the tree.");
						System.out.println();
					}
					System.out.println();
					break;
					
				case "P": // Prints the tree.
					t.displayTree();
					System.out.println();
					break;
					
				case "C": // Moves the cursor to a child node specified by the user.
					System.out.println();
					System.out.print("Please enter the index: ");
					String tempStr = keyboard.nextLine();
					int index = Integer.valueOf(tempStr);
					try {
						t.cursorToChild(index - 1);
						System.out.println();
						System.out.println("Cursor was moved to " + t.getCursor().getName() + ".");
						System.out.println();
					} catch(InvalidTreeException ex) {
						System.out.println();
						System.out.println("The tree is invalid.");
						System.out.println();
					} catch(IllegalArgumentException ex) {
						System.out.println();
						System.out.println("The index you entered is not valid.");
						System.out.println();
					}
					break;
				
				case "R": // Moves the cursor to the root.
					String str = "";
					t.cursorToRoot();
					System.out.println();
					str = (t.getRoot() == null) ? "The tree does not exist." : "Cursor was moved to " + t.getCursor().getName() + ".";
					System.out.println(str);
					System.out.println();
					break;
				
				case "U": // Moves the cursor up to the parent.
					try {
						t.cursorToParent();
						System.out.println();
						System.out.println("Cursor was moved to " + t.getCursor().getName() + ".");
						System.out.println();
					} catch(IllegalCursorException ex) {
						System.out.println();
						System.out.println("The cursor is invalid.");
						System.out.println();
					}
					break;
					
				case "A": // Adds a child specified by the user.
					int theIndex = 0;
					if(t.getCursor() != null) {
						System.out.println();
						System.out.print("Please enter the index: ");
						String tempIndex = keyboard.nextLine();
						theIndex = Integer.valueOf(tempIndex);
					}
					else {
						theIndex = 1;
					}
					System.out.println();
					System.out.print("Please enter the device name: ");
					String device = keyboard.nextLine();
					System.out.println();
					System.out.print("Is this Nintendo? (y/n): ");
					String nintendo = keyboard.nextLine();
					try {
						switch(nintendo.toUpperCase()) {
						
							case "Y": // When the user chooses that the node that will be added will be a Nintendo node. 
								NetworkNode theNode = new NetworkNode(true, device);
								t.addChild(theIndex - 1, theNode);
								t.setCursor(theNode);
								System.out.println();
								System.out.println("Nintendo was added.");
								System.out.println();
								break;
							
							case "N": // When the user chooses that the node that will be added will not be a Nintendo node.
								NetworkNode node = new NetworkNode(false, device);
								t.addChild(theIndex - 1, node);
								t.setCursor(node);
								System.out.println();
								System.out.println("Child was added.");
								System.out.println();
								break;
								
							default: // When the user does not choose Y or N.
								System.out.println("The option you entered is invalid.");
						}
					} catch(IllegalArgumentException ex) {
						System.out.println();
						System.out.println("The index you entered is not valid.");
						System.out.println();
					} catch(MaximumTreeException ex) {
						System.out.println();
						System.out.println("The tree is full.");
						System.out.println();
					} catch(InvalidChildException ex) {
						System.out.println();
						System.out.println("The child can not be added to a Nintendo.");
						System.out.println();
					} catch(VoidPositionException ex) {
						System.out.println();
						System.out.println("Adding a child at this index would create a void position.");
						System.out.println();
					}
					break;
				
				case "X": // Removes and cuts the cursor and its subtree.
					try {
						n = t.cutCursor();
						String theStr = "";
						System.out.println();
						theStr = (t.getRoot() == null) ? n.getName() + " was cut, the tree is empty." : n.getName() + " was cut, the cursor is at " + t.getCursor().getName() + ".";
						System.out.println(theStr);
						System.out.println();
					} catch(InvalidTreeException ex) {
						System.out.println();
						System.out.println("The tree is invalid.");
						System.out.println();
					}
					break;
				
				case "V": // Pastes the cursor and its subtree.
					if(n == null) {
						System.out.println();
						System.out.println("There is nothing to be pasted.");
						System.out.println();
					}
					else {
						System.out.println();
						System.out.print("Please enter the index: ");
						String strIndex = keyboard.nextLine();
						int newIndex = Integer.valueOf(strIndex);
						try {
							if(t.getRoot() == null) {
								if(newIndex == 1) {
									t.addChild(newIndex - 1, n);
									t.setCursor(n);
									System.out.println();
									System.out.println(n.getName() + " was pasted.");
									System.out.println();
									n = null;
								}
								else {
									System.out.println();
									System.out.println("It is not possible to paste.");
									System.out.println();
								}
							}
							else {
								t.addChild(newIndex - 1, n);
								t.setCursor(n);
								System.out.println();
								System.out.println(n.getName() + " was pasted as a child of " + n.getParent().getName() + ".");
								System.out.println();
								n = null;
							}
						} catch(IllegalArgumentException ex) {
							System.out.println();
							System.out.println("The index you entered is not valid.");
							System.out.println();
						} catch(MaximumTreeException ex) {
							System.out.println();
							System.out.println("The tree is full.");
							System.out.println();
						} catch(InvalidChildException ex) {
							System.out.println();
							System.out.println("The child can not be added to a Nintendo.");
							System.out.println();
						} catch(VoidPositionException ex) {
							System.out.println();
							System.out.println("Adding a child at this index would create a void position.");
							System.out.println();
						}
					}
					break;
				
				case "S": // Saves to a file.
					System.out.println();
					System.out.print("Please enter a file name: ");
					String fName = keyboard.nextLine();
					try {
						t.writeToFile(t, fName);
						System.out.println();
						System.out.println("The file was saved.");
						System.out.println();
						
					} catch(IOException ex) {
						System.out.println();
						System.out.println("The file could not be saved.");
						System.out.println();
					}
					break;
				
				case "Q": // Quits the menu.
					System.out.println("\nMake like a tree and leave!");
					break;
				
				default: // When the user does not pick one of the valid menu options.
					System.out.println();
					System.out.println("The option you entered is invalid.");
					System.out.println();
			}
		} while(input.equalsIgnoreCase("Q") == false);
	}
}
