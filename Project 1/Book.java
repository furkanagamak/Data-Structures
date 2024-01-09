
/**
 * Date: 2/8/22
 * This class describes a Textbook and contains the title of the textbook (String), the author of the textbook (String), 
 * the name of the borrower (String), and the condition of the book (int).
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Book {
	
	/**
	 * String value for the title of the textbook.
	 */
	private String title;
	/**
	 * String value for the name of the author of the textbook.
	 */
	private String author;
	/**
	 * String value for the name of the person who borrows the textbook.
	 */
	private String borrower;
	/**
	 * int value for the condition of the textbook (1-5).
	 */
	private int condition;
	
	/**
	 * This is a default constructor that constructs a new Book object with the specified title,
	 * author, and condition number. Borrower is set to an empty String, as the book isn't loaned out yet.
	 * Postconditions: - This object has been initialized to a Book object with the required properties.
	 * @param title 
	 * 		A String representing the title of the textbook.
	 * @param author
	 * 		A String representing the author of the textbook.
	 * @param condition
	 * 		An int representing the condition number of the textbook.
	 */
	public Book(String title, String author, int condition) {
		this.title = title;
		this.author = author;
		this.borrower = null;
		this.condition = condition;
	}
	
	/** 
	 * Gets the title of the textbook.
	 * @return 
	 * 		A String representing the title of the textbook.
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Gets the name of the author of the textbook.
	 * @return
	 * 		A String representing the name of the author of the textbook.
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * Gets the name of the borrower of the textbook.
	 * @return
	 * 		A String representing the name of the borrower of the textbook.
	 */
	public String getBorrower() {
		return this.borrower;
	}
	
	/**
	 * Gets the condition number of the textbook.
	 * @return
	 * 		An int representing the condition number of the textbook.
	 */
	public int getCondition() {
		return this.condition;
	}
	
	/**
	 * Sets the title of the textbook.
	 * @param title
	 * 		A String representing the title of the textbook.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the name of the author of the textbook.
	 * @param author
	 * 		A String representing the name of the author of the textbook.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Sets the name of the borrower of the textbook.
	 * @param borrower
	 * 		A String representing the name of the borrower of the textbook.
	 */
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	/**
	 * Sets the condition number of the textbook.
	 * @param condition
	 * 		An int representing the condition number of the textbook.
	 */
	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	/**
	 * This method compares this Book to another object for equality. The borrower field is not checked.
	 * @return
	 * 		Returns a value of true if the obj refers to a Book object with the same properties as this Book. 
	 * 		Otherwise, returns a value of false.
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book b = (Book) obj;
			if((this.getTitle().equals(b.getTitle())) && (this.getAuthor().equals(b.getAuthor())) && (this.getCondition() == b.getCondition())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This is a method that generates a clone of a Book object.
	 * @return
	 * 		A Book object representing the new book that was cloned.
	 */
	public Book clone() {
		Book newBook = new Book(this.getTitle(), this.getAuthor(), this.getCondition());
		return newBook;
	}
	
	/**
	 * This method creates a String representation of the Book object which contains its properties.
	 * @return
	 * 		A String representing the title of the textbook, the author, the condition number 
	 *      and the name of the borrower.
	 */
	public String toString() {
		return "Title: " + this.getTitle() + " Author: " + this.getAuthor() + " Condition: " + this.getCondition() + " Borrower: " + this.getBorrower();
	}
}
