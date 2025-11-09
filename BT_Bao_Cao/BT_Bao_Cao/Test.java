package BT_Tuan_9;

public class Test {
	public static void main(String[] args) {

		IQuanLySach quanly = new BookManager();
		Book book1 = new Textbook("HD32", "Giai tich II", "Minh Huy", 2025, 3, 34000, "Hỏng", "Toan hoc", "Dai hoc");
		Book book2 = new Novel("MD11", "Conan", "Kim Oanh", 2024, 8, 12000, "Cho muon", "Trinh tham", true);
		quanly.addBook(book1);
		quanly.addBook(book2);
		quanly.Display();
		quanly.Start();
	}
}