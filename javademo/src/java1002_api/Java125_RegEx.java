package java1002_api;

public class Java125_RegEx {

	public static void main(String[] args) {
		String sn = "1a2345";
		String sb = "a5netg";
		String st = "aetwefgcc";
		
		// a-zA-Z_*$가 sn변수에 포함이 되어있으면 true, 아니면 false 리턴. // 언더바는 공백을 의미
		System.out.println(sn.matches(".*[a-zA-Z_*$].*"));
		
		// 숫자가 포함되어 있는가?
		System.out.println(sn.matches(".*[0-9].*"));
		System.out.println(sn.matches(".*\\d.*"));
		
		// sb변수에 저장된 값이 2로 시작되면 true 아니면 false를 리턴
		System.out.println(sb.matches("2.*"));
		
		// sb변수에 저장된 값이 2로 시작하고 5로 끝나면 true 아니면 false를 리턴
		System.out.println(sb.matches("2.*5"));
		
		// sb변수에 저장된 값이 a,b로 시작하고 자리가 5개이면 true 아니면 false를 리턴
		System.out.println(sb.matches("[ab].{5}"));
		System.out.println(sb.matches("[ab].{5,}")); //5개 이상이면 true
		System.out.println(sb.matches("[ab].{0,5}")); //5개 이하면 true
		
		System.out.println(sb.matches("[ab].{1,5}cc")); //1~5개 이하이고 cc로 끝나면 true
	}

}
