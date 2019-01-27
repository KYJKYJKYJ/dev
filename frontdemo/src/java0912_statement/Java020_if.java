package java0912_statement;

public class Java020_if {
	
	//다중 if-else
	/*
	 * if (조건1) {
	 * 	수행할 문장 1
	 * } else if (조건2) {
	 * 		수행할 문장 2
	 * } else if (조건3) {
	 * 		수행할 문장3
	 * } else {
	 * 		수행할 문장;
	 * }
	 */
	
	public static void main(String[] args) {
		char code = 'B';
		
		if (code == 'A') {
			System.out.println("식품류");
		} else if (code == 'B') {
			System.out.println("육류");
		} else if (code == 'c') {
			System.out.println("야채류");
		} else {
			System.out.println("기타");
		}
		
		System.out.println("코드별 제품 종류 체크");

	}

}
