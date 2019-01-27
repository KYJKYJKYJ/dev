package java1005_api;

public class Java151_System {

	public static void main(String[] args) {
		int[] arr1 = {1, 5, 2, 4};
		int[] arr2 = {6, 3, 9, 7, 8};
		int[] arr3 = {4, 2};
		int[] arr4 = process(arr1, arr2, arr3);
		
		for(int data : arr4)
			System.out.printf("%3d", data);
	
	} // end main()
	
		public static int[] process(int[] arr1, int[] arr2, int[] arr3) {
			int[] sum_arr = new int[arr1.length+arr2.length+arr3.length];
			
			/*for(int i = 0; i < arr1.length; i++)
				sum_arr[i] = arr1[i];
			
			for(int i = 0; i < arr2.length; i++) {
				sum_arr[i+arr1.length] = arr2[i];
			}
			
			for(int i = 0; i < arr3.length; i++) {
				sum_arr[i+arr1.length+arr2.length] = arr3[i];
			}*/ //배열 3개를 합치는 과정
			
			//System.arraycopy(원본, 원본에서 복사 시작할 위치, 대상, 대상에 붙여지기 시작할 위치, 복사갯수);
			System.arraycopy(arr1, 0, sum_arr, 0, arr1.length);
			System.arraycopy(arr2, 0, sum_arr, arr1.length, arr2.length);
			System.arraycopy(arr3, 0, sum_arr, arr1.length+arr2.length, arr3.length);
			
			return sum_arr;
		} // end process()


} // end class
