package java0913_array;

public class Java042_array {

	public static void main(String[] args) {
		/*int[] jumsu = new int[3];
		
		jumsu[0] = 90;
		jumsu[1] = 80;
		jumsu[2] = 40;*/
		
		//초기값 할당시 배열의 크기를 명시할 수 없다
		int[] jumsu = new int[] { 80, 90, 40 };
		
		for(int index = 0; index < jumsu.length; index++) {
			System.out.println(jumsu[index]);
		}
	}

}
