package thai;
import java.time.LocalDate;

public class TinhTrangSach {
    private String maTinhTrang;
    private String tenTinhTrang;
    private LocalDate ngayCapNhat;
    public TinhTrangSach() {
    }

    public TinhTrangSach(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public TinhTrangSach(String maTinhTrang, String tenTinhTrang) {
        this.maTinhTrang = maTinhTrang;
        this.tenTinhTrang = tenTinhTrang;
        this.ngayCapNhat = LocalDate.now();
    }

    public TinhTrangSach(String maTinhTrang, String tenTinhTrang, LocalDate ngayCapNhat) {
        this.maTinhTrang = maTinhTrang;
        this.tenTinhTrang = tenTinhTrang;
        this.ngayCapNhat = ngayCapNhat != null ? ngayCapNhat : LocalDate.now();
    }
    public String getMaTinhTrang() {
        return maTinhTrang;
    }

    public void setMaTinhTrang(String maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
        this.ngayCapNhat = LocalDate.now(); // tự đông cập nhật lại ngày
    }
    public LocalDate getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(LocalDate ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public void capNhatTinhTrang(String tenTinhTrangMoi, String moTaMoi) {
        this.tenTinhTrang = tenTinhTrangMoi;
        this.ngayCapNhat = LocalDate.now();
    }

    @Override
    public String toString()
    {
        String ngay;
        if (ngayCapNhat != null) {
            ngay = String.format("%02d/%02d/%d",
                    ngayCapNhat.getDayOfMonth(),
                    ngayCapNhat.getMonthValue(),
                    ngayCapNhat.getYear());
        } else {
            ngay = "Chưa cập nhật";
        }
        return ngay;
    }
}

