package baitap4;

public class Textbook extends Book {
	private String Subject;
	private String Level;

	public Textbook() {

	}

	public Textbook(String bookID, String title, String author, int publication_year, int quantity, String Subject,
			String Level) {
		super(bookID, title, author, publication_year, quantity);
		this.Subject = Subject;
		this.Level = Level;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		this.Subject = subject;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		this.Level = level;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMôn học: " + Subject + "\nCấp độ: " + Level;
	}

}
