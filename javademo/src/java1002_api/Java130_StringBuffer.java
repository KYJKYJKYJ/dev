package java1002_api;

public class Java130_StringBuffer {

	public static void main(String[] args) {
		//String 불변
		//StringBuffer 가변
		
		StringBuffer sb = new StringBuffer("java test");
		//4인덱스에 jsp 삽입
		//java test 각각 012345678
		sb.insert(4, ",jsp");
		sb.delete(4, 8); // 4부터 8미만
		System.out.println(sb.toString());

		//0인덱스의 문자를 삭제한다
		sb.deleteCharAt(0);
		System.out.println(sb.toString());
		
		//문자열을 반대로 정렬
		sb.reverse();
		System.out.println(sb.toString());
		
		System.out.println("=============================================");
		
		String data = "mybatis orm";
		StringBuffer sf = new StringBuffer(data); // String 타입을 매개변수로 사용할수 있다!
		sf.reverse();
		System.out.println(sf.toString());
		
		System.out.println("=============================================");
		
		char[] arr = new char[] { 'k', 'o', 'r', 'e', 'a' };
		StringBuffer sf2 = new StringBuffer();
		sf2.append(arr).reverse(); // StringBuffer의 append 메소드는 char형식 배열을 처리할수 있다!
		
		System.out.println(sf2.toString());
		
		System.out.println("=============================================");
		
		StringBuffer st = new StringBuffer(String.valueOf(arr)); // 객체로 받을 때 valueOf
		st.reverse();
		
		System.out.println(st.reverse());
	}

}
