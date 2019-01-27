package java0912_statement;

public class Java021_if {

	public static void main(String[] args) {
		
		// 변수에 저장된 문자가 대문자인지 소문자인지 판별하기
		
		char data = 'd';
		
		if(data >= 'A' && data <= 'Z') {
			System.out.printf("%c는 대문자 입니다.\n", data);
		} else if (data >= 'a' && data <= 'z') {
			System.out.printf("%c는 소문자 입니다.\n", data);
		} else {
			System.out.printf("%c는 기타입니다.\n", data);
		}

		System.out.printf("\n%d %d %d %d\n", (int)'A', (int)'Z', (int)'a', (int)'z');
		
	}

}
