package java1004_api;

import java.util.Scanner;

/*
 * 이름, 학점을 입력하는 프로그램을 구현하세요.
 * 입력 : 홍길동,80,93
 * 
 * [출력결과]
 * 이름 : 홍길동
 * 국어 : 80
 * 영어 : 93
 * 평균 : 86.5 (double로 계산)
 */

public class Java146_Wrapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String[] line = sc.nextLine().split(",");
		String name = String.valueOf(line[0]);
		int kor = Integer.parseInt(line[1]);
		int eng = Integer.parseInt(line[2]);
		double avg = (kor + eng) / 2.0;
		
		
		//double avg = (double)(kor + eng) / 2.0;
		
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("평균 : " + avg);
		
		
		
	}

}
