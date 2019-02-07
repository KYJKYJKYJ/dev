package part02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part02/tx.xml");
		Service svc = (Service) context.getBean("svc");
		
		//트랜잭션이 설정된 메소드에서는 try~catch를 설정하면 안되고 메소드를 호출하는 곳에서 선언해야 한다.
		try {
			svc.insertProcess();
			System.out.println("ok");
		} catch (Exception ex) {
			System.out.println("result: "+ex.toString()+"//end result");
		}
	}
}
