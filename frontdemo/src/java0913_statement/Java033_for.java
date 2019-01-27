package java0913_statement;

public class Java033_for {

	public static void main(String[] args) {
		/*
		int sum = 0;
		int i = 1;
		
		//종료할 시점을 모를때는 for(초기식 ; ; 증감식) 무한루프 사용
		for(i = 1; i <= 10; i++) {
			sum += i;
			System.out.println(sum);
		*/
		
		
		// 짝수, 홀수 합 가려내기
		int oddnum = 0;
		int evennum = 0;
		
		int i;
		
		for(i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				evennum += i;
			} else {
				oddnum += i;
			}
		}
		
		System.out.println("짝수 합 : " + evennum);
		System.out.println("홀수 합 : " + oddnum);
	}

}