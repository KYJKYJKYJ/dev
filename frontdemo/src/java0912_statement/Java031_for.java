package java0912_statement;

public class Java031_for {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		
		for(i = 1 ;  ; i++) {
			sum += i;
			System.out.printf("i = %d\n", i);
			if (sum >= 15) {
				break;
			}
		}
		
		System.out.printf("sum = %d\n", sum);
		
	}

}
