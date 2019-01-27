package java1008_exception;

public class Java154_exception {

	public static void main(String[] args) {
		String data1 = "10";
		String data2 = "0";
		
		try {
			int x = Integer.parseInt(data1);
			int y = Integer.parseInt(data2);
			int res = x / y;
			System.out.println(res);
		} catch(NumberFormatException exc) {
			System.out.println(exc.toString());
			System.out.println("숫자를 입력하셔야 합니다");
		} catch(ArithmeticException exc) {
			System.out.println(exc.toString());
			System.out.println("0으로 나눌 수 없습니다");
		} catch(RuntimeException exc) {
			System.out.println(exc.toString());
		} catch(Exception exc) { // 밑으로 갈수록 범위가 큼 (만약 맨 위로 가게 되면 중복되서 오류 발생!)
			System.out.println(exc.toString());
		}
		
		System.out.println("프로그램 종료");
	}

}
