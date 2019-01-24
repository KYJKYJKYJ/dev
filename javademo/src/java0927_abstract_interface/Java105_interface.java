package java0927_abstract_interface;

/*		  			class 			interface
 *  멤버변수			0				상수
 *  메소드			선언부+구현부		선언부(추상메소드)
 *  생성자 			O				X
 *  초기화블록			O				X
 *  내부클래스 		O				O
 *  
 *  
 *  extends : 클래스에 클래스를 상속(단일상속), 인터페이스 상속(다중상속)
 *  implements : 클래스에 인터페이스 상속(다중상속)
 *  
 *  인터페이스(interface)
 *  1 추상메소드와 상수를 가지고 있는 형태이다.
 *  2 클래스 작성에 도움을 주기위한 목적으로 제공이 되는 표준명세서이다.
 *  3 implements : 클래스에 인터페이스를 상속할 때 사용되는 키워드이다.
 *  4 인터페이스는 접근제어자로 public만 제공한다.
 *  5 인터페이스는 추상메소드에 abstract키워드를 명시하지 않아도 된다.
 *    자바가상머신에서 자동처리 처리하기 때문에..
 *  
 */

interface CarRun {
	int carCount = 5; // public static final /상수 final 이 저장된 상수 단한번 사용가능,선언할때 사용
	// public final <-자바가상머신에서는 final 을 사용함

	// public CarRin() {} 생성자를 가질수없음.

	void prn(); // public abstract
	// void display() {} 메소드 구현부에 오류가있음
	// static {System.out.println("static"); 인터페이스에서는 스태틱 사용안함

	class Sun {
		
	}

}// end CarRun

class TruckRun implements CarRun {
	public TruckRun() {

	}

	@Override
	public void prn() {
		System.out.println("prn");
	}

}// end TruckRun

public class Java105_interface {

	public static void main(String[] args) {
		System.out.println(CarRun.carCount);// 상수가정의된 인터페이스 CarRun.carCount
		TruckRun tr = new TruckRun();
		tr.prn();
		
	}// end main()

}// end class
