package thai;

import java.util.List;

public interface IQuanLySach {
    boolean themSach(Sach sach);
    List<Sach> timKiemSach(String tuKhoa);
    boolean xoaSach(String maSach);
    void hienThiDanhSach();
}

