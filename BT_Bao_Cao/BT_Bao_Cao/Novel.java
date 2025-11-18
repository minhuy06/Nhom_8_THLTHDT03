package BT_Tuan_9;

import java.util.Scanner;

public class Novel extends Book {
	// Các attribute của class Novel
	private String theLoai;
	private boolean laSachSeries;
	// Constructor không tham số

	public Novel() {
		super();
	}

	// Constructor có tham số
	public Novel(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan,
			String tinhTrang, String theLoai, boolean laSachSeries) {
		super(book_ID, title, author, pub_year, quantity, giaCoBan, tinhTrang);
		this.theLoai = theLoai;
		this.laSachSeries = laSachSeries;
	}

	// Getter & Setter
	public void SettheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public void SetlaSachSeries(boolean laSachSeries) {
		this.laSachSeries = laSachSeries;
	}

	public String getTheLoai() {
		return this.theLoai;
	}

	public boolean getLaSachSeries() {
		return this.laSachSeries;
	}

	// Các method class Novel
	@Override
	public void nhap(boolean boQuaNhapMa) {
		super.nhap(boQuaNhapMa);
		Scanner sc = new Scanner(System.in);

		// Nhập thể loại
		while (true) {
			System.out.print("Nhập thể loại tiểu thuyết: ");
			this.theLoai = sc.nextLine().trim();

			if (this.theLoai.isEmpty()) {
				System.out.println(" Thể loại không được để trống!");
			} else if (this.theLoai.length() > 50) {
				System.out.println(" Tên thể loại quá dài (tối đa 50 ký tự)!");
			} else {
				break; // hợp lệ
			}
		}

		// Nhập có phải sách series hay không?
		while (true) {
			System.out.print("Có phải sách thuộc series không? (true/false): ");
			String input = sc.nextLine().trim().toLowerCase();

			if (input.equals("true")) {
				this.laSachSeries = true;
				break;
			} else if (input.equals("false")) {
				this.laSachSeries = false;
				break;
			} else {
				System.out.println(" Vui lòng chỉ nhập 'true' hoặc 'false'!");
			}
		}

		System.out.println(" Đã nhập thông tin tiểu thuyết thành công!");
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Thể loại: " + this.theLoai);
		System.out.println("Là sách series: " + (this.laSachSeries ? "Có" : "Không"));
		System.out.println("Giá bán: " + this.tinhGiaBan());
	}

	@Override
	public void printTableHeader() {
		System.out.printf("%-10s %-25s %-18s %-6s %-8s %-12s %-12s %-15s %-15s %-10s%n", "MA_NOVEL", "TIÊU ĐỀ",
				"TÁC GIẢ", "NĂM", "S.LG", "GIÁ CƠ BẢN", "GIÁ BÁN", "TÌNH TRẠNG", "THỂ LOẠI", "SERIES");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void printTableRow() {
		String shortTitle = getTitle().length() > 25 ? getTitle().substring(0, 22) + "..." : getTitle();
		String shortAuthor = getAuthor().length() > 18 ? getAuthor().substring(0, 15) + "..." : getAuthor();
		String tinhTrang = (getStatus() != null) ? getStatus().getTinhTrang() : "Chưa xác định";
		String series = laSachSeries ? "Có" : "Không";

		System.out.printf("%-10s %-25s %-18s %-6d %-8d %-12.2f %-12.2f %-15s %-15s %-10s%n", getBook_ID(), shortTitle,
				shortAuthor, getPub_year(), getQuantity(), getGiaCoBan(), tinhGiaBan(), tinhTrang, getTheLoai(),
				series);
	}

	@Override
	public double tinhGiaBan() {
		if (this.laSachSeries == true)
			return this.giaCoBan + 15000;
		else
			return this.giaCoBan;
	}

	@Override
	public String toString() {
		return "Novel [theLoai=" + theLoai + ", laSachSeries=" + laSachSeries + ", getTheLoai()=" + getTheLoai()
				+ ", getLaSachSeries()=" + getLaSachSeries() + ", tinhGiaBan()=" + tinhGiaBan() + "]";
	}
}
