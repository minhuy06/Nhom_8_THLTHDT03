package BT_Tuan_8;

public class Test {
	public static void main(String[] args) {
		IQuanLySach manager = new BookManagerImpl();// dùng interface
		manager.menu();// gọi menu từ interface
	}
}
