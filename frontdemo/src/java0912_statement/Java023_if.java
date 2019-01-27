package java0912_statement;

public class Java023_if {

	public static void main(String[] args) {
		
		/*
		 * 각 월의 마지막 일
		 * 1 3 5 7 8 10 12 => 31
		 * 4 6 9 11 => 30
		 * 2 => 28 
		 */
		
		int month = 4; // 월
		int lasyDay = -1; // 월의 마지막일
		
		if (month == 1 || month == 3 || month == 5 || 
				month == 7 || month == 8 || month == 10 || month == 12) {
			lasyDay = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			lasyDay = 30;
		} else if (month == 2) {
			lasyDay = 28;
		}
		
		if (month < 1 || month > 12) {
			System.out.println("1~12 까지만 입력하세요");
		} else {	
			System.out.printf("%d월은 %d일 까지 있습니다.\n", month, lasyDay);
			return;
		}
	}

}
