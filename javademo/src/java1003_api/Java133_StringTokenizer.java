package java1003_api;

import java.util.StringTokenizer;

public class Java133_StringTokenizer {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("java,,jsp/spring", ",/"); // 만약 두번째 인자값이 없으면 공백을 기준으로 나눔
		
		System.out.println("토큰갯수 : " + st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("===================================");
		
		String[] arr = new String("java,,jsp/string").split("[,/]");
		System.out.println("배열크기 : " + arr.length);
		
		for(String ss : arr) {
			System.out.println(ss); // 사이에 공백이 존재함 (중간에 ,, 사이에 공백도 구분해버려서)
		}

	}

}
