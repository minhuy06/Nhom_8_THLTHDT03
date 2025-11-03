package BT_Tuan_9;

//File: MainTest.java

public class MainTest {
	public static void main(String[] args) {
		System.out.println("--- WEEK 7, 8, 9: FINAL SYSTEM TEST ---");

		// Polymorphism: Declaring object by Interface type
		IBookManager manager = new BookManager();

		// 1. Create objects using the new Condition Enum (New Team Idea)
		Textbook textbook1 = new Textbook("TBT001", "OOP Java", "A", 120000.0, 50, "K1-A1", Condition.NEW, "CS", "Uni",
				2022);
		Novel novel1 = new Novel("NOV001", "Little Prince", "B", 75000.0, 150, "K2-C3", Condition.USED, "Fantasy",
				true);

		// 2. Add books and test exception handling (New Team Idea)
		manager.addBook(textbook1);
		manager.addBook(novel1);
		manager.addBook(textbook1); // Test: Should trigger the exception

		// 3. Simulate Borrowing (New Team Idea)
		System.out.println("\n--- TESTING BORROW FEATURE ---");
		novel1.incrementBorrowedCount();
		novel1.incrementBorrowedCount();

		// 4. Display the list
		manager.displayList();

		// 5. Week 9 Feature: Generate Statistics
		manager.generateStatistics();

		// 6. Test Inventory Interface
		System.out.println("\n--- TESTING INVENTORY (IInventory) ---");
		System.out.println("TBT001 in stock (>=55)? " + textbook1.checkStock(55));
		novel1.updateLocation("K3-C5");
	}
}
