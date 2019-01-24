package java0920_class;

public class Java081_for {

	public static void main(String[] args) {
		int[] num = { 10, 20, 30, 40 ,50 };
		
		for(int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		
		System.out.println("===========================================");
		
		/*
		 * 개선된 루프 = 확장된 루프 = 개선된 for문
		 * for(데이터타입 변수 : 배열 or 컬렉션) {
		 * 	수행할 문장;
		 * }
		 */
		
		for(int data : num) { // 처음부터 차례대로 돌면서 배열 안의 요소를 저장함
			System.out.println(data);
		}

	}

}
