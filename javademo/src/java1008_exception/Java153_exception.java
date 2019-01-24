package java1008_exception;

public class Java153_exception {

	public static void main(String[] args) {
		StringBuffer sb = null;
		
		try {
			sb.reverse();
		} catch(NullPointerException exc) {
			System.out.println(exc.toString());
		} finally {
			System.out.println("예외처리 종료");
		}

		System.out.println("프로그램 종료");
	}

}
