package java1008_exception;

public class Java158_exception {

	public static void main(String[] args) {
		String data = "991023";
		process(data);

	}//end main()
	
	public static void process(String data) {
		char chk;
		for(int i=0; i<data.length(); i++) {
			chk=data.charAt(i);
			if(!Character.isDigit(chk)) {
				try {
					throw new UserException("숫자만 입력하세요");
				} catch (UserException e) {
					System.out.println(e.toString());
					return; // 있다면 finally 수행하고 빠져나가게함
				}
			}
		}
		System.out.println(data);
	}//end process()

	//스트림?
	//대상(콘솔창..etc)에 연결해서 내용을 읽거나 쓰려면 write라는 클래스, read 클래스 필요하다. 이것들이 스트림 클래스라고 한다.
	//이런 입출력 스트림은 java.io에서 제공
}
