package java0913_statement;

public class Java034_for {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {			
			/*
			 if(i % 3 != 0) {
				System.out.println(i);
				}
			*/
			
			if (i % 3 == 0) {
				continue; // 반복문에서 실행시 조건식으로, for문에서 실행시 증감식으로 이동
			}
			
			System.out.println(i);
		}

	}

}
