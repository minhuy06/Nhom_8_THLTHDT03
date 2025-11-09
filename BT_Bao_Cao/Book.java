package BT_Tuan_9;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Book implements IGiaBan, IKiemKe {
	// Các attribute của class Book
	protected String book_ID;
	protected String title;
	protected String author;
	protected int pub_year;
	protected int quantity;
	protected double giaCoBan;
	protected BookStatus status;

	// Constructor không tham số
	public Book() {
		this.status = new BookStatus("Trong kho"); // tình trạng mặc định
	}

	// Constructor có tham số
	public Book(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan,
			String tinhTrang) {
		this.book_ID = book_ID;
		this.title = title;
		this.author = author;
		this.pub_year = pub_year;
		this.quantity = quantity;
		this.giaCoBan = giaCoBan;
		this.status = new BookStatus(tinhTrang);
	}

	// Getter and setter
	public String getBook_ID() {
		return this.book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPub_year() {
		return this.pub_year;
	}

	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getGiaCoBan() {
		return this.giaCoBan;
	}

	public void setGiaCoBan(double giaCoBan) {
		this.giaCoBan = giaCoBan;
	}

	public BookStatus getStatus() {
		return this.status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	// Các method class Book
	public void nhap(boolean boQuaNhapMa) {
		Scanner sc = new Scanner(System.in);

		// Nhập mã sách
		if (!boQuaNhapMa) { // chỉ nhập mã nếu không trong chế độ cập nhật
			while (true) {
				System.out.print("Nhập mã sách: ");
				this.book_ID = sc.nextLine().trim();

				if (this.book_ID.isEmpty()) {
					System.out.println("Mã sách không được để trống!");
				} else if (!this.book_ID.matches("[A-Za-z0-9_-]+")) {
					System.out.println("Mã sách chỉ được chứa chữ, số, dấu gạch dưới hoặc gạch ngang!");
				} else if (BookManager.isDuplicateID(this.book_ID, null)) { // kiểm tra trùng
					System.out.println("Mã sách '" + this.book_ID + "' đã tồn tại! Vui lòng nhập mã khác.");
				} else {
					break; // mã hợp lệ và không trùng
				}
			}
		}

		// Nhập tiêu đề
		while (true) {
			System.out.print("Nhập tiêu đề: ");
			this.title = sc.nextLine().trim();
			if (this.title.isEmpty()) {
				System.out.println("Tiêu đề không được để trống!");
			} else {
				break;
			}
		}

		// Nhập tác giả
		while (true) {
			System.out.print("Nhập tác giả: ");
			this.author = sc.nextLine().trim();
			if (this.author.isEmpty()) {
				System.out.println("Tác giả không được để trống!");
			} else if (!this.author.matches("[\\p{L} .'-]+")) {
				System.out.println("Tên tác giả chỉ được chứa ký tự chữ!");
			} else {
				break;
			}
		}

		// Nhập năm xuất bản
		while (true) {
			try {
				System.out.print("Nhập năm xuất bản: ");
				this.pub_year = Integer.parseInt(sc.nextLine().trim());
				int currentYear = LocalDate.now().getYear();

				if (this.pub_year < 1000 || this.pub_year > currentYear) {
					System.out.println("Năm xuất bản phải nằm trong khoảng 1000 - " + currentYear + "!");
				} else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số nguyên hợp lệ!");
			}
		}

		// Nhập số lượng
		while (true) {
			try {
				System.out.print("Nhập số lượng: ");
				this.quantity = Integer.parseInt(sc.nextLine().trim());
				if (this.quantity <= 0) {
					System.out.println("Số lượng phải lớn hơn 0!");
				} else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số nguyên hợp lệ!");
			}
		}

		// Nhập giá cơ bản
		while (true) {
			try {
				System.out.print("Nhập giá cơ bản: ");
				this.giaCoBan = Double.parseDouble(sc.nextLine().trim());
				if (this.giaCoBan <= 1000) {
					System.out.println("Giá cơ bản phải lớn hơn 1000!");
				} else if (this.giaCoBan > 1_000_000_000) {
					System.out.println("Giá cơ bản quá lớn, vui lòng nhập nhỏ hơn 1 tỷ!");
				} else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số thực hợp lệ!");
			}
		}

		// Nhập tình trạng
		while (true) {
			System.out.print("Nhập tình trạng (Trong kho / Cho mượn / Hỏng): ");
			String tinhTrang = sc.nextLine().trim();

			if (tinhTrang.isEmpty()) {
				tinhTrang = "Trong kho";
			}

			if (!tinhTrang.equalsIgnoreCase("Trong kho") && !tinhTrang.equalsIgnoreCase("Cho mượn")
					&& !tinhTrang.equalsIgnoreCase("Hỏng")) {
				System.out.println("Tình trạng không hợp lệ! Vui lòng nhập: Trong kho, Cho mượn hoặc Hỏng.");
			} else {
				this.status = new BookStatus(tinhTrang);
				break;
			}
		}
	}

	public void xuat() {
		System.out.println("Mã sách: " + this.book_ID);
		System.out.println("Tiêu đề: " + this.title);
		System.out.println("Tác giả: " + this.author);
		System.out.println("Năm xuất bản: " + this.pub_year);
		System.out.println("Số lượng: " + this.quantity);
		System.out.println("Giá cơ bản: " + this.giaCoBan);
		System.out.println("Tình trạng: " + this.status);
		System.out.println("==========================");
	}

	public abstract double tinhGiaBan();

	@Override
	public boolean kiemTraTonKho(int soLuongToiThieu) {
		if (this.quantity >= soLuongToiThieu)
			return true;
		else
			return false;
	}

	public void muonSach(String nguoiMuon, int soNgayMuon) {
		if (this.status == null) {
			System.out.println(" Trạng thái sách chưa được khởi tạo!");
			return;
		}
		if (soNgayMuon <= 0) {
			System.out.println(" Số ngày mượn phải lớn hơn 0!");
			return;
		}
		this.status.muonSach(nguoiMuon, soNgayMuon);
	}

	public void traSach() {
		if (this.status == null) {
			System.out.println(" Trạng thái sách chưa được khởi tạo!");
			return;
		}
		this.status.traSach();
	}

	@Override
	public void capNhatViTri(String viTriMoi) {
		System.out.println(" Đã chuyển sách [" + this.title + "] đến khu vực [" + viTriMoi + "]");
	}

	@Override
	public String toString() {
		return "Book [book_ID=" + book_ID + ", title=" + title + ", author=" + author + ", pub_year=" + pub_year
				+ ", quantity=" + quantity + ", giaCoBan=" + giaCoBan + ", status=" + status + ", getBook_ID()="
				+ getBook_ID() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getPub_year()="
				+ getPub_year() + ", getQuantity()=" + getQuantity() + ", getGiaCoBan()=" + getGiaCoBan()
				+ ", getStatus()=" + getStatus() + ", tinhGiaBan()=" + tinhGiaBan() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
