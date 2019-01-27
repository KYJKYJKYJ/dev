package java0914_array;

public class Java051_array {

	public static void main(String[] args) {
		int[][] num = new int[3][];
		//가변 배열로 지정할 때는 마지막 크기 지정 하지않음
		// 메모리 손실을 최소화 하도록 가변 배열 제공
		
		num[0] = new int[2]; // 0행 2열
		num[1] = new int[3]; // 1행 3열
		num[2] = new int[4]; // 2행 4열
		
		int[][] data = new int[][] { {1,2}, {3,4,5}, {6,7,8,9} };

		for(int row = 0 ; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				System.out.printf("%-4d", data[row][col]);
			}
			System.out.println();
		}
	}

}
