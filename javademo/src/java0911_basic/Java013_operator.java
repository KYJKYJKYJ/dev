package java0911_basic;

public class Java013_operator {

	public static void main(String[] args) {
		// 삼항 연산자 (조건 연산자) 리턴하는 값이 여러개 일때 사용됨
		// 조건식 ? (참 : 거짓) [ 여기서 참, 거짓의 자료형은  조건식과 같아야 한다 ]
		// ex) int res = true ? 1 : 0
		
		// 복수 수행 가능
		// (조건식1) ? 참 : (조건식2) ? 참 : 거짓
		
		int total = 21;
		int record = 5;
		
		int res = (total % record) == 1 ? 100 : 0; 
		
		System.out.println(res);
	}

}
