package java0910_basic;

public class Java009_operator {

	public static void main(String[] args) {
		int i = 5;
		int j = 0;
		int k = 0;
		
		//전위 증감자 : 변수가 호출 되기 전 값을 1 증가 시킨다.
		j = ++i; // i의 값에서 1 증가되고 대입됨
		
		//후위 증감자 : 변수가 호출 되고 난 뒤 값을 1 증가 시킨다.
		//j = i++; // i값 대입 후 i 값 1 증가됨
		
		System.out.println(j);
	}

}
