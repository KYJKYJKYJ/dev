package java1017_inner;

abstract class InnerAnonymous {
	abstract void prn();
} // end InnerAnonymous

class Test extends InnerAnonymous {

	@Override
	void prn() {
		System.out.println(100);		
	}
	
}// end Test

class OuterAnonymous {
	private int x;
	public void call() {
		/*InnerAnonymous tt = new InnerAnonymous() {
			@Override
			void prn() {
				x = 5;
				System.out.println(x);
			}
		}; // 클래스 생성과 동시에 객체 생성을 해버림 (익명 클래스), 외부에서 객체 생성 불가능, 한번만 사용됨
		tt.prn();*/
		
		new InnerAnonymous() {
			@Override
			void prn() {
				x = 5;
				System.out.println(x);
			}
		}.prn(); // 클래스 생성과 동시에 객체 생성을 해버림 (익명 클래스), 외부에서 객체 생성 불가능, 한번만 사용됨
		
	} // end call()
} // end OuterAnonymous

public class Java205_inner {

	public static void main(String[] args) {
		Test tt = new Test();
		tt.prn();
		
		OuterAnonymous outer = new OuterAnonymous();
		outer.call();
	} // end main()

} // end class
