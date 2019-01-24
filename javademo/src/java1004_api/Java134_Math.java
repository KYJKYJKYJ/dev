package java1004_api;

import java.lang.Math.*; // Math 클래스 내는 전부 static으로 선언이 되어서 별도의 생성자가 없다. 즉, 별도의 객체 생성이 필요가 없다.
// 그냥 기능을 호출해서 사용하면 됨.

import static java.lang.Math.E;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/*
 * 클래스에서 static 키워드로 선언된 멤버변수, 메소드를 호출할 때
 * import static을 선언하면 클래스명 없이 바로 멤버변수, 메소드 호출이 가능하다!
 * import static java.lang.Math.*;
 */

public class Java134_Math {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.max(10, 20)); // 인자값을 두개밖에 비교하지 못함...
		System.out.println(Math.min(10, 20)); // 인자값을 두개밖에 비교하지 못함...
		System.out.println(E);
		System.out.println(sqrt(25));
		System.out.println(pow(2, 2));

	}

}
