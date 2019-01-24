package java0914_array.prob;

/*
 * [출력결과]
 * 1
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
 */

public class Prob_07 {

	public static void main(String[] args) {
		int[][] data = new int[][] { { 0 }, { 0, 0 }, { 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		//여기에 구현하세요.////////////////////
		for(int row = 0; row < data.length; row++) {
			data[row][row] = 1;
			for(int col = 0; col < data[row].length; col++) {
				data[row][0] = 1;				
			}
		}
			
		for(int row = 2; row < data.length; row++) {
			for(int col = 1; col < data[row].length-1; col++) {
				data[row][col] = data[row-1][col-1] + data[row-1][col];
			}
		}
		
		//////////////////////////////////

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.printf("%4d", data[i][j]);
			}
			System.out.println();
		}
	}// end main()

}// end class
