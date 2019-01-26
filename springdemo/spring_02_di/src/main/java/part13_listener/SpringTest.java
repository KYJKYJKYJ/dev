package part13_listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("part13_listener/di.xml");
		//강제적으로 종료를 할수 있는 abstract
		Service svc = (Service) context.getBean("svc");
		svc.prn();
		
		context.close(); // 강제적으로 종료가 가능함

	}

}
