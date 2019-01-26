package simple03;

/*
 * factory를 이용하면 결합도는 인터페이스보다 낮지만
 * factory가 정확히 구현되어 있지 않으면 참조하는 객체에 영향이 간다.
 * 
 * factory를 거쳐서 객체를 생성해서 전부 뿌려지는 듯
 * 인터페이스는 개별로 부르는 거니까 그거보다 결합도가 낮음
 */

public class HelloSpring {
	public static void main(String[] args) {
		MessageBean bean = MessageFactory.getInstance("en");
		bean.sayHello("Spring");
		
		bean = MessageFactory.getInstance("ko");
		bean.sayHello("스프링");
	} // end main()
} // end HelloSpring
