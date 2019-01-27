package java1016_collection;

import java.util.HashSet;

/*
 * HashSet
 * 1. Set 인터페이스를 구현한 클래스이다.
 * 2. 중복허용 안되고, 순서유지 안된다. (순서가 유지가 되는 것들은 HashSet보다 느림)
 */
public class Java195_HashSet {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>(); 
		set.add(new Integer(10));
		set.add(new Integer(20));
		set.add(new Integer(30));
		set.add(new Integer(30));
		
		for(Integer it : set)
			System.out.println(it);
		
	}

}
