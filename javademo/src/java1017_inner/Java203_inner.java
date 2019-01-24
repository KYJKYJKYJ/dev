package java1017_inner;

class OuterStatic {
	private int x;
	static private int y;
	
	static void call() {
		y = 9;
		System.out.println(y);
	}
	
	static class InnerStatic {
		int z;
		static int k = 5;
		void prn() {
			//x = 40; // 비스태틱 외부 자원을 스태틱 내부 클래스에서 참조 못함
			y = 20;
			z = 30; // prn이 비스태틱이라서 z 참조 가능
			System.out.printf("%d %d\n", y, z);
		} // end prn()
	} // end InnerStatic
} // end OuterStatic

public class Java203_inner {

	public static void main(String[] args) {
		OuterStatic.call();
		OuterStatic.InnerStatic inner = new OuterStatic.InnerStatic(); //내부 스태틱클래스는 외부객체를 참조하지 않고 객체 생성이 가능함
		inner.prn();
		
		System.out.println(OuterStatic.InnerStatic.k); // 내부클래스의 스태틱 자원은 바로 호출이 가능함
	}

}
