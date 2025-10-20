import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private List<Book> bookList;
    private Scanner scanner;

    public BookManager() {
        this.bookList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Add New Book (Uses Polymorphism)
     */
    public void addNewBook(Book book) {
        if (findByBookID(book.getBookID()) != null) {
            System.out.println("(!) Addition failed: Book ID " + book.getBookID() + " already exists.");
            return;
        }
        this.bookList.add(book);
        System.out.println("(+) Successfully added book: " + book.gettitle());
    }

    /**
     * Display the list of Books
     */
    public void displayBookList() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is currently empty.");
            return;
        }
        System.out.println("\n--- CURRENT BOOK LIST (" + bookList.size() + " items) ---");
        for (Book book : bookList) {
            // Polymorphism: Automatically calls the correct toString() of the subclass
            System.out.println(book);
        }
        System.out.println("-----------------------------------------------------");
    }

    /**
     * Search by Book ID
     */
    public Book findByBookID(String bookID) {
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(bookID)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Delete Book by Book ID
     */
    public boolean deleteBook(String bookID) {
        Book bookToDelete = findByBookID(bookID);
        if (bookToDelete != null) {
            bookList.remove(bookToDelete);
            System.out.println("(-) Successfully deleted book with ID " + bookID + ".");
            return true;
        }
        System.out.println("(!) Deletion failed: Book ID " + bookID + " not found.");
        return false;
    }

    /**
     * Update Book (Simple: Update Base Price)
     */
    public void updateBook(String bookID, double newBasePrice) {
        Book bookToUpdate = findByBookID(bookID);
        if (bookToUpdate != null) {
            bookToUpdate.basePrice = newBasePrice; // Update protected property
            System.out.println("(~) Successfully updated book ID " + bookID + ". New Base Price: " + String.format("%,.0f VND", newBasePrice));
            // The selling price will be recalculated automatically when calling calculateSellingPrice()
        } else {
            System.out.println("(!) Update failed: Book ID " + bookID + " not found.");
        }
    }
}