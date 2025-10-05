public class Test {
    public static void main(String[] args) {
        Sach sach1 = new Sach("B001", "Lập trình Java", "Nguyễn Văn A", 2022, 10);
        Sach sach2 = new Sach("B002", "Cấu trúc dữ liệu", "Trần Thị B", 2020, 5);
        Sach sach3 = new Sach();
        sach3.setMaSach("B003");
        sach3.setTieuDe("Thuật toán nâng cao");
        sach3.setTacGia("Lê Văn C");
        sach3.setNamXuatBan(2020);
        sach3.setSoLuong(7);
        sach1.hienThiThongTin();
        sach2.hienThiThongTin();
        sach3.hienThiThongTin();
    }
}
