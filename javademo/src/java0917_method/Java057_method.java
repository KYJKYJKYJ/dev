package java0917_method;

public class Java057_method {

	/*
	 * 자바에서 제공하는 데이터타입
	 * 기본 : byte, short, int, long, float, double, char, boolean
	 * 참조 : 배열, 클래스, 인터페이스
	 * 
	 * 매개변수 전달방식
	 * 1. call by value : 인자값을 전달할때 기본 데이터 타입을 넘겨주는 형식 (값 전달)
	 * 2. call by reference : 인자값을 전달할때 참조 데이터 타입을 넘겨주는 형식 (주소 전달)
	 */
	public static void main(String[] args) {
		int a = 10, b = 20;
		callByValue(a, b);
		System.out.printf("a=%d, b=%d\n", a, b);
		
		int[] num = new int[] { 100, 200 };
		callByReference(num);
		System.out.printf("num[0]=%d, num[1]=%d\n", num[0], num[1]);

	}
	
	public static void callByValue(int c, int d) {
		int temp = d;
		d = c;
		c = temp;
		System.out.printf("c=%d, d=%d\n", c, d);
	}
	
	public static void callByReference(int arr[]) {
		int temp = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		System.out.printf("arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
		
	}

}
