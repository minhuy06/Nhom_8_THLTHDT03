package BT_Tuan_6;

public class Novel extends Book {
	private String theLoai;
	private boolean laSachSeries;
	
	public Novel(String book_ID, String title, String author, int pub_year, int quantity, String theLoai, boolean laSachSeries) {
		super(book_ID, title, author, pub_year, quantity);
		this.theLoai = theLoai;
		this.laSachSeries = laSachSeries;
	}
	
	public void SettheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public void SetlaSachSeries(boolean laSachSeries) {
		this.laSachSeries = laSachSeries;
	}
	@Override
	public String toString() {
		return super.toString() + "Thể loại: "+theLoai+", Là sách Series: "+laSachSeries;
	}
}