package java1016_collection;

class Average<T extends Number> { //Number 클래스를 상속 받은 값이나, Number 클래스 값만 받을 수 있음
	//super Number면 Number보다 상위 클래스의 값이나 Number 클래스 값만 받을 수 있음
	private T[] list;
	
	public Average() { }
	
	public Average(T[] list) {
		this.list = list;
	}
	
	public double findAverage() {
		double sum = 0.0;
		for(T data : list) {
			sum += data.doubleValue();
			// 모든 값을 넘겨받으면 타입이 달라서 오류가 남
			// 그래서 T extends Number를 통해 Number를 상속받은 Wrapper 클래스 값들만 받도록 설정해 주었음
		}
		return sum / list.length;
	}
} // end class

public class Java200_User {

	public static void main(String[] args) {
		Integer it[] = new Integer[] {1, 5, 3, 2};
		Average<Integer> av = new Average<Integer>(it);
		System.out.println(av.findAverage());

		//Average<String> ae = null;
		//Number를 상속받은 클래스의 값이거나 Number의 값이여야 하는데 String은 전혀 상관이 없으므로 오류
		
		Number nt[] = new Number[] {2, 5.3F, 4.5};
		Average<Number> av2 = new Average<Number>(nt); // Number 클래스도 가능.
		System.out.println(av2.findAverage());
	} // end main()

}// end class
