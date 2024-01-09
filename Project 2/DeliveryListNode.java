
/**
 * Date: 2/22/2022
 * This class describes a DeliveryListNode and wraps a Delivery object to allow it to be inserted 
 * into a doubly linked-list data structure. The Delivery object reference is contained in a field 
 * called data and there are two DeliveryListNode references serving as ‘links’ to the previous and 
 * next DeliveryListNodes in the list.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class DeliveryListNode {
	
	/**
	 * Delivery object that holds the data of the delivery.
	 */
	private Delivery data;
	/**
	 * DeliveryListNode object that serves as a 'link' to the next DeliveryListNode in the list.
	 */
	private DeliveryListNode next;
	/**
	 * DeliveryListNode object that serves as a 'link' to the previous DeliveryListNode in the list.
	 */
	private DeliveryListNode prev;
	
	/**
	 * This is a default constructor that constructs a new DeliveryListNode object with the specified delivery.
	 * The two DeliveryListNode references serving as 'links' to the previous and next DeliveryListNodes
	 * in the list are set to null.
	 * Preconditions: - initData is not null.
	 * Postconditions: - This DeliveryListNode has been initialized to wrap the indicated Delivery. 
	 * 				   - prev and next have been set to null.
	 * @param initData
	 * 		The indicated Delivery object that will be wrapped by the initialized DeliveryListNode.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the parameter initData is null. 
	 */
	public DeliveryListNode(Delivery initData) throws IllegalArgumentException {
		if(initData == null) {
			throw new IllegalArgumentException();
		}
		data = initData;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Gets the Delivery object that holds the data of the delivery.
	 * @return
	 * 		A Delivery object that holds the data of the delivery.
	 */
	public Delivery getData() {
		return this.data;
	}
	
	/**
	 * Sets the Delivery object that holds the data of the delivery.
	 * @param data
	 * 		A Delivery object that holds the data of the delivery.
	 */
	public void setData(Delivery data) {
		this.data = data;
	}
	
	/**
	 * Gets the 'link' to the next DeliveryListNode in the list.
	 * @return
	 * 		A DeliveryListNode object that serves as a 'link' to the next DeliveryListNode in the list.
	 */
	public DeliveryListNode getNext() {
		return this.next;
	}
	
	/**
	 * Sets the 'link' to the next DeliveryListNode in the list.
	 * @param next
	 * 		A DeliveryListNode object that serves as a 'link' to the next DeliveryListNode in the list.
	 */
	public void setNext(DeliveryListNode next) {
		this.next = next;
	}
	
	/**
	 * Gets the 'link' to the previous DeliveryListNode in the list.
	 * @return
	 * 		A DeliveryListNode object that serves as a 'link' to the previous DeliveryListNode in the list.
	 */
	public DeliveryListNode getPrev() {
		return this.prev;
	}
	
	/**
	 * Sets the 'link' to the previous DeliveryListNode in the list.
	 * @param prev
	 * 		A DeliveryListNode object that serves as a 'link' to the previous DeliveryListNode in the list.
	 */
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}
}
