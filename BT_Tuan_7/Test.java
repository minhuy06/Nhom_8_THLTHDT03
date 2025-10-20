public class Test {
    public static void main(String[] args) {
        // Initialize the book manager
        BookManager manager = new BookManager();

        System.out.println("--- INITIAL DATA SETUP ---");

        // 1. Create Textbook objects
        // Price Calculation Example for TBT001: 120,000 + (2025 - 2022) * 5,000 = 135,000 VND
        Textbook textbook1 = new Textbook("TBT001", "Introduction to Programming", "Nguyen Van A", 
                                                120000.0, "Computer Science", "University", 2022);
        Textbook textbook2 = new Textbook("TBT002", "Physics 12", "Tran Thi B", 
                                                90000.0, "Physics", "HighSchool", 2018);

        // 2. Create Novel objects
        // Price Calculation Example for NOV002: 75,000 + 15,000 = 90,000 VND
        Novel novel1 = new Novel("NOV001", "Hanoi Long Story", "To Hoai", 
                                                80000.0, "Modern Literature", false); // Single
        Novel novel2 = new Novel("NOV002", "The Little Prince - Vol 1", "Saint-Exupery", 
                                                75000.0, "Fantasy", true); // Series

        // 3. Execute Add New function
        manager.addNewBook(textbook1);
        manager.addNewBook(novel1);
        manager.addNewBook(textbook2);
        manager.addNewBook(novel2);

        // 4. Execute Display Book List function
        manager.displayBookList();

        // 5. Execute Search by Book ID function
        System.out.println("\n--- EXECUTING SEARCH (ID NOV002) ---");
        String searchID = "NOV002";
        Book foundBook = manager.findByBookID(searchID);
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book with ID " + searchID + " not found.");
        }
        
        // 6. Execute Update function
        System.out.println("\n--- EXECUTING UPDATE (ID NOV001) ---");
        manager.updateBook("NOV001", 100000.0); // Increase base price of NOV001
        // Check after update
        System.out.println("Info after update: " + manager.findByBookID("NOV001"));
        
        // 7. Execute Delete function
        System.out.println("\n--- EXECUTING DELETE (ID TBT001) ---");
        manager.deleteBook("TBT001");
        
        // 8. Display list after deletion
        manager.displayBookList();
    }
}