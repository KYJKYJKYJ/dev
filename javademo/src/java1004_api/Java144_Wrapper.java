package java1004_api;

public class Java144_Wrapper {

	public static void main(String[] args) {
		char data = 'a';
		if(data >= 'A' && data <= 'Z')
			System.out.println("대문자");
		else
			System.out.println("소문자");
		
		System.out.println(Character.isUpperCase(data)); // 대문자 인지 물음
		System.out.println(Character.isLowerCase(data)); // 소문자 인지 물음
		System.out.println(Character.isDigit(data)); // 숫자 검색해서 있으면 T 없으면 F
		System.out.println(Character.isAlphabetic(data)); // 알파벳 검색해서 있으면 T 없으면 F
		System.out.println(Character.toUpperCase(data)); // 대문자로
		System.out.println(Character.toLowerCase(data)); // 소문자로

	}

}
