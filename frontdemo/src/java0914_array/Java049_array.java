package java0914_array;

public class Java049_array {

	public static void main(String[] args) {
		/*
		 * [데이터]
		 * 홍길동 90 85 40
		 * 갑동이 100 35 75
		 * 
		 * [출력결과]
		 * 홍길동 90 85 40 215 71.7
		 * 갑동이 100 35 75 210 70.0
		 */

		String[] name = new String[] { "홍길동", "갑동이" };
		int[][] score = new int[][] { {90, 85, 40},
										{100, 35, 75} };
	
		int sum = 0; double avg = 0;
		
		for(int row = 0; row < score.length; row++) {
			System.out.printf("%s", name[row]);
			for(int col = 0; col < score[row].length; col++) {
				System.out.printf("%4d", score[row][col]);
				sum += score[row][col];
				avg = sum / (double)score[row].length;
			}
			System.out.printf("%4d %.1f\n", sum, avg);
			sum = 0;
		}
	}

}
