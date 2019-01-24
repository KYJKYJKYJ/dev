package simple02;

public class HelloSpring {

	public static void main(String[] args) {
		//인터페이스를 사용하여 결합도를 낮추었음
		MessageBean bean = new MessageBeanEnglish();
		bean.sayHello("awaken");

		bean = new MessageBeanKorea();
		bean.sayHello("일어났다");
	} // end main()

} // end HelloSpring
