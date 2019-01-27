package java0911_basic;

public class Java016_print {

	public static void main(String[] args) {
		System.out.println("java");
		System.out.println("jsp");
		
		System.out.print("spring\n");
		System.out.print("oracle\n");

		//printf 관련 출력기호
		/*
		
		%d : 정수
		%f : 실수
		%s : 문자열
		%c : 문자
		%b : 논리
		%% : %
		\ : 특수문자 처리 기호
		
		*/
		
		System.out.printf("%s\n", "mybatis");
		System.out.printf("%d\n", 50L); // byte, short, int, long
		System.out.printf("%f\n", 4.5F); // float, double
		System.out.printf("%c %b %d\n", 'a', true, 100);
		
		// 정수1.정수2f => 정수1 만큼의 자리수 확보 ( 소수점 포함 ) , 정수2 만큼 소수점 자리 출력 ( 반올림 ) 
		System.out.printf("%.1f\n", 4.56); // 소수점 첫째 자리까지 출력한다 (반올림)
		System.out.printf("%5.1f\n", 4.56); // 5자리 확보하고 소수점 첫째 자리까지 출력한다
		System.out.printf("%5.1f\n", 124.56);
		System.out.printf("%5.1f\n", 1231244.56); // 5. 이라도 5자리가 넘어가면 그냥 무시함
		
		System.out.printf("%5.2f\n", 4.5);
		System.out.printf("%5.2f\n", 24.567);
		System.out.printf("%5.2f\n", 123.5); // 5. 이래도 무시되고 .2라서 소수점 자리를 출력함
		
		System.out.printf("%10s\n", "korea"); // 10자리 확보하고 오른쪽 정렬 [     korea]
		System.out.printf("%-10s\n", "korea"); // 10자리 확보하고 왼쪽 정렬  [korea     ]
		
		// 내 나이는 10살 입니다.
		int age = 10;
		System.out.printf("내 나이는 %d살 입니다.\n", age);
		
		double score = 95;
		char grade = 'A';
		String name = "김영재";
		System.out.printf("%s님의 평균은 %.1f 이므로 %c학점 입니다.\n", name, score, grade);
		
		int num1 = 3;
		int num2 = 2;
		int result = num1 + num2;
		System.out.printf("%d + %d = %d\n", num1, num2, result);
		
		int result2 = num1 % num2;
		System.out.printf("%d %% %d = %d\n", num1, num2, result2);
		
		String color = "파랑";
		System.out.printf("당신의 색깔은 \"%s\"입니다\n", color);
	}

}
