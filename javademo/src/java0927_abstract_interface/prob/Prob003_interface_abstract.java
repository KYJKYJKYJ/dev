package java0927_abstract_interface.prob;
/*[주의]테스트할때 main( )메소드의 주석을 해제하세요.
 * Mammal인터페이스, Fish클래스를 상속받아
 * 아래와 같이 출력이 되도록  Whale클래스를 구현하세요.
 * 테스트 할때 main()메소드의 주석은 해제를 합니다.
 * 
 * [출력결과]
 * 물고기는 헤엄치며 움직입니다.
 * 고래는 새끼를 낳습니다.
 */

interface Mammal { // 포유류
	abstract void bear(); // 새끼를 낳음
}

abstract class Fish { // 어류
	String name;

	public Fish() {

	}

	public Fish(String name) {
		this.name = name;
	}

	void swim() {
		System.out.println("물고기는 헤엄치며 움직입니다.");
	}

}

//여기에서 Whale클래스를 구현하세요.
class Whale extends Fish implements Mammal {
	
	public Whale() {
		super("고래");
	}
	
	@Override
	public void bear() {
		System.out.println("고래는 새끼를 낳습니다");
	}
	
}
	


public class Prob003_interface_abstract {
	public static void main(String[] args) {
		//테스트할때 주석을 아래 주석을 해제 하세요.
		Whale whale1 = new Whale();
		whale1.swim();
		whale1.bear();
	}//end main()
}//end class
