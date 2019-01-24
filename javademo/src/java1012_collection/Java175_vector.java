package java1012_collection;

import java.util.Vector;

/* Vector : 가변크기의 컨테이너
 * 객체들의 삽입, 제거, 검색이 가능함
 * (기본타입 자료들은 삽입 자체가 불가, 객체와 null값만 삽입 가능)
 */

public class Java175_vector {

	public static void main(String[] args) {
		Vector v = new Vector(3);
		
		//Integer -> Object : up-casting
		v.add(new Integer(10)); // 세칸 벡터에 하나씩..
		v.add(new Integer(20));
		v.add(new Integer(30));
		v.add(new Integer(40)); // 세칸 벡터 새로 만들어지고 하나..
		
		v.remove(2); //2인덱스 제거
		System.out.println(v.capacity()); // -> 메모리 크기
		System.out.println(v.size()); // -> 요소의 크기
		
		for(int i = 0; i < v.size(); i++) {
			//Object -> Integer : down-casting
			Integer it = (Integer)v.get(i);
			System.out.println(it);
		}

	}

}
