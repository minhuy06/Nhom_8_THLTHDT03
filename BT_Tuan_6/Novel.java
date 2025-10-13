public class Novel extends Book {
    private String theLoai; // Thể loại (VD: Lãng mạn, Khoa học viễn tưởng)
    private boolean laSachSeries; // Sách có thuộc loại series hay không

    // Hàm tạo (Constructor) đầy đủ tham số
    public Novel(String maSach, String tenSach, String tacGia, int namXuatBan, double giaBan, 
                          String theLoai, boolean laSachSeries) {
        // Gọi constructor của lớp cha bằng super
        super(maSach, tenSach, tacGia, namXuatBan, giaBan);
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries;
    }

    // Ghi đè (Override) phương thức toString()
    @Override
    public String toString() {
        // Sử dụng toán tử 3 ngôi cho thuộc tính boolean
        String seriesStatus = laSachSeries ? "Có" : "Không"; 
        return "Novel [" + super.toString() + 
               ", Thể loại: " + theLoai + 
               ", Là Series: " + seriesStatus + "]";
    }
}