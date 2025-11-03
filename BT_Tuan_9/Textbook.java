package BT_Tuan_9;

//File: Textbook.java

//Textbook extends Book (Kế thừa)
public class Textbook extends Book {
	private String subject;
	private String level;
	private int publicationYear;

	public Textbook(String bookID, String title, String author, double basePrice, int stockQuantity,
			String warehouseLocation, Condition condition, String subject, String level, int publicationYear) {
		super(bookID, title, author, basePrice, stockQuantity, warehouseLocation, condition);
		this.subject = subject;
		this.level = level;
		this.publicationYear = publicationYear;
	}

	// Implementation of calculateSellingPrice (Đa hình)
	@Override
	public double calculateSellingPrice() {
		// Logic: basePrice + (Years Published * 5,000 VND).
		final int CURRENT_YEAR = 2025;
		final double ANNUAL_SURCHARGE = 5000.0;
		int yearsPublished = CURRENT_YEAR - this.publicationYear;

		return this.basePrice + (Math.max(0, yearsPublished) * ANNUAL_SURCHARGE);
	}
}