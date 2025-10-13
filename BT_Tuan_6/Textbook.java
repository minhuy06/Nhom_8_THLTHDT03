public class Textbook extends Book {
    private String monHoc; // Môn học
    private String capDo; // Cấp độ (VD: Đại học, Phổ thông)

    // Hàm tạo (Constructor) đầy đủ tham số
    public Textbook(String maSach, String tenSach, String tacGia, int namXuatBan, double giaBan, 
                         String monHoc, String capDo) {
        // Gọi constructor của lớp cha bằng super
        super(maSach, tenSach, tacGia, namXuatBan, giaBan); 
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    // Ghi đè (Override) phương thức toString()
    @Override
    public String toString() {
        // Gọi toString() của lớp cha để lấy thông tin chung
        return "TextBook [" + super.toString() + 
               ", Môn học: " + monHoc + 
               ", Cấp độ: " + capDo + "]";
    }
}