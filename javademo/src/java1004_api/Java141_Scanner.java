package java1004_api;

import java.util.Scanner;

/*
 단입력 : 2
 2 X 1 =  2
 2 X 2 =  4
 2 X 3 =  6
 2 X 4 =  8
 2 X 5 = 10
 2 X 6 = 12
 2 X 7 = 14
 2 X 8 = 16
 2 X 9 = 18
 종료를 원하면 n, 계속하려면 아무키나 누르세요 : n
 프로그램 종료
 */

public class Java141_Scanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("단입력 : ");
			int dan = scan.nextInt();
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d X %d = %2d\n",dan, i, dan * i);
			}
			
			System.out.print("종료를 원하면 n, 계속하려면 아무키나 누르세요 : ");
			String terminal = scan.next();
			if(terminal.equals("n")) { System.out.println("프로그램 종료"); break; }
			// 비교연산자 == 를 쓰게 될 때
			// String st1 = n;
			// String st1 = new String(); 이 두개를 구분하기는 어렵다.
			// 후자의 경우 == 를 쓰면 오류가 나므로 이제 equals()를 사용하자.
		}
		
		scan.close();
	}

}
