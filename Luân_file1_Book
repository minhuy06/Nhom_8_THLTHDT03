/**
 * Lớp Sach (Book) dùng để biểu diễn thông tin chi tiết về một cuốn sách.
 * Bao gồm các thuộc tính và phương thức để quản lý dữ liệu.
 */
public class Sach {
    // Yêu cầu 1: Thuộc tính (attributes)
    private String maSach;      // book ID
    private String tieuDe;      // title
    private String tacGia;      // author
    private int namXuatBan;     // publication year
    private int soLuong;        // quantity

    // Yêu cầu 4: Constructor để khởi tạo đối tượng Sach
    /**
     * Constructor có tham số để khởi tạo tất cả các thuộc tính của đối tượng Sach.
     * @param maSach Mã sách
     * @param tieuDe Tiêu đề
     * @param tacGia Tác giả
     * @param namXuatBan Năm xuất bản
     * @param soLuong Số lượng
     */
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        
        // Thêm một dòng in để minh họa constructor đã được gọi khi đối tượng được tạo
        System.out.println("-> Đối tượng Sách \"" + this.tieuDe + "\" đã được tạo và khởi tạo.");
    }
    
    // Yêu cầu 2: Tạo một phương thức hienThiThongTin() để in ra tất cả thông tin
    /**
     * Phương thức hiển thị tất cả thông tin chi tiết của cuốn sách ra màn hình console.
     */
    public void hienThiThongTin() {
        System.out.println("---------------------------------");
        System.out.println("THÔNG TIN CHI TIẾT SÁCH:");
        System.out.println("  Mã sách (book ID): " + maSach);
        System.out.println("  Tiêu đề (title): " + tieuDe);
        System.out.println("  Tác giả (author): " + tacGia);
        System.out.println("  Năm xuất bản (publication year): " + namXuatBan);
        System.out.println("  Số lượng (quantity): " + soLuong);
        System.out.println("---------------------------------");
    }

    // Yêu cầu 5: Hoàn thiện phần code sao cho thể hiện tính đóng trong Java.
    // Để thể hiện tính đóng (Encapsulation), ta đặt các thuộc tính là private 
    // và cung cấp các phương thức công khai (public methods) là getter và setter 
    // để truy cập và thay đổi chúng một cách có kiểm soát (Tuy không bắt buộc trong Yêu cầu, 
    // nhưng đây là cách hoàn thiện code theo nguyên tắc OOP):
    
    // Getters (Để đọc giá trị thuộc tính)
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

    // Setters (Để thay đổi giá trị thuộc tính)
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
        if (namXuatBan > 0) { // Ví dụ: Có thể thêm logic kiểm tra dữ liệu
            this.namXuatBan = namXuatBan;
        }
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) { // Ví dụ: Số lượng không thể là số âm
            this.soLuong = soLuong;
        }
    }
}