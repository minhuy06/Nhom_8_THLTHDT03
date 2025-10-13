package BT_Tuan_6;

public class Textbook extends Book {
	private String monHoc;
	private String capDo;
	
	public Textbook(String book_ID, String title, String author, int pub_year, int quantity, String monHoc, String capDo) {
		super(book_ID, title, author, pub_year, quantity);
		this.monHoc = monHoc;
		this.capDo = capDo;
	}
	
	public void SetmonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public void SetcapDo(String capDo) {
		this.capDo = capDo;
	}
	
	@Override
	public String toString(){
		return super.toString() + "Môn: "+monHoc+", Cấp độ: "+capDo;
	}
}
