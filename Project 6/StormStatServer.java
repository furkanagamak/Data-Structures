
/**
 * Date: 4/19/2022
 * This class describes a StormStatSaver which lets the user interact with the database of the Storms. A menu-based interface is 
 * provided which lets the user add, remove, and edit the storms. This interface has the ability to to serialize (save) 
 * the database at the end of the program and deserialize (load) the database if a file containing the database already exists. 
 * The database has the storm name as the key and the associated Storm object as the value. The storm names are converted to uppercase
 * String values.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.*;
import java.io.*;

public class StormStatServer {
	/**
	 * A static HashMap representing the database of the Storm objects.
	 */
	static HashMap<String, Storm> db;
	
	/**
	 * The main method which takes in user input and lets the user interact with the database of the Storms. On startup, the main 
	 * method checks to see if the file hurricane.ser exists in the current directory. If it does, then the file is loaded and 
	 * deserialized into the database instance. If the file does not exist, a new HashMap is created and used instead. 
	 * In either case, the user is able to fully interact with the StormStatServer without issues.
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "";
		boolean flag = true;
		Scanner keyboard = new Scanner(System.in); // Creating a Scanner object to take input from the user.
		System.out.println("Welcome to the StormStatServer, we may not be able to make it rain, "
				+ "but we sure can tell you when it happened!");
		System.out.println();
		try {
			FileInputStream f = new FileInputStream("hurricane.ser"); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions.
			ObjectInputStream o = new ObjectInputStream(f); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions. They were applied to this homework's specifications.
			System.out.println();
			try {
				db = (HashMap<String, Storm>) o.readObject(); // This line was taken from Professor Esmaili's examples in Homework 6 instructions. It was applied to this homework's specifications.
				System.out.println();
				System.out.println("The file hurricane.ser was found and loaded.");
				System.out.println();
			} catch(IOException exception) {
				System.out.println();
				System.out.println("There was an error reading the file.");
				System.out.println();
			} catch(ClassNotFoundException exception) {
				System.out.println();
				System.out.println("The class was not found.");
				System.out.println();
			}
			o.close();
		} catch(FileNotFoundException exception) {
			db = new HashMap<String, Storm>(); 
			System.out.println();
			System.out.println("No previous data was found.");
			System.out.println();
		} catch(IOException exception) {
			System.out.println();
			System.out.println("There was an error with the input or output of the file.");
			System.out.println();
		}
		System.out.println("Menu:");
		System.out.println("\tA) Add A Storm");
		System.out.println("\tL) Look Up A Storm");
		System.out.println("\tD) Delete A Storm");
		System.out.println("\tE) Edit Storm Data");
		System.out.println("\tR) Print Storms Sorted By Rainfall");
		System.out.println("\tW) Print Storms by Windspeed");
		System.out.println("\tX) Save and quit");
		System.out.println("\tQ) Quit and delete saved data");
		
		do {
			System.out.println();
			System.out.print("Please enter an option: ");
			input = keyboard.nextLine();
			System.out.println();
			switch(input.toUpperCase()) {
				
				case "A": // Adds a storm specified by the user.
					String n = "";
					String d = "";
					System.out.print("Please enter the name: ");
					n = keyboard.nextLine();
					n = n.toUpperCase();
					if(db.containsKey(n) == false) {
						System.out.println();
						System.out.print("Please enter the date: ");
						d = keyboard.nextLine();
						if(isProperDate(d)) { // Checks if the entered date is valid.
							double p;
							System.out.println();
							System.out.print("Please enter the precipitation in cm: ");
							String temp = keyboard.nextLine();
							p = Double.valueOf(temp);
							if(p >= 0) { // Checks if the entered precipitation is valid.
								double wSpeed;
								System.out.println();
								System.out.print("Please enter the windspeed in km/h: ");
								String tempStr = keyboard.nextLine();
								wSpeed = Double.valueOf(tempStr);
								if(wSpeed >= 0) { // Checks if the entered windspeed is valid.
									String sName = "";
									Storm theStorm = new Storm(d, n, wSpeed, p);
									sName = theStorm.getName();
									System.out.println();
									System.out.println("The storm " + sName + " was added.");
									System.out.println();
									db.put(sName, theStorm);
								}
								else {
									System.out.println();
									System.out.println("The windspeed can not be a negative value.");
									System.out.println();
								}
							}
							else {
								System.out.println();
								System.out.println("The precipitation can not be a negative value.");
								System.out.println();
							}
						}
						else {
							System.out.println();
							System.out.println("The date of the storm was not inputted in the correct format which is YYYY-MM-DD.");
							System.out.println();
						}
					}
					else {
						System.out.println();
						System.out.println("The storm with the name " + n + " already exists.");
						System.out.println();
					}
					break;
				
				case "L": // Looks up a storm specified by the user.
					String theName = "";
					System.out.println();
					System.out.print("Please enter the name: ");
					theName = keyboard.nextLine();
					theName = theName.toUpperCase();
					if(db.get(theName) == null) {
						System.out.println("\nThe storm " + theName + " could not be found.\n");
					}
					else {
						System.out.println("\nStorm " + db.get(theName));
					}
					break;
				
				case "D": // Deletes a storm specified by the user.
					String removedName = "";
					System.out.println();
					System.out.print("Please enter the name: ");
					removedName = keyboard.nextLine();
					removedName = removedName.toUpperCase();
					if(db.get(removedName) == null) {
						System.out.println("\nThe storm " + removedName + " could not be found.\n");
					}
					else {
						System.out.println();
						System.out.println("The storm " + removedName + " was found and deleted.");
						System.out.println();
						db.remove(removedName);
					}
					break;
				
				case "E": // Allows the user to edit the data of a storm specified by the user.
					String editName = "";
					System.out.println();
					System.out.print("Please enter the name: ");
					editName = keyboard.nextLine();
					editName = editName.toUpperCase();
					boolean theFlag;
					if(db.get(editName) == null) {
						System.out.println();
						System.out.println("The storm " + editName + " could not be found.");
						System.out.println();
					}
					else {
						String theDate = "";
						System.out.println();
						System.out.println("In the edit mode, please press enter without any input to leave the storm data unchanged.");
						System.out.println();
						System.out.print("Please enter the date: ");
						theDate = keyboard.nextLine();
						if(theDate.equals("")) {
							theFlag = true;
						}
						else if(!isProperDate(theDate)) { // Checks if the entered date is valid.
							theFlag = false;
							System.out.println();
							System.out.println("The date of the storm was not inputted in the correct format which is YYYY-MM-DD.");
							System.out.println();
						}
						else {
							theFlag = true;
							db.get(editName).setDate(theDate);
						}
						
						if(theFlag == true) {
							String tempPrecip = "";
							System.out.println();
							System.out.print("Please enter the precipitation in cm: ");
							tempPrecip = keyboard.nextLine();
							if(tempPrecip.equals("") == false) {
								double precip;
								precip = Double.valueOf(tempPrecip);
								if(precip >= 0) { // Checks if the entered precipitation is valid.
									theFlag = true;
									db.get(editName).setPrecip(precip);
								}
								else {
									theFlag = false;
									System.out.println();
									System.out.println("The precipitation can not be a negative value.");
									System.out.println();
								}
							}
						}
						if(theFlag == true) {
							String tempWspeed = "";
							System.out.println();
							System.out.print("Please enter the windspeed in km/h: ");
							tempWspeed = keyboard.nextLine();
							if(tempWspeed.equals("") == false) {
								double windSpeed;
								windSpeed = Double.valueOf(tempWspeed);
								if(windSpeed >= 0) { // Checks if the entered windspeed is valid.
									theFlag = true;
									db.get(editName).setWspeed(windSpeed);
								}
								else {
									theFlag = false;
									System.out.println();
									System.out.println("The windspeed can not be a negative value.");
									System.out.println();
								}
							}
						}
						
						if(theFlag == true) {
							System.out.println();
							System.out.println("The storm " + editName + " was edited.");
							System.out.println();
						}
					}
					break;
					
				case "R": // Allows the user to print the storms sorted by their rainfall.
					String str = "";
					int l = 0;
					Collection<Storm> collectionStorms = db.values();
					ArrayList<Storm> storms = new ArrayList<Storm>(collectionStorms); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions.
					System.out.println();
					Collections.sort(storms, new PrecipitationComparator()); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions. They were applied to this homework's specifications.
					System.out.printf("%-24s %-15s %-12s %s%n", "Name", "Windspeed", "RainFall", "Date");
					System.out.println("------------------------------------------------------------------");
					while(l < storms.size()) {
						str += String.format("%-24s %-15s %-12s %s%n", storms.get(l).getName(), storms.get(l).getWspeed(),
								storms.get(l).getPrecip(), storms.get(l).getDate());
						l = l + 1;
					}
					System.out.println(str);
					break;
				
				case "W": // Allows the user to print the storms sorted by their windspeed.
					String theStr = "";
					int a = 0;
					Collection<Storm> colStorms = db.values();
					ArrayList<Storm> theStorms = new ArrayList<Storm>(colStorms); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions.
					System.out.println();
					Collections.sort(theStorms, new WindSpeedComparator()); // These two lines were taken from Professor Esmaili's examples in Homework 6 instructions. They were applied to this homework's specifications.
					System.out.printf("%-24s %-15s %-12s %s%n", "Name", "Windspeed", "RainFall", "Date");
					System.out.println("------------------------------------------------------------------");
					while(a < theStorms.size()) {
						theStr += String.format("%-24s %-15s %-12s %s%n", theStorms.get(a).getName(), theStorms.get(a).getWspeed(),
								theStorms.get(a).getPrecip(), theStorms.get(a).getDate());
						a = a + 1;
					}
					System.out.println(theStr);
					break;
					
				case "X": // Saves the file and quits the program.
					try {
						FileOutputStream f = new FileOutputStream("hurricane.ser"); // These four lines were taken from Professor Esmaili's examples in Homework 6 instructions.
						ObjectOutputStream o = new ObjectOutputStream(f); // These four lines were taken from Professor Esmaili's examples in Homework 6 instructions.
						o.writeObject(db); // These four lines were taken from Professor Esmaili's examples in Homework 6 instructions.
						o.close(); // These four lines were taken from Professor Esmaili's examples in Homework 6 instructions. They were applied to this homework's specifications.
						flag = false;
						System.out.println();
						System.out.println("The file was saved to hurricane.ser. Please feel free to use the weather channel "
								+ "in the meantime.");
						System.out.println();
					} catch(FileNotFoundException exception) {
						System.out.println();
						System.out.println("The file was not found.");
						System.out.println();
					} catch(IOException exception) {
						System.out.println();
						System.out.println("There was an error with the input or output of the file.");
						System.out.println();
					}
					break;
					
				case "Q": // Deletes the saved data and quits the program.
					flag = false;
					System.out.println();
					System.out.println("Goodbye, it's hard to hold an (electric) candle in the cold November (and April!) rain!.");
					System.out.println();
					File dFile = new File("hurricane.ser");
					dFile.delete();
					break;
				
				default: // When the user does not pick one of the valid menu options.
					System.out.println();
					System.out.println("The option you entered is invalid.");
					System.out.println();
			}
			
		}while(flag == true);
    }
	
	/**
	 * This is a method that allows the StormStatServer to check if the date that the user entered
	 * is in the proper date format(YYYY--MM-DD), and returns a boolean value based on this check.
	 * @param date
	 * 		A String variable representing the date of the storm that the user inputted.
	 * @return
	 * 		This method returns false if the entered date is in the wrong format, and returns true
	 * 		if the entered date is in the proper format which is YYYY-MM-DD.
	 */
	private static boolean isProperDate(String date) {
		boolean flag = true;
		String[] dates = date.split("-", 3);
		int len0 = dates[0].length();
		int len = dates.length;
		if(len != 3 || len0 != 4 || date == null) {
			return false;
		}
		int len1 = dates[1].length();
		int len2 = dates[2].length();
		if(((len2 == 2 || len2 == 1) && (len1 == 2 || len1 == 1)) == false) {
			return false;
		}
		int j = 0;
		while(j < len0) {
			if(Character.isDigit(dates[0].charAt(j)) == true) {
				
			}
			else {
				return false;
			}
			j = j + 1;
		}
		int m;
		m = Integer.valueOf(dates[1]);
		flag = (m > 12 || m < 1) ? false : flag;
		int d;
		d = Integer.valueOf(dates[2]);
		flag = (d > 31 || d < 1) ? false : flag;
		
		return flag;
	}
}
