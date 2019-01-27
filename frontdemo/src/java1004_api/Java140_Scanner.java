package java1004_api;

import java.util.Scanner;

public class Java140_Scanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//System.out.print("부서:");
		String dept = scan.next(); //next는 문자열을 읽음
		//String dept = scan.nextLine(); //nextLine은 줄 전체를 읽음
		
		//System.out.print("연봉:");
		int salary = scan.nextInt();
		
		//System.out.print("평균:");
		double avg = scan.nextDouble();

		System.out.printf("%s %d %.1f\n", dept, salary, avg);
		scan.close();
	}

}
