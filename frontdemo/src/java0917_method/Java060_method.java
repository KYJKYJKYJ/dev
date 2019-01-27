package java0917_method;

public class Java060_method {

	public static int length(char[] data) {
		return data.length;
	}
	
	public static char charAt(char[] data, int index) {
		return data[index];
	}
	
	public static void main(String[] args) {
		char[] data = new char[] {'j', 'A', 'v', 'a' };
		System.out.println("문자열의 길이 : " + length(data));
		System.out.println("2인덱스의 요소값 가져오기 : " + charAt(data, 2));
		}	
}
