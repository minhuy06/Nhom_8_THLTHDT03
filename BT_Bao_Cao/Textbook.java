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
		return monHoc;
	}

	public String getCapDo() {
		return capDo;
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
			monHoc = sc.nextLine().trim();

			if (monHoc.isEmpty()) {
				System.out.println("Môn học không được để trống!");
			} else if (monHoc.length() > 50) {
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
			capDo = sc.nextLine().trim();

			if (capDo.isEmpty()) {
				System.out.println("Cấp độ không được để trống!");
			} else if (capDo.length() > 50) {
				System.out.println("Cấp độ quá dài (tối đa 50 ký tự)!");
			} else if (!capDo.matches("^[\\p{L}\\s]+$")) {
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
		System.out.println("Môn học: " + monHoc);
		System.out.println("Cấp độ: " + capDo);
		System.out.println("Giá bán: " + tinhGiaBan());
	}

	@Override
	public double tinhGiaBan() {
		return giaCoBan + ((2025 - pub_year) * 5000);
	}

	@Override
	public String toString() {
		return super.toString() + ", Môn: " + monHoc + ", Cấp độ: " + capDo + ", Giá bán: " + this.tinhGiaBan();
	}
}
