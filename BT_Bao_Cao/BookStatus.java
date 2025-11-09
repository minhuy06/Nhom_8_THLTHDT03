package BT_Tuan_9;

import java.time.LocalDate;

public class BookStatus {
	private String tinhTrang; // "Trong kho", "Cho muon"
	private LocalDate ngayCapNhat;

	public BookStatus() {
		this.tinhTrang = "Trong kho";
		this.ngayCapNhat = LocalDate.now();
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public LocalDate getNgayCapNhat() {
		return ngayCapNhat;
	}

	// Cập nhật khi sách được mượn
	public void sachMuon() {
		this.tinhTrang = "Cho muon";
		this.ngayCapNhat = LocalDate.now();
	}

	// Cập nhật khi sách được trả
	public void sachTra() {
		this.tinhTrang = "Trong kho";
		this.ngayCapNhat = LocalDate.now();
	}

	public boolean isDangMuon() {
		return "Cho muon".equalsIgnoreCase(this.tinhTrang);
	}

	public boolean isTrongKho() {
		return "Trong kho".equalsIgnoreCase(this.tinhTrang);
	}
}
