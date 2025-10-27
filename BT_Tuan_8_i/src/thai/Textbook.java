package thai;
import java.lang.String;
public class Textbook extends Sach {
    private String monHoc;
    private String capDo;

    public Textbook() {}

    public Textbook(String maSach, String tieuDe, String tacGia, double giaCoBan, int soLuong, String viTri,
                    String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, giaCoBan, soLuong, viTri);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    public String getMonHoc() { return monHoc; }
    public void setMonHoc(String monHoc) { this.monHoc = monHoc; }

    public String getCapDo() { return capDo; }
    public void setCapDo(String capDo) { this.capDo = capDo; }

    @Override
    public double tinhGiaBan() {
        return this.giaCoBan * 1.10; // Giá bán = giá cơ bản + 10%
    }

    @Override
    public String toString() {
        return "[Sách giáo trình] " + super.toString() +
                " | Môn học: " + monHoc +
                " | Cấp độ: " + capDo +
                " | Giá bán: " + String.format("%.0f", tinhGiaBan());
    }
}


