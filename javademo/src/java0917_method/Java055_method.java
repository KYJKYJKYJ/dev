package java0917_method;

public class Java055_method {

	public static int process(int x, int y, int z) { //4
		return x + y + z; //5
	} //6
	
	public static int plus(int[] arr) { //9
		int sum = 0; //10
		for(int i = 0; i < arr.length; i++) { //11
			sum = sum + arr[i]; // 12
		}
		return sum; //13
	} //14
	
	public static void main(String[] args) { //1
		int a = 4, b = 2, c = 5; //2
		System.out.println(process(a,b,c)); //3
		
		int[] num = new int[] { 100, 200, 300 }; //7 //참조데이터는 주소복사 [값을 바꿀 때 유의]
		int[] data = new int[] { 1, 5, 8, 9 };
		System.out.println(plus(num)); //8
		System.out.println(plus(data));

	} // 15

}
