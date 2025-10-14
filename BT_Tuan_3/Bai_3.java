import java.util.Scanner;
public class Bai_3{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số 1: ");
        int s1 = sc.nextInt();
        System.out.print("Nhập số 2: ");
        int s2 = sc.nextInt();
        System.out.println("Tổng: " + (s1 + s2));
        System.out.println("Tích: " + ((long) s1 * s2));
        System.out.println("Thương: " + ((double) s1 / s2));
        System.out.println("Số dư: " + (s1 % s2));
        sc.close();
    }
}