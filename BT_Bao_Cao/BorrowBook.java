package BT_Tuan_9;

import java.time.LocalDate;

public class BorrowBook {
	private Book book;
	private String tenNguoiMuon;
	private int soNgayMuon;
	private LocalDate ngayMuon;
	private LocalDate hanTra;

	public BorrowBook(Book book) {
		this.book = book;
	}

	// Mượn sách
	public void muonSach(String tenNguoiMuon, int soNgayMuon) {
		if (book.getStatus() == null) {
			System.out.println("Trạng thái sách chưa được khởi tạo!");
			return;
		}
		if (book.getStatus().isDangMuon()) {
			System.out.println("Sách đang được mượn!");
			return;
		}

		this.tenNguoiMuon = tenNguoiMuon;
		this.soNgayMuon = soNgayMuon;
		this.ngayMuon = LocalDate.now();
		this.hanTra = ngayMuon.plusDays(soNgayMuon);

		book.getStatus().sachMuon(); // cập nhật trạng thái trong BookStatus

		System.out.println("Mượn thành công! Hạn trả: " + hanTra);
	}

	// Trả sách
	public void traSach() {
		if (book.getStatus() == null || !book.getStatus().isDangMuon()) {
			System.out.println("Sách chưa được mượn nên không có trả");
			return;
		}

		book.getStatus().sachTra(); // cập nhật trạng thái về "Trong kho"

		// Xóa thông tin mượn
		this.tenNguoiMuon = null;
		this.soNgayMuon = 0;
		this.ngayMuon = null;
		this.hanTra = null;

		System.out.println("Đã trả sách thành công!");
	}

	// Getter
	public Book getBook() {
		return book;
	}

	public String getTenNguoiMuon() {
		return tenNguoiMuon;
	}

	public int getSoNgayMuon() {
		return soNgayMuon;
	}

	public LocalDate getNgayMuon() {
		return ngayMuon;
	}

	public LocalDate getHanTra() {
		return hanTra;
	}
}
