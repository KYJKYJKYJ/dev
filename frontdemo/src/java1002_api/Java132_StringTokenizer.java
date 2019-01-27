package java1002_api;

import java.util.StringTokenizer;

public class Java132_StringTokenizer {

	public static void main(String[] args) {
		StringTokenizer st =
				new StringTokenizer("java,jsp", ","); // 구분자에 의해서 나눠지는 것을 Token 이라 함
		
		/*System.out.println(st.nextToken()); // Token : java, 토큰을 가져오게 되면 메모리를 아예 가져옴 그래서 없어짐
		System.out.println(st.nextToken());*/ // Token : jsp
		//System.out.println(st.nextToken()); 한번 더 하면 오류발생 예외처리 필요
		
		/*int cnt = st.countTokens();
		// 만약 그대로 그냥 for문의 조건문에 countToken()을 사용하면 한번 꺼내오면 토큰카운트가 1로 줄어서.. 하나만 출력됨..
		for(int i = 0; i < cnt; i++) {
			System.out.println(st.nextToken());
		}
		 */
		
		while(st.hasMoreTokens()) { // 토큰 사용시 for보다 while을 쓰는게 편하다. hasMoreTokens() **
		// 메모리에 저장된 토큰이 있으면 true 없으면 false를 리턴한다.
			System.out.println(st.nextToken());
		}
	}

}
