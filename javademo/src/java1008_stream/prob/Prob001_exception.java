package java1008_stream.prob;

import java.util.Scanner;
/*
 * [문제]
 * 콘솔창으로 부터 아이디와 비밀번호를 입력받아  [실행결과]을 참조하여
 * 프로그램을 구현하시오.
 * 
 * [실행결과]
 * ex1)
 * 아이디입력: blue
 * 비밀번호입력: 12345
 * 로그인 완료
 * 
 * ex2)
 * 아이디입력: blue
 * 비밀번호입력: 5232
 * 패스워드가 틀립니다.
 * 
 * ex3)
 * 아이디입력: red
 * 비밀번호입력: 12345
 * 아이디가 존재하지 않습니다. 
 */

public class Prob001_exception {
	public static void main(String[] args) {
		//콘솔창으로 부터 아이디 비밀번호 입력받아 처리하는 프로그램 구현
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String password = sc.next();
		
		login(id, password);
		
	}//end main()
	
	public static void login(String id, String password) {
		//id가 blue가 아니라면 NotExistIDException 발생시킴
		if(!id.equals("blue")) {
			try {
				throw new NotExistIDException("아이디가 존재하지 않습니다");
			} catch (NotExistIDException nei) {
				System.out.println(nei.getMessage());
			}
		}
		
		//password가 12345가 아니라면 WrongPasswordException 발생시킴
		if(!password.equals("12345")) {
			try {
				throw new WrongPasswordException("패스워드가 틀립니다");
			} catch (WrongPasswordException wpe) {
				System.out.println(wpe.getMessage());
			}
		}
		
		if(id.equals("blue") && password.equals("12345")) {
			System.out.println("로그인 완료");
		}
	}
}
