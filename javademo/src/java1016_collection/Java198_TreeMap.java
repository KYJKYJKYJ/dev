package java1016_collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 * TreeMap
 * 1. Map인터페이스를 구현한 클래스
 * 2. 정렬을 제공하는 클래스
 */

public class Java198_TreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
		tree.put(10, "java");
		tree.put(30, "spring");
		tree.put(20, "jsp");
		
		Set<Integer> keyset = tree.keySet();
		Iterator<Integer> iterator = keyset.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			
			System.out.printf("%d : %s\n", key, tree.get(key)); // tree는 key를 가지고 정렬해줌
		}
	}

}
