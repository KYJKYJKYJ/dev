package part02_annotation;

//핵심로직만 구현해 놓은 클래스
public class ServiceImp implements Service{

	public ServiceImp() {
		
	}

	public void comm() {
		System.out.println("before");
	}
	
	@Override
	public void prn1() {
		 //comm(); //하지만 결국 호출을 하는 것도 중복 -> 핵심 로직을 구현하는 클래스 말고 별도로 뺌

		System.out.println("prn");
	}

	@Override
	public void prn1(int x) {
		System.out.println("before");
		System.out.println("x :" + x);
		
	}

	@Override
	public void prn1(int a, int b) {
		System.out.printf("prn : a=%d b=%d\n", a, b);
		
	}

	@Override
	public void prn2() {
		System.out.println("prn2");
	}

	@Override
	public String prn3() {
		System.out.println("prn3");
		return "홍길동";
	}

	@Override
	public void prn4() {
		
		System.out.println("prn4");
		String data = "abcd";
		int num = Integer.parseInt(data);
		
	}

	@Override
	public void prn5() {
		System.out.println("prn5");
	}
	
	
}
