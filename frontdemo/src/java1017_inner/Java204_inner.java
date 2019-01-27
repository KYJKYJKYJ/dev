package java1017_inner;

class OuterLocal {
	private int x;
	static int y;
	final private int z = 10;
	
	public void call(int a) {
		final int b = 20;
		int c = 30;
		//a = 300;
		//System.out.println(a);
		//c = 50;
		class InnerLocal {
			void prn() {
				x = 5;
				y = 150;
				
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("z = " + z);
				System.out.println("a = " + a); //매개변수를 내부클래스에서 접근하려면 둘러싸는 범위에 정의 된 지역 변수 a는 최종적(final)이거나 유효해야함
											    //버전업이 되면서 final 키워드 붙여주지 않아도 사용은 가능, 대신 메소드에서 a 값을 지정해주면 final 키워드가 붙지 못하므로 오류
				System.out.println("b = " + b);
				System.out.println("c = " + c); //만약 값을 지정해주면 final 키워드가 못 붙음
			} // end prn() -- inner class
		} // end InnerLocal
		
		InnerLocal inner = new InnerLocal(); // call 메소드 안에서 내부 클래스 객체를 생성 해줘야 작업 가능
		inner.prn();
	} // end call() -- outer class
} // end OuterLocal

public class Java204_inner {

	public static void main(String[] args) {
		OuterLocal outer = new OuterLocal();
		outer.call(100); // 이 메소드 안에 내부클래스 객체가 생성이 안되 있어서 sysout 결과가 출력이 안됨
	} // end main

} // end class
