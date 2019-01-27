package java1015_collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

//Enumeration은 Vector와 Hashtalbe에서만 제공이 되는 인터페이스
//iterator와 기능이 똑같음 다만 지원범위가 iterator가 더 넓음
public class Java186_Enumeration {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(new Integer(10));
		v.add(new Integer(20));
		v.add(new Integer(30));
		
		
		System.out.println("리스트들을 가져오는 방법들");
		
		for(int i = 0; i < v.size(); i++)
			System.out.println(v.get(i));
			
		System.out.println("===============================");
		
		//열거형
		Enumeration<Integer> enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		System.out.println("===============================");
		
		//반복자
		Iterator<Integer> ite = v.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("===============================");
		
		//개선된 루프
		for(Integer i : v) {
			System.out.println(i);
		}
	}

}
