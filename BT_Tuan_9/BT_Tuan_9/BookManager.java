package Huy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements IQuanLySach{
	private List<Book> Manage;
	private Scanner sc = new Scanner(System.in);
	public BookManager() {
		this.Manage = new ArrayList<>();
		
	}
	@Override
	public void addBook(Book book) {
		this.Manage.add(book);
	}
	@Override
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
		System.out.println("Nhap gia co ban: ");
		double Gia = sc.nextDouble();
		sc.nextLine();
		System.out.println("Nhap tinh trang sach: ");
		String tinhTrang = sc.nextLine();
		if(choice == 1) {
			System.out.println("Nhap mon hoc: ");
			String MonHoc = sc.nextLine();
			System.out.println("Nhap cap do: ");
			String CapDo = sc.nextLine();
			Book TB = new Textbook(ID, Title, Author, Year, Quantity, Gia, tinhTrang, MonHoc, CapDo);
			Manage.add(TB);
		}
		if(choice == 2) {
			System.out.println("Nhap the loai: ");
			String TheLoai = sc.nextLine();
			System.out.println("La sach Series (True/False): ");
			Boolean LaSachSeries = sc.nextBoolean();
			sc.nextLine();
			Book NV = new Novel(ID, Title, Author, Year, Quantity, Gia, tinhTrang, TheLoai, LaSachSeries);
			Manage.add(NV);
		}
	}
	
	@Override
	public void Display() {
		if(this.Manage.isEmpty())
			System.out.println("Danh sach trong");
		else
			for(Book b : Manage) {
				System.out.println(b);
		}
	}
	
	@Override
	public void Delete() {
		boolean found = false;
		String ma = null;
		if(this.Manage.isEmpty())
			System.out.println("Danh sach trong");
		else {
			System.out.println("Chon ID sach can xoa: ");
			ma = sc.nextLine();
			for(Book b : Manage) {
				if(b.book_ID.equals(ma)) {
					Manage.remove(b);
					System.out.println("Da xoa sach co ID: " +ma);
					found = true;
					break;
				}
			}
		}
		if(!found) {
			System.out.println("Khong tim thay sach co ID: " +ma);
		}
	}
	
	@Override
	public void Update() {
		if(this.Manage.isEmpty())
			System.out.println("Danh sach trong");
		else {
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
					System.out.println("Nhap gia co ban moi: ");
					double newGia = sc.nextDouble();
					b.giaCoBan = newGia;
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
	}
	
	@Override
	public void Search() {
		if(this.Manage.isEmpty())
			System.out.println("Danh sach trong");
		else {
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
	
	public void muonSach() {
	    System.out.println("Nhap ma sach can muon: ");
	    String ma = sc.nextLine();
	    boolean found = false;
	    for (Book b : Manage) {
	        if (b.book_ID.equals(ma)) {
	            found = true;
	            System.out.println("Nhap ten nguoi muon: ");
	            String ten = sc.nextLine();
	            System.out.println("Nhap so ngay muon: ");
	            int soNgay = sc.nextInt();
	            sc.nextLine();
	            b.muonSach(ten, soNgay); 
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("Khong tim thay sach voi ma: " + ma);
	    }
	}
	@Override
	public void Start() {
		int choice = 1;
		while(choice != 0) {
			System.out.println("1. Them Sach   2. Hien thi   3. Xoa   4. Cap nhat   5. Tim   6. Muon   0. Thoat");
			System.out.println("Nhap lua chon: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:{
				this.Add();
				System.out.println("Them sach thanh cong");
				break;
			}
			case 2:
				this.Display();
			case 3:
				this.Delete();
			case 4:{
				this.Update();
				System.out.println("Cap nhat thanh cong");
			}
			case 5:
				this.Search();
			case 6:
				this.muonSach();
			}
		}
	}
}
