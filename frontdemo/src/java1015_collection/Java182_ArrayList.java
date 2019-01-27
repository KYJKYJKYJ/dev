package java1015_collection;

import java.util.ArrayList;

/*
 * Vector와 ArrayList
 * 1. Vector는 동기화 처리가 되어있고 ArrayList는 비동기화 처리한다
 * 2. Vector와 ArrayList는 메모리에 요소를 처리할 때 배열의 구조를 따른다.
 * 3. Vector와 ArrayList의 클래스는 처리방법이 비슷함.
 * 4. Vector와 ArrayList로 요소의 삽입, 삭제를 처리하는 것은 좋은 방법이 아님
 */

/*
 * 벡터와 달리 알아서 메모리 크기도 나눠지기 때문에 trim 같은 메소드가 제공되지 않음.
 * (capacity, size 들이 자동으로 할당됨)
 */

public class Java182_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(new Integer(10));
		aList.add(new Integer(20));
		aList.add(new Integer(30));
		
		for(int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}
		
	}

}
