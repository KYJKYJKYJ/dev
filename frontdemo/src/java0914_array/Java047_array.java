package java0914_array;

public class Java047_array {

	public static void main(String[] args) {
		//3행 2열의 배열
		int[][] num = new int[3][2];
		//   0  1
		// 0 a  a
		// 1 a  a
		// 2 a  a
		
		/*
		 *     0  1
		 *  0  1  2
		 *  1  3  4
		 *  2  5  6
		 */
		num[0][0] = 1;  
		num[0][1] = 2;
		num[1][0] = 3;
		num[1][1] = 4;
		num[2][0] = 5;
		num[2][1] = 6;
		
		System.out.printf("%4d", num[0][0]);
		System.out.printf("%4d\n", num[0][1]);
		System.out.printf("%4d", num[1][0]);
		System.out.printf("%4d\n", num[1][1]);
		System.out.printf("%4d", num[2][0]);
		System.out.printf("%4d\n", num[0][1]);
		
		
		System.out.println("///////////////////////////////////////////");
		
		/*for(int row = 0; row < 3; row++) {
			System.out.printf("%4d", num[row][0]);
			System.out.printf("%4d", num[row][1]);
		}*/
		
		
		//num.length : 행의 크기
		//num[row].length : 열의크기
		for(int row = 0; row < num.length; row++) {
			for(int col = 0; col < num[row].length; col++) {				
			System.out.printf("%4d", num[row][col]);
			}
			System.out.println();
		}
		
		System.out.println("///////////////////////////////////////////");
		
		// 1 3 5
		// 2 4 6
		
		for (int row = 0; row < 2; row++) {
			for(int col = 0; col < num.length; col++) {
				System.out.printf("%4d", num[col][row]);
			}
			System.out.println();
		}
		
		System.out.println();
		}	

	}

