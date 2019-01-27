package java1004_api.prob;

/*
 * javac Prob002_String.java
 * java Prob002_String JAva Test
 */
/*1 프로그램 실행할때  "JAva Test" 문자열을 args배열에서 값을 받아 출력결과에 같이
 *  나오도록 프로그램을 구현하시오.
 *  java Prob002_String JAva Test
 *   * 
 * 2 출력결과
 *   source : JAva Test 
 *   convert: jaVA tEST     
 *   length: 9  
 *   reverse : tseT avAJ
 */

public class Prob004_String {

	public static void main(String[] args) {
	String src = "";
	String cnv = "";
	
	for(int i = 0; i < args.length; i++) {
		src += args[i] + " ";
		cnv += convert(args[i]) + " ";
	}
	
	// 앞뒤 문자열 공백 제거는 trim()
	
	src = src.trim();
	System.out.println("source : " + src);
	cnv = cnv.trim();
	System.out.println("source : " + cnv);
	System.out.println("length : " + cnv.length());
	StringBuffer sb = new StringBuffer(src);
	System.out.println("reverse : " + sb.reverse());
	}//end main()
	
	public static String convert(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				result += Character.toLowerCase(str.charAt(i));
			}
			
			if(Character.isLowerCase(str.charAt(i))) {
				result += Character.toUpperCase(str.charAt(i));
			}
		}
		
		return result;
	}
	
}// end class













