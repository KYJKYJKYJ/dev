package java0921_inheritance;

/*
 * [출력결과]
 * 애완동물이 움직입니다.
 * 애완동물이 움직입니다.
 * 강아지의 이름은 누렁이고, 몸무게는 10Kg입니다.
 * 새의 종류는 앵무새고, 날 수 있습니다
 */
class Pet {
	int age; // 애완동물 개월수

	public void move() {
		System.out.println("애완동물이 움직입니다.");
	}
}// end Pet

class Dog extends Pet {
	String name; // 강아지 이름
	int weight; // 강아지 무게

	void sum(int a, int b) {

	}

	void sum(int a, int c, int d) {

	}

	int getWeight() {
		return weight;
	}// end gettWeight( )
}// end Dog

class Bird extends Pet {
	String type; // 새 종류
	boolean flightYN; // 날수 있는지 여부

	boolean getFlight() {
		return flightYN;
	}// end getFlight()
}// end Bird

public class Java101_inheritance {

	public static void main(String[] args) {
		// 출력결과를 참조하여 정상적으로 프로그램 실행이 되도록 여기를 구현하세요.
		  Dog dog = new Dog();
		  Bird bird = new Bird();
		  
		  dog.move();
		  bird.move();
		  
		  dog.name = "누렁이";
		  dog.weight = 10;
		  
		  bird.type = "앵무새";
		  bird.flightYN = true;
		//////////////////////////////////////////////		
		// 실행할때 아래 부분의 주석을 해제하세요.
		System.out.println("강아지의 이름은 " + dog.name + "고, 몸무게는 " + dog.getWeight() + "Kg입니다.");
		System.out.println("새의 종류는 " + bird.type + "고, 날 수 " + (bird.getFlight() ? "있" : "없") + "습니다");

	}// end main()

}// end class