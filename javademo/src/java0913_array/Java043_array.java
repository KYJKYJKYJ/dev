package java0913_array;

public class Java043_array {

	public static void main(String[] args) {
		int[] num = new int[] { 8, 22, 3, 12 };
		
		int sum = 0;
		
		for(int index = 0; index < num.length; index++) {
			sum += num[index];
		}

		System.out.println("sum = " + sum);
		
	}

}
