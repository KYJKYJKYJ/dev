package java0927_abstract_interface;

/*
 * final = 상수화, 변경되지 않는 결과에 사용.
 * 1. 변수 : 상수
 * int num = 20;
 * num = 30;
 * 
 * final int DATA = 5; 
 * final 키워드가 붙은 변수는 대문자로 선언해줌 (일반 변수와 구별)
 * 반드시 초기값을 부여해야함
 * 
 * 2. 메소드 : 메소드에 final 키워드를 붙이면 오버라이딩 할수가 없음
 * final void prn() { }
 * 
 * 3. 클래스 : 상속을 할 수 없다
 * final class Test { }
 * 
 */

class FinalTest {
	final int CODE = 1;
	
	void display() {
		
	}
	
	void call() {
		System.out.println("call");
	}
	
	final void process() {
		System.out.println("process");
	}
}

class UserFinal extends FinalTest {
	public UserFinal() { }
	
	@Override
	void call() {
		System.out.println("Override call");
	}
	
	/*void process() { final 키워드 때문에 오버라이딩 불가
		System.out.println("process");
	}*/
}

final class Base { }

//final이 선언된 Base는 상속이 불가능
//class Expand extends Base { }

public class Java108_final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
