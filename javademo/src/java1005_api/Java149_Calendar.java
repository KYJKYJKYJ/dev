package java1005_api;

//2016년 2월의 마지막일과 요일을 구하는 프로그램을 구현하세요

/*
 * [출력결과]
 * 2016-2-29 월요일
 */

//요일 같은 경우 인덱스 번호로 생각하고 배열짜서 하면 됨. or switch

import java.util.Calendar;


public class Java149_Calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		
		final String[] day = new String[] {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.printf("%d-%d-%d %s", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1,
				cal.get(Calendar.DATE), day[cal.get(Calendar.DAY_OF_WEEK)-1]+"요일");
		
		/*
		int day = cal.getActualMaximum(Calendar.DATE);
		String week = "";
		switch(day) {
			case 1: week="일"; break;
			case 2: week="월"; break;
			case 3: week="화"; break;
			case 4: week="수"; break;
			case 5: week="목"; break;
			case 6: week="금"; break;
			case 7: week="토"; break;
		} 를 활용해서 해도 됨
		*/
		
		
	}

}
