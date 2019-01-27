package java0913_array;

public class Java044_array {

	public static void main(String[] args) {
		int[] num = new int[] { 8, 22, 3, 12 };
		
		int sum = 0;
		
		int even = 0;
		int odd = 0;
		
		for(int index = 0; index < num.length; index++) {
			sum += num[index];
			
			if(num[index] % 2 == 0) {
				even = even + num[index];
			} else {
				odd = odd + num[index];
			}
			
		}

		System.out.println("even = " + even);
		System.out.println("odd = " + odd);
		System.out.println("sum = " + sum);

	}

}
