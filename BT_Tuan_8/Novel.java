package Baituan8;

public class Novel extends Book {
	private String theLoai;
	private boolean laSachSeries;

	public Novel() {
		super();
	}

	public Novel(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan,
			String theLoai, boolean laSachSeries) {
		super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
		this.theLoai = theLoai;
		this.laSachSeries = laSachSeries;
	}

	// Getter / Setter
	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public boolean isLaSachSeries() {
		return laSachSeries;
	}

	public void setLaSachSeries(boolean laSachSeries) {
		this.laSachSeries = laSachSeries;
	}

	@Override
	public String toString() {
		return super.toString() + "\nThể loại: " + theLoai + "\nLà sách series: " + (laSachSeries ? "Có" : "Không")
				+ "\nGiá bán: " + tinhGiaBan() + " VNĐ";
	}

	@Override
	public double tinhGiaBan() {
		double phuThuSeries = laSachSeries ? 15000 : 0;
		return getGiaCoBan() + phuThuSeries;
	}

	// Bổ sung theo yêu cầu IKiemKe
	@Override
	public boolean kiemTraTonKho(int soLuongToiThieu) {
		return getSoLuong() >= soLuongToiThieu;
	}

	@Override
	public void capNhatViTri(String viTriMoi) {
		System.out.println("Đã chuyển sách \"" + getTieuDe() + "\" đến khu vực: " + viTriMoi);
	}
}
