
/**
 * Date: 4/5/2022
 * This class describes a NetworkTree which serves as the tree manager for the NetworkTree. The class
 * holds references into a tree (the root and cursor), as well as be able to generate and save the tree to 
 * and from a file. The class also has methods that allow the user to manipulate the instance variables (such as 
 * getters and setters).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class NetworkTree {
	
	/**
	 * A NetworkNode object representing the node that is cut from the tree. This is initialized to null.
	 */
	private NetworkNode cut = null;
	/**
	 * A NetworkNode object representing the root of the tree.
	 */
	private static NetworkNode root;
	/**
	 * A NetworkNode object representing the cursor which allows us to move around the tree.
	 */
	private NetworkNode cursor;
	
	/**
	 * This is a no-arg constructor which constructs a NetworkTree object with the cursor and the root set to
	 * null.
	 */
	public NetworkTree() {
		this.cursor = null;
		this.root = null;
	}
	
	/**
	 * This is a method that sets the cursor of this NetworkTree object to the root of this NetworkTree object.
	 */
	public void cursorToRoot() {
		this.cursor = this.root;
	}
	
	/**
	 * This is a method that gets the root of the tree.
	 * @return
	 * 		A NetworkNode object representing the root of the tree.
	 */
	public NetworkNode getRoot() {
		return this.root;
	}
	
	/**
	 * This is a method that sets the root of the tree.
	 * @param root
	 * 		A NetworkNode object representing the root of the tree.
	 */
	public void setRoot(NetworkNode root) {
		this.root = root;
	}
	
	/**
	 * This is a method that sets the cursor.
	 * @param cursor
	 * 		A NetworkNode object representing the cursor which allows us to move around the tree.
	 */
	public void setCursor(NetworkNode cursor) {
		this.cursor = cursor;
	}
	
	/**
	 * This is a method that gets the cursor.
	 * @return
	 * 		A NetworkNode object representing the cursor which allows us to move around the tree.
	 */
	public NetworkNode getCursor() {
		return this.cursor;
	}
	
	/**
	 * This is a method that removes a child based on the specified index of the tree, and all of its children.
	 * The cursor goes to the parent. Cutting the root clears the tree. The method returns the node which is cut.
	 * @return
	 * 		A NetworkNode object representing the node that is cut from the tree.
	 * @throws InvalidTreeException
	 * 		Throws this exception when the root is null, which makes the tree invalid.
	 */
	public NetworkNode cutCursor() throws InvalidTreeException {
		int i = 0;
		this.cut = this.cursor;
		NetworkNode temp = null;
		if(this.root != this.cursor) {
			temp = this.cursor.getParent();
			int j = 0;
			while(j <= temp.getNumChildren()) {
				if(this.cursor == temp.getChildren()[j]) {
					i = j;
					break;
				}
				j++;
			}
			int m = i;
			while(m < temp.getMaxChildren() - 1) {
				temp.getChildren()[m] = temp.getChildren()[m + 1];
				m++;
			}
			temp.getChildren()[temp.getMaxChildren() - 1] = null;
			this.cursor = temp;
			this.cursor.setNumChildren(this.cursor.getNumChildren() - 1);
		}
		else if(this.root == null) {
			throw new InvalidTreeException("The tree is invalid.");
		}
		else if(this.root == this.cursor) {
			this.cursor = null;
			this.root = null;
		}
		return this.cut;
	}
	
	/**
	 * This method adds the given node to the corresponding index of the children array. This method does not return anything.
	 * @param index
	 * 		An int variable representing the specified index where the child will be added.
	 * @param node
	 * 		A NetworkNode object representing the specified node that will be added to the NetworkTree.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the specified index is less than 0, which makes the index invalid.
	 * @throws InvalidChildException
	 * 		Throws this exception if there is an attempt to add a child to a Nintendo node, which makes the child invalid.
	 * @throws MaximumTreeException
	 * 		Throws this exception if the tree is at maximum, or full.
	 * @throws VoidPositionException
	 * 		Throws this exception if adding a child at the specified index would create a void position in the tree.
	 */
	public void addChild(int index, NetworkNode node) throws IllegalArgumentException, InvalidChildException, 
	MaximumTreeException, VoidPositionException {
		NetworkNode temp = this.cursor;
		if(this.cursor == null) {
			this.root = node;
			this.cursor = node;
		}
		else if(index < 0) {
			throw new IllegalArgumentException("The index is invalid.");
		}
		else if(this.cursor.getIsNintendo()) {
			throw new InvalidChildException("The child cannot be added since it is a Nintendo node.");
		}
		else if(this.cursor.getNumChildren() == this.cursor.getMaxChildren()) {
			throw new MaximumTreeException("The tree is at maximum capacity.");
		}
		else if(index == this.cursor.getNumChildren()) {
			this.cursor.getChildren()[index] = node;
			this.cursor.setNumChildren(this.cursor.getNumChildren() + 1);
			this.cursor.getChildren()[index].setParent(temp);
		}
		else if(this.cursor.getNumChildren() - 1 >= index) {
			int j = this.cursor.getNumChildren();
			while(j > index) {
				this.cursor.getChildren()[j] = this.cursor.getChildren()[j - 1];
				j--;
			}
			this.cursor.getChildren()[index] = node;
			this.cursor.setNumChildren(this.cursor.getNumChildren() + 1);
			this.cursor.getChildren()[index].setParent(temp);
		}
		else {
			throw new VoidPositionException("The index would create a void position.");
		}
	}
	
	/**
	 * This is a method which moves the cursor to the child node of the of the cursor corresponding to the specified index.
	 * This method does not return anything.
	 * @param index
	 * 		An int variable representing the specified index.
	 * @throws InvalidTreeException
	 * 		Throws this exception if the root is null, which makes the tree invalid.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the index is not valid.
	 */
	public void cursorToChild(int index) throws InvalidTreeException, IllegalArgumentException {
		if(this.root == null) {
			throw new InvalidTreeException("The tree is invalid.");
		}
		else if(index >= 0 && index < this.cursor.getNumChildren()) {
			this.cursor = this.cursor.getChildren()[index];
		}
		else {
			throw new IllegalArgumentException("The index is invalid.");
		}
	}
	
	/**
	 * This is a method which moves the cursor to the parent of the current node. This method does not return anything.
	 * @throws IllegalCursorException
	 * 		Throws this exception if the cursor is null or it is equal to the root, which means it can not be moved.
	 */
	public void cursorToParent() throws IllegalCursorException {
		if(this.cursor == null || this.root == this.cursor) {
			throw new IllegalCursorException("The cursor can not be moved.");
		}
		else {
			this.cursor = this.cursor.getParent();
		}
	}
	
	/**
	 * This is a static method which generates the NetworkTree based on the specified name of the file. It returns a tree
	 * by reading from a file based on the name.
	 * @param filename
	 * 		A String variable representing the specified name of the file.
	 * @return
	 * 		A NetworkTree object which is constructed by reading from the specified file.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the tree is invalid.
	 * @throws InvalidChildException
	 * 		Throws this exception during the construction of the NetworkTree, if a child is invalid because it is added to a node that is Nintendo.
	 * @throws InvalidTreeException
	 * 		Throws this exception if the tree does not exist.
	 * @throws MaximumTreeException
	 * 		Throws this exception during the construction of the NetworkTree, if the tree is at maximum, or full.
	 * @throws FileNotFoundException
	 * 		Throws this exception if the specified file is not able to be found.
	 * @throws VoidPositionException
	 * 		Throws this exception during the construction of the NetworkTree, if there exists void positions in the tree.
	 */
	public static NetworkTree readFromFile(String filename) throws IllegalArgumentException, InvalidChildException, InvalidTreeException, 
	MaximumTreeException, FileNotFoundException, VoidPositionException {
		String str = "";
		String strNum = "";
		File f = new File(filename);
		int i = 0;
		NetworkTree n = new NetworkTree();
		n.cursorToRoot();
		boolean flag;
		Scanner s = new Scanner(f);
		while(s.hasNextLine() == true) {
			flag = false;
			String theStr = s.nextLine();
			if(Character.isDigit(theStr.charAt(0)) == true) {
				int j = 0;
				while(j < theStr.length()) {
					if('-' == theStr.charAt(j)) {
						i = j + 1;
						flag = true;
						strNum = theStr.substring(0, j);
						break;
					}
					else if(Character.isLetter(theStr.charAt(j)) == true) {
						strNum = theStr.substring(0, j);
						i = j;
						break;
					}
					j++;
				}
				int m = 0;
				str = theStr.substring(i);
				for(; strNum.length() > 1 ;) {
					m = strNum.charAt(0) - 1 - '0';
					strNum = strNum.substring(1);
					n.cursorToChild(m);
				}
				NetworkNode temp = new NetworkNode(flag, str);
				n.addChild(strNum.charAt(0) - 1 - '0', temp);
				n.cursorToRoot();
			}
			else {
				NetworkNode temp = new NetworkNode(false, theStr);
				n.cursor = temp;
				n.root = temp;
			}
		}
		return n;
	}
	
	/**
	 * This is a static method which serves as a helper for the method writeToFile(). It constructs and returns a String 
	 * representation of the tree which will be written to the file.
	 * @param str
	 * 		A String variable which will be added to the newStr and returned as a part of the tree.
	 * @param n
	 * 		A NetworkNode object representing the node which will be displayed as a String variable.
	 * @return
	 * 		A String variable representing the tree which will be written to the file.
	 */
	public static String treeHelper(String str, NetworkNode n) {
		String newStr = "";
		newStr = newStr + str;
		
		newStr = (n.getIsNintendo() == true) ? newStr + "-" + n.getName() + "\r\n": newStr + n.getName() + "\r\n";
		
		int j = 0; 
		while(j < n.getNumChildren()) {
			if(n != null) {
				newStr = newStr + treeHelper(str + (j + 1), n.getChildren()[j]);
			}
			j++;
		}
		return newStr;
	}
	
	/**
	 * This is a static method which generates a text file that reflects the structure of the NetworkTree. The format of 
	 * the tree of the file matches the format of the input file. This method does not return anything.
	 * @param tree
	 * 		A NetworkTree object representing the tree which will be written.
	 * @param filename
	 * 		A String variable representing the name of the file which will be written. 
	 * @throws IOException
	 * 		Throws this exception if the tree is empty or if the file can not be written.
	 */
	public static void writeToFile(NetworkTree tree, String filename) throws IOException {
		NetworkNode n = root;
		if(n == null) {
			throw new IOException();
		}
		String str = "";
		File f = new File(filename);
		FileWriter w = new FileWriter(f, false);
		PrintWriter p = new PrintWriter(w);
		p.print(treeHelper(str, n));
		p.flush();
		p.close();
	}
	
	/**
	 * This is a method which displays the tree. This method does not return anything.
	 */
	public void displayTree() {
		NetworkNode n = this.root;
		if(this.root == null) {
			System.out.println();
			System.out.println("The tree cannot be displayed since it does not exist.");
			System.out.println();
		}
		else {
			displayTreeHelper(0, n);
		}
	}
	
	/**
	 * This is a method which serves as a helper for the displayTree() method. This method does not return anything.
	 * @param i
	 * 		An int variable representing the counter for the number of tabs that will be displayed while printing each node of the tree.
	 * @param n
	 * 		A NetworkNode object representing the node which will be displayed.
	 */
	public void displayTreeHelper(int i, NetworkNode n) {
		int j = 0;
		while(j < i) {
			System.out.print("\t");
			j++;
		}
		if(n == this.cursor) {
			System.out.print("->");
		}
		else if(n.getIsNintendo() == false) {
			System.out.print("+");
		}
		else if(n.getIsNintendo() == true) {
			System.out.print("-");
		}
		System.out.println(n.getName());
		int m = 0;
		while(m < n.getNumChildren()) {
			if(n != null) {
				displayTreeHelper(i + 1, n.getChildren()[m]);
			}
			m++;
		}
	}
}
