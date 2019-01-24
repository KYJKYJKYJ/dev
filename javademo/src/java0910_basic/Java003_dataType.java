package java0910_basic;

// literal : 그 자체의 값 (1,2,3... a,b,c... true, false) [ 상수와는 다름 ! ]
// 변수 : 하나의 값을 저장하기 위한 메모리 공간 [ 여기에 literal이 들어감 ]
// 자료형 : 변수에 저장하는 값의 종류와 할당되는 메모리 크기를 결정

// 자료형의 타입 : 1. 기본형  2. 참조형
// 기본형 : 실수형, 정수형, 논리형, 문자형
// 참조형 : 배열, 클래스, 인터페이스

// 형변환(casting) : 시스템에서 인식하는 데이터 타입의 크기에 비례해 변환 ex) (int)(3.5)
// byte < short, char < int < long < float < double

public class Java003_dataType {
	public static void main(String[] args) {
		int data = 3; // int : 자료형 (4byte 메모리 크기 할당), data : 메모리 접근 위한 변수 지정
		double data2 = 3.4;
		
		data = 10;
		
		System.out.println(data);
		System.out.println(data2);
	}
}
