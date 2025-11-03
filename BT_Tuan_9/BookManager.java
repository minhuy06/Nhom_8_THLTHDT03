package BT_Tuan_8;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
	private ArrayList<Book> books = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public void themSach() {
		System.out.print("Loại sách (1-Giáo trình, 2-Tiểu thuyết): ");
		int loai = sc.nextInt();
		sc.nextLine();

		System.out.print("Mã sách: ");
		String ma = sc.nextLine();
		System.out.print("Tiêu đề: ");
		String tieuDe = sc.nextLine();
		System.out.print("Tác giả: ");
		String tacGia = sc.nextLine();
		System.out.print("Năm xuất bản: ");
		int nam = sc.nextInt();
		System.out.print("Số lượng: ");
		int sl = sc.nextInt();
		System.out.print("Giá cơ bản: ");
		double gia = sc.nextDouble();
		sc.nextLine();

		Book sach = null;
		if (loai == 1) {
			System.out.print("Môn học: ");
			String mon = sc.nextLine();
			System.out.print("Cấp độ: ");
			String cap = sc.nextLine();
			sach = new Textbook(ma, tieuDe, tacGia, nam, sl, gia, mon, cap);
		} else if (loai == 2) {
			System.out.print("Thể loại: ");
			String tl = sc.nextLine();
			System.out.print("Sách series? (true/false): ");
			boolean series = sc.nextBoolean();
			sc.nextLine();
			sach = new Novel(ma, tieuDe, tacGia, nam, sl, gia, tl, series);
		}

		if (sach != null) {
			books.add(sach);
			System.out.println("Thêm sách thành công!");
		}
	}

	public void hienThiDanhSach() {
		if (books.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}
		for (Book b : books) {
			System.out.println("----------------");
			System.out.println(b);
		}
	}

	public void timSach() {
		System.out.print("Mã sách cần tìm: ");
		String ma = sc.nextLine();
		for (Book b : books) {
			if (b.getMaSach().equalsIgnoreCase(ma)) {
				System.out.println(b);
				return;
			}
		}
		System.out.println("Không tìm thấy!");
	}

	public void xoaSach() {
		System.out.print("Mã sách cần xóa: ");
		String ma = sc.nextLine();
		books.removeIf(b -> b.getMaSach().equalsIgnoreCase(ma));
		System.out.println("Xóa sách thành công nếu tồn tại!");
	}

	public void capNhatSach() {
		System.out.print("Mã sách cần cập nhật: ");
		String ma = sc.nextLine();
		Book sach = null;
		for (Book b : books)
			if (b.getMaSach().equalsIgnoreCase(ma)) {
				sach = b;
				break;
			}
		if (sach == null) {
			System.out.println("Không tìm thấy!");
			return;
		}

		System.out.print("Tiêu đề mới: ");
		String td = sc.nextLine();
		if (!td.isEmpty())
			sach.setTieuDe(td);
		System.out.print("Tác giả mới: ");
		String tg = sc.nextLine();
		if (!tg.isEmpty())
			sach.setTacGia(tg);
		System.out.print("Năm xuất bản mới: ");
		String n = sc.nextLine();
		if (!n.isEmpty())
			sach.setNamXuatBan(Integer.parseInt(n));
		System.out.print("Số lượng mới: ");
		String s = sc.nextLine();
		if (!s.isEmpty())
			sach.setSoLuong(Integer.parseInt(s));
		System.out.print("Giá cơ bản mới: ");
		String g = sc.nextLine();
		if (!g.isEmpty())
			sach.setGiaCoBan(Double.parseDouble(g));

		if (sach instanceof Textbook) {
			Textbook tb = (Textbook) sach;
			System.out.print("Môn học mới: ");
			String mon = sc.nextLine();
			if (!mon.isEmpty())
				tb.setMonHoc(mon);
			System.out.print("Cấp độ mới: ");
			String cap = sc.nextLine();
			if (!cap.isEmpty())
				tb.setCapDo(cap);
		} else if (sach instanceof Novel) {
			Novel nv = (Novel) sach;
			System.out.print("Thể loại mới: ");
			String tl = sc.nextLine();
			if (!tl.isEmpty())
				nv.setTheLoai(tl);
			System.out.print("Sách series? (true/false): ");
			String ser = sc.nextLine();
			if (!ser.isEmpty())
				nv.setLaSachSeries(Boolean.parseBoolean(ser));
		}

		System.out.println("Cập nhật thành công!");
	}

	public void menu() {
		int chon;
		do {
			System.out.println("\n1.Thêm  2.Hiển thị  3.Tìm  4.Xóa  5.Cập nhật  0.Thoát");
			System.out.print("Chọn: ");
			chon = sc.nextInt();
			sc.nextLine();
			switch (chon) {
			case 1 -> themSach();
			case 2 -> hienThiDanhSach();
			case 3 -> timSach();
			case 4 -> xoaSach();
			case 5 -> capNhatSach();
			case 0 -> System.out.println("Thoát!");
			default -> System.out.println("Sai lựa chọn!");
			}
		} while (chon != 0);
	}
}
