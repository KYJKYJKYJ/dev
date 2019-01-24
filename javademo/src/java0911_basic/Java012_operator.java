package java0911_basic;

public class Java012_operator {
	public static void main(String[] args) {
		
	int a = 4;
	int b = 5;
	int c = 7;
	
	boolean res = (++a > b) && (++b < c);
	// 논리 연산은 좌변 먼저 처리한다.
	// 좌변 먼저 처리했을 때 False 값이 나오므로 우변을 처리하지 않아도 결과값이 False인 것을 알 수 있다.
	// 그러므로 우변의 증감 연산자는 연산되지 않는다.
	
	System.out.println("a = " + a);
	System.out.println("b = " + b);
	System.out.println("res = " + res);
	
	int x = 4;
	int y = 8;
	int z = 10;
	
	res = (z > ++y) || (++x > y);
	// 논리 연산은 좌변 먼저 처리한다.
	// or 연산에서 한 쪽만 true 면 true 이다. 좌변이 true 이므로 우변을 처리하지 않아도 됨.
	System.out.println("x = " + x);
	System.out.println("y = " + y);
	System.out.println("res = " + res);
	}
}
