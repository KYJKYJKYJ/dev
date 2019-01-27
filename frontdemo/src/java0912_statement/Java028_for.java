package java0912_statement;

public class Java028_for {
	public static void main(String[] args) {
		
		/*
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		*/
		
		//for(초기식[복수갯수 가능]; 조건식 ; 증감식[복수갯수 가능])
		//ex) for(int i, sum = 0; i<= 10; i++, sum+=i )
		
		//조건식이 생략되면 무한루프
		
		for(int i = 1, sum = 0; i <= 5; i++, sum+=i) {
			System.out.printf("%2d, %2d\n", i, sum);
		}
	}
}
