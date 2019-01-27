package java1002_api;

/*
 * 문자열 관련 클래스
 * java.lang.String : 불변
 * java.lang.StringBuffer : 가변, 비동기화
 * java.lang.StringBuilder : 가변, 동기화
 */

public class Java129_StringBuffer {

	public static void main(String[] args) {
		String sg = new String("java test");
		/*System.out.println(sg.replace("java", "jsp"));
		System.out.println(sg.toString()); //sg 내부에 있는 데이터를 그대로 끌어와서 그냥 java test */
		System.out.println(sg.toString());
		String sn = sg.replace("java", "jsp");
		System.out.println(sn.toString());

		System.out.println("========================================");
		
		StringBuffer sb = new StringBuffer("spring test");
		// 0부터 6미만 사이의 문자열을 "framework"로 변경하라
		System.out.println(sb.replace(0, 6, "framework"));
		System.out.println(sb.toString());
	}

}
