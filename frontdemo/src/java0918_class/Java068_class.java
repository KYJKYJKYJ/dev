package java0918_class;
/*
 * 메뉴명	    가격	   갯수
 * 떡볶이	  2000	  3
 * 김말이	   500	  2
 * 오뎅	   300	  4
 */

/*
[출력결과]
메뉴명:떡볶이
가격:2000
갯수:3
메뉴금액:6000

메뉴명:김말이
가격:500
갯수:2
메뉴금액:1000

메뉴명:오뎅
가격:300
갯수:4
메뉴금액:1200
============
총금액:8200
 */

class MenuShop {
	String menu; // 메뉴명
	int price; // 가격
	int cnt; // 갯수

	// 주문메뉴 계산
	int count() {
		return price * cnt;
	}
	
	public void prn() {
		System.out.printf("메뉴명:%s\n", menu);
		System.out.printf("가격:%d\n" , price);
		System.out.printf("갯수:%d\n" , cnt);
		System.out.printf("메뉴금액:%d\n\n" , count());
	}// end main()
	
	
}// end MenuShop


public class Java068_class {

	public static void main(String[] args) {
		MenuShop ttk = new MenuShop();
		ttk.menu = "떡볶이";
		ttk.price = 2000;
		ttk.cnt = 3;
		
		MenuShop km = new MenuShop();
		km.menu = "김말이";
		km.price = 500;
		km.cnt = 2;
		
		MenuShop od = new MenuShop();
		od.menu = "오뎅";
		od.price = 300;
		od.cnt = 4;

		ttk.prn();
		km.prn();
		od.prn();
		
		System.out.println("========================");
		System.out.println("총 금액 : " + (ttk.count()+km.count()+od.count()));
		
	}

}
