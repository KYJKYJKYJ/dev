package java0914_array.prob;
/*
 * 4행 4열 data배열에 가로 세로 합계를 구하는 프로그램을 구현하시오.
 * [출력결과]
 *  1   2   3   6 0/3
 *  4   5   6  15 1/3
 *  7   8   9  24 2/3
 * 12  15  18  45 3/3
 *///3/1 3/2 3/3 3/3

public class Prob_02 {

	public static void main(String[] args) {
		int[][] data = new int[4][4];
		int cnt = 1;
		
		// 여기를 구현하시오.
		
		for(int row = 0; row < data.length-1; row++) {
			for(int col = 0; col < data[row].length-1; col++) {
				data[row][col] = cnt++;				
			}
		}
		
		// 따로 for문 쓰는것임;;
		for(int i = 0; i < data.length-1; i++) {
			for(int j = 0; j < data[i].length-1; j++) {
			 data[i][3] += data[i][j];
			 data[3][j] += data[i][j];
			}
			data[3][3] += data[i][3];
		}
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {				
				System.out.printf("%-4d", data[row][col]);
			}
			System.out.println();
		 }
		
	}// end main()

}// end class


