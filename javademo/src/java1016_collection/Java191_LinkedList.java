package java1016_collection;

import java.util.LinkedList;

/*
 * stack(스택)
 * 1. LIFO : 마지막에 저장된 요소를 먼저 꺼냄
 * 2. 수식계산, 수식괄호검사, undo/redo, 뒤로/앞으로
 */

public class Java191_LinkedList {

	public static void main(String[] args) {
		//LinkedList를 이용하면 list, stack, queue 구현 가능.
		LinkedList<String> nStack =new LinkedList<String>();
		
		//추가 - push
		nStack.push(new String("java"));
		nStack.push(new String("jsp"));
		nStack.push(new String("spring"));
		
		while(!nStack.isEmpty()) // nStack.isEmpty() 스택이 비었는지?
		//추출 - pop
			System.out.println(nStack.pop());
	}

}
