package Baituan6;

public class Textbook extends Book {
	private String monHoc;
	private String capDo;

	public Textbook() {
		super();
	}

	public Textbook(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan,
			String monHoc, String capDo) {
		super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
		this.monHoc = monHoc;
		this.capDo = capDo;
	}

	// Getter / Setter
	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public String getCapDo() {
		return capDo;
	}

	public void setCapDo(String capDo) {
		this.capDo = capDo;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMôn học: " + monHoc + "\nCấp độ: " + capDo + "\nGiá bán: " + tinhGiaBan() + " VNĐ";
	}

	@Override
	public double tinhGiaBan() {
		int namHienTai = 2025;
		int soNamDaXuatBan = namHienTai - getNamXuatBan();
		return getGiaCoBan() + soNamDaXuatBan * 5000;
	}
}
