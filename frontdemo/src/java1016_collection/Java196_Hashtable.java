package java1016_collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
 * Hashtable
 * 1. Map 인터페이스를 구현해놓은 클래스
 * 2. Map 인터페이스를 구현해놓은 클래스들은 key, value 쌍으로 저장한다.
 * 3. value를 구현해주는 것은 key 이므로 key는 중복을 허용하지 않음
 */

public class Java196_Hashtable { // 동기화로 처리되는 Hashtable (요즘은 HashMap을 더 사용함 [비동기화] )

	public static void main(String[] args) {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		//Hashtable<key, value>
		
		table.put(10, "java");
		table.put(20, "jsp");
		table.put(30, "spring");

		System.out.println(table.get(20)); // get을 사용하면 value만 가져옴
		
		System.out.println();
		
		//모든 요소를 출력하고 싶으면 Enumeration 또는 Iterator 사용
		//열거형은 조작이 안됨, 반복자는 조작 가능
		System.out.println("Enumeration 사용하여 전부 출력");
		Enumeration<Integer> enu = table.keys();
		while(enu.hasMoreElements()) {
			Integer key = enu.nextElement();
			System.out.printf("%d : %s\n", key, table.get(key));
		}
		
		System.out.println();
		
		System.out.println("iterator 사용하여 전부 출력");
		//직접적으로 iterator로 리턴해주는 메소드가 없음 table.keySet()을 이용함
		
		Set<Integer> set = table.keySet();
		Iterator<Integer> ite = set.iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			System.out.printf("%d : %s\n", key, table.get(key));
		}
		
		
	} // end main()

} // end class
