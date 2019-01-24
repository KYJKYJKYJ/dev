package java0917_method;

public class Java064_method {

	public static void main(String[] args) {
		char[] data = new char[] { 'a','b','c' };
		System.out.println(data);
		System.out.printf("%s\n", data); // 주소값 [C@1b6d3586
		System.out.println("data:" + data); // 주소값 [C@1b6d3586

		int[] num = new int[] { 1, 2, 3 };
		System.out.println(num); // 주소값 [I@4554617c
		
	}

}
