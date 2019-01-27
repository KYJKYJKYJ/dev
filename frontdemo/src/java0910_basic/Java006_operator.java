package java0910_basic;

public class Java006_operator {
	public static void main(String[] args) {
		int numa = 10;
		int numb = 3;
		
		System.out.println(numa / numb); // 몫값 계산 
		System.out.println(numa % numb); // 나머지값 계산
		//int로 계산됨
		
		System.out.println((double)numa / numb); // 몫값 계산
		System.out.println((double)numa % numb); // 나머지값 계산
	}

}
