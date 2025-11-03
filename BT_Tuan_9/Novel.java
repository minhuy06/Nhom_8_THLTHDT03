package BT_Tuan_9;

//File: Novel.java
public class Novel extends Book {
	private String genre;
	private boolean isSeries;

	public Novel(String bookID, String title, String author, double basePrice, int stockQuantity,
			String warehouseLocation, Condition condition, String genre, boolean isSeries) {
		super(bookID, title, author, basePrice, stockQuantity, warehouseLocation, condition);
		this.genre = genre;
		this.isSeries = isSeries;
	}

	// Implementation of calculateSellingPrice (Đa hình)
	@Override
	public double calculateSellingPrice() {
		// Logic: basePrice + (If Series: + 15,000 VND, Else: + 0).
		final double SERIES_SURCHARGE = 15000.0;

		return this.basePrice + (isSeries ? SERIES_SURCHARGE : 0.0);
	}
}
