package homework_prob;

class Booksss {

	private String category;
	private String bookName;
	private double bookPrice;
	private double bookDiscountRate;
	
	public Booksss() { }
	
	public Booksss(String category, String bookName, double bookPrice, double bookDiscountRate) {
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	public String getBookName() { return bookName; }
	public void setBookName(String bookName) { this.bookName = bookName; }
	public double getBookPrice() { return bookPrice; }
	public void setBookPrice(double bookPrice) { this.bookPrice = bookPrice; }
	public double getBookDiscountRate() { return bookDiscountRate; }
	public void setBookDiscountRate(double bookDiscountRate) { this.bookDiscountRate = bookDiscountRate; }

}

public class BookTest {

	public static void main(String[] args) {
		Booksss bookArray[] = new Booksss[5];
		
		Booksss b1 = new Booksss("IT", "SQL Plus", 50000, 5);
		bookArray[0] = b1;
		
		Booksss b2 = new Booksss("IT", "Java 2.0", 40000, 3);
		bookArray[1] = b2;
		
		Booksss b3 = new Booksss("IT", "JSP Servlet", 60000, 6);
		bookArray[2] = b3;
		
		Booksss b4 = new Booksss("Nobel", "davincicode", 30000, 10);
		bookArray[3] = b4;
		
		Booksss b5 = new Booksss("Nobel", "Cloven hoof", 50000, 15);
		bookArray[4] = b5;
		
		double sum = 0;
		for(int i = 0; i < bookArray.length; i++) {
			System.out.printf("%s %s %.1f원 %.1f%%\n", bookArray[i].getCategory()
					, bookArray[i].getBookName(), bookArray[i].getBookPrice(), bookArray[i].getBookDiscountRate());
			
			sum += bookArray[i].getBookPrice();
		}
		
		
		System.out.printf("\n책 가격의 합: %.1f원", sum);

	}

}
