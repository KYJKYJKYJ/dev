package java0910_basic;

public class Java005_operator {
	public static void main(String args[]) {
	
		// 연산자 : 어떠한 기능을 수행하는 기호 ( +, -, *, /, %, <, >, == , != ....)
		// 피연산자 : 연산자에 의해 기능을 받는 대상 ( 변수, 상수, 리터럴, 수식 )
		
		/*
			산술연산자 : +, -, *, /, %
			논리연산자 : &&, ||, !
			삼항연산자 : 조건 ? (참 : 거짓)
			대입연산자 : =, +=, -=, *=, /=
			단항연산자 : a++, a--, ++a, --a
		*/
		
		int kor = 10;
		int eng = 20;
		int result = kor + eng; // 동일 데이터 타입 끼리의 연산 
		
		double avg = 4.5;
		double result2 = kor + avg; // int + double의 계산에선 큰 데이터 타입을 따라가므로 결과값은 double형
		
		short numa = 3;
		short numb = 4;
		short result3; // = numa + numb; 시 오류 발생함 (short)(numa + numb)가 맞는 표현;
		// int 이하 자료형 타입 끼리의 연산시 결과값은 int형임에 주의하자
		// ex) (byte + short), (char + short), (byte + int), (byte + byte)
		
		
		char data = 'a';
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(data-32); // int 이하 끼리 연산시 결과값은 int형
		System.out.println((char)(data-32)); // 값 65는 유니코드 A
		
	}
}
