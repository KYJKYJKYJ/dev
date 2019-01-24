package java1001_api;

/*
 * 문자열 관련 클래스
 * java.lang.String
 * java.lang.StringBuffer
 * java.lang.StringBuilder
 * java.util.StringTokenizer
 */
public class Java116_String {

	public static void main(String[] args) {
		
		String sn = "java";
		String sg = "java";
		String st = new String("java");
		String ss = new String("java");
		
		 /*
		  * String class의 특징과 관련이 있다. 
		  * 참조변수는 생성자를 이용하여 객체를 생성하고 사용할 수 있다. 
		  * 그러나 String class의 특성상 초기 java개발자들은 간편하게 ""따옴표를 이용하여 객체를 생성 할 수 있게 하였다.
		  */


		
		System.out.printf("sn == sg : %b\n", sn==sg); // true (주소비교)
		System.out.printf("st == ss : %b\n", st==ss); // false (주소비교)
		
		//equals() : (주소)문자열 비교
		//equals는 object 클래스의 메소드이므로 오버라이딩 되어서 사용됨
		
		/* equals는 hashcode를 이용하여 두 객체를 비교해야 한다는 것이다. hashcode란 객체의 내용을 숫자값으로 반환하는 메서드이다.
		 * c언어의 포인터와 비슷하게 생각하는 경우가 있지만 포인터는 엄밀하게 포인터와는 다른 속성을 갖는다. hashcode의 특징은 다음과 같다.
		  
		 * - 동일 객체의 해시값은 반드시 동일하다.
		 * - 해시값이 다른 경우에는 서로 다른 객체다.
		 * - 서로 다른 객체라도 해시값이 동일한 경우가 있다.
		  
		 * 착각하지 말아야 할 것은 해시 값은 객체 고유의 값이 아니다. 따라서 서로 다른 객체가 같은 해시값을 가질 수도 있음을 명시해야 한다.
		 */

		System.out.printf("sn.equals(sg) : %b\n", sn.equals(sg)); // true
		System.out.printf("st.equals(ss) : %b\n", st.equals(ss)); // true
		//독자적으로 메모리 영역을 가르키는 것이 아니라 java 값이 기록된 동일한 힙 메모리영역을 st,ss가 가르킴
		
		//toString(); : 메모리에 저장된 문자열 리턴
		System.out.println(sn.toString());
		System.out.println(sn); // 결과는 같다.
		
	}

}
