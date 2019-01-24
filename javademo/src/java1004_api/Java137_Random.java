package java1004_api;

import java.util.Random;

public class Java137_Random {

	public static void main(String[] args) {
		Random ran = new Random();
		
		double r1 = ran.nextDouble();
		System.out.println(r1);
		
		int r2 = ran.nextInt(); // 4byte에 해당하는 값을 그냥 정수로 바꿈 (음수고 양수고 다 나옴)
		System.out.println(r2);
		
		// 0부터 10 미만
		int r3 = ran.nextInt(10); // 범위를 지정함
		System.out.println(r3);
		
		// 1부터 ~ 10 까지
		System.out.println(r3+1);

	}

}
