package java0912_statement;

public class Java026_switch {

	public static void main(String[] args) {
		/*if (month == 1 || month == 3 || month == 5 || 
				month == 7 || month == 8 || month == 10 || month == 12) {
			lasyDay = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			lasyDay = 30;
		} else if (month == 2) {
			lasyDay = 28;
		}*/
		
		int month = 4; // 월
		int lasyDay = -1; // 월의 마지막일
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: 
			lasyDay=31; 
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lasyDay=30;
			break;
		case 2:
			lasyDay=28;
			break;
		default :
			System.out.println("1~12까지 입력하셔야 합니다.");
			return;
		}
	
			System.out.printf("%d월은 %d일 까지 있습니다.\n", month, lasyDay);
			return;
			
	}

}
