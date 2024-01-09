
/**
 * Date: 3/8/2022
 * This class creates two instances of the Application class and provides an interface for the user to input
 * menu options based on which screen it is currently on (it can be either Home, Maps, or Safari).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class iCatchUp {
	
	/**
	 * A String representing the current option. It can be either Home("H"), Safari("S") or Maps("M).
	 */
	protected static String option = "H";
	
	/**
	 * A Safari object representing the stack for Safari.
	 */
	private static Safari s;
	/**
	 * A Maps object representing the stack for Maps.
	 */
	private static Maps m;
	
	/**
	 * The main method runs a menu driven application which allows the user to create two instances of the Application class 
	 * and then prompts the user for input based on which screen it is currently in (Home, Maps, or Safari). The required 
	 * information for each command is then requested from the user based on the selected operation.
	 * @param args
	 */
	public static void main(String[] args) { 
		String input;
		java.util.Scanner keyboard = new java.util.Scanner(System.in); // // Creates a Scanner object to accept input from the user.
		
		s = new Safari();
		m = new Maps();
		
		System.out.println("Welcome to the iPhony pocket telegraph simulator. You are on the home screen.");
		System.out.println();
		
		while(option.equals("H") || option.equals("M") || option.equals("S")) { // The current screen.
			switch(option) {
				case "H": // Home.
					System.out.println("Home Options:\n\tS - Safari\n\tM - Maps\n\tQ - Quit");
					System.out.print("Please select an option: ");
					input = keyboard.nextLine();
					
					switch(input.toUpperCase()) {
						case "M": // Maps.
							option = "M";
							System.out.println();
							printStack();
							System.out.print(m.stk);
							System.out.println();
							System.out.println(m.stk.getScreenCommand());
							break;
						
						case "S": // Safari.
							option = "S";
							printStack();
							System.out.print(s.stk);
							System.out.println();
							System.out.println(s.stk.getScreenCommand());
							break;
						
						case "Q": // Quit.
							option = "Q";
							System.out.println();
							System.out.println("Sorry to see you go, tell the iPod I said hi!");
							break;
						
						default:
							System.out.println("Please select a valid option.");
					}
					break;
				
				case "S": // Safari.
					System.out.println("Safari Options:\n\tG) Google Something\n\tF) Go to a "
							+ "favorite (bookmark)\n\tL) Follow a link\n\tH) Home Screen\n\tS) Switch to Maps\n\tB) Back");
					System.out.print("Please enter an option: ");
					
					try {
						s.readCommand(keyboard);
						switch(option) {
							case "S": // Safari.
								printStack();
								System.out.print(s.stk);
								System.out.println();
								System.out.println(s.stk.getScreenCommand());
								break;
								
							case "M": // Maps.
								printStack();
								System.out.print(m.stk);
								System.out.println();
								System.out.println(m.stk.getScreenCommand());
								break;
						}
					} catch (EmptyStackException e) {
						System.out.println("The stack is empty.");
						System.out.println();
					} catch (InvalidCommandException e) {
						System.out.println("The option is not valid.");
						System.out.println();
					}
					break;
				
				case "M": // Maps.
					System.out.println("Maps Options:\n\tF) Find a place\n\tP) Plan a route\n\tN) Start Navigation"
							+ "\n\tH) Home Screen\n\tS) Switch to Safari\n\tB) Back");
					System.out.print("Please enter an option: ");
					
					try {
						m.readCommand(keyboard);
						switch(option) {
						case "S": // Safari.
							printStack();
							System.out.print(s.stk);
							System.out.println();
							System.out.println(s.stk.getScreenCommand());
							break;
							
						case "M": // Maps.
							printStack();
							System.out.print(m.stk);
							System.out.println();
							System.out.println(m.stk.getScreenCommand());
							break;
						}
					} catch (EmptyStackException e) {
						System.out.println("No route or destination!");
						System.out.println();
					} catch (InvalidCommandException e) {
						System.out.println("The option is not valid.");
						System.out.println();
					}
			}
		}
	}
	
	/**
	 * This is a method that makes it easier to display Stack Debug and prevents duplicate code.
	 * It displays Stack Debug:[Home-> then either MapsHome or SafariHome based on the screen that
	 * we are currently on.
	 */
	public static void printStack() {
		String str = "Stack Debug:\n[Home->";
		
		if(option.equals("M")) {
			str += "MapsHome";
			
			str = (m.stk.isEmpty()) ? str + "\nCurrent Screen: Maps Home" : str;
		}
		else if(option.equals("S")) {
			str += "SafariHome";
			str = (s.stk.isEmpty()) ? str + "\nCurrent Screen: Safari Home" : str;
		}
		System.out.print(str);
	}
}



