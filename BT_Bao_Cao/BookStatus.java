package BT_Tuan_9;

import java.time.LocalDate;

public class BookStatus {
	// Các attribute của class BookStatus
	private String tinhTrang; // "Trong kho", "Cho muon", "Mat", ...
	private LocalDate ngayCapNhat; // Ngày cập nhật tình trạng
	private String nguoiMuon; // Tên người mượn (nếu có)
	private LocalDate ngayHenTra; // Hạn trả (nếu có)
	// Constructor không tham số

	public BookStatus() {
	}

	// Constructor có tham số
	public BookStatus(String tinhTrang) {
		this.tinhTrang = tinhTrang;
		this.ngayCapNhat = LocalDate.now();
		this.nguoiMuon = null;
		this.ngayHenTra = null;
	}
	// Getter and setter

	public String getNguoiMuon() {
		return this.nguoiMuon;
	}

	public void setNguoiMuon(String nguoiMuon) {
		this.nguoiMuon = nguoiMuon;
	}

	public LocalDate getNgayHenTra() {
		return this.ngayHenTra;
	}

	public void setNgayHenTra(LocalDate ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}

	public void setNgayCapNhat(LocalDate ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	// Các method class BookStatus
	// Mượn sách
	public void muonSach(String nguoiMuon, int soNgayMuon) {
		if (nguoiMuon == null || nguoiMuon.trim().isEmpty()) {
			System.out.println("Lỗi: Tên người mượn không hợp lệ.");
			return;
		}
		if (soNgayMuon <= 0) {
			System.out.println("Lỗi: Số ngày mượn phải lớn hơn 0.");
			return;
		}

		// Kiểm tra tình trạng sách
		if (this.tinhTrang.equalsIgnoreCase("Trong kho")) {
			this.tinhTrang = "Cho muon";
			this.nguoiMuon = nguoiMuon.trim();
			this.ngayHenTra = LocalDate.now().plusDays(soNgayMuon);
			this.ngayCapNhat = LocalDate.now();

			System.out.println("Mượn sách thành công!");
			System.out.println("Người mượn: " + this.nguoiMuon);
			System.out.println("Hạn trả: " + this.ngayHenTra);
		} else {
			System.out.println("Lỗi: Sách đang ở trạng thái '" + this.tinhTrang + "', không thể cho mượn.");
		}
	}

	public void traSach() {
		if (this.tinhTrang.equalsIgnoreCase("Cho muon")) {
			this.tinhTrang = "Trong kho";
			this.nguoiMuon = null;
			this.ngayHenTra = null;
			this.ngayCapNhat = LocalDate.now();

			System.out.println("Trả sách thành công.");
		} else {
			System.out.println("Lỗi: Sách đang ở trạng thái '" + this.tinhTrang + "', không cần trả.");
		}
	}

	// Kiểm tra nhanh tình trạng
	public boolean isDangMuon() {
		return this.tinhTrang.equalsIgnoreCase("Cho muon");
	}

	public boolean isTrongKho() {
		return this.tinhTrang.equalsIgnoreCase("Trong kho");
	}

	public String getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		if (!tinhTrang.equalsIgnoreCase("Trong kho") && !tinhTrang.equalsIgnoreCase("Cho muon")) {
			System.out.println("Cảnh báo: Trạng thái không hợp lệ!");
			return;
		}
		this.tinhTrang = tinhTrang;
		this.ngayCapNhat = LocalDate.now();
	}

	public LocalDate getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	@Override
	public String toString() {
		return "BookStatus [tinhTrang=" + tinhTrang + ", ngayCapNhat=" + ngayCapNhat + ", nguoiMuon=" + nguoiMuon
				+ ", ngayHenTra=" + ngayHenTra + ", getNguoiMuon()=" + getNguoiMuon() + ", getNgayHenTra()="
				+ getNgayHenTra() + ", isDangMuon()=" + isDangMuon() + ", isTrongKho()=" + isTrongKho()
				+ ", getTinhTrang()=" + getTinhTrang() + ", getNgayCapNhat()=" + getNgayCapNhat() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
