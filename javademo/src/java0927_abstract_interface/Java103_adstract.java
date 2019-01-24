package java0927_abstract_interface;

abstract class Shape {
	private int width;
	private int height;

	public Shape() {

	}

	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	abstract double getArea();

}

class Rect extends Shape {
	public Rect() {

	}

	public Rect(int width, int height) {
		super(width, height);
	}

	@Override
	double getArea() {
		return getWidth() * getHeight();
	}

}// end Rect

class Tri extends Shape {
	public Tri() {

	}

	public Tri(int width, int height) {
		super(width, height);
	}

	@Override
	double getArea() {

		return getWidth() * getHeight() / 2;
	}
}

public class Java103_adstract {

	public static void main(String[] args) {
		Rect rr = new Rect(10, 20);
		System.out.println("사각형 넓이:" + rr.getArea());

		Tri tt = new Tri(10, 20);
		System.out.println("삼각형 넓이:" + tt.getArea());

	}//end main()

}//end class
