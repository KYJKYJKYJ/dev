package java0912_statement;

public class Java030_for {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		
		for(i = 1 ;  ; i++) {
			sum += i;
			
			System.out.printf("i = %d sum = %d\n", i, sum);
			
			if (sum >= 15) {
				break;
			}
		}

	}

}
