package java1016_collection.prob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * LinkedList
 * 1 List : 순서적으로 데이터를 저장
 * 2 Stack : LIFO
 * 3 Queue : FIFO
 */

public class Prob001_LinkedList {

	public static void main(String[] args) {
		/*
		 * booklist.txt파일의 데이터를 Stack으로 처리하여 출력되도록 
		 * 프로그램을 구현하시오.
		 *  title             	publisher   writer     price
		 	JSP Programming  	JSPPub     JSPExpert   21000
			Servlet Programming WeBBest 	GoodName	 20000
			JDBC Programming 	JDBCBest 	NaDo SQL 	30000
			SQL Fundmental 		SQLBest		 Na SQL 	47000
			Java Programming 	JavaBest	 Kim kava	 25000
		 */
		
	File file = new File("C:\\study\\workspace\\javademo\\src\\java1016_collection\\prob\\Booklist.txt");
	Scanner sc = null;
	LinkedList<Book> bkStack = new LinkedList<Book>();
	
	try {
		sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			String[] bkstr = sc.nextLine().split("/");
			bkStack.push(new Book(bkstr[0], bkstr[1], bkstr[2], bkstr[3]));
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} finally {
		sc.close();
	}
		
	System.out.printf("%-20s\t%-10s\t%-10s\t%-5s\n", "title", "publisher", "writer", "price");
	while(!bkStack.isEmpty()) {
		Book bkPop = bkStack.pop();
		System.out.printf("%-20s\t%-10s\t%-10s\t%-5s\n", bkPop.getTitle(), bkPop.getPublisher(), 
				bkPop.getWriter(), bkPop.getPrice());
	}
	}//end main()

}//end class











