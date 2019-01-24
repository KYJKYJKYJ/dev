package java1002_api;

/*
 * 정규식 (Regular Expression) - 내일모레까지 정리 10/4
 * 1. 정규식이란 텍스트 데이터 중에서 원하는 조건(패턴)과 일치하는 문자열을 찾아내기 위해
 *    사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한 문자열을 말한다.
 */

public class Java124_RegEx {

	public static void main(String[] args) {
		String sn = "java korea";
		String sg = "";
		String st = "java    korea";
		
		//j_v_ ko_e_
		for(int i = 0; i < sn.length(); i++) {
			if(sn.charAt(i) == 'a' || sn.charAt(i) == 'r')
				sg +='_'; // 내부에서는 문자열로 바뀜
			else
				sg+=sn.charAt(i);
			
		}
		System.out.println(sg);
		
		
		
		System.out.println("regular expression을 이용한 문자변경");
		
		//[]는 or 상징
		//sn 변수에 저장된 문자열에서 a이거나 r이면 "_"으로 변경
		System.out.println(sn.replaceAll("[ar]", "_")); // replaceAll 키워드 !
		
		//*는 여러개를 의미
		//sn 변수에 저장된 문자열에서 a이거나 r이 포함되면 true 아니면 false를 리턴한다.
		System.out.println(sn.matches(".*[ar].*"));
		
		//sn 변수에 저장된 문자열에서 a이거나 r로 끝나면 true 아니면 false를 리턴한다.
		System.out.println(sn.matches(".*[ar]"));
		
		//sn 변수에 저장된 문자열에서 a이거나 r로 시작하면 true 아니면 false를 리턴한다.
		System.out.println(sn.matches("[ar].*"));
		
		// \는 문자 상징, \s는 공백의미, { }는 범위 ex) 2~3개
		System.out.println(st.replaceAll("\\s{2,3}", "@"));
		// 공백이 2개부터 @로 변환
		System.out.println(st.replaceAll("\\s{2,}", "@"));
	}

}
