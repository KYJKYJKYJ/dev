package java0913_statement;

public class Java036_for {

	public static void main(String[] args) {
		/*(1,1)
		 *  1   2   3   4   5
		 *  1   2   3   4   5
		 *  1   2   3   4   5
		 *  1   2   3   4   5
		                (5,5)
		 */
		
		for(int i = 1; i <= 400; i++) {
			for (int j = 1; j <= 50; j++) {
				System.out.printf("%4d", j);
			}
			System.out.println();
		}
		
	}

}
