package Huy;

public class Textbook extends Book {
	private String monHoc;
	private String capDo;
	
	public Textbook(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan, String tinhTrang, String monHoc, String capDo) {
		super(book_ID, title, author, pub_year, quantity, giaCoBan, tinhTrang);
		this.monHoc = monHoc;
		this.capDo = capDo;
	}
	public Textbook() {
		
	}
	
	public void SetmonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public void SetcapDo(String capDo) {
		this.capDo = capDo;
	}
	
	@Override
	public double tinhGiaBan() {
		return giaCoBan + ((2025-pub_year)*5000);
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Môn: " + monHoc + ", Cấp độ: " + capDo + ", Giá Bán: " + this.tinhGiaBan();
	}
}
