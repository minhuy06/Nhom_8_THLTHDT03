package thai;

public class Novel extends Sach {
    private String theLoai;
    private boolean thuocSeries;

    public Novel() {}

    public Novel(String maSach, String tieuDe, String tacGia, double giaCoBan, int soLuong, String viTri,
                 String theLoai, boolean thuocSeries, TinhTrangSach tinhTrang) {
        super(maSach, tieuDe, tacGia, giaCoBan, soLuong, viTri, tinhTrang);
        this.theLoai = theLoai;
        this.thuocSeries = thuocSeries;
    }

    public Novel(String maSach, String tieuDe, String tacGia, double giaCoBan, int soLuong, String viTri,
                 String theLoai, boolean thuocSeries, String tenTinhTrang) {
        super(maSach, tieuDe, tacGia, giaCoBan, soLuong, viTri, new TinhTrangSach(tenTinhTrang));
        this.theLoai = theLoai;
        this.thuocSeries = thuocSeries;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public boolean isThuocSeries() {
        return thuocSeries;
    }

    public void setThuocSeries(boolean thuocSeries) {
        this.thuocSeries = thuocSeries;
    }

    @Override
    public double tinhGiaBan() {
        double heSo = 1.15;
        if (thuocSeries) heSo += 0.05;
        return this.giaCoBan * heSo;
    }

    @Override
    public String toString() {
        return "[Sách tiểu thuyết] " + super.toString() +
                " | Thể loại: " + theLoai +
                " | Series: " + (thuocSeries ? "Có" : "Không") +
                " | Giá bán: " + String.format("%.0f", tinhGiaBan());
    }
}