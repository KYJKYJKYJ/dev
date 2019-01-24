package java1016_collection;

public class Java188_sort {

	public static void main(String[] args) {
		String a = "ABCqwer24";
		String b = "ABC";
		String c = "ABC";
		String d = "ab";
		
		System.out.println(b.compareTo(c)); // 값이 0이 출력 (서로 값이 같음)
		
		//65-97 (비교라는 것은 서로 값을 빼는 것)
		System.out.println(c.compareTo(d)); // 값이 -32 출력 (음수면 뒤의 값이 작음)
		
		//97-32
		System.out.println(d.compareTo(c)); // 값이 32 출력 (양수면 앞의 값이 큼)
		
		//앞의 문자열이 같고 길이가 다르면 길이를 비교함
		System.out.println(a.compareTo(b)); // 값이 6 출력 (ABC 빼고 나머지 길이 값)		
		System.out.println(b.compareTo(a)); // 값이 -6 출력
		
	} // end main()

} // end class
