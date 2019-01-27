package java0913_statement;

public class Java040_do_while {

	public static void main(String[] args) {
		/*
		 * do {
		 *  수행하는 문장
		 *  } while(조건식);
		 *  
		 *  적어도 한번은 수행하는 문장을 실행함
		 */

		char chk = 'y';
		
		do {
			System.out.println("주문하시겠습니까? (Y / N)");
		} while(chk == 'n');
		
		
	}

}
