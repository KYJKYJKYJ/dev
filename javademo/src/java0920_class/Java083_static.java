package java0920_class;

/*
 * [프로그램 실행과정]
 * 1. 소스 코드 작성  Java083_static.java
 * 2. 컴파일(클래스 파일생성)    javac Java083_static.java (javac => 자바 바이트 코딩)
 * 3. 실행 (클래스 파일실행) java Java083_static
 * 4. 클래스 로딩-메모리로 읽어온다.(JVM method영역에 클래스 정보를 저장한다)
 *    (static으로 선언된 자원은 JVM method영역에 생성된다.)
 * 5. main()메소드 실행-main 스레드에서 main()메소드를 호출한다.
 * 6. 객체생성(new)
 * 7. 멤버변수, 메소드 호출
 * 8. main() 메소드 종료-프로그램 종료
 * 
 * [JVM의 메모리 구조]
 * 1. statck area : 메서드의 작업공간. 메서드가 호출되면
 *    메서드 수행에 필요한 메모리 공간을 할당받고 메서드가 종료되면
 *    사용하던 메모리를 반환한다.
 * 2. heap area : 객체(인스턴스)가 생성되는 공간. new키워드에
 *    의해서 생성되는 배열과 객체는 모두 여기에 생성된다.
 * 3. method area : 클래스 정보와 클래스 변수(static)가 저장되는 곳     
 * 
* static
 * 1. 같은 데이터 타입으로 생성된 객체는 서로 공유한다.
 * 2. 클래스가 로딩되는 시점에 메모리에 저장된다.
 * 3. static키워드가 선언된 메소드에서는 this, super키워드를 사용할 수 없다.
 *    (static키워드가 선언된 메소드가 위 실행과정 4번에서 생성되기 때문에
 *      즉, new보다 빠르다)
 *      
 * static은 공용(어떠한 객체, 클래스도 접근 가능) 을 목적으로 할 때 사용된다. 대신 호출 할때마다 static이 선언된 메소드의 영향을 받는다
 * ex) static int num = 1; num++; 라고 선언되었을때 서로 다른 클래스에서 num을 호출 할 경우 값이 1씩 증가함
 * 	   int num2 = 1; num++; 는 서로 다른 클래스에서 호출해도  값이 그대로임
 * 
 */


class StaticEx {
	int x = 5;
	static int y = 10;


	public StaticEx() {
	
	}
	
	void prn() {
		System.out.printf("%2d %2d\n", x, y);
	}
}

public class Java083_static {

	public static void main(String[] args) {
		System.out.printf("StaticcEx.y = %d\n", StaticEx.y);
		//System.out.printf("StaticcEx.y = %d\n", StaticEx.x); (아직 메모리에 생성 안됨)
		
		StaticEx se = new StaticEx();
		System.out.printf("se.x=%d se.y=%d\n", se.x, se.y);
		
		StaticEx ss = new StaticEx();
		System.out.printf("ss.x=%d ss.y=%d\n", ss.x, ss.y);
		
		se.x = 20;
		se.y = 30;
		System.out.printf("se.x=%d se.y=%d\n", se.x, se.y);
		System.out.printf("ss.x=%d ss.y=%d\n", ss.x, ss.y);

	}

}
