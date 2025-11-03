package BT_Tuan_9;

//File: BookManager.java

import java.util.ArrayList;
import java.util.List;

//--- INTERFACE (Consolidated from separate files) ---
interface IBookManager {
	void addBook(Book book);

	Book findBook(String bookID);

	boolean deleteBook(String bookID);

	void displayList();

	// Week 9: Added statistical function
	void generateStatistics();
}

//--- IMPLEMENTATION CLASS (Renamed to match file) ---
public class BookManager implements IBookManager {
	private List<Book> bookList = new ArrayList<>();

	// Uses try-catch for robust addition (New Team Idea)
	@Override
	public void addBook(Book book) {
		try {
			if (findBook(book.getBookID()) != null) {
				throw new BookAlreadyExistsException(book.getBookID());
			}
			bookList.add(book);
			System.out.println("Successfully added book: " + book.getTitle());
		} catch (BookAlreadyExistsException e) {
			System.err.println(" Add Book Error: " + e.getMessage());
		}
	}

	@Override
	public Book findBook(String bookID) {
		for (Book book : bookList) {
			if (book.getBookID().equalsIgnoreCase(bookID)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public boolean deleteBook(String bookID) {
		Book bookToDelete = findBook(bookID);
		if (bookToDelete != null) {
			bookList.remove(bookToDelete);
			System.out.println(" Successfully deleted book with ID " + bookID + ".");
			return true;
		}
		System.out.println(" Deletion failed: Book ID " + bookID + " not found.");
		return false;
	}

	@Override
	public void displayList() {
		if (bookList.isEmpty()) {
			System.out.println("The book list is currently empty.");
			return;
		}
		System.out.println("\n--- CURRENT BOOK LIST (" + bookList.size() + " items) ---");
		for (Book book : bookList) {
			System.out.println(book);
		}
		System.out.println("-----------------------------------------------------");
	}

	// Week 9: Generate Statistics (New Team Idea)
	@Override
	public void generateStatistics() {
		int textbookCount = 0;
		int novelCount = 0;

		for (Book book : bookList) {
			if (book instanceof Textbook) {
				textbookCount++;
			} else if (book instanceof Novel) {
				novelCount++;
			}
		}
		System.out.println("\n--- BOOK STATISTICAL REPORT ---");
		System.out.println("Total number of books: " + bookList.size());
		System.out.println("  - Textbooks: " + textbookCount + " items.");
		System.out.println("  - Novels: " + novelCount + " items.");
		System.out.println("-----------------------------");
	}
}
