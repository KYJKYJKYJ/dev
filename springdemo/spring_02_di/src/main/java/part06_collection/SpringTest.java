package part06_collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path="part06_collection/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Service svc = (Service) context.getBean("svc1");
		svc.prn1();
		
		System.out.println("----------------------------------------------------------");
		
		svc = (Service) context.getBean("svc2");
		svc.prn2();
		
		System.out.println("----------------------------------------------------------");
		
		svc = (Service) context.getBean("svc3");
		svc.prn3();
		
		System.out.println("----------------------------------------------------------");
		
		svc = (Service) context.getBean("svc4");
		svc.prn4();
	} // end main()

} // end class
