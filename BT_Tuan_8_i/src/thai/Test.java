package thai;
import java.util.List;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        IQuanLySach quanLy = new BookManager();
        Scanner sc = new Scanner(System.in);
        quanLy.themSach(new Textbook("GT01", "Lập trình Java", "Nguyễn Văn A", 120000, 10, "Kệ A1", "Lập trình", "Đại học"));
        quanLy.themSach(new Novel("TT01", "Hành trình trên mây", "Trần Thị B", 90000, 5, "Kệ B2", "Viễn tưởng", true));

        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n===== MENU QUẢN LÝ SÁCH =====");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Kiểm tra tồn kho");
            System.out.println("6. Cập nhật vị trí sách");
            System.out.println("7. Xem giá bán sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String chon = sc.nextLine();

            switch (chon) {
                case "1":
                    quanLy.hienThiDanhSach();
                    break;
                case "2":
                    themSachMenu(quanLy, sc);
                    break;
                case "3":
                    System.out.print("Nhập từ khóa: ");
                    String tuKhoa = sc.nextLine();
                    List<Sach> kq = quanLy.timKiemSach(tuKhoa);
                    if (kq.isEmpty()) System.out.println("Không tìm thấy sách.");
                    else kq.forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = sc.nextLine();
                    System.out.println(quanLy.xoaSach(maXoa) ? "✅ Xóa thành công" : "❌ Không tìm thấy mã sách.");
                    break;
                case "5":
                    System.out.print("Nhập mã sách: ");
                    String maKiem = sc.nextLine();
                    System.out.print("Nhập số lượng tối thiểu: ");
                    int min = Integer.parseInt(sc.nextLine());
                    Sach sachKiem = ((BookManager) quanLy).timSachTheoMa(maKiem);
                    if (sachKiem == null) System.out.println("Không tìm thấy sách.");
                    else System.out.println(sachKiem.kiemTraTonKho(min)
                            ? "✅ Đủ số lượng tồn kho."
                            : "⚠ Không đủ số lượng tồn kho.");
                    break;
                case "6":
                    System.out.print("Nhập mã sách: ");
                    String maCap = sc.nextLine();
                    Sach sachCap = ((BookManager) quanLy).timSachTheoMa(maCap);
                    if (sachCap == null) {
                        System.out.println("Không tìm thấy sách.");
                    } else {
                        System.out.print("Nhập vị trí mới: ");
                        String vt = sc.nextLine();
                        sachCap.capNhatViTri(vt);
                    }
                    break;
                case "7":
                    System.out.print("Nhập mã sách: ");
                    String maGia = sc.nextLine();
                    Sach sachGia = ((BookManager) quanLy).timSachTheoMa(maGia);
                    if (sachGia == null) System.out.println("Không tìm thấy sách.");
                    else System.out.println("Giá bán: " + String.format("%.0f", sachGia.tinhGiaBan()) + " VND");
                    break;
                case "0":
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        sc.close();
        System.out.println("Chương trình kết thúc!");
    }

    private static void themSachMenu(IQuanLySach quanLy, Scanner sc) {
        System.out.println("Chọn loại sách: 1. Giáo trình  2. Tiểu thuyết");
        String loai = sc.nextLine();

        System.out.print("Mã sách: ");
        String ma = sc.nextLine();
        System.out.print("Tiêu đề: ");
        String td = sc.nextLine();
        System.out.print("Tác giả: ");
        String tg = sc.nextLine();
        System.out.print("Giá cơ bản: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Số lượng: ");
        int sl = Integer.parseInt(sc.nextLine());
        System.out.print("Vị trí: ");
        String vt = sc.nextLine();

        if ("1".equals(loai)) {
            System.out.print("Môn học: ");
            String mh = sc.nextLine();
            System.out.print("Cấp độ: ");
            String cd = sc.nextLine();
            quanLy.themSach(new Textbook(ma, td, tg, gia, sl, vt, mh, cd));
            System.out.println("Thêm sách giáo trình thành công!");
        } else if ("2".equals(loai)) {
            System.out.print("Thể loại: ");
            String tl = sc.nextLine();
            System.out.print("Thuộc series? (y/n): ");
            boolean series = sc.nextLine().equalsIgnoreCase("y");
            quanLy.themSach(new Novel(ma, td, tg, gia, sl, vt, tl, series));
            System.out.println(" Thêm sách tiểu thuyết thành công!");
        } else {
            System.out.println(" Lựa chọn không hợp lệ.");
        }
    }
}

