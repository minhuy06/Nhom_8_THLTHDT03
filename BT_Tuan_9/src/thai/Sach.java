package thai;
import java.time.LocalDate;
public abstract class Sach implements IGiaBan, IKiemKe {
    protected String maSach;
    protected String tieuDe;
    protected String tacGia;
    protected double giaCoBan;
    protected int soLuong;
    protected String viTri;
    protected TinhTrangSach tinhTrang;
    protected int namXuatBan;

    public Sach() {
        this.soLuong = 1; // Giá trị mặc định
    }

    public Sach(String maSach, String tieuDe, String tacGia, double giaCoBan, int soLuong, String viTri) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setGiaCoBan(giaCoBan);
        setSoLuong(soLuong);
        this.viTri = viTri;
        this.tinhTrang = new TinhTrangSach("Mới");
    }

    public Sach(String maSach, String tieuDe, String tacGia, double giaCoBan, int soLuong, String viTri, TinhTrangSach tinhTrang) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setGiaCoBan(giaCoBan);
        setSoLuong(soLuong);
        this.viTri = viTri;
        this.tinhTrang = tinhTrang;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getGiaCoBan() {
        return giaCoBan;
    }

    public void setGiaCoBan(double giaCoBan) {
        if (giaCoBan <= 0) {
            throw new IllegalArgumentException("Giá cơ bản phải lớn hơn 0!");
        }
        this.giaCoBan = giaCoBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0!");
        }
        this.soLuong = soLuong;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public TinhTrangSach getTinhTrang() {
        return tinhTrang;
    }
    public void setTinhTrang(TinhTrangSach tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public void setNamXuatBan(int namXuatBan) {
        int namHienTai = LocalDate.now().getYear();
        if (namXuatBan > namHienTai) {
            throw new IllegalArgumentException("Năm xuất bản không được lớn hơn năm hiện tại (" + namHienTai + ")!");
        }
        this.namXuatBan = namXuatBan;
    }
    // Phương thức cập nhật tình trạng sách
    public void capNhatTinhTrang(TinhTrangSach tinhTrangMoi) {
        this.tinhTrang = tinhTrangMoi;
    }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return this.soLuong >= soLuongToiThieu;
    }
    @Override
    public void capNhatViTri(String viTriMoi) {
        this.viTri = viTriMoi;
        System.out.println("Đã chuyển sách [" + this.tieuDe + "] đến khu vực: " + viTriMoi);
    }
    @Override
    public String toString() {
        return "Mã sách: " + maSach +
                " | Tiêu đề: " + tieuDe +
                " | Tác giả: " + tacGia +
                " | Giá cơ bản: " + giaCoBan +
                " | Số lượng: " + soLuong +
                " | Vị trí: " + viTri +
                " | Năm XB: " + (namXuatBan > 0 ? namXuatBan : "Chưa cập nhật") +
                " | Tình trạng: " + (tinhTrang != null ? tinhTrang.toString() : "Chưa cập nhật");
    }
public abstract class MuonSach extends Sach {
        protected int soLanMuon;
        public MuonSach() {
        }
        public MuonSach(String maSach, String tieuDe, String tacGia,
                        double giaCoBan, int soLuong, String viTri, String tenTinhTrang) {
            super(maSach, tieuDe, tacGia, giaCoBan, soLuong, viTri, new TinhTrangSach(tenTinhTrang));
            this.soLanMuon = 0;
        }
        public void muonSach() {
            if (soLuong > 0) {
                soLuong--;
                soLanMuon++;
                System.out.println("Mượn sách thành công: " + tieuDe);
            } else {
                System.out.println("Sách đã hết hàng.");
            }
        }
        public void traSach() {
            soLuong++;
            System.out.println("Trả sách thành công: " + tieuDe);
        }
        public int getSoLanMuon() {
            return soLanMuon;
        }
        public void setSoLanMuon(int soLanMuon) {
            this.soLanMuon = soLanMuon;
        }
    }
}