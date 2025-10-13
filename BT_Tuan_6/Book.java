public class Book {
    protected String maSach; // Mã sách
    protected String tenSach; // Tên sách
    protected String tacGia; // Tác giả
    protected int namXuatBan; // Năm xuất bản
    protected double giaBan; // Giá bán

    // Constructor đầy đủ tham số
    public Book(String maSach, String tenSach, String tacGia, int namXuatBan, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaBan = giaBan;
    }

    // Các getters và setters (có thể bỏ qua nếu không cần thiết)
    // ...

    @Override
    public String toString() {
        return "Mã sách: " + maSach + 
               ", Tên: " + tenSach + 
               ", Tác giả: " + tacGia + 
               ", Năm XB: " + namXuatBan + 
               ", Giá: " + giaBan;
    }
}