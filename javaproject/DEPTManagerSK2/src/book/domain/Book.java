package book.domain;

//project DEPTManagerSK2
public class Book {
	
//	BOOKID    NOT NULL NUMBER(2)    
//	BOOKNAME           VARCHAR2(40) 
//	PUBLISHER          VARCHAR2(40) 
//	PRICE              NUMBER(8)    
	
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public Book() {
		super();
	}
	
	public Book(int bookid, String bookname, String publisher, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", price=" + price
				+ "]";
	}
}
