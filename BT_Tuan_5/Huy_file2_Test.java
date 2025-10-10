package QL_Sach;

import java.util.Scanner;

public class Huy_file2_Test{
	public static void main(String[] args) {
		// Tao doi tuong bang cac Stuctor co tham so
		Huy_file1_Book book1 = new Huy_file1_Book("HD32", "Conan", "Minh Huy", 2025, 3);
		Huy_file1_Book book2 = new Huy_file1_Book("MD11", "Trinh tham", "Kim Oanh", 2024, 8);
		
		// Hien thi thong ti sach
		System.out.println("Thong tin sach 1: ");
		book1.displayInfo();
		System.out.println("Thong tin sach 2: ");
		book2.displayInfo();
		
		// Thay doi gia tri cua sach thong qua setter, getter
		book1.Setauthor("To Hoai");
		System.out.println("Thong tin sach 2 sau khi thay doi: ");
		book1.displayInfo();
	}
}
