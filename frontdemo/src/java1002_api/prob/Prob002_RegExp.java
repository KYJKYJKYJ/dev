package java1002_api.prob;
/*
 * 아이디를 입력할때 영문자,숫자 조합으로 합니다. 
 *   최소 5자이상 10자이하까지만 가능합니다.
 * (반드시 영문자로 시작한다.)
 * [출력결과]
 *  로그인 되었습니다.
 *  회원이 아닙니다.
 */
import java.util.regex.Pattern;

public class Prob002_RegExp {

	public static void main(String[] args) {
		System.out.print("ymy232");
		display(process("ymy232"));		

		System.out.print("korea");
		display(process("korea"));
	}// end main()
	public static boolean process(String sn) {
		// 여기를 구현하세요.
		if(sn.matches("[a-zA-Z.\\w]{5,10}$") &&
			Pattern.compile("[0-9]").matcher(sn).find() &&
			Pattern.compile("[a-zA-Z]").matcher(sn).find()) {
			return true;
		}
		return false;		
	}// end process()
	
	public static void display(boolean res) {
		if (res) {
			System.out.println(" 로그인이 되었습니다.");
		} else {
			System.out.println(" 회원이 아닙니다.");
		}
	}// end display()

}//end class
