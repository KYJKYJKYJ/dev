package java0928_binding.prob;
/*
 * 아래를 참조하여 main()메소드를 구현하세요.
 * 단, main( )메소드에서 선언된 객체변수를 사용합니다.
 * 
 * [출력결과]
 * (2,3)
 * (3,4)red
 * (2,3)입니다
 * (3,4)입니다
 */

class CPoint {
	private int x, y;

	public CPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void show() {
		System.out.println("(" + x + "," + y + ")" + other());
	}

	protected String other() {
		return "";
	}

	public String toString() {
		return "(" + x + "," + y + ")" + "입니다";
	}
}

class ColorPoint extends CPoint {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public String other() {
		return color;
	}
}

public class Prob001_binding {

	public static void main(String[] args) {		
		CPoint a, b;
		// 여기에서 구현하세요.
		a = new CPoint(2, 3);
		a.show();
		b = new ColorPoint(3, 4, "red");
		b.show();
		System.out.println(a.toString());
		System.out.println(b.toString());		
	}
}
