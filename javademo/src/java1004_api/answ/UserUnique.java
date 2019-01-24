package java1004_api.answ;

import java.util.Random;

public class UserUnique {
	public UserUnique() {

	}

	public int[] makeArray() {
		// 난수값를 발생시킨후 반환하는 프로그램을 구현하시오.
		int[] arr = new int[10];
		Random ran = new Random();

		for (int i = 0; i < arr.length; i++)
			arr[i] = ran.nextInt(20) + 1;

		return arr;
	}// end makeArray()

	public void printUniqueNumber(int[] array) {
		// array배열에서 중복되지 않은 유일한 숫자만을 출력하는 프로그램을 구현하시오.
		boolean chk = false;
		for (int i = 0; i < array.length; i++) {
			chk = false;
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					chk = true;
					break;
				}
			} // end for j

			if (chk == false)
				System.out.printf("%5d", array[i]);
		} // end for i

	}// end printUniqueNumber()

}// end class
