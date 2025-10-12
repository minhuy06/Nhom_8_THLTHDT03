package baitap4;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
	private ArrayList<Book> listBooks;
	private Scanner sc = new Scanner(System.in);

	// Hàm tạo
	public BookManager() {
		listBooks = new ArrayList<>();
	}

	// 1️⃣ Thêm mới sách (nhập từ bàn phím)
	public void addBook() {
		System.out.println("=== THÊM SÁCH MỚI ===");
		System.out.print("Nhập loại sách (1-Giáo trình, 2-Tiểu thuyết): ");
		int choice = sc.nextInt();
		sc.nextLine(); // bỏ qua ký tự Enter

		System.out.print("Nhập mã sách: ");
		String id = sc.nextLine();
		System.out.print("Nhập tiêu đề: ");
		String title = sc.nextLine();
		System.out.print("Nhập tác giả: ");
		String author = sc.nextLine();
		System.out.print("Nhập năm xuất bản: ");
		int year = sc.nextInt();
		System.out.print("Nhập số lượng: ");
		int qty = sc.nextInt();
		sc.nextLine();

		Book b = null;

		if (choice == 1) {
			System.out.print("Nhập môn học: ");
			String monHoc = sc.nextLine();
			System.out.print("Nhập cấp độ (Đại học, Phổ thông...): ");
			String capDo = sc.nextLine();
			b = new Textbook(id, title, author, year, qty, monHoc, capDo);
		} else if (choice == 2) {
			System.out.print("Nhập thể loại: ");
			String theLoai = sc.nextLine();
			System.out.print("Có phải sách series không? (true/false): ");
			boolean isSeries = sc.nextBoolean();
			b = new Novel(id, title, author, year, qty, theLoai, isSeries);
		} else {
			System.out.println("❌ Lựa chọn không hợp lệ!");
			return;
		}

		listBooks.add(b);
		System.out.println("✅ Thêm sách thành công!");
	}

	public void displayAllBooks() {
		if (listBooks.isEmpty()) {
			System.out.println("Danh sách sách trống!");
			return;
		}

		System.out.println("\n=== DANH SÁCH SÁCH ===");
		for (Book b : listBooks) {
			System.out.println("------------------------------");
			System.out.println(b.toString());
		}
	}

	public void findBookByID() {
		System.out.print("Nhập mã sách cần tìm: ");
		String id = sc.nextLine();
		for (Book b : listBooks) {
			if (b.Get_bookID().equalsIgnoreCase(id)) {
				System.out.println("✅ Tìm thấy sách:");
				System.out.println(b.toString());
				return;
			}
		}
		System.out.println("❌ Không tìm thấy sách có mã " + id);
	}

	public void removeBook() {
		System.out.print("Nhập mã sách cần xóa: ");
		String id = sc.nextLine();
		for (Book b : listBooks) {
			if (b.Get_bookID().equalsIgnoreCase(id)) {
				listBooks.remove(b);
				System.out.println("✅ Đã xóa sách có mã " + id);
				return;
			}
		}
		System.out.println("❌ Không tìm thấy sách để xóa!");
	}

	public void menu() {
		int choice;
		do {
			System.out.println("\n====== QUẢN LÝ SÁCH ======");
			System.out.println("1. Thêm sách mới");
			System.out.println("2. Hiển thị danh sách sách");
			System.out.println("3. Tìm kiếm sách theo mã");
			System.out.println("4. Xóa sách theo mã");
			System.out.println("0. Thoát");
			System.out.print("➡ Chọn chức năng: ");
			choice = sc.nextInt();
			sc.nextLine(); // bỏ Enter

			switch (choice) {
			case 1 -> addBook();
			case 2 -> displayAllBooks();
			case 3 -> findBookByID();
			case 4 -> removeBook();
			case 0 -> System.out.println("👋 Thoát chương trình.");
			default -> System.out.println("❌ Lựa chọn không hợp lệ!");
			}
		} while (choice != 0);
	}
}
