package java0917_method;

public class Java059_method {

	public static void main(String[] args) {

		int data = 10;
		if (process(data)) {
			System.out.printf("%d는 짝수입니다.\n", data);
		} else {
			System.out.printf("%d는 홀수입니다.\n", data);
		}
	}
	
	public static boolean process(int number) {
		if(number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
