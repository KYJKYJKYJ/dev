package java1005_api.prob;

/*
 * [출력결과]
 *  영어 소문자 갯수:3
 *  영어 대문자 갯수:3
 *  숫자 갯수:2
 */

public class Prob004_String {

	public static void main(String[] args) {
		String data = "ke4RdTA5";

		display(process(data));
	}// end main()

	public static char[] process(String data) {
		
		return data.toCharArray();
	}// end process()

	public static void display(char[] arr) {
		int Ucount = 0;
		int Lcount = 0;
		int Dcount = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(Character.isUpperCase(arr[i]))
				Ucount++;
			
			if(Character.isLowerCase(arr[i]))
				Lcount++;
			
			if(Character.isDigit(arr[i]))
				Dcount++;
		}
		
		System.out.printf("영어 대문자 갯수 : %d\n", Ucount);
		System.out.printf("영어 소문자 갯수 : %d\n", Lcount);
		System.out.printf("숫자 갯수 : %d\n", Dcount);
		
	}// end display()

}// end class
