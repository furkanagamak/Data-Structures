
/**
 * Date: 2/22/2022
 * This class describes a DeliveryList and includes a counter for the total number of deliveries (int), the head 
 * reference (DeliveryListNode), the tail reference (DeliveryListNode) and the cursor reference (DeliveryListNode).
 * This class implements a double linked-list data structure and maintains a list of Deliveries by chaining a series 
 * of DeliveryListNodes between a head and a tail reference. In addition, a cursor is provided to allow a user to 
 * traverse the list, selecting individual DeliveryListNodes to allow for insertion, deletion, and manipulation of 
 * the Deliveries they contain.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class DeliveryList {
	
	/**
	 * int value for the total number of deliveries.
	 */
	private int deliveries = 0;
	/**
	 * DeliveryListNode object for the head which references the first node in the list.
	 */
	private DeliveryListNode head;
	/**
	 * DeliveryListNode object for the tail which references the last node in the list.
	 */
	private DeliveryListNode tail;
	/**
	 * DeliveryListNode object for the cursor which points to one of the nodes of the list.
	 */
	private DeliveryListNode cursor;
	
	/**
	 * This is a default constructor that initializes this object to an empty list of Deliveries.
	 * Postconditions: - This DeliveryList has been initialized with head, tail, and cursor all set to null.
	 */
	public DeliveryList() {
		this.head = null;
		this.tail = null;
		this.cursor = null;
	}
	
	/**
	 * This is a method that runs in O(1) time and returns the total number of Deliveries in the list.
	 * @return
	 * 		An int value that represents the total number of Deliveries in the list.
	 */
	public int numDeliveries() {
		return this.deliveries;
	}
	
	/**
	 * Gets the reference to the Delivery wrapped by the DeliveryListNode currently referenced by cursor.
	 * @return
	 * 		The reference by the Delivery wrapped by the DeliveryListNode currently referenced by cursor. 
	 * 		If the cursor is null, then this method returns null as well (i.e. the cursor does not reference 
	 * 		a Delivery).
	 */
	public Delivery getCursor() {
		if(this.cursor == null) {
			return null;
		}
		else {
			return cursor.getData();
		}
	}
	
	/**
	 * Returns the cursor to the end of the list.
	 * Postconditions: - If tail is not null, the cursor now references the last DeliveryListNode in this list.
	 * 				   - If tail is null, the cursor is set to null as well (there are no Deliveries in this list).
	 */
	public void resetCursorToTail() {
		if(this.tail == null) {
			this.cursor = null;
		}
		else {
			this.cursor = this.tail;
		}
	}
	
	/**
	 * Returns the cursor to the start of the list.
	 * Postconditions: - If head is not null, the cursor now references the first DeliveryListNode in this list.
	 * 				   - If head is null, the cursor is set to null as well (there are no Deliveries in this list).
	 */
	public void resetCursorToHead() {
		if(this.head == null) {
			this.cursor = null;
		}
		else {
			this.cursor = this.head;
		}
	}
	
	/**
	 * Moves the cursor to select the previous DeliveryListNode in the list. If the cursor is at the head of the list, 
	 * this method throws an exception (this includes the case where cursor and head are both null).
	 * @throws EndOfListException
	 * 		Throws this exception if cursor is at the head of the list.
	 */
	public void cursorBackward() throws EndOfListException {
		if(this.cursor == this.head) {
			throw new EndOfListException("The cursor is at the head.");
		}
		else {
			this.cursor = this.cursor.getPrev();
		}
	}
	
	/**
	 * Moves the cursor to select the next DeliveryListNode in the list. If the cursor is at the tail of the list, 
	 * this method throws an exception (this includes the case where cursor and tail are both null).
	 * @throws EndOfListException
	 * 		Throws this exception if cursor is at the tail of the list.
	 */
	public void cursorForward() throws EndOfListException {
		if(this.cursor == this.tail) {
			throw new EndOfListException("The cursor is at the tail.");
		}
		else {
			this.cursor = this.cursor.getNext();
		}
	}
	
	/**
	 * Inserts the indicated Delivery after the tail of the list. This insertion method does not affect the cursor, unless the 
	 * list was previously empty. In that case, head, tail, and cursor all reference the new DeliveryListNode.
	 * Preconditions: - newDelivery is not null.
	 * Postconditions: - newDelivery has been wrapped in a new DeliveryListNode object.
	 * 				   - If tail was previously not null, the newly created DeliveryListNode has been inserted into the list 
	 * 					 after the tail.
	 * 				   - If tail was previously null, the newly created DeliveryListNode has been set as the new head of the 
	 * 					 list (as well as the tail and the cursor).
	 * 				   - The tail now references the newly created DeliveryListNode.
	 * @param newDelivery
	 * 		The indicated Delivery that will be inserted after the tail of the list.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if newDelivery is null.
	 */
	public void appendToTail(Delivery newDelivery) throws IllegalArgumentException {
		if(newDelivery == null) {
			throw new IllegalArgumentException();
		}
		else {
			deliveries = deliveries + 1;
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			if(this.tail == null) {
				this.tail = newNode;
				this.cursor = newNode;
				this.head = newNode;
			}
			else {
				newNode.setPrev(this.tail);
				this.tail.setNext(newNode);
				this.tail = newNode;
			}
		}
	}
	
	/**
	 * Inserts the indicated Delivery after the cursor.
	 * Preconditions: - newDelivery is not null.
	 * Postconditions: - newDelivery has been wrapped in a new DeliveryListNode object.
	 * 				   - If cursor was previously not null, the newly created DeliveryListNode has been inserted into the list 
	 * 					 after the cursor.
	 * 				   - If cursor was previously null, the newly created DeliveryListNode has been set as the new head of the 
	 *                   list (as well as the tail).
	 *                 - The cursor remains unchanged.
	 * @param newDelivery
	 * 		The indicated Delivery that will be inserted after the cursor.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if newDelivery is null.
	 */
	public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException {
		if(newDelivery == null) {
			throw new IllegalArgumentException();
		}
		else {
			deliveries = deliveries + 1;
			DeliveryListNode newNode = new DeliveryListNode(newDelivery);
			if(this.cursor == null) {
				this.tail = newNode;
				this.head = newNode;
				this.cursor = newNode;
			}
			else {
				if(this.cursor == this.tail) {;
					newNode.setPrev(this.tail);
					this.tail.setNext(newNode);
					this.tail = newNode;
				}
				else {
					newNode.setPrev(this.cursor);
					newNode.setNext(this.cursor.getNext());
					this.cursor.setNext(newNode);
					newNode.getNext().setPrev(newNode);
				}
			}
		}
	}
	
	/**
	 * Removes the DeliveryListNode referenced by cursor and returns the Delivery inside.
	 * Preconditions: - Cursor is not null.
	 * Postconditions: - The DeliveryListNode referenced by cursor has been removed from the list.
	 * 				   - All other DeliveryListNodes in the list exist in the same Delivery as before.
	 *                 - The cursor now references the next DeliveryListNode (or the tail, if the cursor previously 
	 *                   referenced the tail of the list).
	 * @return
	 * 		The Delivery referenced by the cursor which is removed from the list.
	 * @throws EndOfListException
	 * 		Throws this exception if the cursor is null.
	 */
	public Delivery removeCursor() throws EndOfListException {
		if(this.cursor == null) {
			throw new EndOfListException("Cursor is null.");
		}
		else {
			deliveries = deliveries - 1;
			Delivery deliveryInside = this.cursor.getData();
			if(this.cursor == this.tail && this.cursor == this.head) {
				this.tail = null;
				this.cursor = null;
				this.head = null;
			}
			else if(this.cursor == this.tail) {
				this.tail = this.cursor.getPrev();
				this.cursor = this.tail;
			}
			else if(this.cursor == this.head) {
				this.head = this.cursor.getNext();
				this.cursor = this.head;
			}
			else {
				this.cursor.getNext().setPrev(this.cursor.getPrev());
				this.cursor.getPrev().setNext(this.cursor.getNext());
				this.cursor = this.cursor.getNext();
			}
			return deliveryInside;
		}
	}

	/**
	 * This method creates a String representation of the DeliveryList object which contains its properties.
	 * @return
	 * 		A String representing the deliveries in the delivery list which contains the source of the delivery, 
	 * 		the destination of the delivery and the instruction of the delivery.
	 */
	public String toString() {
		String str = "";
		int j = 0;
		DeliveryListNode pointer = head;
		
		while(j < deliveries) {
			str = (this.cursor != pointer) ? str + "~\n": str + "->\n";
			str += pointer.getData().toString() + "\n";
			pointer = pointer.getNext();
			j++;
		}
		return str;
	}
}
