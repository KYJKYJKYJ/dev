package java0918_class.prob;
/*
 * draw()메소드를   [실행결과]를 참조하여 구현하세요.
 * 
 * [실행결과]
 * &&&&&&&&&&
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 * %%%%%%%%%%%%%%%%%%%%
 */

class Box {
	private int width, height; // 박스의 너비와 높이
	private char fillChar; // 박스를 그리는 데 사용하는 문자

	public Box() { // 매개 변수 없는 생성자
		this(10, 1); // this() 이용
	}

	public Box(int width, int height) { // 너비외 높이의 2 매개 변수를 가진 생성자
		this.width = width;
		this.height = height;
	}

	public void draw() { // 박스 그리는 메소드
		///////////// 여기에서 구현하세요.
		for(int i = 1; i <= this.height; i++) {
			for(int j = 1; j <= this.width; j++) {
			System.out.printf("%s",this.fillChar);
			}
			System.out.println();
		}

	}// end draw()

	public void fill(char c) { 
		// 박스를 그리는데 사용하는 문자 설정
		this.fillChar = c;
		
	}//end fill( )
}//end class

public class Prob03_class {

	public static void main(String[] args) {
		//여기를  구현하세요.
		Box b = new Box();
		b.fill('&');
		b.draw();

		Box b2 = new Box(20, 3);
		b2.fill('%');
		b2.draw();
	}//end main()

}//end class
