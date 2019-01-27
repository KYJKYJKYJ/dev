package java1008_exception;

public class Java152_exception {

	public static void main(String[] args) {
		int[] num = new int[] { 10, 20, 30 };
		//System.out.println(num[5]); // 시스템 상 오류가 없다. 하지만 5번째 인덱스값을 가져오지 못하게 예외처리 발생
		
		/*
		 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
				at java1008_exception.Java152_exception.main(Java152_exception.java:7)
		 */
		
		
		/*
		 * 1. 쓰레기(정확치 않은 값)를 처리함 - 문제발생
		 * 2. Exception 장치로 해결
		 * 3. 정상종료 - 문제발생
		 * 4. 예외처리 try-catch-finally로 해결
		 */
		
		try {
			//예외 발생될 가능성이 있는 구문
			System.out.println(num[5]);
		} catch(ArrayIndexOutOfBoundsException exc) {
			//예외 발생 문제를 해결함
			System.out.println(exc.toString());
		} finally {
			//무조건 실행
			System.out.println("예외 처리 종료");
		}
		
		System.out.println("프로그램 종료");
	}

}
