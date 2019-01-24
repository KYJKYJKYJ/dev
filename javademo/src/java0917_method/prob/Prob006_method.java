package java0917_method.prob;

public class Prob006_method {

	public static void main(String[] args) {
		System.out.println("<< 15 까지의 소수 >>");
		primeNumber(15);
		System.out.println("<< 32 까지의 소수 >>");
		primeNumber(32);
	}//end main( )

	private static void primeNumber(int num) {
		// 구현하세요.
		int divcnt = 0;
		for(int i = 2; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(i % j == 0) divcnt += 1;
			}
			
			if(divcnt == 2) System.out.printf("%d ", i);
			divcnt = 0;
			}
		
		System.out.println();
		
	}// end primeNumber( )
}//end class