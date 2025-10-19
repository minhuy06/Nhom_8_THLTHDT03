package Baituan6;

public abstract class Book {

	private String maSach;
	private String tieuDe;
	private String tacGia;
	private int namXuatBan;
	private int soLuong;
	private double giaCoBan;

	public Book(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan) {
		this.maSach = maSach;
		this.tieuDe = tieuDe;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.giaCoBan = giaCoBan;
	}

	public Book() {
	}

	// Setter
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setGiaCoBan(double giaCoBan) {
		this.giaCoBan = giaCoBan;
	}

	// Getter
	public String getMaSach() {
		return maSach;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public String getTacGia() {
		return tacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public double getGiaCoBan() {
		return giaCoBan;
	}

	@Override
	public String toString() {
		return "Mã sách: " + maSach + "\nTiêu đề: " + tieuDe + "\nTác giả: " + tacGia + "\nNăm xuất bản: " + namXuatBan
				+ "\nSố lượng: " + soLuong + "\nGiá cơ bản: " + giaCoBan;
	}

	public abstract double tinhGiaBan();
}
