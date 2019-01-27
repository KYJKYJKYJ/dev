package java0911_basic;

public class Java015_operator {

	public static void main(String[] args) {
		//연산자 우선순위
		//단항(++,--,!) > 산술 > 비교 > 논리 > 삼항 > 대입

		int a = 10;
		int b = 3;
		int c = 5;
		
		int res = a > b && a == b ? a + b : a - b;
		System.out.println(res);
	}

}
