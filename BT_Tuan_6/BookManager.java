package thai;
import java.util.ArrayList;
import java.lang.String;
public class BookManager {
    private ArrayList<Sach> danhSachSach;

    public BookManager() {
        danhSachSach = new ArrayList<>();
    }
    public boolean themSach(Sach sach) {
        if (timKiemTheoMa(sach.getMaSach()) != null) {
            System.out.println("Mã sách đã tồn tại");
            return false;
        }
        danhSachSach.add(sach);
        System.out.println("Thêm sách thành công");
        return true;
    }

    public boolean xoaSach(String maSach) {
        Sach sach = timKiemTheoMa(maSach);
        if (sach != null) {
            danhSachSach.remove(sach);
            System.out.println("Xóa sách");
            return true;
        }
        System.out.println("Không tìm thấy sách với mã là " + maSach);
        return false;
    }

    public boolean capNhatSach(String maSach, String tenMoi, String tacGiaMoi,
                               int namMoi, double giaMoi) {
        Sach sach = timKiemTheoMa(maSach);
        if (sach != null) {
            sach.setTacGia(tacGiaMoi);
            sach.setNamXuatBan(namMoi);
            System.out.println("Cập nhật sách thành công!");
            return true;
        }
        System.out.println("Không tìm thấy sách để cập nhật!");
        return false;
    }

    public Sach timKiemTheoMa(String maSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) {
                return sach;
            }
        }
        return null;
    }
    public void hienThiSach(){
        for(Sach sach : danhSachSach){
            System.out.println(sach);
        }
}
}
