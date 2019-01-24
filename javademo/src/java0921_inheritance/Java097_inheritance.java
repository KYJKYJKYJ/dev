package java0921_inheritance;

/*
 * PetOver를 상속받은 main() 메소드를 참조하여 DogOver, BirdOver 클래스를 아래와 같이 출력하도록 구현하시오
 * 
 * [출력결과]
 * 수퍼클래스 move() : 애완동물이 움직입니다.
 * 서브클래스 move() : 새가 날아갑니다.
 */

class PetOver {
	int age;
	
	public void move() {
		System.out.println("수퍼클래스 move() : 애완동물이 움직입니다.");
	}
}

class DogOver extends PetOver {
	DogOver() {
		
	}
}

class BirdOver extends PetOver {
	BirdOver() {
		
	}
	
	@Override
	public void move() {
		System.out.println("서브클래스 move() : 새가 날아갑니다.");
	}
}

public class Java097_inheritance {

	public static void main(String[] args) {
		DogOver dog = new DogOver();
		BirdOver bird = new BirdOver();
		
		dog.move();
		bird.move();
	}

}
