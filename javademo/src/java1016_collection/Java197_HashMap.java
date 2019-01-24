package java1016_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * HashMap
 * 1. Map 인터페이스를 구현한 클래스이다.
 * 2. Hashtable은 동기화 처리하고, HashMap은 비동기화 처리
 * 3. Hashtable과 HashMap의 기능들은 비슷함
 */

public class Java197_HashMap {

	public static void main(String[] args) {
		HashMap<Integer, Number> map = new HashMap<Integer, Number>();
		map.put(1, new Integer(10));
		map.put(2, new Double(4.5));
		map.put(3, new Float(2.3f));
		
		System.out.println(map.get(2)); // 복사해서 가지고오는 get
		System.out.println();
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> iterator = keyset.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.printf("%d : %s\n", key, map.get(key)); // 그냥 String으로 받아오면 다운캐스팅 안해도 됨...
		}
	} // end main()

} // end class
