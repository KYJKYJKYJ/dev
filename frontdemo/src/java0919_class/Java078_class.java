package java0919_class;

/*
 * [출력결과]
 * 기업은행 42523-52325 100000 
 * 하나은행 52253-22623 153000
 * 신한은행 16239-95235 256000
 * 총납입액:509000
 */
class CreditCard {
	String cardName;
	String cardNum;
	int pay;

	public CreditCard() {
	}

	public CreditCard(String cardName, String cardNum, int pay) {
		super();
		this.cardName = cardName;
		this.cardNum = cardNum;
		this.pay = pay;
	}

	public void prn() {
		System.out.printf("%s %s %d\n", cardName, cardNum, pay);
	}
	
}// end CreditCard

public class Java078_class {

	public static void main(String[] args) {
		/// [출력결과]를 참조하여 구현하시요/////////////////
		CreditCard[] ccard = new CreditCard[3];
		ccard[0] = new CreditCard("기업은행", "42523-52325", 100000);
		ccard[1] = new CreditCard("하나은행", "52253-22623", 153000);
		ccard[2] = new CreditCard("신한은행", "16239-95235", 256000);
		
		display(ccard);
		sum(ccard);
		
	}// end main()

	public static void display(CreditCard[] ccard) {
		for(int i = 0; i < ccard.length; i++) {
			ccard[i].prn();
		}
	}
	
	public static void sum(CreditCard[] ccard) {
		int sum = 0;
		for(int i = 0; i < ccard.length; i++) {
			sum += ccard[i].pay;
		}
		System.out.printf("총납입액 : %d\n", sum);
	}
	
}// end class






