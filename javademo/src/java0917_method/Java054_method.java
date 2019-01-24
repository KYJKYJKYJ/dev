package java0917_method;

public class Java054_method {
//윤년
	public static boolean isLeapYear(int year) { //4
		//boolean chk; //5
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { //6
			//chk = true; //7
			return true;
		} /*8*/ else {
			//chk = false;
			return false;
		}
		//return chk; //9
	} //10
	
	public static void main(String[] args) { //1
		int year = 2012; //2
		
		if(isLeapYear(year)) { //11
			System.out.println(year + "년도는 윤년입니다."); //12
		} /*13*/ else {
			System.out.println(year + "년도는 평년입니다.");
		}

	} //14

}
