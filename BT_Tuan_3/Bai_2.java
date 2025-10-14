public class Bai_2 {
	public static void main(String[] args) {
		char[] myName = { 'Đ', 'Ạ', 'T' };
		int myAge = 19;
		double myHeight = 1.75;
		boolean myAnswer = true;
		System.out.println("Tên: " + new String(myName));
		System.out.println("Tuổi: " + myAge);
		System.out.println("Chiều cao: " + myHeight);
		if (myAnswer == true)
			System.out.println("Tôi thích lập trình ");
		else
			System.out.println("Tôi không thích lập trình ");
	}
}