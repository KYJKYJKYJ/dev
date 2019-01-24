package java0921_inheritance;

//상속관계에서 생성자 처리도

class oldMakers /* extends Object */  { // Object는 기본적으로 상속되는 클래스
	public oldMakers() { //7
		System.out.println("oldMakers"); //8
	} //9
}

class Makers extends oldMakers {
	public Makers() { //5
		super(); //6
		System.out.println("Makers");//10
	}//11
}

class Cars extends Maker { // 자식클래스 생성자 안에서 부모클래스 안의 생성자를 호출해야됨
	public Cars() { // 3
		super(); // 부모 객체를 호출할 때 쓰는 키워드 (한개만) // 부모생성자 호출이 생략되어 있으면 JVM에서 super()로 호출 // 4
		System.out.println("Cars"); //12
	}//13
}

public class Java093_inheritance {

	public static void main(String[] args) { //1
		Cars c = new Cars(); //2
	}//14

}
