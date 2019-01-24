package java0911_statement;

public class Java018_if {

	public static void main(String[] args) {
		//int num = 10;
		int num = -5;
		
		if (num > 0) {
			System.out.printf("%d는 자연수 입니다\n", num);
		}
		
		System.out.println("Program end");
		System.out.println("==========================================");
		
		int data = 9;
		
		if (data % 3 == 0) {
			System.out.printf("%d는 3의 배수이다\n", data);
		}

		else {
			System.out.printf("%d는 3의 배수가 아니다\n", data);
		}
	}

}
