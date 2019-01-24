package java0911_statement;

public class Java017_if {

	public static void main(String[] args) {
		// [ 제어문 ]
		// 조건문 : if - else, switch - case
		// 반복문 : for, while, do - while
		// 기타 : break, continue, (label)

		int num = 3;

		if (num % 2 == 0) {
			System.out.printf("%d는 %s 입니다\n", num, "짝수");
		}

		else {
			System.out.printf("%d는 %s 입니다\n", num, "홀수");
		}

	}

}
