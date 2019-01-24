package java1008_exception;

public class Java157_exception {

	public static void main(String[] args) {
		int num = 5;
		process(num);
		System.out.println("korea");
	} //end main()

	public static void process(int data) {
		try {
			if(data < 10) {
				throw new ArithmeticException("10 이상만 응답");
				//DB에서 연결확인 할 때 throw 사용하면 좋음
			}
		} catch (ArithmeticException exc) {
			System.out.println(exc.toString());
		}
	} //end process()
	
} //end class
