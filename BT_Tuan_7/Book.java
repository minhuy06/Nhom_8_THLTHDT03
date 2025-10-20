import java.text.DecimalFormat;

public abstract class Book {
    protected String bookID;
    protected String title;
    protected String author;
    protected double basePrice;

    // Full Constructor
    public Book(String bookID, String title, String author, double basePrice) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.basePrice = basePrice;
    }

    // Abstract method (Required by the previous week's task)
    // Must be implemented by subclasses
    public abstract double calculateSellingPrice();

    // Getter for bookID (Needed for search/management functions)
    public String getBookID() {
        return bookID;
    }

    // Basic toString() for common properties
    @Override
    public String toString() {
        // Use DecimalFormat for currency
        DecimalFormat df = new DecimalFormat("#,### VND");
        return String.format("BookID: %s, Title: %s, Author: %s, Base Price: %s",
                bookID, title, author, df.format(basePrice));
    }
}