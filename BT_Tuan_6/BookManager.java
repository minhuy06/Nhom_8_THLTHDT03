import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class BookManager {
    // Sử dụng List để lưu trữ các đối tượng Sach (đa hình)
    private List<Book> danhSachSach; 

    public BookManager() {
        this.danhSachSach = new ArrayList<>();
    }

    // --- Chức năng 1: Thêm sách ---
    public void themSach(Book sach) {
        danhSachSach.add(sach);
        System.out.println("✅ Đã thêm sách: " + sach.tenSach);
    }

    // --- Chức năng 2: Hiển thị danh sách Sach ---
    public void hienThiDanhSachSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách sách hiện đang trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SÁCH HIỆN CÓ ---");
        for (Book sach : danhSachSach) {
            // Đa hình: Phương thức toString() được gọi sẽ là của lớp con tương ứng
            System.out.println(sach.toString()); 
        }
        System.out.println("--------------------------------");
    }

    // --- Chức năng 3: Tìm kiếm theo tên (tìm chính xác hoặc gần đúng) ---
    public void timKiemTheoTen(String tenTimKiem) {
        System.out.println("\n--- KẾT QUẢ TÌM KIẾM cho '" + tenTimKiem + "' ---");
        boolean found = false;
        String tenTimKiemLower = tenTimKiem.toLowerCase();
        for (Book sach : danhSachSach) {
            if (sach.tenSach.toLowerCase().contains(tenTimKiemLower)) {
                System.out.println(sach.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách nào với tên đã nhập.");
        }
    }

    // --- Chức năng 4: Xóa sách theo mã sách ---
    public void xoaSach(String maSach) {
        Iterator<Book> iterator = danhSachSach.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Book sach = iterator.next();
            // Truy cập thuộc tính maSach (protected)
            if (sach.maSach.equals(maSach)) { 
                iterator.remove();
                System.out.println("✅ Đã xóa sách có mã: " + maSach + " (" + sach.tenSach + ")");
                removed = true;
                break; 
            }
        }
        if (!removed) {
            System.out.println("❌ Không tìm thấy sách có mã: " + maSach + " để xóa.");
        }
    }

    // --- Chức năng 5: Cập nhật sách theo mã sách (Ví dụ: Cập nhật giá bán) ---
    public void capNhatGiaBan(String maSach, double giaMoi) {
        boolean updated = false;
        for (Book sach : danhSachSach) {
            if (sach.maSach.equals(maSach)) {
                double giaCu = sach.giaBan;
                sach.giaBan = giaMoi; // Cập nhật thuộc tính giaBan (protected)
System.out.println("✅ Đã cập nhật giá sách: " + sach.tenSach + " từ $" + giaCu + " lên $" + giaMoi);
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("❌ Không tìm thấy sách có mã: " + maSach + " để cập nhật.");
        }
    }
}