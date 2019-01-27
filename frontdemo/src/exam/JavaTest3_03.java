package exam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JavaTest3_03 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1987);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DATE, 27);
		
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(cal.getTime());
		
		String[] day = new String[] { "일", "월", "화", "수", "목", "금", "토" };
		
		System.out.printf("생일 : %d년 %d월 %d일 %s요일\n", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE), day[cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)-1]);
		
		String datepattern = "yyyy년 MM월 dd일";
		SimpleDateFormat date_sdf = new SimpleDateFormat(datepattern);
		System.out.println("현재 : " + date_sdf.format(System.currentTimeMillis()));
		
		String yearpattern = "yyyy";
		SimpleDateFormat year_sdf = new SimpleDateFormat(yearpattern);
		System.out.printf("나이 : %d세\n", (Integer.parseInt(year_sdf.format(System.currentTimeMillis()))-g.get(Calendar.YEAR)));
		
	}

}
