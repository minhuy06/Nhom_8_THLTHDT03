package baitap3b;

public class Book {
	private String bookID;
	private String title;
	private String author;
	private int publication_year;
	private int quantity;

	// Constructor
	Book() {

	}

	Book(String bookID, String title, String author, int publication_year, int quantity) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.publication_year = publication_year;
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

	void displayInfo() {
		System.out.println("Mã sách:" + bookID);
		System.out.println("Tiêu đề:" + title);
		System.out.println("Tác giả:" + author);
		System.out.println("Năm xuất bản:" + publication_year);
		System.out.println("Số lượng:" + quantity);
	}
}
