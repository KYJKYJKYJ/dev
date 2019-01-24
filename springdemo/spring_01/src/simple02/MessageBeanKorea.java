package simple02;

public class MessageBeanKorea implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕, " + name + "!");
	} // end sayHello()
	
} // end MessageBeanKorea