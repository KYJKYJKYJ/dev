package java1004_api.answ;

import java.util.Random;

public class UserPrime {
	public UserPrime() {

	}

	public int[] makeArray() {
		// 난수값를 발생시킨후 반환하는 프로그램을 구현하시오.
		int[] arr = new int[10];
		Random ran = new Random();

		for (int i = 0; i < arr.length; i++)
			arr[i] = ran.nextInt(19) + 2;

		return arr;
	}// end makeArray()

	public  void primeNumber(int[] array) {
		// array배열에서 소수만 출력하는 프로그램을 구현하시오.
		int count = 0;
		for (int j = 0; j < array.length; j++) {

			for (int i = 2; i < array[j]; i++) {
				if (array[j] % i == 0)
					count++;
			}

			if (count == 0)
				System.out.printf("%4d", array[j]);
			count = 0;
		}

	}// end primeNumber()

}// end class
