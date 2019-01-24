package java1002_api;

public class Java131_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("java test");
		String str = sb.toString();
		display(str.toCharArray()); // String을 char[]로
		//display(sb.toString().toCharArray()); 와 동일
	}

	public static void display(char[] data) {
		for(char cn : data) {
			System.out.println(cn);
		}
	}
}
