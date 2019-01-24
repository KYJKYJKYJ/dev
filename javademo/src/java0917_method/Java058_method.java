package java0917_method;

public class Java058_method {

	// e의 대문자는 E입니다.
	// 대문자와 소문자의 차이는 32
	
	public static char process(char data) {
		return (char)(data-32);
	}
	
	public static void main(String[] args) {
		char data = 'a';
		char code = process(data);
		
		System.out.printf("%c의 대문자는 %c입니다.\n", data, code);

	}

}
