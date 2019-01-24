package simple01;

//클래스에서 클래스를 사용하는 has a관계 일 때 결합도가 가장 높다.
public class MessageBean {
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	} // end sayHello()
} // end MessageBean
