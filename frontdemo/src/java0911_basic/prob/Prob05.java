package java0911_basic.prob;

/*
 *평년,윤년을 구하는 프로그램을 구현하시오.
 *1 윤년의 조건
 * 1) 년도를 4로 나눈 나머지가 0이고 100로 나눈 나머지가 0이 아니다.
 * year % 4 == 0 && year % 100 != 0
 * 2) 년도를 400로 나눈 나머지가 0이다.
 * year % 400 == 0
 * 
 * 2 [출력결과]
 *   2012년도는 윤년입니다.
 *   2013년도는 평년입니다.
 */

public class Prob05 {

	public static void main(String[] args) {
		int year=2013 ;
		String leapYear="";
		
		//여기에 작성하시오.
		leapYear = year % 4 == 0 && year % 100 != 0 ? "윤년" : year % 400 == 0 ? "윤년" : "평년";
		
		System.out.printf("%d년도는 %s입니다.", year, leapYear);
		
	}//end main()

}//end class






