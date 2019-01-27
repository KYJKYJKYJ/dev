package java0918_class;
/*
 * 생성자
 * 1. 멤버변수를 초기화 하기 위한 목적으로 사용됨 (한번만 호출)
 * 2. 클래스명과 동일
 * 3. 클래스는 한개 이상의 생성자를 가짐
 * 4. 생성자는 리턴타입이 없음
 * 5. 클래스에 생성자가 정의되어 있지 않으면 JVM에서 기본생성자 제공
 * 6. 기본생성자는 클래스의 접근제어자를 그대로 사용함
 */
class HandPhone {
	String name;
	String number;

	//생성자
	HandPhone(){} //기본생성자
	
	HandPhone(String name, String number) {
		this.name = name;
		this.number = number;
	} // 클래스에 생성자가 하나라도 존재하면 기본생성자 생성 안함
	
	void prn() {
		System.out.printf("%s %s\n", name, number);
	}
}

//클래스는 기본적으로 한개 이상의 클래스를 지님
//멤버변수 - 생성자 - 메소드 순서로 코드를 제작하는 것이 좋다

public class Java070_constructor {

	public static void main(String[] args) {
		/*
		 * 1. 스택 영역에 4바이트 생성
		 * (객체변수 선언 : HandPhone hp);
		 * 2. 힙 영역에 HandPhone 크기만큼 메모리 생성
		 * (new)
		 * 3. 멤버변수에 초기값 할당
		 * (생성자 호출 : HandPhone())
		 * 4. 힙의 주소를 스택에 저장
		 * (=)
		 * 
		 */
		HandPhone hp = new HandPhone(); // 생성자
		hp.name = "홍길동";
		hp.number = "010-8999-8888";
		hp.prn();
		
		HandPhone ne = new HandPhone("이영희", "010-8888-7777");
		ne.prn();
	}

}
