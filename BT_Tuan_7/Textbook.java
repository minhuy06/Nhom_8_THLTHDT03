public class Textbook extends Book {
    // New properties (Current week's requirement)
    private String subject;
    private String level; // E.g., University, HighSchool
    
    // Property for price calculation (Previous week's requirement)
    private int publicationYear; 

    // Full Constructor
    public Textbook(String bookID, String title, String author, double basePrice, 
                    String subject, String level, int publicationYear) {
        super(bookID, title, author, basePrice);
        this.subject = subject;
        this.level = level;
        this.publicationYear = publicationYear;
    }

    // Override the abstract method (Implementation of the previous week's price logic)
    @Override
    public double calculateSellingPrice() {
        // Logic: Selling Price = basePrice + (Years Published * 5,000 VND). (Assuming current year is 2025)
        final int CURRENT_YEAR = 2025;
        final double ANNUAL_SURCHARGE = 5000.0;
        
        int yearsPublished = CURRENT_YEAR - this.publicationYear;
        
        // Ensure years published is not negative
        return this.basePrice + (Math.max(0, yearsPublished) * ANNUAL_SURCHARGE);
    }
    
    // Override toString() to display all information
    @Override
    public String toString() {
        return super.toString() + String.format(
                ", Type: Textbook, Subject: %s, Level: %s, Selling Price: %,.0f VND (Pub Year: %d)",
                subject, level, calculateSellingPrice(), publicationYear);
    }
}