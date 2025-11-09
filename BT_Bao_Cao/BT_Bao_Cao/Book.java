package Huy;

public abstract class Book implements IGiaBan, IKiemKe {
		protected String book_ID;
		protected String title;
		protected String author;
		protected int pub_year;
		protected int quantity;
		protected double giaCoBan;
		protected BookStatus status;
	
		// Tao constructor khong tham so
		public Book() {
			
		}
		
		// Tao constructor co tham so
	
		public Book(String book_ID, String title, String author, int pub_year, int quantity, double giaCoBan, String tinhTrang) {
		    this.book_ID = book_ID;
		    this.title = title;
		    this.author = author;
		    this.pub_year = pub_year;
		    this.quantity = quantity;
		    this.giaCoBan = giaCoBan;
		    this.status = new BookStatus(tinhTrang); 
		}
	
		public String getBook_ID() {
			return book_ID;
		}

		public void setBook_ID(String book_ID) {
			this.book_ID = book_ID;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getPub_year() {
			return pub_year;
		}

		public void setPub_year(int pub_year) {
			this.pub_year = pub_year;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getGiaCoBan() {
			return giaCoBan;
		}

		public void setGiaCoBan(double giaCoBan) {
			this.giaCoBan = giaCoBan;
		}
		
		public BookStatus GetTinhTrang() {
			return status;
		}
		public void SetTinhTrang(BookStatus status) {
			this.status = status;
		}
		
		@Override
		public boolean kiemTraTonKho(int soLuongToiThieu) {
			return this.quantity >= soLuongToiThieu;
		}
		
		public void muonSach(String nguoiMuon, int soNgayMuon) {
			this.status.muonSach(nguoiMuon, soNgayMuon);
		}
		public void traSach() {
			this.status.traSach();
		}
		
		@Override
		public void capNhatViTri(String viTriMoi) {
			System.out.println("Da chuyen sach ["+this.title+"] den khu vuc ["+viTriMoi+"]");
		}
		
		@Override
		public String toString() {
			return "Book ID: "+book_ID+", Tiêu Đề: "+title+", Tác giả: "+author+", Năm xuất bản: "+pub_year+", Số lượng: "+quantity+", "+status.toString();
		}
		
	}