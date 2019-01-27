package java0919_class;

/*
 * [데이터]
 * a001  생명보험  자동차보험   30000
 * a002  생명보험  운전자보험   20000
 * b001  손해보험  화재보험      15000
 * b002  손해보험  해상보험      25000
 * 
 * [출력결과]
 * 손해보험 총납입액은 40000원 입니다.
 */

class Insurance {
	String code; // 상품코드
	String name; // 상품명
	String type; // 상품종류
	int payment; // 납입보험료

	public Insurance() {

	}

	public Insurance(String code, String name, String type, int payment) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.payment = payment;
	}

	public void prn() {
		System.out.printf("%s %s %s %d\n", code, name, type, payment);
	}
}// end Insurance

public class Java077_class {

	public static void main(String[] args) {
		String search = "손해보험";
		Insurance[] is = new Insurance[4];
		is[0] = new Insurance("a001", "생명보험", "자동차보험", 30000);
		is[1] = new Insurance("a002", "생명보험", "운전자보험", 20000);
		is[2] = new Insurance("b001", "손해보험", "화재보험", 15000);
		is[3] = new Insurance("b002", "손해보험", "해상보험", 25000);
		int sum = process(is, search);
		totalPrice(sum, search);

	}// end main( )

	public static int process(Insurance[] is, String name) {
		// 여기를 구현하세요////////////////	
		int sum = 0;
		
		for(int i = 0; i < is.length; i++) {
			if(is[i].name == name) { // 변수 착각하지 말기~
				sum += is[i].payment;
			}
		}
		
		return sum;
	}// end process( )

	public static void totalPrice(int sum, String name) {
		System.out.printf("%s 총납입액은 %d원 입니다.\n", name, sum);
	}
}// end class




