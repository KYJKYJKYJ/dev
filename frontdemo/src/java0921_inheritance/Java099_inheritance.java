package java0921_inheritance;

/*
 * [출력결과]
 * 1000량의 물을 뿌린다
 * 8인승 차량입니다.
 */

class allCar {
	private int speed;
	String color;

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}// end class Car/////////////////////////

class FireEngine extends allCar {
	private long water;

	public void setWater(long water) {
		this.water = water;
	}

	void waterSpread() {
		System.out.println(water + "량의 물을 뿌린다.");
	}
}// end class FireEngine////////////////////

class OwnerEngine extends allCar {
	private int seat;
	
	public void setSeat(int seat) {
		this.seat = seat;
	}

	void information() {
		System.out.println(seat + "인승 차량입니다.");
	}
}// end class OwnerEngine////////////////////

public class Java099_inheritance {

	public static void main(String[] args) {
		// 여기를 구현하세요.////////////////////
		FireEngine fe = new FireEngine();
		fe.setWater(1000);
		fe.waterSpread();
		
		OwnerEngine oe = new OwnerEngine();
		oe.setSeat(8);
		oe.information();
	}//end main( )

}//end class




