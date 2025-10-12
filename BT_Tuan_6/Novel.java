package thai;

public class Novel extends Sach {
    private String theLoai;
    private boolean laSachSeries;

    public Novel(String theLoai, boolean laSachSeries) {
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    public Novel(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

}
