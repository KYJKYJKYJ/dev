package java1001_api;

class StringTest { // 그냥 String과 동일한 클래스..
	private char[] arr;
	public StringTest() {
		
	}
	
	public StringTest(char[] arr) {
		this.arr=arr;
	}
	
	public char[] toChar() {
		return arr;
	}
	
	public int length() {
		return arr.length;
	}
	
	public char charAt(int index) {
		return arr[index];
	}
	
	public boolean isUpperCase(int index) {
		if(charAt(index) >= 'A' && charAt(index) <= 'Z') {
			return true;
		} else { return false; }
	}
}

public class Java115_String {

	public static void main(String[] args) {
		char[] data = new char[] {'J', 'A', 'V', 'A'};
		StringTest st = new StringTest(data);
		
		System.out.println(st.toChar());
		System.out.printf("%s\n", st.toChar()); // 주소값이 나옴 (리턴되는 것이 배열임, 참조데이터타입 => 주소)

		System.out.println(st.length());
		
		System.out.println(st.charAt(0)); // 인덱스에 해당하는 문자 리턴 **
		System.out.println(st.isUpperCase(0)); // 활용
	}

}
