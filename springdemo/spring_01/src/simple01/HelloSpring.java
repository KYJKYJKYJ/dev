package simple01;

/*
 * 결합도
 * 1. 클래스간의 상호 연결성 측정을 의미한다.
 * 2. 낮은 결합도를 가지려면 하나의 객체 변경이 다른 객체에 영향을 미쳐서는 안된다.
 * 
 * 클래스안에서 다른 클래스를 호출하는 has a 관계가 결합도가 가장 높다.
 * 
 * 결합도가 낮을 수록 유지보수 하기가 좋다.
 * 
 * bean : 자주 사용하는 객체를 Singleton 객체로 생성해놓고 어디서든 불러서 쓸 수 있는 것 (스프링 프레임워크가 초기화시 직접 객체를 생성해줌 (인스턴스화))
 * 협업의 기초 **
 *  
 * 객체 지향 프로그래밍에서, 어떤 클래스에 속하는 각 객체를 인스턴스라 한다
 * class : 붕어빵틀, Object : 붕어빵, Instance : 각각의 붕어빵들 (슈크림도 있을꺼고.. 탄거도 있을꺼고..)
 */

public class HelloSpring {
	public static void main(String[] args) {
		//MessageBean 클래스 이름을 직접적으로 사용하고 있기 때문에 높은 결합도를 가지고 있다.
		MessageBean bean = new MessageBean();
		bean.sayHello("정그니형 그만자요");
	} // end main()
} // end HelloSpring
