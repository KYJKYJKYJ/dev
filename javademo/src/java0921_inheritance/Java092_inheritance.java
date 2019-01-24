package java0921_inheritance;

/*
 * 상속 (inheritance)
 * 1. 기본 클래스를 재사용하여 새로운 클래스를 정의하는 것
 * 2. 두 클래스를 조상과 자손 관계를 맺어줌 (extends)
 * 3. 상속을 해주는 클래스 : 수퍼클래스 == 부모클래스 == 기본클래스
 *	    상속을 받는 클래스 : 서브클래스 == 자식클래스 == 유도클래스
 * 4. 자식(자손)클래스는 조상의 모든 자원을 기본적으로 상속받는다.
 *    (생성자, static()은 제외)
 * 5. 접근제어자가 private이거나 default면 상속 받지 못한다.
 * 6. 자식클래스의 자원은 부모클래스보다 크기가 크거나 같아야 한다. (자식클래스 >= 부모클래스)
 * 7. 상속을 할 때 사용되는 키워드 : extends (단일 상속)
 * 
 * class A {}
 * class B extends A {} (B는 A를 상속받음) (A : 부모, B : 자식)
 * = A는 B에게 상속한다
 * = B는 A이다 (상속관계의 클래스를 is a 관계라 한다)
 * 
 * class 도형 {}
 * class 삼각형 extends 도형 {} = 삼각형은 도형이다.
 * 
 * =======================================================================
 * 
 * class Test {}
 * class Sample {
 * 		public static void main(String[] args) {
 * 			Test tt = new Test();
 * 		}
 * }
 * 
 * Sample은 Test를 포함한다 (포함관계 - has a)
 * 
 * =======================================================================
 * 
 * 상속에서 클래스 상위로 갈수록 추상적 (ex. 동물)
 * 클래스 하위로 갈수록 구체적 (ex. 포유류)
 * final 키워드를 마지막에 붙여 완전함을 명시 (ex. 인간)
 */

class Maker { // 원래는 따로 클래스를 만들어서 작업하는 것이 좋다.
	int a = 3;
	void prn() {
		System.out.println("a = " + a);
	}
}

class Car extends Maker {
	int b = 5;
}

public class Java092_inheritance {

	public static void main(String[] args) {
	Car c = new Car();
	System.out.println("c.a = " + c.a);
	c.prn();
	}

}
