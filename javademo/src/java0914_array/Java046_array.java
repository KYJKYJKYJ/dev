package java0914_array;

public class Java046_array {

	public static void main(String[] args) {
		// 대문자 갯수 출력하기
		
	char[] data = new char[] { 'a', 'b', 'F', 'R', 'a' };
	
	int cnt = 0;
	
	for(int index = 0; index < data.length; index++) {
		if(data[index] >= 'A' && data[index] <= 'Z') {
			cnt++;
		}
	}
		System.out.println("대문자 갯수 : " + cnt);
	}

}
