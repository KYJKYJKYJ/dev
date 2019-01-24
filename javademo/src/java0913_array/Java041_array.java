package java0913_array;


public class Java041_array {

	public static void main(String[] args) {
		int ko = 90;
		int eng = 80;
		int jp = 40;

		int[] jumsu;

		// 참조 타입에 메모리 (힙) 확보할 때 new
		jumsu = new int[3];

		// JVM 구조
		// [스택] [힙]
		
		System.out.printf("기본 타입 값 : %d %d %d\n", ko, eng, jp);
		// 스택 : 기본 데이터 타입 (4 byte) ko, eng, jp, 참조형 데이터 타입 (4 byte) jumsu
		
		System.out.printf("참조형 타입이 갖는 주소에 저장된 값 : %d %d %d\n", jumsu[0], jumsu[1], jumsu[2]);
		// jumsu는 [new 키워드] 를 통해 힙 메모리에 3개의 공간을 확보함, 스택에 jumsu는 힙 주소값을 갖고 있음
		// 힙 -> ㅁ ㅁ ㅁ -> 하나하나는 element(요소) (여기에 각각 값이 저장됨)
		// [0][1][2]
		
		jumsu[0] = 90;
		jumsu[1] = 80;
		jumsu[2] = 40;
		System.out.printf("참조형 타입이 갖는 주소에 저장된 값 : %d %d %d\n", jumsu[0], jumsu[1], jumsu[2]);
		System.out.println("참조형 타입이 갖는 주소값 : " + jumsu);
		
		System.out.println("========================================================");
		
		for(int index = 0; index < jumsu.length /* 배열의 크기를 리턴하는 length */; index++) {
			System.out.println(jumsu[index]);
			
		}

	}

}
