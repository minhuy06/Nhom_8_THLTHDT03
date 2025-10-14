import java.util.Scanner;
public class Bai_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so tien gui: ");
		double SoTienGui = sc.nextDouble();
		System.out.println("Nhap lai suat hang nam: ");
		double LaiSuatNam = sc.nextDouble();
		System.out.println("Nhap so thang gui: ");
		int SoThangGui = sc.nextInt();
		double LaiSuatThang = LaiSuatNam/12/100;
		double SoTienLai = SoTienGui * LaiSuatThang * SoThangGui;
		double TongTien = SoTienGui + SoTienLai;
		System.out.println("So tien lai: "+SoTienLai+" VND");
		System.out.println("Tong tien cuoi ki: "+TongTien+" VND");
		sc.close();
	}
}