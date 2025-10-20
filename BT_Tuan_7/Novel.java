public class Novel extends Book {
    // New properties (Current week's requirement)
    private String genre; // E.g., Romance, Sci-Fi
    private boolean isSeries; 

    // Full Constructor
    public Novel(String bookID, String title, String author, double basePrice, 
                 String genre, boolean isSeries) {
        super(bookID, title, author, basePrice);
        this.genre = genre;
        this.isSeries = isSeries;
    }

    // Override the abstract method (Implementation of the previous week's price logic)
    @Override
    public double calculateSellingPrice() {
        // Logic: Selling Price = basePrice + (If Series: + 15,000 VND, Else: + 0).
        final double SERIES_SURCHARGE = 15000.0;
        
        return this.basePrice + (isSeries ? SERIES_SURCHARGE : 0.0);
    }

    // Override toString() to display all information
    @Override
    public String toString() {
        String seriesStatus = isSeries ? "Series" : "Single";
        return super.toString() + String.format(
                ", Type: Novel, Genre: %s, Series Status: %s, Selling Price: %,.0f VND",
                genre, seriesStatus, calculateSellingPrice());
    }
}