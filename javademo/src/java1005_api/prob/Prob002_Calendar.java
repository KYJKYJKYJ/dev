package java1005_api.prob;

/*
 * 
 * 1 년도와 월을 입력받는다.
 * 2 process()메소드에서 달력에 표현해줄 값을 구해서 배열에 저장한
 *   다음 반환한다.
 * 3 prn()메소드에서 아래와 같이 출력한다.
 * 
 * 4 출력결과
 2012년도 5월
 일    월      화       수      목      금    토
 			1     2     3     4    5
 6     7     8     9    10    11   12
 13    14    15    16    17    18   19
 20    21    22    23    24    25   26
 27    28    29    30    31          

 4 문제해결
 * getActualMaximum(Calendar.DATE); //각 달의 마지막일
 * set(year,month,1) //Calendar객체에 새로운 날짜 설정
 * get(Calendar.DAY_OF_WEEK); //요일 출력  일요일=1, 토요일=7
 */
import java.util.Calendar;
import java.util.Scanner;

public class Prob002_Calendar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도입력: ");
		int year = sc.nextInt();
		System.out.print("월입력: ");
		int month = sc.nextInt();
		prn(process(year, month), year, month);
	}// end main()

	public static int[][] process(int year, int month) {
		int[][] data = new int[6][7];
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		
		if(day == 1) {
			int date = 1;		
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(date <= cal.getActualMaximum(Calendar.DATE)) {
						data[i][j]=date++;
					}
				}
			}	
			return data;
		} else {
			//첫째 주
			int date = 1;
			for(int j = day; j < 7; j++) {
				data[0][j] = date++;
			} // 첫째 주에서 요일에 따라 자리를 지정함
		
			//둘째 주 부터
			for(int i = 1; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if(date <= cal.getActualMaximum(Calendar.DATE)) {
						data[i][j]=date++;
					}
				}
			}	
			return data;
		}
	}

	public static void prn(int arr[][], int year, int month) {
		System.out.printf("	%10d년도  %6d월\n", year, month);

		System.out.println("\t일 \t월 \t화\t수\t목\t금\t토");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) 
					System.out.printf("%4c", ' ');
				else
					System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}// end prn()

}// end class
