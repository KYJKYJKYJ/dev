package java1016_collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Java194_TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<Integer>(); // Set은 중복이 안됨
		tree.add(new Integer(10));
		tree.add(new Integer(40));
		tree.add(new Integer(20));
		tree.add(new Integer(30));
		tree.add(new Integer(20)); //Set은 중복이 안됨 그러므로 중복처리 데이터를 하나만 뽑아서 작업할 때 Set을 씁시다.

		for(Integer it : tree)
			System.out.println(it); // 기본적으로 오름차순
		
		System.out.println("=====================================");
		System.out.println("반복자를 활용한 오름차순, 내림차순");
		Iterator<Integer> ita = tree.iterator();
		while(ita.hasNext())
			System.out.println(ita.next()); // 반복자를 활용한 오름차순 출력
		
		System.out.println();
		
		Iterator<Integer> ite = tree.descendingIterator(); // descendingIterator() 내림차순
		while(ite.hasNext())
			System.out.println(ite.next()); // 반복자를 활용한 내림차순 출력
	} // end main()

}// end class
