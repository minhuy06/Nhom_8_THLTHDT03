package QL_Sach;

import java.util.Scanner;

public class Book{
		// Bieu dien cac thuoc tinh the hien tinh dong goi
		private String book_ID;
		private String title;
		private String author;
		private int pub_year;
		private int quantity;
	
		// Tao constructor khong tham so
		public Book() {}
		
		// Tao constructor co tham so
		public Book(String book_ID, String title, String author, int pub_year, int quantity) {
			this.book_ID = book_ID;
			this.title = title;
			this.author = author;
			this.pub_year = pub_year;
			this.quantity = quantity;
		}
		
		public String Getbook_ID() {
			return book_ID;
		}
		public void Setbook_ID(String book_ID) {
			this.book_ID = book_ID;
		}
		public String Gettitle() {
			return title;
		}
		public void Settitle(String title) {
			this.title = title;
		}
		public String Getauthor() {
			return author;
		}
		public void Setauthor(String author) {
			this.author = author;
		}
		public int Getpub_year() {
			return pub_year;
		}
		public void Setpub_year(int pub_year) {
			this.pub_year = pub_year;
		}
		public int Getquantity() {
			return quantity;
		}
		public void Setquantity(int quantity) {
			this.quantity = quantity;
		}
	
		// tao phuong thuc để in ra thong tin chi tiet cua sach ra man hinh
		public void displayInfo() {
			System.out.println("Ma sach: "+book_ID);
			System.out.println("Tieu de: "+title);
			System.out.println("Tac gia: "+author);
			System.out.println("Nam xuat ban: "+pub_year);
			System.out.println("So luong: "+quantity);
		}
	}
