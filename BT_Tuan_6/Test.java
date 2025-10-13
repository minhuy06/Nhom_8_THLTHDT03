public class Test {
    public static void main(String[] args) {
        // Khởi tạo đối tượng quản lý sách
        BookManager manager = new BookManager();

        System.out.println("--- BƯỚC 1: TẠO VÀ THÊM SÁCH ---");
        
        // 1. Tạo đối tượng SachGiaoTrinh
        Textbook gt1 = new Textbook("GT001", "Cấu Trúc Dữ Liệu", "Nguyễn Văn A", 2022, 125.0, 
                                              "Tin học", "Đại học");
        
        // 2. Tạo đối tượng SachTieuThuyet
        Novel tt1 = new Novel("TT001", "Mật Mã", "Dan Brown", 2003, 95.5, 
                                                "Trinh thám", false);
        
        Novel tt2 = new Novel("TT002", "Dòng Thời Gian", "H.G. Wells", 1895, 80.0, 
                                                "Khoa học viễn tưởng", true);

        // 3. Thêm các đối tượng vào BookManager (Kiểm tra Đa hình)
        manager.themSach(gt1); 
        manager.themSach(tt1);
        manager.themSach(tt2);

        System.out.println("\n--- BƯỚC 2: HIỂN THỊ DANH SÁCH ---");
        manager.hienThiDanhSachSach(); // Kiểm tra Override toString() và Đa hình
        
        System.out.println("\n--- BƯỚC 3: TÌM KIẾM ---");
        manager.timKiemTheoTen("Mật");
        manager.timKiemTheoTen("Lập Trình"); // Sách không có

        System.out.println("\n--- BƯỚC 4: CẬP NHẬT ---");
        manager.capNhatGiaBan("TT001", 105.99); // Cập nhật giá tt1
        manager.capNhatGiaBan("TT099", 50.0); // Cập nhật sách không tồn tại

        System.out.println("\n--- BƯỚC 5: XÓA SÁCH ---");
        manager.xoaSach("GT001"); // Xóa gt1
        manager.xoaSach("GT001"); // Xóa lại (kiểm tra không tồn tại)

        System.out.println("\n--- BƯỚC CUỐI: HIỂN THỊ DANH SÁCH CÒN LẠI ---");
        manager.hienThiDanhSachSach();
    }
}
