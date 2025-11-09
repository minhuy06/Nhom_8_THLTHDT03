package BT_Tuan_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements IQuanLySach {
	private static List<Book> Manage;
	private Scanner sc = new Scanner(System.in);

	public BookManager() {
		this.Manage = new ArrayList<>();
	}

	// ==================== METHOD NHÁNH ====================
	// Method kiểm tra mã có trùng hay không
	public static boolean isDuplicateID(String ma, String excludeID) {
		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(ma)) {
				if (excludeID == null || !b.getBook_ID().equalsIgnoreCase(excludeID)) {
					return true;
				}
			}
		}
		return false;
	}

	// Method tìm mã có trong danh sách hay không
	private Book findBookByID(String id) {
		for (Book b : Manage) {
			if (b.getBook_ID().equalsIgnoreCase(id)) {
				return b;
			}
		}
		return null;
	}

	// Trả về true nếu danh sách trống, đồng thời in thông báo
	private boolean checkEmpty() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách trống!");
			return true;
		}
		return false;
	}

	// In danh sách ngắn (mã + tiêu đề) hoặc là danh sách trống
	private void showBookList() {
		if (this.checkEmpty()) { // dùng method checkEmpty để kiểm tra danh sách trống
			return;
		}

		System.out.println("\nDANH SÁCH SÁCH HIỆN CÓ:");
		System.out.printf("%-10s %-40s%n", "MÃ SÁCH", "TIÊU ĐỀ");
		System.out.println("--------------------------------------------------------------");

		for (Book b : Manage) {
			String shortTitle = b.getTitle().length() > 40 ? b.getTitle().substring(0, 37) + "..." : b.getTitle();
			System.out.printf("%-10s %-40s%n", b.getBook_ID(), shortTitle);
		}
	}

	// Phương thức quay lại menu
	private boolean returnToMenu(String input) {
		if (input.equals("0")) {
			System.out.println("Quay lại menu chính...");
			return true;
		}
		return false;
	}

	private void printTableHeader() {
		System.out.printf("%-10s %-35s %-18s %-6s %-8s %-10s%n", "MÃ SÁCH", "TIÊU ĐỀ", "TÁC GIẢ", "NĂM", "S.LG",
				"GIÁ BÁN");
		System.out.println(
				"-----------------------------------------------------------------------------------------------");
	}

	private void printTableRow(Book b) {
		String title = b.getTitle().length() > 35 ? b.getTitle().substring(0, 32) + "..." : b.getTitle();
		String author = b.getAuthor().length() > 18 ? b.getAuthor().substring(0, 15) + "..." : b.getAuthor();
		System.out.printf("%-10s %-35s %-18s %-6d %-8d %-10.2f%n", b.getBook_ID(), title, author, b.getPub_year(),
				b.getQuantity(), b.tinhGiaBan());
	}

	// ==================== METHOD CHÍNH ====================
	@Override
	public void addBook(Book book) {
		this.Manage.add(book);
	}

	// Method thêm sách
	@Override
	public void Add() {
		Book book = null;
		System.out.println("\n Chọn loại sách cần thêm:");
		System.out.println("1. Textbook");
		System.out.println("2. Novel");
		System.out.println("0. Hủy thao tác");

		while (true) {
			System.out.print(" Nhập lựa chọn của bạn: ");
			String input = sc.nextLine().trim();

			if (this.returnToMenu(input))
				return;

			try {
				int choice = Integer.parseInt(input);
				switch (choice) {
				case 1:
					book = new Textbook();
					break;
				case 2:
					book = new Novel();
					break;
				default:
					System.out.println("Vui lòng chọn 1, 2 hoặc 0!");
					continue;
				}
				book.nhap(false);
				Manage.add(book);
				System.out.println("Thêm sách thành công!");
				break;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai định dạng, vui lòng nhập số!");
			}
		}
	}

	// Method hiển thị
	@Override
	public void Display() {
		if (this.checkEmpty())
			return;
		this.showBookList();

		while (true) {
			System.out.print("\nNhập mã sách để xem chi tiết (all để xem tất cả, 0 để quay lại): ");
			String input = sc.nextLine().trim();

			if (this.returnToMenu(input))
				return;

			// Hiển thị tất cả sách
			if (input.equalsIgnoreCase("all")) {
				this.printTableHeader();
				for (Book b : Manage)
					printTableRow(b);
			}
			// Hiển thị 1 mã cụ thể
			else {
				Book found = findBookByID(input);

				if (found == null) {
					System.out.println("Không tìm thấy sách có mã: " + input);
				} else {
					this.printTableHeader();
					this.printTableRow(found);
				}
			}

			// Hỏi người dùng có muốn xem tiếp
			System.out.print("\nBạn có muốn xem tiếp không? (y/n): ");
			String tiep = sc.nextLine().trim();
			if (!tiep.equalsIgnoreCase("y")) {
				System.out.println("Quay lại menu chính...");
				return;
			}
		}
	}

	// Method xoá sách
	@Override
	public void Delete() {
		if (this.checkEmpty())
			return;

		this.showBookList();

		while (true) {
			System.out.print("\nNhập mã sách cần xóa (0 để hủy): ");
			String ma = sc.nextLine().trim();
			if (this.returnToMenu(ma))
				return;

			Book found = this.findBookByID(ma);

			if (found == null) {
				System.out.println("Không tìm thấy mã: " + ma);
				continue;
			}

			System.out.printf("Xác nhận xóa [%s - %s]? (y/n): ", found.getBook_ID(), found.getTitle());
			if (this.sc.nextLine().trim().equalsIgnoreCase("y")) {
				Manage.remove(found);
				System.out.println("Đã xóa thành công!");
			}
			break;
		}
	}

	// Method cập nhật
	@Override
	public void Update() {
		if (this.checkEmpty())
			return;

		while (true) {
			this.showBookList();
			System.out.print("\nNhập mã sách cần cập nhật (0 để quay lại): ");
			String ma = sc.nextLine().trim();
			if (this.returnToMenu(ma))
				return;

			Book found = this.findBookByID(ma);

			if (found == null) {
				System.out.println("Không tìm thấy sách có mã: " + ma);
				continue;
			}

			System.out.println("\nThông tin hiện tại:");
			this.printTableHeader();
			this.printTableRow(found);

			System.out.print("\nNhập mã sách mới (Enter để giữ nguyên): ");
			String newID = this.sc.nextLine().trim();
			if (!newID.isEmpty() && !isDuplicateID(newID, found.getBook_ID())) {
				found.setBook_ID(newID);
			}

			System.out.println("Nhập lại thông tin mới cho sách:");
			found.nhap(true);
			System.out.println("Cập nhật thành công!");

			System.out.print("\nCập nhật sách khác? (y/n): ");
			if (!this.sc.nextLine().trim().equalsIgnoreCase("y"))
				return;
		}
	}

	// Method tìm kiếm
	@Override
	public void Search() {
		if (checkEmpty())
			return;

		System.out.print("Nhập mã sách cần tìm: ");
		String ma = sc.nextLine().trim();
		Book found = findBookByID(ma);

		if (found != null) {
			printTableHeader();
			printTableRow(found);
		} else {
			System.out.println("Không tìm thấy sách có mã: " + ma);
		}
	}

	//
	@Override
	public void Start() {
		int choice;
		do {
			System.out.println("\n===== MENU QUẢN LÝ SÁCH =====");
			System.out.println("1. Thêm sách");
			System.out.println("2. Hiển thị");
			System.out.println("3. Xóa sách");
			System.out.println("4. Cập nhật");
			System.out.println("5. Tìm kiếm");
			System.out.println("6. Mượn sách");
			System.out.println("0. Thoát");
			System.out.print("Nhập lựa chọn: ");
			choice = this.sc.nextInt();
			this.sc.nextLine(); // đọc bỏ dòng thừa
			switch (choice) {
			case 1:
				Add();
				break;
			case 2:
				if (!this.checkEmpty())
					this.Display();
				break;
			case 3:
				if (!this.checkEmpty())
					this.Delete();
				break;
			case 4:
				if (!this.checkEmpty())
					this.Update();
				break;
			case 5:
				if (!this.checkEmpty())
					this.Search();
				break;
			case 6:
				if (!this.checkEmpty())
					this.muonSach();
				break;
			case 0:
				System.out.println("Thoát chương trình!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
				break;
			}
		} while (choice != 0);
	}

	// ==================== MƯỢN SÁCH ====================
	public void muonSach() {
		if (this.checkEmpty())
			return;

		while (true) {
			this.showBookList();
			System.out.print("\nNhập mã sách cần mượn (0 để quay lại): ");
			String ma = this.sc.nextLine().trim();
			if (returnToMenu(ma))
				return;

			Book found = findBookByID(ma);

			if (found == null) {
				System.out.println("Không tìm thấy mã: " + ma);
				continue;
			}

			System.out.println("\nThông tin sách:");
			System.out.println("----------------------------------------");
			System.out.println("Tiêu đề: " + found.getTitle());
			System.out.println("Tình trạng: " + found.getStatus().getTinhTrang());

			String tt = found.getStatus().getTinhTrang();
			if (tt.equalsIgnoreCase("Cho mượn")) {
				System.out.println("Sách đang được mượn!");
				continue;
			}

			System.out.print("Nhập tên người mượn: ");
			String nguoiMuon = this.sc.nextLine().trim();

			int soNgay;
			while (true) {
				try {
					System.out.print("Nhập số ngày mượn: ");
					soNgay = Integer.parseInt(sc.nextLine().trim());
					if (soNgay <= 0)
						throw new NumberFormatException();
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập số nguyên > 0!");
				}
			}

			found.muonSach(nguoiMuon, soNgay);
			System.out.println("Mượn thành công! Hẹn trả: " + found.getStatus().getNgayHenTra());

			System.out.print("\nMượn sách khác? (y/n): ");
			if (!this.sc.nextLine().trim().equalsIgnoreCase("y"))
				return;
		}
	}
}