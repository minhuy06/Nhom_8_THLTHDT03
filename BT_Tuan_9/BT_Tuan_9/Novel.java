package Huy;

public class Novel extends Book {
	private String theLoai;
	private boolean laSachSeries;
	
	public Novel(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan, String tinhTrang, String theLoai, boolean laSachSeries) {
		super(book_ID, title, author, pub_year, quantity, giaCoBan, tinhTrang);
		this.theLoai = theLoai;
		this.laSachSeries = laSachSeries;
	}
	
	public void SettheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public void SetlaSachSeries(boolean laSachSeries) {
		this.laSachSeries = laSachSeries;
	}
	
	public double tinhGiaBan() {
		if(this.laSachSeries)
			return giaCoBan + 15000;
		else
			return giaCoBan;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Thể loại: "+theLoai+", Là sách Series: "+laSachSeries+", Giá bán: " +this.tinhGiaBan();
	}
	
}