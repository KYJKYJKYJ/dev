package java1005_api;

import java.util.Calendar;

public class Java148_Calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar는 추상클래스라서 이렇게 객체를 받으라고 API에 명시 되있음.
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; // 1월을 0을 기준으로 작성했기 때문에 1을 더해줘야 현재월에 맞음
		                                       // 저장(세팅)할 때는 1을 빼줘야 맞음
		int date = cal.get(Calendar.DATE);
		
		int hour = cal.get(Calendar.HOUR); // 12시간
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24시간
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.printf("%d-%d-%d %d:%d:%d\n", year, month, date, hour, minute, second);
		
		System.out.println(cal.getActualMaximum(Calendar.DATE)); // 이번달의 마지막일 리턴
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 오늘의 요일 리턴 (일요일 -> 1)
		
		cal.add(Calendar.DATE, -5); //5일전 날짜 리턴, +5면 5일후 날짜 리턴
		System.out.println(cal.toString());
		
		cal.set(2017, 2, 1); // cal.set(Calendr.YEAR, 2017); // 2017-3-1
		System.out.printf("%d-%d-%d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));


	}

}
