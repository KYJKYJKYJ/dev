package java1004_api;

/*
 * 난수를 이용해서 소수점 첫째자리까지 반올림해서 구하시오
 * ex) 0.5689.... -> 5.7
 */

import static java.lang.Math.*;

public class Java136_Math {

	public static void main(String[] args) {
		double result2 = random();
		result2 *= 100;
		
		long data = Math.round(result2); // 반올림한 정수값
		System.out.println(data);
		
		double num = data / 10.0;
		System.out.println(num);

	}

}
