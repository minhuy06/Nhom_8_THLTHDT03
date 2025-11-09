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
	public double tinhGiaBan() {
		if (this.laSachSeries == true)
			return this.giaCoBan + 15000;
		else
			return this.giaCoBan;
	}

	@Override
	public String toString() {
		return "Novel [theLoai=" + theLoai + ", laSachSeries=" + laSachSeries + ", book_ID=" + book_ID + ", title="
				+ title + ", author=" + author + ", pub_year=" + pub_year + ", quantity=" + quantity + ", giaCoBan="
				+ giaCoBan + ", status=" + status + ", getTheLoai()=" + getTheLoai() + ", getLaSachSeries()="
				+ getLaSachSeries() + ", tinhGiaBan()=" + tinhGiaBan() + ", getBook_ID()=" + getBook_ID()
				+ ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getPub_year()=" + getPub_year()
				+ ", getQuantity()=" + getQuantity() + ", getGiaCoBan()=" + getGiaCoBan() + ", getStatus()="
				+ getStatus() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}
