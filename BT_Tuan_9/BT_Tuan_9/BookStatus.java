package Huy;

import java.time.LocalDate;

public class BookStatus {
	private String tinhTrang;
	private LocalDate ngayCapNhap;
	private String nguoiMuon; 
	private LocalDate ngayHenTra;
	
	public BookStatus(String tinhTrang) {
		this.tinhTrang = tinhTrang;
		this.ngayCapNhap = LocalDate.now(); 
		this.nguoiMuon = null; 
		this.ngayHenTra = null;
	}
	public void muonSach(String nguoiMuon, int soNgayMuon) {
		if (this.tinhTrang.equals("Trong kho")) {
			this.tinhTrang = "Cho muon";
			this.nguoiMuon = nguoiMuon;
			this.ngayHenTra = LocalDate.now().plusDays(soNgayMuon); 
			this.ngayCapNhap = LocalDate.now();
			System.out.println("Muon sach thanh cong, han tra: " + this.ngayHenTra);
		} else {
			System.out.println("Loi! Sach nay o trang thai '" + this.tinhTrang + "', Khong the cho muon.");
		}
	}
	
	public void traSach() {
		if (this.tinhTrang.equals("Cho muon")) {
			this.tinhTrang = "Trong kho";
			this.nguoiMuon = null;
			this.ngayHenTra = null;
			this.ngayCapNhap = LocalDate.now();
			System.out.println("Tra sach thanh cong");
		} else {
			System.out.println("Loi! Sach nay o trang thai '" + this.tinhTrang + "', Khong can tra.");
		}
	}
	
	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
		this.ngayCapNhap = LocalDate.now();
	}

	public LocalDate getNgayCapNhap() {
		return ngayCapNhap;
	}
	
	@Override
	public String toString() {
		if (tinhTrang.equals("Cho muon")) {
			return "Trang thai: " + tinhTrang + 
			       " (Nguoi muon: " + nguoiMuon + 
			       ", Han tra: " + ngayHenTra + ")";
		}
		return "Trang thai: " + tinhTrang + " (Ngay cap nhap: " + ngayCapNhap + ")";
	}
}
	
	

