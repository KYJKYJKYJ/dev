package java0914_array;

public class Java048_array {

	public static void main(String[] args) {
		//3행 2열
		int[][] num = new int[][] { {1,2}, {3,4}, {5,6} };
		//{} 갯수 : 행의 갯수
		//{} 안의 숫자 갯수 : 열의 갯수

		for(int row = 0; row < num.length; row++) {
			for(int col = 0; col < num[row].length; col++) {
				System.out.printf("%4d", num[row][col]);
			}
			System.out.println();
		}
		
		// 배열은 동일한 데이터 타입의 묶음
	}

}
