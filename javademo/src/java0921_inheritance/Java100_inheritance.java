package java0921_inheritance;

/* 
[출력결과]
삼성          SHV-E250S     200000
삼성          SHV-E160S     180000
아이폰       A1586 	      250000
아이폰       A1524 	      220000
LG      LG-F700L 	  190000
LG      LG-F650L 	  180000
***************************************************
삼성         SHV-E250S     200000   010-2534-2532     SK
아이폰        A1586         250000   010-2532-5902     LG
LG       LG-F650L      180000   010-7280-5283     KT
아이폰        A1524         220000   010-2259-3052     LG
*/
class HandPhone {
	private String maker; // samsung, iphone, lg, saomi
	private String model;
	private int price;

	public HandPhone(String maker, String model, int price) {
		this.maker = maker;
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void display() {
		System.out.printf("%-4s %-10s %6d\n", maker, model, price);
	}
}

class SmartPhone extends HandPhone {
	private String number;
	private String type;// 통신타입 kt, lg, sk

	public SmartPhone(String maker, String model, int price, String number, String type) {
		super(maker, model, price);
		this.number = number;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void display() {
		System.out.printf("%-4s %-10s %6d %s %s\n", getMaker(), getModel(), getPrice(), getNumber(), getType());
	}
}

public class Java100_inheritance {

	public static void main(String[] args) {
		
		HandPhone[] hPhone = new HandPhone[6];
		hPhone[0] = new HandPhone("삼성", "SHV-E250S", 200000);
		hPhone[1] = new HandPhone("삼성", "SHV-E160S", 180000);
		hPhone[2] = new HandPhone("아이폰", "A1586", 250000);
		hPhone[3] = new HandPhone("아이폰", "A1524", 220000);
		hPhone[4] = new HandPhone("LG", "LG-F700L", 190000);
		hPhone[5] = new HandPhone("LG", "LG-F650L", 180000);

		for (HandPhone hh : hPhone)
			hh.display();

		System.out.println("***************************************************");
		SmartPhone[] sPhone = new SmartPhone[4];
		//여기를 구현하세요./////////////////
		sPhone[0] = new SmartPhone("삼성", "SHV-E250S", 200000, "010-2534-2532", "SK");
		sPhone[1] = new SmartPhone("아이폰", "A1586", 250000, "010-2532-5902", "LG");
		sPhone[2] = new SmartPhone("LG", "LG-F650L", 180000, "010-7280-5283", "KT");
		sPhone[3] = new SmartPhone("아이폰", "A1524", 220000, "010-2259-3052", "LG");
		////////////////////////////////////////

		for (SmartPhone ss : sPhone)
			ss.display();
	}//end main()

}//end class
