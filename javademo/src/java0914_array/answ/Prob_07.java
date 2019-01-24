package java0914_array.answ;
/*
   [출력결과]
   1
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
 */
public class Prob_07 {

	public static void main(String[] args) {
		int[][] data = new int[][] { { 0 }, { 0, 0 }, { 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		
		//여기에 구현하세요.////////////////////
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (j == 0 || j == i)
					data[i][j] = 1;
				else
					data[i][j] = data[i - 1][j - 1] + data[i - 1][j];
			}
			System.out.println();
		}
		/////////////////////////////////////
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.printf("%4d", data[i][j]);
			}
			System.out.println();
		}
	}// end main()

}// end class
