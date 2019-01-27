package java0911_statement;

public class Java019_if {
	public static void main(String[] args) {
		//다중 if문
		/*
		 * if(조건1) {
		 *  	if(조건2) {
		 *  		
		 *   	} else {
		 *   		[조건 2의 else]
		 *   	}
		 *  } else { [조건 1의  else]
		 *  	if(조건3) {
		 *  	
		 *  	} else {
		 *  		[조건 3의 else]
		 *  	}
		 *  }
		 *  
		 *  조건 : "논리값"
		 */
		
		//회원을 구별하는 프로그램
		boolean member = true; // 회원 or 비회원
		String grade = "일반"; // 회원등급
		
		// 회원이고 vip 고객이면 30% 적립, 회원이고 vip 아닐때는 10% 적립
		
		if (member) {
			if(grade == "vip") {
				System.out.println("30% 적립"); // 회원이면서 vip 고객
			} else {
				System.out.println("10% 적립"); // 회원이면서 일반고객
			}
		} else {
			 System.out.println("비회원"); // 비회원
		}
		
		System.out.println("감사합니다 고객님");
		
	}
}
