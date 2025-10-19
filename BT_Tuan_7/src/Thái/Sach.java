package Thái;
public abstract class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    private double giaCoBan;

    public Sach() {
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaCoBan = giaCoBan;
    }

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

    public double getGiaCoBan() {
        return giaCoBan;
    }

    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan;
    }

    @Override
    public String toString() {
        return "Sach " +
                "Mã sách: '" + maSach + '\'' +
                ", Tiêu Đề:'" + tieuDe + '\'' +
                ", Tác Giả: " + tacGia + '\'' +
                ", Năm Xuất Bản: " + namXuatBan +
                ", Số Lượng: " + soLuong +", Giá Bán: "+this.tinhGiaBan()+
                ' ';
    }
    public abstract double tinhGiaBan();
}

