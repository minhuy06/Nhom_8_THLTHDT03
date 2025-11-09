package BT_Tuan_9;

import java.util.Scanner;

public class Textbook extends Book {
	// Các attribute của class Textbook
	private String monHoc;
	private String capDo;

	// Constructor không tham số
	public Textbook() {
		super();
	}

	// Constructor có tham số
	public Textbook(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan,
			String tinhTrang, String monHoc, String capDo) {
		super(book_ID, title, author, pub_year, quantity, giaCoBan, tinhTrang);
		this.monHoc = monHoc;
		this.capDo = capDo;
	}

	// Getter and setter
	public void SetmonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public void SetcapDo(String capDo) {
		this.capDo = capDo;
	}

	public String getMonHoc() {
		return this.monHoc;
	}

	public String getCapDo() {
		return this.capDo;
	}

	// Các method class Textbook
	@Override
	public void nhap(boolean boQuaNhapMa) {
		// Gọi nhập thông tin chung từ lớp cha Book (có thể bỏ qua nhập mã nếu
		// boQuaNhapMa = true
		super.nhap(boQuaNhapMa);

		Scanner sc = new Scanner(System.in);

		// Nhập môn học
		while (true) {
			System.out.print("Nhập môn học: ");
			this.monHoc = sc.nextLine().trim();

			if (this.monHoc.isEmpty()) {
				System.out.println("Môn học không được để trống!");
			} else if (this.monHoc.length() > 50) {
				System.out.println("Tên môn học quá dài (tối đa 50 ký tự)!");
			} else if (!monHoc.matches("^[\\p{L}\\s]+$")) {
				System.out.println("Môn học chỉ được chứa chữ cái và khoảng trắng!");
			} else {
				break;
			}
		}

		// Nhập cấp độ
		while (true) {
			System.out.print("Nhập cấp độ (VD: Tiểu học, THPT, Đại học...): ");
			this.capDo = sc.nextLine().trim();

			if (this.capDo.isEmpty()) {
				System.out.println("Cấp độ không được để trống!");
			} else if (this.capDo.length() > 50) {
				System.out.println("Cấp độ quá dài (tối đa 50 ký tự)!");
			} else if (!this.capDo.matches("^[\\p{L}\\s]+$")) {
				System.out.println("Cấp độ chỉ được chứa chữ cái và khoảng trắng!");
			} else {
				break;
			}
		}

		System.out.println("Đã nhập thông tin giáo trình thành công!");
	}

	@Override
	public void xuat() {
		super.xuat(); // Xuất thông tin chung
		System.out.println("Môn học: " + this.monHoc);
		System.out.println("Cấp độ: " + this.capDo);
		System.out.println("Giá bán: " + this.tinhGiaBan());
	}

	@Override
	public void printTableHeader() {
		System.out.printf("%-10s %-25s %-18s %-6s %-8s %-12s %-12s %-15s %-15s %-12s%n", "MA_TEXTBOOK", "TIÊU ĐỀ",
				"TÁC GIẢ", "NĂM", "S.LG", "GIÁ CƠ BẢN", "GIÁ BÁN", "TÌNH TRẠNG", "MÔN HỌC", "CẤP ĐỘ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void printTableRow() {
		String shortTitle = getTitle().length() > 25 ? getTitle().substring(0, 22) + "..." : getTitle();
		String shortAuthor = getAuthor().length() > 18 ? getAuthor().substring(0, 15) + "..." : getAuthor();
		String tinhTrang = (getStatus() != null) ? getStatus().getTinhTrang() : "Chưa xác định";

		System.out.printf("%-10s %-25s %-18s %-6d %-8d %-12.2f %-12.2f %-15s %-15s %-12s%n", getBook_ID(), shortTitle,
				shortAuthor, getPub_year(), getQuantity(), getGiaCoBan(), tinhGiaBan(), tinhTrang, getMonHoc(),
				getCapDo());
	}

	@Override
	public double tinhGiaBan() {
		return this.giaCoBan + ((2025 - this.pub_year) * 5000);
	}

	@Override
	public String toString() {
		return "Textbook [monHoc=" + monHoc + ", capDo=" + capDo + ", getMonHoc()=" + getMonHoc() + ", getCapDo()="
				+ getCapDo() + ", tinhGiaBan()=" + tinhGiaBan() + "]";
	}

}
