package java0928_binding;

/*
 * 다형성(polymorphism)
 * 1. 사전적 의미는 여러가지형태를 가질 수 있는 능력 을 의미
 * 2. 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조하는 기술
 * 
 * void add(Parent a, Parent b) {}
 * 
 * add(new Child(), new Child());
 * add(new Son(), new Son());
 * 
 * 바인딩 : 메소드 호출을 실제 메소드의 몸체와 연결하는 기술
 * 1. 정적바인딩 (static binding) : 컴파일 단계에서 어떤 클래스의 어떤 메소드가 호출 되는지 연결하는 기술
 * 2. 동적바인딩 (dynamic binding) : 실행 단계에서 어떤 클래스의 어떤 메소드가 호출 되는지 연결하는 기술
 * */

class BindTest extends Object {
	String stn = "BindTest";
	
	public BindTest() {
		
	}
	
	public BindTest(String stn) {
		this.stn = stn;
	}
	
	@Override
	public String toString() {
		return stn;
	}
	
}

public class Java110_binding {

	public static void main(String[] args) {
		BindTest bt = new BindTest();
		
		//정적 바인딩
		System.out.println(bt.toString());
		
		//업캐스팅 (부모클래스의 객체에서 자식클래스의 객체를 사용하는 것, 하위에서 상위로) (상속관계 일때만 사용 가능, is-a 관계)
		Object obj = bt; //Object obj = new BindTest();
		//실제로 호출시 가리키는건 obj 메모리 영역
		//근데 왜 bt영역을 참조? 오버라이딩 되어있는 메소드 때문에
		
		//동적 바인딩
		System.out.println(obj.toString());
		//obj의 toString 찾고 bt의 toString으로 오버라이딩 되서 넘어감
		//만약 부모클래스에서 메소드 없으면 업캐스팅 안됨 (부모클래스의 자원이 있어야지 업캐스팅 가능)
		//즉, 업캐스팅으로 그냥 자식 클래스의 메소드를 사용할 수 없음 (자신도 있어야됨)
		//다운캐스팅 (부모클래스의 객체를 자식클래스로 대입하는 것, 업캐스팅을 원래대로, 상위를 하위로)은 업캐스팅이 전제되어야지 가능
		
		process(new String("java"));
		
		//Object -> Number -> Integer
		process(new Integer(10));
	}
	
	//is-a 관계 -> 업캐스팅 -> 동적바인딩
	public static void process(Object obj) {
		System.out.println(obj.toString()); //호출시 bt 영역 가르킴
	}
}
