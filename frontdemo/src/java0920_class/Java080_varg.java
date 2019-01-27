package java0920_class;

/*
 * Variable Argument (가변 매개변수)
 * 1. 5.0 이하 버저에서는 메소드 정의시 인자의 타입과 수를 정해놓고 일치하지 않으면 오류가 발생
 * 2. 이를 유연하게 처리할 수 있도록 Variable Argument 기능 제공함
 * 
 * [ 형태 ]
 * 리턴 타입 메소드명 (데이터타입...매개변수) { }
 */

class CountVarg {
	void addValue(int... arr /*double...data [X]*/) { // ... 로 선언하면 배열 크기를 유연하게 생성함 (가변 매개변수)
													  // 하나만 선언 가능함
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		System.out.println(sum);
	}

	// 가변 매개변수와 고정 매개변수가 같이 사용될 때는 고정 매개변수가 먼저 선언되야함
	void sumValue(String name, int...arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.printf("name = %s, sum = %d\n", name, sum);
	}
}

public class Java080_varg {

	public static void main(String[] args) {
		CountVarg cv = new CountVarg();
		cv.addValue(4, 8);
		cv.addValue(1, 2, 3);
		cv.addValue(1, 4, 6, 7, 8, 9, 3, 4, 6, 3);
		
		CountVarg cv2 = new CountVarg();
		cv2.sumValue("홍길동", 1, 2, 3);
	}

}
