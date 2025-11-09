package thai;

public class Test {
    public static void main(String[] args) {
        IQuanLySach quanLy = new BookManager();
        System.out.println("Kiểm tra thêm sách hợp lệ");
        try {
            quanLy.themSach(new Textbook("GT01", "Lập trình Java", "Nguyễn Văn A", 120000, 10, "Kệ A1",
                    "Lập trình", "Đại học", "Mới"));
            System.out.println("Thêm sách giáo trình thành công");

            quanLy.themSach(new Novel("TT01", "Hành trình trên mây", "Trần Thị B", 90000, 5, "Kệ B2",
                    "Viễn tưởng", true, "Cũ"));
            System.out.println("Thêm sách tiểu thuyết thành công");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        System.out.println("\nKiểm tra giá cơ bản <= 0");
        try {
            quanLy.themSach(new Textbook("GT02", "Test", "Tác giả", -5000, 10, "Kệ B1",
                    "Toán", "Trung học", "Mới"));
            System.out.println("Không bắt được lỗi giá âm");
        } catch (IllegalArgumentException e) {
            System.out.println("Đã bắt lỗi: " + e.getMessage());
        }
        System.out.println("\nKiểm tra cấp độ không hợp lệ");
        try {
            quanLy.themSach(new Textbook("GT03", "Test", "Tác giả", 60000, 5, "Kệ D1",
                    "Văn", "Mầm non", "Mới"));
            System.out.println("Không bắt được lỗi cấp độ không hợp lệ");
        } catch (IllegalArgumentException e) {
            System.out.println("Đã bắt lỗi: " + e.getMessage());
        }
        System.out.println("Kiểm tra cấp độ hợp lệ không phân biệt hoa thường");
        quanLy.themSach(new Textbook("GT04", "Toán cao cấp", "Nguyễn Văn B", 80000, 8, "Kệ E1",
                "Toán", "đại học", "Mới"));
        System.out.println("Chấp nhận cấp độ 'đại học' viết thường");
        System.out.println("\nDanh sách sách trong hệ thống");
        quanLy.hienThiDanhSach();
        System.out.println("\nKiểm tra tìm kiếm");
        System.out.println("Tìm từ khóa 'Java':");
        quanLy.timKiemSach("Java").forEach(System.out::println);
    }
}