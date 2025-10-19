package Thái;
import java.lang.String;
public class Textbook extends Sach {
    private String monHoc;
    private String capDo;

    public Textbook(String monHoc, String capDo) {
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    public Textbook(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public String toString() {
        return "Textbook{" +
                "monHoc='" + monHoc + '\'' +
                ", capDo='" + capDo + '\'' +
                '}';
    }

    @Override
    public double tinhGiaBan() {
        return this.getGiaCoBan()+((2025-this.getNamXuatBan())*5000);
    }
}

