package exam;

import java.util.Scanner;

public class JavaTest3_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt();
		
		Calculator cal = new Calculator();
		
		if(!(val >= 2 && val <= 5)) {
			try {
				throw new InvalidException("입력 값에 오류가 있습니다.");
			} catch(InvalidException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println(cal.getSum(val));
		}
	}
}

class Calculator {
	public double getSum(int data) {
		double sum = 0;
		for(int i = 1; i <= data; i++)
			sum += i;
		return sum;
	}
}

class InvalidException extends Exception {
	public InvalidException(String message) {
		super(message);
	}
}