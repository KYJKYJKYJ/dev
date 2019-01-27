package java1016_collection;

import java.util.Comparator;

//오름차순
public class Ascending implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		System.out.println((o1 + "/" + o2 + " ") + o1.compareTo(o2)) ; // 앞의 값이 크면 1을 넘겨받고 뒤의 값이 크면 -1을 넘겨받는다.
		return o1.compareTo(o2); // 오름차순
		//return o2.compareTo(o1); or o1.compareTo(o2)*-1; // 내림차순
	}
	
}
