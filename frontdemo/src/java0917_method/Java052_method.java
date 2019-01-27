package java0917_method;

public class Java052_method {

	//메소드 정의
	/*
	 * 1. 값의 계산을 위해 사용되는 기능
	 * 2. 객체의 동작을 처리하기 위한 기능
	 */
	
	/* 메소드의 구조
	 * public int addition(int a, int b) // 메소드의 선언부 {
	 * [접근 지정자] [리턴타입] [메소드이름] (데이터 타입 매개변수 )
	 * 		return a+b; [반환값] 			 // 메소드의 구현부
	 * }
	 * 
	 * 1. 리턴값이 없고 매개변수도 없을시
	 * void add() {
	 * 	int x = 10; // 지역변수
	 * 	int y = 20;
	 *  
	 *  if(y > 30) {
	 *  	return;
	 *  } else {
	 *  	System.out.println(x+y);
	 *  }
	 * }
	 * 
	 * 호출시 add();
	 * 
	 * 2. 리턴값이 없지만 매개변수가 있을시
	 * void plus(int x, int y) {
	 * 	System.out.println(x+y);
	 * }
	 * 
	 * 호출시 plus(10,20);
	 * 
	 * 3. 리턴값이 있지만 매개변수가 없을시
	 * double avg() {
	 *  int total = 15;
	 *  return total / 3.0;
	 *  }
	 *  
	 *  호출시 double res = avg(); or Syso(avg());
	 *  
	 *  4. 리턴값이 있고 매개변수도 있을시
	 *  int sum(int a, int b, int c) {
	 *   int total = a + b + c;
	 *   return sum;
	 *  }
	 *   
	 *  호출시 int res = sum(10,10,20); or Syso(sum(10,30,20));
	 */
	
	// 프로그램 실행시 JVM에서 main스레드에 의해 main()메소드 호출
	public static void main(String[] args) { //1
		System.out.println("main start"); //2
		makeTest(); // 메소드 호출 //3
		System.out.println("main end"); //7
	} // end main // 8
	
	public static void makeTest() { //4
		System.out.println("makeTest"); //5
	} // end makeTest // 6

}
