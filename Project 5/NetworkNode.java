
/**
 * Date: 4/5/2022
 * This class describes a NetworkNode which holds the type of component that is being represented, an array that has 
 * children (null if this will be a Nintendo), and string for the text. The class has methods that allow
 * the user to manipulate the instance variables (such as getters and setters).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class NetworkNode {
	
	/**
	 * An int variable representing the number of children of the node. This is initialized to 0.
	 */
	private int numChildren = 0;
	/**
	 * An int variable representing the maximum number of children. This is finalized to 9.
	 */
	private final int maxChildren = 9;
	/**
	 * A String variable representing the name of the node.
	 */
	private String name;
	/**
	 * A boolean variable representing if the node is Nintendo or not.
	 */
	private boolean isNintendo;
	/**
	 * A boolean variable representing if the node is broken or not. This is initialized to false.
	 */
	private boolean isBroken = false;
	/**
	 * A NetworkNode object representing the parent of the node.
	 */
	private NetworkNode parent;
	/**
	 * A NetworkNode array representing the children of the node. The size of the array is the maximum number of children which is 9.
	 */
	private NetworkNode[] children = new NetworkNode[maxChildren];
	
	/**
	 * This is a constructor which constructs a NetworkNode object with the specified boolean value for whether the node is 
	 * Nintendo or not.
	 * @param isNintendo
	 * 		A boolean variable representing if the node is Nintendo or not.
	 */
	public NetworkNode(boolean isNintendo) {
		this.isNintendo = isNintendo;
	}
	
	/**
	 * This is a constructor which constructs a NetworkNode object with the specified name of the node.
	 * @param name
	 * 		A String variable representing the name of the node.
	 */
	public NetworkNode(String name) {
		this.name = name;
	}
	
	/**
	 * This is a constructor which constructs a NetworkNode object with the specified boolean value for whether the node is
	 * Nintendo or not, and the name of the node.
	 * @param isNintendo
	 * 		A boolean variable representing if the node is Nintendo or not.
	 * @param name
	 * 		A String variable representing the name of the node.
	 */
	public NetworkNode(boolean isNintendo, String name) {
		this.isNintendo = isNintendo;
		this.name = name;
	}
	
	/**
	 * This is a constructor which constructs a NetworkNode object with the specified boolean value for whether the node is
	 * Nintendo or not, the name of the node, and the boolean value for whether the node is broken or not.
	 * @param isNintendo
	 * 		A boolean variable representing if the node is Nintendo or not.
	 * @param name
	 * 		A String variable representing the name of the node.
	 * @param isBroken
	 * 		A boolean variable representing if the node is broken or not.
	 */
	public NetworkNode(boolean isNintendo, String name, boolean isBroken) {
		this.isNintendo = isNintendo;
		this.name = name;
		this.isBroken = isBroken;
	}
	
	/**
	 * This is a method that gets the number of children of the node.
	 * @return
	 * 		An int variable representing the number of children of the node.
	 */
	public int getNumChildren() {
		return this.numChildren;
	}
	
	/**
	 * This is a method that sets the number of children of the node.
	 * @param numChildren
	 * 		An int variable representing the number of children of the node.
	 */
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}
	
	/**
	 * This is a method that gets the maximum number of children.
	 * @return
	 * 		An int variable representing the maximum number of children of the node.
	 */
	public int getMaxChildren() {
		return this.maxChildren;
	}
	
	/**
	 * This is a method that gets the name of the node.
	 * @return
	 * 		A String variable representing the name of the node.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This is a method that sets the name of the node.
	 * @param name
	 * 		A String variable representing the name of the node.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This is a method that gets whether the node is Nintendo or not.
	 * @return
	 * 		A boolean variable representing if the node is Nintendo or not.
	 */
	public boolean getIsNintendo() {
		return this.isNintendo;
	}
	
	/**
	 * This is a method that sets whether the node is Nintendo or not.
	 * @param isNintendo
	 * 		A boolean variable representing if the node is Nintendo or not.
	 */
	public void setIsNintendo(boolean isNintendo) {
		this.isNintendo = isNintendo;
	}
	
	/**
	 * This is a method that gets whether the node is broken or not.
	 * @return
	 * 		A boolean variable representing if the node is broken or not.
	 */
	public boolean getIsBroken() {
		return this.isBroken;
	}
	
	/**
	 * This is a method that sets whether the node is broken or not.
	 * @param isBroken
	 * 		A boolean variable representing if the node is broken or not.
	 */
	public void setIsBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}
	
	/**
	 * This is a method that gets the array representing the children of the node.
	 * @return
	 * 		A NetworkNode array representing the children of the node.
	 */
	public NetworkNode[] getChildren() {
		return this.children;
	}
	
	/**
	 * This is a method that sets the array representing the children of the node.
	 * @param children
	 * 		A NetworkNode array representing the children of the node.
	 */
	public void setChildren(NetworkNode[] children) {
		this.children = children;
	}
	
	/**
	 * This is a method that gets the parent of the node.
	 * @return
	 * 		A NetworkNode object representing the parent of the node.
	 */
	public NetworkNode getParent() {
		return this.parent;
	}
	
	/**
	 * This is a method that sets the parent of the node.
	 * @param parent
	 * 		A NetworkNode object representing the parent of the node.
	 */
	public void setParent(NetworkNode parent) {
		this.parent = parent;
	}
}
