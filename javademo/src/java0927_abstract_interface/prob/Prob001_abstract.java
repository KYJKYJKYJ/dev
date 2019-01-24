package java0927_abstract_interface.prob;

/* [주의]테스트할때 main( )메소드의 주석을 해제하세요.
 * MyPoint클래스를 상속받아 아래와 같이 출력이 되도록
 * MyColorPoint클래스를 구현하세요.
 * 
 * [출력결과]
 * 3,2,blue
 */

abstract class MyPoint {
	int x;
	int y;
	public MyPoint(int x, int y)  {
		this.x = x; this.y = y; 	
	}
	protected abstract void move(int x, int y); // 새로운 x, y 위치로 이동
	protected abstract void reverse(); // (x, y)에서 (y, x)로 위치 변경
	protected void show() {
		System.out.println(x + "," + y);
	}
}//end class MyPoint


//여기에서 MyColorPoint클래스를 구현하세요/////////////
class MyColorPoint extends MyPoint {
	String color;
	
	@Override
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected void reverse() {
		int temp;
		temp = this.x;
		this.x = this.y;
		this.y = temp;
	}
	
	@Override
	protected void show() {
		System.out.println(this.x + "," + this.y + "," + color);
	}
	
	MyColorPoint(int x, int y, String color) {
		super(x,y);
		this.color = color;		
	}
}


public class Prob001_abstract {

	public static void main(String[] args) {
		//테스트할때 아래 주석을 해제하세요.
		MyPoint p = new MyColorPoint(2,3,"blue");		
		p.reverse();
		p.show(); // 이 메소드의 실행 결과 "3,2,blue"가 출력된다.

	}

}
