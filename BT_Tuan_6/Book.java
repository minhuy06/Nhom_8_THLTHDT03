package BT_Tuan_6;

public class Book{
		protected String book_ID;
		protected String title;
		protected String author;
		protected int pub_year;
		protected int quantity;
	
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
	
		@Override
		public String toString() {
			return "Book ID: "+book_ID+", Tiêu Đề: "+title+", Tác giả: "+author+", Năm xuất bản: "+pub_year+", Số lượng: "+quantity;
		}
	}