package java0917_method;

public class Java061_method {

	public static void process(int num) {
		// data 변수의 값이 0보다  크면 양수, 0이면 0, 0보다 작으면 음수로 출력
		if(num > 0 ) {
			System.out.println(num + "은 양수입니다.");
		} else if (num == 0) {
			System.out.println(num + "은 0입니다.");
		} else {
			System.out.println(num + "은 음수입니다.");
		}
	}
	
	public static void main(String[] args) {
		process(20);
		process(0);
		process(-20);
	}

}
