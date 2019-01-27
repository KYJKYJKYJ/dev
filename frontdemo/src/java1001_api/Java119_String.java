package java1001_api;

/*
 * [출력결과]
 * aerok
 * korea
 */

public class Java119_String {

	public static void main(String[] args) {
		String sn = "korea";
		char[] data = display(sn);
		System.out.println(data);
		System.out.println(sn);
	}
	
	public static char[] display(String alpa) {
		char[] reverseData = new char[alpa.length()];
		
		for(int i = 0; i < alpa.length(); i++) {
			reverseData[i] = alpa.charAt(alpa.length()-1-i);
		}
		
		return reverseData;
	}

}
