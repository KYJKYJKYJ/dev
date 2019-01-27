package java1016_collection.answ;

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
LinkedList<Book> stack=new LinkedList<Book>();
		
		try {
			//콘솔,파일,네트워크등의 목적지와 연결해서 데이터를 입출력할때는
			//입출력스트림과 연결하여 수행한다.
			Scanner sc=new Scanner(new File(".\\src\\java1016_collection\\answ\\booklist.txt"));
			
			//hasNext()은 booklist.txt파일에서 읽어올 내용이 있는지를 검색한다.
			while(sc.hasNext()){
				
				//booklist.txt파일에서 nextLine()를 이용해서 한 라인을 읽어온후
				//line변수에 저장한다.
				//SQL Fundmental/SQLBest/Na SQL/47000
				String line=sc.nextLine();
				//"/"구분자를 이용해서  line변수에 저장된 문자열을 구분하여
				//arr[]배열에 저장한다.
				String arr[]=line.split("/");				
				
				//Book클래스 객체의 멤버변수에 arr배열에 저장된 값을
				//할당하기 위해서 생성자를 호출하여  인자값으로 넘겨준다.
				Book book=new Book(arr[0],arr[1],arr[2],arr[3]);
				stack.push(book);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//stack객체변수가 비어있지 않으면
		while(!stack.isEmpty()){
			//stack객체변수에서 데이터를 가져와서 book변수에 저장한다.
			Book book=stack.pop();
			System.out.printf("%s %s %s %s\n",book.getTitle(),book.getPublisher(),
					     book.getWriter(), book.getPrice());
		}
	
	}//end main()

}//end class











