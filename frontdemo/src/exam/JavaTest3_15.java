package exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Books implements Serializable {
	private String title;
	private String author;
	private int price;
	private String publisher;
	private double discountRate;
	
	public Books() { }
	public Books(String title, String author, int price, String publisher, double discountRate) {
		this.title = title; this.author = author; this.price = price; this.publisher = publisher;
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		return title + ", " + author + ", " + publisher + ", " + price + "원, " + String.valueOf((int)(discountRate*100)) + "% 할인";
	}
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public String getPublisher() { return publisher; }
	public void setPublisher(String publisher) { this.publisher = publisher; }
	public double getDiscountRate() { return discountRate; }
	public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
	
}

public class JavaTest3_15 implements Serializable {

	public static void main(String[] args) {
		JavaTest3_15 test5 = new JavaTest3_15();
		ArrayList<Books> list = new ArrayList<Books>();
		
		test5.storeList(list);
		test5.saveFile(list);
		List<Books> booksList = test5.loadFile();
		test5.printList(booksList);

	}
	
	public void storeList(List<Books> list) {
		list.add(new Books("자바의 정석", "남궁성", 30000, "도우출판", 0.15));
		list.add(new Books("열혈강의 자바", "구정은", 29000, "프리렉", 0.2));
		list.add(new Books("객체지향 JAVA8", "금영욱", 30000, "프리렉", 0.1));
	}
	
	public void saveFile(List<Books> list) {
		File file = new File("src/exam/books.dat");
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		
		try {
			fs = new FileOutputStream(file);
			os = new ObjectOutputStream(fs);
			for(int i = 0; i < list.size(); i++)
				os.writeObject(list.get(i));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Books> loadFile() {
		File file = new File("src/exam/books.dat");
		FileInputStream fi = null;
	    ObjectInputStream oi = null;
	    List<Books> bkList = new ArrayList<Books>();    
	   
	    try {
			fi = new FileInputStream(file);
			oi = new ObjectInputStream(fi);
		
			Books bk = (Books) oi.readObject();
			bkList.add(bk);
			
			Books bk1 = (Books) oi.readObject();
			bkList.add(bk1);
			
			Books bk2 = (Books) oi.readObject();
			bkList.add(bk2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		return bkList;		
	}
	
	public void printList(List<Books> list) {
		for(Books bk : list) {
			System.out.printf("%s\n", bk.toString());
			System.out.printf("할인된 가격 : %d원\n", (bk.getPrice() - (int)(bk.getPrice() * bk.getDiscountRate())));
		}
	}
}
