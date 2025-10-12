package thai;

public class Test {
    public static void main(String[] args) {
        BookManager ql = new BookManager();
        Sach sach1 = new Sach("B001", "Lập trình Java", "Nguyễn Văn A", 2022, 10);
        Sach sach2 = new Sach("B002", "Cấu trúc dữ liệu", "Trần Thị B", 2020, 5);
        Sach sach3 = new Sach("B003", "Thuật toán nâng cao", "Lê Văn C", 2021, 7);
        ql.themSach(sach1);
        ql.themSach(sach2);
        ql.themSach(sach3);
        System.out.println("Danh sách sách:");
        ql.hienThiSach();
        System.out.println("\nTìm sách có mã B002:");
        Sach tim = ql.timKiemTheoMa("B002");
        if (tim != null) {
            System.out.println(tim);
        } else {
            System.out.println("Không tìm thấy sách!");
        }
        System.out.println("\nXóa sách mã B001...");
        if (ql.xoaSach("B001")) {
            System.out.println("Đã xóa");
        } else {
            System.out.println("Không tìm thấy để xóa!");
        }
        System.out.println("\nDanh sách sau khi xóa:");
        ql.hienThiSach();
    }
}
