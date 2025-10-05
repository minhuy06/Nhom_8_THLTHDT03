/**
 * Lớp TestSach dùng để tạo và kiểm tra các đối tượng từ lớp Sach.
 */
public class Test{
    public static void main(String[] args) {
        // Yêu cầu 3 & 4: Tạo đối tượng từ lớp Sach bằng cách gọi constructor
        System.out.println("--- BẮT ĐẦU CHƯƠNG TRÌNH KIỂM TRA SÁCH ---");

        // Tạo đối tượng Sach thứ nhất (sach1)
        Sach sach1 = new Sach(
            "S001", 
            "Lập Trình Hướng Đối Tượng Java", 
            "Nguyễn Văn A", 
            2023, 
            50
        );

        // Tạo đối tượng Sach thứ hai (sach2)
        Sach sach2 = new Sach(
            "S002", 
            "Cấu Trúc Dữ Liệu và Giải Thuật", 
            "Trần Thị B", 
            2022, 
            35
        );
        
        System.out.println("\n--- HIỂN THỊ THÔNG TIN CÁC CUỐN SÁCH ---");
        
        // Yêu cầu 2: Gọi phương thức hienThiThongTin() của đối tượng sach1
        sach1.hienThiThongTin();

        // Yêu cầu 2: Gọi phương thức hienThiThongTin() của đối tượng sach2
        sach2.hienThiThongTin();

        // Yêu cầu 5: Minh họa việc thay đổi thông tin (tính đóng - Encapsulation)
        System.out.println("\n--- MINH HỌA TÍNH ĐÓNG (Cập nhật số lượng) ---");
        System.out.println("Số lượng sách S001 ban đầu: " + sach1.getSoLuong()); // Sử dụng getter
        
        // Cập nhật số lượng sách S001
        sach1.setSoLuong(45); // Sử dụng setter để thay đổi số lượng
        
        System.out.println("Số lượng sách S001 sau cập nhật: " + sach1.getSoLuong()); 

        // Hiển thị lại thông tin sách S001 sau khi cập nhật
        System.out.println("\n--- THÔNG TIN SÁCH S001 SAU CẬP NHẬT ---");
        sach1.hienThiThongTin();
        
        System.out.println("--- KẾT THÚC CHƯƠNG TRÌNH KIỂM TRA SÁCH ---");
    }
}