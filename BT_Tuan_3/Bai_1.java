import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên của bạn: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Hello!");
        } else {
            System.out.println("Hello " + name);
        }

        sc.close();
    }
}