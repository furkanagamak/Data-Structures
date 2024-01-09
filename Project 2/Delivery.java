
/**
 * Date: 2/22/2022
 * This class describes a Delivery and includes the source of the delivery (String), the destination of the delivery (String), 
 * and the instruction of the delivery (String).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Delivery {
	
	/**
	 * String value for the source of the delivery.
	 */
	private String source;
	/**
	 * String value for the destination of the delivery.
	 */
	private String dest;
	/**
	 * String value for the instruction of the delivery.
	 */
	private String instruction;
	
	/**
	 * This is a no-arg constructor that constructs a new Delivery object. Since this constructor
	 * does not accept any parameters, the source, the destination and the instruction are all set to null.
	 */
	public Delivery() {
		this.source = null;
		this.dest = null;
		this.instruction = null;
	}
	
	/**
	 * This is a constructor that constructs a new Delivery object with the specified source of the delivery.
	 * The destination and the instruction are set to null.
	 * @param source
	 * 		A String representing the source of the delivery.
	 */
	public Delivery(String source) {
		this.source = source;
		this.dest = null;
		this.instruction = null;
	}
	
	/**
	 * This is a constructor that constructs a new Delivery object with the specified source and destination
	 * of the delivery. The instruction is set to null.
	 * @param source
	 * 		A String representing the source of the delivery.
	 * @param dest
	 * 		A String representing the destination of the delivery.
	 */
	public Delivery(String source, String dest) {
		this.source = source;
		this.dest = dest;
		this.instruction = null;
	}
	
	/**
	 * This is a constructor that constructs a new Delivery object with the specified source, destination and
	 * instruction of the delivery.
	 * @param source
	 * 		A String representing the source of the delivery.
	 * @param dest
	 * 		A String representing the destination of the delivery.
	 * @param instruction
	 * 		A String representing the instruction of the delivery.
	 */
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}
	
	/**
	 * Gets the source of the delivery.
	 * @return
	 * 		A String representing the source of the delivery.
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Sets the source of the delivery.
	 * @param source
	 * 		A String representing the source of the delivery.
	 */
	public void setSource(String source) {
		this.source = dest;
	}
	
	/**
	 * Gets the destination of the delivery.
	 * @return
	 * 		A String representing the destination of the delivery.
	 */
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * Sets the destination of the delivery.
	 * @param dest
	 * 		A String representing the destination of the delivery.
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * Gets the instruction of the delivery.
	 * @return
	 * 		A String representing the instruction of the delivery.
	 */
	public String getInstruction() {
		return this.instruction;
	}
	
	/**
	 * Sets the instruction of the delivery.
	 * @param instruction
	 * 		A String representing the instruction of the delivery.
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	/**
	 * This method creates a String representation of the Delivery object which contains its properties.
	 * @return
	 * 		A String representing the source, destination, and instruction of the delivery.
	 */
	public String toString() {
		String str = "To: " + this.getDest() + " | From: " + this.getSource() + "\nInstruction: " + this.getInstruction();
		return str;
	}
}
