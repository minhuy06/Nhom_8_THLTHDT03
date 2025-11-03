package BT_Tuan_9;

//--- INTERFACES (Consolidated from separate files) ---

//Interface for Week 7 & 8 Price Logic
interface ISellingPrice {
	double calculateSellingPrice();
}

//Interface for Week 8 Inventory Logic
interface IInventory {
	boolean checkStock(int minimumStock);

	void updateLocation(String newLocation);
}

//--- ENUM (New Team Idea) ---
enum Condition {
	NEW, USED, DAMAGED
}

//--- CUSTOM EXCEPTION (New Team Idea: Try-catch) ---
class BookAlreadyExistsException extends Exception {
	public BookAlreadyExistsException(String bookID) {
		super("Book ID " + bookID + " already exists in the system.");
	}
}

//--- ABSTRACT CLASS (Week 7 & 8) ---
public abstract class Book implements ISellingPrice, IInventory {
	// Encapsulated Properties
	protected String bookID;
	protected String title;
	protected String author;
	protected double basePrice;
	protected int stockQuantity;
	protected String warehouseLocation;
	protected Condition condition; // New Team Idea
	protected int timesBorrowed; // New Team Idea (Borrow/Return)

	public Book(String bookID, String title, String author, double basePrice, int stockQuantity,
			String warehouseLocation, Condition condition) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.basePrice = basePrice;
		this.stockQuantity = stockQuantity;
		this.warehouseLocation = warehouseLocation;
		this.condition = condition;
		this.timesBorrowed = 0;
	}

	// New Team Idea: Increment borrow count
	public void incrementBorrowedCount() {
		this.timesBorrowed++;
		System.out.println("Book \"" + this.title + "\" has been borrowed. Total borrows: " + this.timesBorrowed);
	}

	// Implementing IInventory (Common logic)
	@Override
	public boolean checkStock(int minimumStock) {
		return this.stockQuantity >= minimumStock;
	}

	@Override
	public void updateLocation(String newLocation) {
		this.warehouseLocation = newLocation;
		System.out.println(" Book \"" + this.title + "\" moved to location: [" + newLocation + "]");
	}

	// Abstract method from ISellingPrice (Trừu tượng)
	public abstract double calculateSellingPrice();

	// Getters for management
	public String getBookID() {
		return bookID;
	}

	@Override
	public String toString() {
		return String.format("ID: %s, Title: %s, Condition: %s, Stock: %d, Borrows: %d, Selling Price: %,.0f VND",
				bookID, title, condition, stockQuantity, timesBorrowed, calculateSellingPrice());
	}
}
