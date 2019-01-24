package java0919_class;

class Goods {
	String name;
	int price;
	int numberOfStock;
	int sold;
	
	public Goods(String name, int price, int numberOfStock, int sold) {
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}

	public Goods() {
		
	}
	
	public void prn() {
		System.out.printf("%-14s %8d %5d %5d\n", name, price, numberOfStock, sold);
	}
	
}

public class Java074_class {

	public static void main(String[] args) {
		/*
		Goods cam1 = new Goods("Nikon", 400000, 30, 50);
		cam1.prn();
		
		Goods cam2 = new Goods("Sony", 400000, 20, 35);
		cam2.prn();
		
		Goods cam3 = new Goods("FujiFilm", 350000, 10, 20);
		cam3.prn();
		*/
		
		Goods[] goodArray = new Goods[3]; // 참조 데이터 타입도 배열로 묶어서 처리가 가능하다 !
		goodArray[0] = new Goods("Nikon", 400000, 30, 50);
		goodArray[1] = new Goods("Sony", 400000, 20, 35);
		goodArray[2] = new Goods("FujiFilm", 350000, 10, 20);

		/*
		 for(int i = 0; i < goodArray.length; i++) {
			goodArray[i].prn();
		}
		*/
		
		display(goodArray);
		
	}
	
	public static void display(Goods[] goodArray) { // 출력을 위한 메소드 생성 후 분리
		for(int i = 0; i < goodArray.length; i++) {
			goodArray[i].prn();
		}
	}

}
