package java0921_inheritance;

class SuperConst {
	int x;
	int y;
	
	public SuperConst() { // 무인자 생성자는 기본적으로 만들어라!
		
	}
	
	public SuperConst(int x, int y) { //5
		this.x = x; // 6
		this.y = y; // 7
	} // 8
}

class SubConst extends SuperConst {
	public SubConst() { //superConst 클래스에 1개의 생성자가 정의 되어있어 기본생성자가 없다. 그래서 super() 호출 불가. //3
		//super();
		super(10, 40); // 4
	} // 9
}

public class Java094_inheritance {

	public static void main(String[] args) { //1
		SubConst sc = new SubConst(); // 2
		System.out.printf("x = %d y = %d\n", sc.x, sc.y); // 10

	}

}
