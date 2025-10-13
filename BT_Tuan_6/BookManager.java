package BT_Tuan_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager{
	private List<Book> Manage;
	private Scanner sc = new Scanner(System.in);
	public BookManager() {
		this.Manage = new ArrayList<>();
		
	}
	public void addBook(Book book) {
		this.Manage.add(book);
	}
	public void Add() {
		System.out.println("Chon loai sach can them: ");
		System.out.println("1. Textbook");
		System.out.println("2. Novel");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ID sach: ");
		String ID = sc.nextLine();
		System.out.println("Nhap Tieu de: ");
		String Title = sc.nextLine();
		System.out.println("Nhap tac gia: ");
		String Author = sc.nextLine();
		System.out.println("Nhap nam xuat ban: ");
		int Year = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap so luong: ");
		int Quantity = sc.nextInt();
		sc.nextLine();
		if(choice == 1) {
			System.out.println("Nhap mon hoc: ");
			String MonHoc = sc.nextLine();
			System.out.println("Nhap cap do: ");
			String CapDo = sc.nextLine();
			Book TB = new Textbook(ID, Title, Author, Year, Quantity, MonHoc, CapDo);
			Manage.add(TB);
		}
		if(choice == 2) {
			System.out.println("Nhap the loai: ");
			String TheLoai = sc.nextLine();
			System.out.println("La sach Series (True/False): ");
			Boolean LaSachSeries = sc.nextBoolean();
			sc.nextLine();
			Book NV = new Novel(ID, Title, Author, Year, Quantity, TheLoai, LaSachSeries);
			Manage.add(NV);
		}
	}
	
	public void Display() {
		for(Book b : Manage) {
			System.out.println(b);
		}
	}
	
	public void Delete() {
		System.out.println("Chon ID sach can xoa: ");
		String ma = sc.nextLine();
		boolean found = false;
		for(Book b : Manage) {
			if(b.book_ID.equals(ma)) {
				Manage.remove(b);
				System.out.println("Da xoa sach co ID: " +ma);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Khong tim thay sach co ID: " +ma);
		}
	}
	
	public void Update() {
		System.out.println("Nhap ma sach can cap nhap: ");
		String ma = sc.nextLine();
		boolean found = false;
		for(Book b : Manage) {
			if(b.book_ID.equals(ma)) {
				System.out.println("Nhap thong tin moi");
				System.out.println("Nhap ID sach moi: ");
				String newID = sc.nextLine();
				b.book_ID = newID;
				System.out.println("Nhap tieu de moi: ");
				String newTitle = sc.nextLine();
				b.title = newTitle;
				System.out.println("Nhap tac gia moi: ");
				String newAuthor = sc.nextLine();
				b.author = newAuthor;
				System.out.println("Nhap nam xuat ban moi: ");
				int newPub_year = sc.nextInt();
				b.pub_year = newPub_year;
				sc.nextLine();
				System.out.println("Nhap so luong moi: ");
				int newQuantity = sc.nextInt();
				b.quantity = newQuantity;
				sc.nextLine();
				if(b instanceof Textbook) {
					Textbook textbook = (Textbook) b;
					System.out.println("Nhap mon hoc moi: ");
					textbook.SetmonHoc(sc.nextLine());
					System.out.println("Nhap cap do moi: ");
					textbook.SetcapDo(sc.nextLine());
				}
				if(b instanceof Novel) {
					Novel novel = (Novel) b;
					System.out.println("Nhap the loai moi: ");
					novel.SettheLoai(sc.nextLine());
					System.out.println("La sach Series (True/False): ");
					novel.SetlaSachSeries(sc.nextBoolean());
					sc.nextLine();
				}
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Khong tim thay sach de cap nhap");
		}
	}
	
	public void Search() {
		System.out.println("Nhap ma sach can tim kiem: ");
		String ma = sc.nextLine();
		boolean found = false;
		for(Book b : Manage) {
			if(b.book_ID.equals(ma)) {
				System.out.println("Tim thay sach!");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Khong Tim thay sach!");
		}
	}
	
}
