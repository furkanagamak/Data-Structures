
/**
 * Date: 3/8/2022
 * This class describes a CommandStack and includes a stack (LinkedList) to represent the commands for 
 * the application. The stack is implemented by extending Java's LinkedList.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.util.LinkedList;

public class CommandStack extends LinkedList<Command> {
	
	/**
	 * A LinkedList of the Command type that represents the stack.
	 */
	private LinkedList<Command> l = new LinkedList<Command>();
	
	/**
	 * This void method pushes the specified command onto the top of the backing data structure. The method ensures that
	 * Safari commands are not placed on top of the Map commands and vice versa. The method does not return anything.
	 * @param command
	 * 		A Command object representing the indicated Command that will be pushed onto top of the CommandStack. 
	 * @throws InvalidCommandException
	 * 		Throws this exception if the Command is invalid given the current state of this CommandStack.
	 */
	public void pushCommand(Command command) throws InvalidCommandException {
		if(command.validCommand(this)) {
			this.l.addFirst(command);
		}
		else {
			System.out.println();
			throw new InvalidCommandException("The command is invalid.");
		}
	}
	
	/**
	 * This method returns the topmost Command from the stack without removing it. The stack is not changed 
	 * as a result of the method.
	 * @return
	 * 		A Command object representing the topmost Command from the stack.
	 * @throws EmptyStackException
	 * 		Throws this exception if the stack is empty.
	 */
	public Command peekCommand() throws EmptyStackException {
		if(!this.l.isEmpty()) {
			return this.l.peek();
		}
		System.out.println();
		throw new EmptyStackException("");
	}
	
	/**
	 * This method removes the topmost Command from the stack and returns it.
	 * @return
	 * 		A Command object representing the topmost Command that was removed from the stack.
	 * @throws EmptyStackException
	 * 		Throws this exception if the stack is empty.
	 */
	public Command popCommand() throws EmptyStackException {
		if(!this.l.isEmpty()) {
			return this.l.removeFirst();
		}
		System.out.println();
		throw new EmptyStackException("");
	}
	
	/**
	 * This method returns true if the stack is empty, false otherwise.
	 * @return
	 * 		Returns true if the stack is empty. If not, it returns false.
	 */
	public boolean isEmpty() {
		return this.l.isEmpty();
	}
	
	/**
	 * This method returns a String representation of the Command that will be displayed on the screen.
	 * @return
	 * 		A String representing the Command to be displayed on the screen.
	 */
	public String getScreenCommand() {
		try {
			return this.peekCommand().toString();
		} catch(EmptyStackException e) {
			System.out.println();
			return("\n");
		}
	}
	
	/**
	 * This method returns a String representation of this CommandStack.
	 * @return
	 * 		A String that represents the stack based on the sample I/O.
	 */
	public String toString() {
		int j = this.l.size() - 1;
		String str = "";
		while(j >= 0) {
			str += "->" + this.l.get(j).toShortString();
			j--;
		}
		return str;
	}
}

