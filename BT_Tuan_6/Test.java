package BT_Tuan_6;

public class Test{
	public static void main(String[] args) {
		
		BookManager manager = new BookManager();
		Book book1 = new Textbook("HD32", "Giai tich II", "Minh Huy", 2025, 3, "Toan hoc", "Dai hoc");
		Book book2 = new Novel("MD11", "Conan", "Kim Oanh", 2024, 8, "Trinh tham", true);
		manager.addBook(book1);
		manager.addBook(book2);
		System.out.println("Danh sach ban dau");
		System.out.println("Thong tin sach 1: ");
		System.out.println(book1.toString());
		System.out.println("Thong tin sach 2: ");
		System.out.println(book2.toString());
		
		// Them sach
		manager.Add();
		System.out.println("Danh sach sau khi them sach: ");
		manager.Display();

		// Xoa sach
		manager.Delete();
		System.out.println("Danh sach sau khi xoa: ");
		manager.Display();
		
		// Cap nhap sach
		manager.Update();
		System.out.println("Danh sach sau khi cap nhap");
		manager.Display();
		
		// Tim sach
		manager.Search();
		
	}
}