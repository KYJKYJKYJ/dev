package java0912_statement;

public class Java022_if {

	public static void main(String[] args) { // 리턴타입이 void
		
		//키워드(예약어) : 프로그램에서 의미를 부여하여 정의해 놓은 단어
		//return : 현재 수행중인 메소드(main)을 완전히 빠져나올 때 사용하는 키워드
		
		char check = 'n';
		
		if(check == 'n') {
			System.out.println("main 종료");
			return;
		}
		
		System.out.println(check);
		System.out.println("program end");
	
	
		return; // 리턴타입이 void라서 리턴 값이 없어도 됨
	}

	public static int process() { // 리턴타입이 int
	
		return 0; // 리턴타입이 int라서 int값이 리턴되어야 함
	}
}
