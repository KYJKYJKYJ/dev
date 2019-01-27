package java1004_api.prob;

import static java.lang.Math.*;

class UserUnique {
	public UserUnique() {
		
	}
	
	public int[] makeArray() {
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(random() * 10);
		}		
		return arr;
	}
	
	public void printUniqueNumber(int[] array) {
		boolean chk;
		for (int i = 0; i < array.length; i++) {
			chk = false;
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					chk = true;
					break;
				}
			}
			if (chk == false)
				System.out.printf("%d ", array[i]);
		}
		
	}
}