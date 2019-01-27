package java0914_array;

public class Java050_array {

	public static void main(String[] args) {
		/*
		 * 1 2 3 4 5
		 * 6 7 8 9 10
		 * 11 12 13 14 15
		 * 16 17 18 19 20
		 * 
		 * 출력결과
		 * 1 2 * 4 5
		 * * 7 8 * 9
		 * 11 * 13 14 *
		 * 16 17 * 19 20
		 */
		
		int cnt = 1;
		int[][] num = new int[4][5];
		for(int row = 0; row < num.length; row++) {
			for(int col = 0; col < num[row].length; col++) {
				num[row][col] = cnt++;
				
				if(num[row][col] % 3 == 0) {
					System.out.printf("%-4c", '*');
				} else {
					System.out.printf("%-4d", num[row][col]);
				}
				
			}
			System.out.println();
		}
	}

}
