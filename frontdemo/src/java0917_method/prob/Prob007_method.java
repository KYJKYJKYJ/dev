package java0917_method.prob;
/*
 * [출력결과]
 * 내림 차순 결과
    31
	22
	16
	11
	10
	9
    오름 차순 결과
	9
	10
	11
	16
	22
	31
 */

public class Prob007_method {

	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 16, 11, 31};

		int[] result1 = sort(arr, "desc");
		int[] result2 = sort(arr, "asc");
		System.out.println("내림 차순 결과");
		for (int i = 0; i < result1.length; i++) {
			System.out.println(result1[i]);
		}
		System.out.println("오름 차순 결과");
		for (int i = 0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
	}//end main( )

	private static int[] sort(int[] array, String orderby) {
		// 구현하시오.
		int temp;
		
		int[] sortArray = new int[array.length]; // int[] sortArray = array.clone();
		for(int i = 0; i < array.length; i++) {
			sortArray[i] = array[i];
		}
		
		if (orderby == "asc") {
			for(int i = 0; i < sortArray.length; i++) {
				for(int j = 1; j < sortArray.length; j++) {
					if(sortArray[j-1] >= sortArray[j]) {
						temp = sortArray[j-1];
						sortArray[j-1] = sortArray[j];
						sortArray[j] = temp;
					}
				}
			}
		}
		
		if (orderby == "desc") {
			for(int i = 0; i < sortArray.length; i++) {
				for(int j = 1; j < sortArray.length; j++) {
					if(sortArray[j-1] <= sortArray[j]) {
						temp = sortArray[j-1];
						sortArray[j-1] = sortArray[j];
						sortArray[j] = temp;
					}
				}
			}
		}
		
		return sortArray;
	}//end sort( )
}