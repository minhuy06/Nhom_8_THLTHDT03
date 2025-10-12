package baitap4;

public class Novel extends Book {
	private String Typebook;
	private boolean isSeriesBook;

	// Constructor có đối
	public Novel(String bookID, String title, String author, int publication_year, int quantity, String Typebook,
			boolean isSeriesBook) {
		super(bookID, title, author, publication_year, quantity);
		this.Typebook = Typebook;
		this.isSeriesBook = isSeriesBook;
	}

	// Constructor không đối
	public Novel() {
	}

	// Getter & Setter
	public String getTypebook() {
		return Typebook;
	}

	public void setTypebook(String typebook) {
		Typebook = typebook;
	}

	public boolean getisSeriesBook() {
		return isSeriesBook;
	}

	public void setSeriesBook(boolean isSeriesBook) {
		this.isSeriesBook = isSeriesBook;
	}

	@Override
	public String toString() {
		return super.toString() + "\nThể loại: " + Typebook + "\nLà sách series: " + (isSeriesBook ? "Có" : "Không");
	}

}
