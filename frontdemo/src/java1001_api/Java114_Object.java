package java1001_api;

/*
 * API (Application Programming Interface)
 * 1. 운영체제와 응용프로그램 사이에 통신에 사용되는 언어나 메세지 형식을 말한다.
 * 2. 자바개발 환경에서 제공되는 거대한 패키지이다.
 * 3. 자바언어는 작고 단순한 대신 많은 기능들을 제공하는 라이브러리를 API로 제공하고 있다.
 * 
 * Object
 * 1. 클래스 중에서 최상의 클래스이다.
 * 2. Object를 제외한 모든 클래스들은 Object를 상속받고 있다.
 * 3. java.lang 패키지에서 제공하는 클래스이다.
 */

public class Java114_Object {

	public static void main(String[] args) {
		Object obj = new Object();
		
		System.out.println(obj);
		System.out.println(obj.toString()); // 둘의 의미가 동일함 java.lang.Object@7852e922
		
		int x = 5;
		int y = 5;
		
		//기본데이터 타입은 값을 비교
		System.out.printf("x=%d y=%d x==y:%b\n", x, y, x==y);
		
		//참조데이터 타입은 주소를 비교
		Object otj = new Object();
		System.out.printf("obj==otj:%b\n", obj==otj);

		//equals() : 주소비교-객체비교 가능
		System.out.printf("obj.equals(ojt):%b\n", obj.equals(otj));
		
		//class java.lang.Object //객체가 속한 클래스 출력
		System.out.println(obj.getClass());
		
		//java.lang.Object //객체가 속한 클래스명만 출력
		System.out.println(obj.getClass().getName());
	}

}
