package thai;
import java.util.ArrayList;
import java.lang.String;
import java.util.List;

public class BookManager implements IQuanLySach {
    private List<Sach> danhSachSach;

    public BookManager() {
        danhSachSach = new ArrayList<>();
    }

    @Override
    public boolean themSach(Sach sach) {
        if (sach == null) return false;
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(sach.getMaSach())) {
                System.out.println("Mã sách đã tồn tại: " + sach.getMaSach());
                return false;
            }
        }
        danhSachSach.add(sach);
        return true;
    }

    @Override
    public List<Sach> timKiemSach(String tuKhoa) {
        List<Sach> ketQua = new ArrayList<>();
        String key = tuKhoa.toLowerCase();
        for (Sach s : danhSachSach) {
            if (s.getMaSach().toLowerCase().contains(key)
                    || s.getTieuDe().toLowerCase().contains(key)
                    || s.getTacGia().toLowerCase().contains(key)) {
                ketQua.add(s);
            }
        }
        return ketQua;
    }

    @Override
    public boolean xoaSach(String maSach) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSachSach.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("=== DANH SÁCH SÁCH ===");
            for (Sach s : danhSachSach) {
                System.out.println(s);
            }
        }
    }

    public Sach timSachTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }
}

