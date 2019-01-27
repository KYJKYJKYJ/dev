package java0919_class;

class Calculator {
	/*void sum(int x, int y) {
		System.out.println(x+y);
	}
	
	void add(int x, int y, int z) {
		System.out.println(x+y+z);
	}
	
	void plus(double x, double y) {
		System.out.println(x+y);
	}*/
	
	void addValue(int x, int y) {
		System.out.println(x+y);
	}
	
	void addValue(int x, int y, int z) {
		System.out.println(x+y+z);
	}
	
	double addValue(double x, double y) {
		return x+y;
	}
	
	/*
	 * 오버로딩?
	 * 하나의 클래스에 같은 이름의 메소드를 여러개 정의하는 것
	 * 
	 * 조건
	 * 1. 메소드의 이름이 같아야함
	 * 2. 매개변수의 갯수 , 데이터 타입이 달라야 함
	 * 3. 매개변수는 같고 리턴타입이 다른 경우는 오버로딩이 성립되지 않음
	 * (즉, 리턴타입은 오버로딩을 구현하는데 영향을 주지않음)
	 */
	
}

public class Java079_overloading {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.addValue(4, 8);
		cal.addValue(2, 5, 7);
		System.out.println(cal.addValue(0.2, 0.2));

	}

}
