package java1004_api.prob;

import java.util.Random;

public class UserPrime {
	public UserPrime() { }
	
	public int[] makeArray() {
		int[] arr = new int[10];
		Random ran = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(19) + 2; // 0~18
		}
		
		return arr;
	}
	
	public void primeNumber(int[] array) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 2; j < array[i]; j++) {
				if(array[i] % j == 0) {
					count++;
				}
			}
			
			if(count == 0) {
				System.out.print(array[i] + " ");
				count = 0;
			}
		}
	
	}

}
