package java1016_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Java187_sort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 3, 5, 2, 4 };
		ArrayList<Integer> aList =
				new ArrayList<Integer>(Arrays.asList(arr));
		
		aList.sort(new Ascending());
		System.out.println(aList);
		
		aList.sort(new Descending());
		System.out.println(aList);

		System.out.println("=================================================");
		//지금 Descending 되어있음
		System.out.println("앞에서 부터 뒤로 출력");
		ListIterator<Integer> ite = aList.listIterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println();
		//5 -> 4 -> 3 -> 2 -> 1 (1에 포인터가 되어있음)
		System.out.println("=================================================");
		//next()를 통해 커서를 이동해야 previous() 사용 가능함
		System.out.println("뒤에서 부터 앞으로 출력");
		while(ite.hasPrevious()) { // 이전에 가져올 요소가 있는가?
			System.out.println(ite.previous());
		}
		System.out.println();
		//5 <- 4 <- 3 <- 2 <- 1 (5에 포인터가 되어있음)
		
		//ListIterator에서만 사용 가능
		//iterator는 그냥 순차적으로 흘러가는 작업 할 때
		//Listiterator는 앞뒤로 커서를 옮겨가며 작업 할 때
	}

}
