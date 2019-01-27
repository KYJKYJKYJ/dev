package java1008_exception;

public class Java156_exception {

	public static void main(String[] args) {
		String data1 = "test";
		String data2 = "0";
		
		try {
			int x = Integer.parseInt(data1);
			int y = Integer.parseInt(data2);
		
			process(x,y); // 호출하는 영역에서 예외처리를 함
		} catch (NumberFormatException exc) {
			System.out.println(exc.toString());
		} catch (ArithmeticException exc) {
			System.out.println(exc.toString());
		}
		
	}// end main()
	
	public static void process(int x, int y) throws ArithmeticException { //호출하는 곳에서 처리하겠다고 미루는 건데 미리 알려주는 역할
			int res = x / y;
			System.out.println(res);
	} // end process()
}
