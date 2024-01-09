
/**
 * Date: 2/8/22
 * This class describes a Bookshelf and contains an array that is made up of Book objects, and a counter as an int
 * for the total number of books in the array books.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

public class Bookshelf {
	/**
	 * An array of books for the list of books on a shelf.
	 */
	private Book[] books;
	/**
	 * A counter that represents how many books are in the books array.
	 */
	private int count;
	/**
	 * The maximum size that limits the array of books.
	 */
	final int CAPACITY = 20;
	
	/**
	 * This is a default constructor which initializes this object to an empty Bookshelf.
	 * Postconditions: The array books has been initialized, and count has been set to 0.
	 */
	public Bookshelf() {
		this.books = new Book[CAPACITY];
		this.count = 0;
	}
	
	/**
	 * Gets the total number of books on the shelf. This method runs in O(1) time.
	 * @return
	 * 		The total number of books on the shelf. 
	 */
	public int numBooks() {
		return this.count;
	}
	
	/**
	 * Gets the reference to the Book at the given index. The list is unchanged.
	 * @param index
	 * 		Specified index for the book on the shelf.
	 * @return
	 * 		The Book object at the specified index on the shelf.
	 * @throws ArrayIndexOutOfBoundsException
	 * 		Throws this exception if the index is invalid.
	 */
	public Book getBook(int index) throws ArrayIndexOutOfBoundsException {
		if(this.count < index || index < 0 || index > 19) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			return this.books[index];
		}
	}
	
	/**
	 * Gets the reference to the Book at the given index. Removes the given book and moves all books to the right of it leftwards by one index.
	 * @param index
	 * 		Specified index for the book on the shelf.
	 * @return
	 * 		The Book object at the specified index on the shelf.
	 * @throws ArrayIndexOutOfBoundsException
	 * 		Throws this exception if the index is invalid.
	 * @throws EmptyShelfException
	 * 		Throws this exception if there is no book on the shelf.
	 */
	public Book removeBook(int index) throws ArrayIndexOutOfBoundsException, EmptyShelfException {
		if(this.count < index || index < 0 || index > 19) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(this.count == 0) {
			throw new EmptyShelfException("The bookshelf is empty!");
		}
		else {
			int j = index;
			
			while(j < this.books.length - 1) {
				if(this.books[j + 1] == null) {
					break;
				}
				else {
					this.books[j] = this.books[j + 1];
				}
				j++;
			}
			this.count--;
			return this.books[index];
		}
	}
	/**
	 * Adds a book at the given index, moving all books at or after the given index one index to the right.
	 * @param index
	 * 		Specified index for the book on the shelf.
	 * @param book
	 * 		The Book object that will be added.
	 * @throws IllegalArgumentException
	 * 		Throws this exception if the index is too high and would create a hole in the array.
	 * @throws FullShelfException
	 * 		Throws this exception if more than 20 books are added to the shelf.
	 */
	public void addBook(int index, Book book) throws IllegalArgumentException, FullShelfException {
		if(index > this.count) {
			throw new IllegalArgumentException();
		}
		else if (this.count == CAPACITY) {
			throw new FullShelfException("The bookshelf is full!");
		}
		else {
			int j = this.count;
			
			while(j > index) {
				this.books[j] = this.books[j - 1];
				j--;
			}
			this.books[index] = book;
			this.count++;
		}
	}
	
	/**
	 * Swaps the two books if the indices are valid.
	 * @param index1
	 * 		The index of the first Book object.
	 * @param index2
	 * 		The index of the second Book object.
	 * @throws ArrayIndexOutOfBoundsException
	 * 		Throws this exception if either index is invalid.
	 */
	public void swapBooks(int index1, int index2) throws ArrayIndexOutOfBoundsException {
		if(this.count < index1 || index1 < 0 || index1 > 19 || this.count < index2 || index2 < 0 || index2 > 19) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			Book tempVar = this.books[index1];
			this.books[index1] = this.books[index2];
			this.books[index2] = tempVar;
		}
	}
	
	/**
	 * This method creates a deep copy of this Bookshelf object. All the books are copied individually. The borrower field is empty in the clone.
	 * If the copy is modified, this object remains unmodified.
	 * @return 
	 * 		The deep copy of the Bookshelf object.
	 */
	public Object clone() {
		Bookshelf newBookshelf = new Bookshelf();
		int j = 0;
		
		while(j < this.count) {
			Book b = this.books[j].clone();
			newBookshelf.books[j] = b;
			newBookshelf.count++;
			j++;
		}
		return newBookshelf;
	}
	
	/**
	 * This method checks if this Bookshelf is equal to another object (equal books in the same order).
	 * @return
	 * 		Returns a value of true if the Object o is equal to the Bookshelf object. If not, returns false.
	 */
	public boolean equals(Object o) {
		boolean flag = true;
		if(o instanceof Bookshelf) {
			Bookshelf b = (Bookshelf) o;
			int j = 0;
			while(j < this.count) {
				if(!(this.books[j].equals(b.books[j])) || this.count != (b.count)) {
					flag = false;
				}
					j++;
				}
		}
		return flag;
	}
	
	/**
	 * This method creates a String representation of the Bookshelf object which contains its properties.
	 * @return
	 * 		A String representing the books in the bookshelf which contains the number of the book, the title of the book, the author of the book,
	 * 		the condition number, and the borrower.
	 */
	public String toString() {
		String str = "";
		int j = 0;
		while(j < this.count) {
			String b = this.books[j].getBorrower();
			if(b == null) {
				b = "<none>";
			}
			str += String.format("%-7s", (j + 1) + ".") + String.format("%-50s %-26s %-5s %-5s", 
					this.books[j].getTitle(), this.books[j].getAuthor(), this.books[j].getCondition(), b) + "\n";
			j++;
		}
		return str;
	}
}