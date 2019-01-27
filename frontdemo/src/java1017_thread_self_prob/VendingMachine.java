package java1017_thread_self_prob;

import java.util.Stack;

public class VendingMachine {
	Stack<Integer> stack = new Stack<Integer>();
	
	public String getDrink() {
		return "꺼내먹음";
	}
	
	public void putDrink(String drink) {
		System.out.println(stack.pop());
	}
	
}
