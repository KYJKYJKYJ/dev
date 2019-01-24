package java1004_api;

import java.util.Random;

// num 배열에 1부터 10까지의 값을 중복없이 저장하는 프로그램 구현

public class Java138_Random {

	public static void main(String[] args) {
		int[] num = new int[5];
		Random ran = new Random();
	
		for(int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(10) + 1;
			
			for(int j = 0; j < i; j++) {
				if(num[i] == num[j]) {
					i--;
					break;
				}
			}
			
		}
		
		for(int data : num) {
			System.out.println(data);
		}
			
	}
}


