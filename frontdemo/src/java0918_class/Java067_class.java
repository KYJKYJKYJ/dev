package java0918_class;
/*
 * [사각형 도형]
 * 가로 세로 넓이를 구한다 둘레를 구한다
 * 5   3     15         16
 * 7   4     28         22
 */

class Square {
	int width;
	int height;
	
	int sq_Area() {
		int Area;
		Area = width * height;		
		return Area;
	}
	
	int sq_Length() {
		int Length;
		Length = (width * 2) + (height * 2);
		return Length;
	}
	void print() {
		System.out.printf("[가로 %d\t 세로 %d]\n", width, height);
		System.out.printf("넓이 : %d\n", sq_Area());
		System.out.printf("둘레 : %d\n", sq_Length());
	}
}

public class Java067_class {

	public static void main(String[] args) {
		Square sq = new Square();
		Square sq2 = new Square();
		
		sq.width = 5;
		sq.height = 3;
		sq.print();
		
		System.out.println("===================================");
		
		sq2.width = 7;
		sq2.height = 4;
		sq2.print();

	}

}
