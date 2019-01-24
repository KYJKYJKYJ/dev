package java0920_class;


/* 
 * class 클래스명 {
 * 	멤버변수;
 * 	static {}
 * 	생성자() {}
 * 	메소드() {}
 * 	내부 클래스
 * }
 */

class OrderStatic {
	static {
		System.out.println("static");
	} // 메소드 영역에 이미 생성 되어있음
	
	// 스태틱 블록이 수행되고 생성자가 생성됨.
	
	public OrderStatic() {
		System.out.println("constructor");
	}
	
	public void prn() {
		System.out.println("method");
	}
}

public class Java084_static {

	public static void main(String[] args) {
		OrderStatic st = null;
		st = new OrderStatic();
		st.prn(); // 스태틱 - 생성자 - 메소드 순으로 실행됨
		// 위 클래스의 메소드 순서를 바꾸어도 출력은 마찬가지

	}

}
