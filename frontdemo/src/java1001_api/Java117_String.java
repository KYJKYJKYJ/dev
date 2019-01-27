package java1001_api;

// 배열의 크기 : length 키워드
// 문자열의 길이 : length() 메소드

public class Java117_String {

	public static void main(String[] args) {
		String str = new String("KoREa, jsp, java");
		System.out.println("문자열의 길이 : " + str.length());
		System.out.println("대문자 : " + str.toUpperCase()); // 전부 대문자로
		System.out.println("소문자 : " + str.toLowerCase()); // 전부 소문자로
		System.out.println("문자 : " + str.charAt(1));
		System.out.println("인덱스 : " + str.indexOf("a")); // 문자열이 속한 인덱스 출력
		System.out.println("인덱스 : " + str.indexOf(97)); // 유니코드값으로 a == 97
		
		// 5인덱스부터 마지막까지 문자열 리턴
		// ,jsp,java
		System.out.println("범위 : " + str.substring(5));
		System.out.println("범위 : " + str.substring(2, 8)); //2부터 8 미만까지의 인덱스에 해당하는 문자열 리턴
		
		String[] arr = str.split(", ");
		for(String data : arr) //for-each문
			System.out.println(data);
		//구분자를 입력하면 입력내용을 구분해줌
		
		int x = 10;
		int y = 20;
		String s1 = String.valueOf(x); // valueof는 static으로 선언되어 있음, String 클래스에서 오버라이딩됨
									   // 값을 String으로 가져옴
		String s2 = String.valueOf(y);
		System.out.printf("%s + %s = %s\n", s1, s2, s1+s2);
		
		char[] dn = {'1', '2', '3'};
		//char[] -> String
		String s3 = String.valueOf(dn); // 문자배열의 값들을 전부 끌어옴
		System.out.printf("%s" , s3);
	}

}
