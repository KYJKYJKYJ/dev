package java0921_inheritance;

//오버라이딩 : 서브클래스 또는 자식 클래스가 자신의 슈퍼클래스들 또는 부모 클래스들 중 하나에 의해 이미 제공된 메소드를 특정한 형태로 구현하는 것 (재정의)
//오버로딩 : 하나의 클래스에 같은 이름의 메소드를 여러개 정의 하는 것 (매개변수 갯수, 자료형타입을 고쳐서 일어남, 리턴타입은 관련 X) (중복정의)

/*
 * 오버라이딩
 * 1. 조상클래스의 메소드를 자식클래스에서 재정의 (메소드 구현부)하는 기능이다.
 * 2. 메소드의 선언부는 그대로 사용 (리턴타입, 메소드명, 매개변수)
 * 	    단, 접근제어자는 같거나 크면된다.
 *    private < default < protected < public
 * 3. 상속이 되어야지 오버라이딩 가능
 * 
 * super
 * 1. 자식클래스에서 부모클래스를 호출할 때 사용된다.
 * 2. super.멤버변수
 *    super.메소드()
 *    super() => 생성자 
 * 
 * 단일클래스 vs 상속클래스
 * overloading vs overriding => (공통점) 메소드명이 동일함
 * this vs super
 * 위 세가지 답들을 알자!
 */


class First {
	int a = 10;
	
	void prn() {
		System.out.println("a = " + a);
	}
}

class Second extends First {
	int a = 30;
	int b = 20;
	
	@Override //주해 : 오버라이드를 활용하려면 부모클래스와 메소드 이름이 같아야 하는데 잘못 입력하여 새로운 메소드를 생성했다고 착각하는 것을 막아줌
	void prn() { // 오버라이드 된 메소드는 원래 메소드의 접근 지정자를 따라가거나 더 큰 범주여야함
		System.out.printf("a = %d b = %d\n", a, b);
		System.out.printf("a = %d b = %d\n", super.a, b);
	}
	
	public void display() {
		System.out.println("display");
	}
	
	public void superThisMethod() { //static 키워드가 붙게되면 super와 this 키워드 사용 불가
									//클래스 로딩 때 메모리 영역이 확보되므로 new 키워드 보다 빠르다, 즉 객체가 생성되지 않아서
		super.prn();
		this.prn();
	}
}

public class Java096_inheritance {

	public static void main(String[] args) {
		Second sd = new Second();
		sd.prn();
		sd.display();
		sd.superThisMethod();

	}

}
