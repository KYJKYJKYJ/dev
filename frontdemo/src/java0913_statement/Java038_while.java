package java0913_statement;

public class Java038_while {

	public static void main(String[] args) {
		/*
		 for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		 }
		 */
		
		/*
		 while은 조건식 생략 불가
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
		*/
		
		int i = 0;
		while(i++ <= 5) {
			System.out.println(i);
		}
	}

}
