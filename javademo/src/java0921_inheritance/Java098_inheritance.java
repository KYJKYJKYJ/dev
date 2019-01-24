package java0921_inheritance;

/*
다음과 같은 결과가 나오도록 구현하시오.
(단, main()안의 내용수정과 새로운 Method추가하지마시오)

**** x,y,z에 값채우기*** 
10을 넘겨받은 생성자
10   20   을 넘겨받은 생성자
10   20   30  을 넘겨받은 생성자
10   20   30
합 : 60

*/

class SuperClass {
	int x, y, z;

	public SuperClass() { //11
		System.out.println("**** x,y,z에 값채우기***");  //12
	} //13

	public SuperClass(int k) { //9
		this(); //10
		this.x = k; //14
		System.out.println(k + "을 넘겨받은 생성자"); //15
	} //16

	public SuperClass(int a, int b) { //7
		this(a); //8
		this.y = b; //17
		System.out.println(a + "   " + b + "   을 넘겨받은 생성자"); //18
	} //19

	public SuperClass(int a, int b, int c) { //5
		this(a, b); //6
		z = c; //20
		System.out.println(a + "   " + b + "   " + c + "   을 넘겨받은 생성자"); //21
	} //22

	public void display() { //24
		System.out.printf("%d %d %d\n", x, y, z); //25
	} //26
}// end SuperClass

class SubClass extends SuperClass {

	public SubClass(int a, int b, int c) { //3
		// 여기를 구현하세요.//////////////////////
		super(a,b,c); //4
		display(); //23
		sumData(); //27
		//////////////////////////////
	}

	public void sumData() {  //28
		System.out.println("합 : " + (x + y + z)); //29
	} //30
}// end SubClass

public class Java098_inheritance {

	public static void main(String[] args) { //1
		SubClass ss = new SubClass(10, 20, 30); //2

	}// end main( )

}// end class
