package baitap4;

public class Book {
	private String bookID;
	private String title;
	private String author;
	private int publication_year;
	private int quantity;

	public Book(String bookID, String title, String author, int publication_year, int quantity) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.publication_year = publication_year;
		this.quantity = quantity;
	}

	// Constructor
	Book() {

	}

	void Set_bookID(String bookID) {
		this.bookID = bookID;
	}

	void Set_title(String title) {
		this.title = title;
	}

	void Set_author(String author) {
		this.author = author;
	}

	void Set_publication_year(int publication_year) {
		this.publication_year = publication_year;
	}

	void Set_quantity(int quantity) {
		this.quantity = quantity;
	}

	String Get_bookID() {
		return bookID;
	}

	String Get_title() {
		return title;
	}

	String Get_author() {
		return author;
	}

	int Get_publication_year() {
		return publication_year;
	}

	int Get_quantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Mã sách: " + bookID + "\nTiêu đề: " + title + "\nTác giả: " + author + "\nNăm xuất bản: "
				+ publication_year + "\nSố lượng: " + quantity;
	}

}
