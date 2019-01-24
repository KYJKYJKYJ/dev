package java0917_method;

public class Java056_method {

	
	
	public static void main(String[] args) {
		int a = 10; int b = 20;
		int c = a; int d = b; // 값 복사 (call by value)
		
		System.out.printf("a=%d, b=%d\n", a, b);
		System.out.printf("c=%d, d=%d\n", c, d);
		
		System.out.println("===swap 기본데이터타입=======");
		int temp = c;
		c = d;
		d = temp;
		
		System.out.printf("a=%d, b=%d\n", a, b);
		System.out.printf("c=%d, d=%d\n", c, d);
		
		System.out.println("//////////////////////////////");
		
		int[] num = new int[] {10, 20};
		int[] arr = num; // 주소 복사 (call by reference)
		
		System.out.printf("num[0]=%d num[1]=%d\n", num[0], num[1]);
		System.out.printf("arr[0]=%d arr[1]=%d\n", arr[0], arr[1]);
		
		int imsi = arr[0];
		arr[0] = arr[1];
		arr[1] = imsi;
		
		System.out.println("===swap 참조데이터타입=======");
		System.out.printf("num[0]=%d num[1]=%d\n", num[0], num[1]);
		System.out.printf("arr[0]=%d arr[1]=%d\n", arr[0], arr[1]);

	}

}
