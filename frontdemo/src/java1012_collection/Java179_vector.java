package java1012_collection;

import java.util.Vector;

public class Java179_vector {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add(new String("java"));
		
		v = new Vector<String>(2);
		v.add(new String("seoul"));
		v.add(new String("busan"));
		v.add(new String("incheon")); // 용량 4, 크기 3
		
		v = new Vector<String>(2,1); // 초기값이 2, 1씩 증가시킴
		v.add(new String("홍길동"));
		v.add(new String("영순이"));
		v.add(new String("갑돌이"));
		
		System.out.println("용량 : " + v.capacity()); //디폴트 용량은 10
		System.out.println("크기 : " + v.size()); //디폴트 크기는 1

	}

}
