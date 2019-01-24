package java1016_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Java190_LinkedList {

	public static void main(String[] args) {
		//하나의 값을 저장하는 공간인 노드를 여러개 연결해서 구조를 만드는게 Link
		//구조는 배열 또는 Linked
		//배열은 순차적으로 자료를 가져올 때 좋고, Linked는 수시로 삽입과 삭제가 이루어 질 때 좋다.
		
		/*
		 * 1. 배열 구조로 데이터 관리 : Vector, ArrayList
		 * 						 ArrayList-추가-(순차적으로 처리할 때 사용)
		 * 
		 * 2. 링크로 데이터 관리 : LinkedList
		 * 						삽입, 삭제-(비순차적으로 처리할 때 사용)
		 * 
		 * 3. List를 구현해 놓은 컬렉션
		 * 		Vector, ArrayList, LinkedList는 add() 해준 순서대로 데이터 관리를 해줌
		 */

		ArrayList<String> aList = new ArrayList<String>();
		System.out.println("ArrayList의 경우");
		aList.add(new String("java"));
		aList.add(new String("jsp"));
		aList.add(new String("spring"));
		System.out.println(aList);
		System.out.println("==========================================");
		
		LinkedList<String> aNode = new LinkedList<String>();
		System.out.println("LinkedList의 경우");
		
		//추가 (인자값을 하나만 넘길 때)
		aNode.add(new String("java"));
		aNode.add(new String("jsp"));
		aNode.add(new String("spring"));
		System.out.println(aNode);
		
		//삽입 (ArrayList에서도 사용가능)
		System.out.println("인덱스 1번째에 ajax 삽입");
		aNode.add(1, new String("ajax"));
		System.out.println(aNode);
		
		//삭제
		System.out.println("인덱스 2번째 java 삭제됨");
		aNode.remove(2);
		System.out.println(aNode);
		
		System.out.println();
		
		//iterator는 그냥 순차적으로 흘러가는 작업 할 때
		//Listiterator는 앞뒤로 커서를 옮겨가며 작업 할 때
		ListIterator<String> ite = aNode.listIterator();
		System.out.println("앞 -> 뒤");
		while(ite.hasNext())
			System.out.println(ite.next());
		
		System.out.println("뒤 -> 앞");
		while(ite.hasPrevious())
			System.out.println(ite.previous());
	} // end main()

} // end class
