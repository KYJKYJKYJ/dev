package java1004_api;

import static java.lang.Math.*; // 직접적으로 사용하기 위해 바로 static 붙여서 호출

public class Java135_Math {

	public static void main(String[] args) {
		double ran = random(); // 0.0에서 1.0 까지의 난수값
		System.out.println(ran);
		
		//0.0 ~ 10.0 미만 사이의 난수 발생
		ran *= 10;
		System.out.println(ran);

		//소수는 버리고 0 ~ 10만 리턴
		int num = (int) floor(ran); // floor 메소드는 double 형태에 소수점에서 반올림 값을 가져옴 (그래도 형태는 double)
		System.out.println(num);
		
		System.out.println((int)(-7.8)); // 그냥 형변환으로 소수점이 탈락
		System.out.println(floor(-7.8)); // -7.8보다 작은 -8이 출력 (반올림)
		System.out.println(round(7.8)); // 반올림한 정수값을 가져옴 (int형)
	}

}
