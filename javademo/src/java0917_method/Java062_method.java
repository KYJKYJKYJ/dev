package java0917_method;

public class Java062_method {

	//입사총점 : 815
	//입사결과 : 합격입니다.
	
	public static int tot(int toeic, int it) {
		int total;
		total = toeic + it;		
		return total;
	}
	
	public static String res(int total) {
		if(total >= 800) {
			return "합격";
		} else {
			return "불합격";
		}
	}
	
	public static void main(String[] args) {
		int toeic = 750; int it = 65;
		int score = tot(toeic, it);
		String result = res(score);
		System.out.println("입사총점 : " + score);
		System.out.println("입사결과 : " + result + "입니다.");

	}

}
