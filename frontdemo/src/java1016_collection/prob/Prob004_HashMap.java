package java1016_collection.prob;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * [출력결과]
 * 찾는 도서명을 입력 :java
 * 책이름 : java
 * 책저자 : kim
 * 페이지 : 100
 * 
 * 찾는 도서명을 입력 :jsp
 * 찾는 도서가 없습니다
 */


public class Prob004_HashMap {
	public static void main(String[] args) {
		BookShop bk1=new BookShop("java","kim",100);
		BookShop bk2=new BookShop("c++","lee",250);
		BookShop bk3=new BookShop("oracle","park",300);
		BookShop[] bs=new BookShop[3];
		bs[0]=bk1;
		bs[1]=bk2;
		bs[2]=bk3;
		display(bs);
			
	}
	
	public static void display(BookShop[] bs){
		Map<String,BookShop> map=new HashMap<String,BookShop>();
		map.put(bs[0].getTitle(), bs[0]);
		map.put(bs[1].getTitle(), bs[1]);
		map.put(bs[2].getTitle(), bs[2]);
		
		//출력결과를 참조하여 구현하세요.
		String bName;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("찾을 도서 명을 입력하세요 : ");
		bName = sc.nextLine();
	
		if(map.keySet().contains(bName)) {
			System.out.println("책이름 : " + map.get(bName).getTitle());
			System.out.println("책저자 : " + map.get(bName).getAuthor());
			System.out.println("페이지 : " + map.get(bName).getPage());
		} else {
			System.out.println("찾을 수 없습니다.");
		}
	}
}












