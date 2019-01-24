package java0913_statement.answ;

/*
 * 1 10=2x+3y의 해를 구하시오.
 *   x와y의 범위 : 0<=x<=10,  0<=y<=10
 *   
 * 2 출력결과
 *  x=2, y=2
 *  x=5, y=0
 */
public class Prob_04 {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {				
				if (2 * i + 3 * j== 10) { 			 
					System.out.printf("x=%d, y=%d\n", i, j);
				}

			}
		}

	}// end main()

}// end class
