package java0913_statement;

public class Java037_for {

	public static void main(String[] args) {
		//라벨 (자신이 아닌 상위의 반복문을 빠져나올 때 사용함)
		/*move :
		for (;;) {
			for (;;) {
				for (;;) {
					break; //break move; // move 라벨의 반복문을 빠져나옴
				}
				break;
			}
			break;
		}
		 */
		
		move :
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				System.out.printf("j = %d\n", i);
				continue move ; // break move; 하면 한번만 출력됨, 바깥쪽 반복문 탈출
			} // continue 시 한번만 수행 후 빠져나옴
		}
	}

}
