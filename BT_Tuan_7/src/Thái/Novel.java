package Thái;

public class Novel extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public Novel(String theLoai, boolean laSachSeries) {
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    public Novel(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong,double giaCoBan, String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    @Override
    public double tinhGiaBan() {
        if(this.laSachSeries)
        return this.getGiaCoBan()+15000;
        else
            return this.getGiaCoBan();

    }
}
