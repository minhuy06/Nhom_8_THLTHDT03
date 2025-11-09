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

			// Hiển thị toàn bộ danh sách
			if (input.equalsIgnoreCase("all")) {
				// In tất cả Textbook trước
				boolean printedTextbookHeader = false;
				for (Book b : Manage) {
					if (b instanceof Textbook) {
						if (!printedTextbookHeader) {
							b.printTableHeader();
							printedTextbookHeader = true;
						}
						b.printTableRow();
					}
				}
				System.out.println("\n");
				// In tất cả Novel
				boolean printedNovelHeader = false;
				for (Book b : Manage) {
					if (b instanceof Novel) {
						if (!printedNovelHeader) {
							b.printTableHeader();
							printedNovelHeader = true;
						}
						b.printTableRow();
					}
				}
			}

			// Hiển thị sách theo mã
			else {
				Book found = findBookByID(input);

				if (found == null) {
					System.out.println("Không tìm thấy sách có mã: " + input);
				} else {
					found.printTableHeader(); // Đa hình: gọi header theo loại sách
					found.printTableRow(); // Đa hình: gọi row theo loại sách
				}
			}

			// Hỏi người dùng có muốn xem tiếp không
			System.out.print("\nBạn có muốn xem tiếp không? (y/n): ");
			String tiep = sc.nextLine().trim();
			if (!tiep.equalsIgnoreCase("y")) {
				System.out.println("⬅ Quay lại menu chính...");
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

			// Hiển thị thông tin hiện tại của sách
			System.out.println("\n📘 Thông tin hiện tại:");
			found.printTableHeader(); // đa hình
			found.printTableRow(); // đa hình

			// Cho phép nhập mã mới (nếu muốn)
			System.out.print("\nNhập mã sách mới (Enter để giữ nguyên): ");
			String newID = sc.nextLine().trim();
			if (!newID.isEmpty() && !isDuplicateID(newID, found.getBook_ID())) {
				found.setBook_ID(newID);
			}

			// Nhập lại các thông tin khác
			System.out.println("\nNhập lại thông tin mới cho sách:");
			found.nhap(true);

			System.out.println("Cập nhật thành công!");

			System.out.print("\nCập nhật sách khác? (y/n): ");
			if (!sc.nextLine().trim().equalsIgnoreCase("y"))
				return;
		}
	}

	@Override
	public void Search() {
		if (checkEmpty())
			return;

		System.out.print("Nhập mã sách cần tìm: ");
		String ma = sc.nextLine().trim();
		Book found = findBookByID(ma);

		if (found != null) {
			System.out.println("\nKết quả tìm thấy:");
			found.printTableHeader(); // đa hình
			found.printTableRow(); // đa hình
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
			System.out.println("7. Trả sách"); // thêm tùy chọn trả sách
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
			case 7:
				if (!this.checkEmpty())
					this.traSach(); // gọi phương thức trả sách
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
	// Trong BookManager

	// Mượn sách
	public void muonSach() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách sách rỗng!");
			return;
		}

		System.out.print("Nhập mã sách cần mượn: ");
		String ma = sc.nextLine().trim();
		Book found = findBookByID(ma);

		if (found == null) {
			System.out.println("Không tìm thấy sách!");
			return;
		}

		// Kiểm tra trạng thái ngay sau khi nhập mã
		if (found.getStatus().isDangMuon()) {
			System.out.println("Sách đang được mượn, không thể mượn lúc này!");
			return; // Không cần nhập tên người mượn hay số ngày mượn
		}

		// Nếu sách còn trong kho, nhập tiếp thông tin
		System.out.print("Nhập tên người mượn: ");
		String ten = sc.nextLine().trim();

		int ngay;
		while (true) {
			try {
				System.out.print("Nhập số ngày mượn: ");
				ngay = Integer.parseInt(sc.nextLine().trim());
				if (ngay <= 0)
					throw new NumberFormatException();
				break;
			} catch (NumberFormatException e) {
				System.out.println("Số ngày phải > 0!");
			}
		}

		BorrowBook borrow = new BorrowBook(found);
		borrow.muonSach(ten, ngay);
	}

	// Trả sách
	public void traSach() {
		if (Manage.isEmpty()) {
			System.out.println("Danh sách sách rỗng!");
			return;
		}

		System.out.print("Nhập mã sách cần trả: ");
		String ma = sc.nextLine().trim();
		Book found = findBookByID(ma);

		if (found == null) {
			System.out.println("Không tìm thấy sách!");
			return;
		}

		BorrowBook borrow = new BorrowBook(found);
		borrow.traSach();
	}
}