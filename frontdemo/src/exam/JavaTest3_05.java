package exam;

class Book {
	private String title;
	private String author;
	private int price;
	private String publisher;
	private double discountRate;
	
	public Book() { }
	public Book(String title, String author, int price, String publisher, double discountRate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.discountRate = discountRate;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	
}

public class JavaTest3_05 {

	public static void main(String[] args) {
		Book bArray[] = new Book[3];
		
		Book b1 = new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.1);
		bArray[0] = b1;
		Book b2 = new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.1);
		bArray[1] = b2;
		Book b3 = new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 0.1);
		bArray[2] = b3;
		
		for(Book b : bArray) {
			System.out.printf("%s, %s, %s, %d원, %.0f%% 할인\n할인된 가격 : %.0f원\n", 
					b.getTitle(), b.getAuthor(), b.getPublisher(), 
					b.getPrice(), b.getDiscountRate()*100, 
					b.getPrice()-(b.getPrice()*b.getDiscountRate()));
		}
	}

}
