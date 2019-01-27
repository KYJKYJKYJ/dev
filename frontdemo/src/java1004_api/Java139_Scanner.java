package java1004_api;

import java.util.Scanner;

public class Java139_Scanner {

	public static void main(String[] args) {
		//System.in : 입력 콘솔창하고 연결
		
		//목적지로 부터 데이터 값을 불러옴 Scanner
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.println(name);
		System.out.println("Program End");
		
		scan.close();
		// 연결종료
	}

}