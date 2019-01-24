package java1005_api;

import java.util.GregorianCalendar;

abstract class Pet {
	public abstract void move();
	
	public static Pet getInstance() {
		return new Dog();
	}
} // end Pet class

class Dog extends Pet {
	@Override
	public void move() {
		System.out.println("움직인다");
	}
	
	public void process() {
		
	}
} // end Dog class

public class Java150_GregorianCalendar {

	public static void main(String[] args) {
		/*
		//Pet pet = new Dog(); // 바로 업캐스팅
		Pet pet = Pet.getInstance(); // dog 객체 생성 (업캐스팅)
		pet.move();
		//pet.process(); 오버라이딩이 없어서 가르킬 수가 없음, 실질적으로 가르키는건 Pet
		System.out.println(pet.toString());
		
		148번 Calendar에서 cal.toString() 해보면
		java.util.GregorianCalendar가 있는데, 이걸 Calendar가 업캐스팅해서 메소드를 오버라이딩 후 사용하는 것
		*/
		
		int year = 2012;
		GregorianCalendar gre = new GregorianCalendar();
		if(gre.isLeapYear(year))
			System.out.printf("%s년도는 윤년입니다.\n", year);
		else
			System.out.printf("%s년도는 평년입니다.\n", year);
		//윤년 판단
		
	} // end main()

} // end class
