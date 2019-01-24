package java0913_statement;

public class Java035_for {

	public static void main(String[] args) {
		/*
		 * 3행 * 4열
		 * 1 2 3 4
		 * 5 6 7 8
		 * 9 10 11 12
		 */

		/*for(int i = 1 ; i <= 12 ; i++) {
			
			System.out.printf("%-2d ", i);
			
			if(i % 4 == 0) {
				System.out.println();
			}
		}*/
		
		int k = 1;
		for(int i = 0; i < 3 ; i++) { //행 (바깥)
			for(int j = 1; j <= 4; j++) { //열 (안)
				System.out.printf("%4d", k);
				k++;
			}			
			System.out.println();
		}
		
	}

}
