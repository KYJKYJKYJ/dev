package part07_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
																	//Config 안의 클래스
	
	Service svc = (Service) context.getBean("svc");
	svc.prn();
	
	System.out.println("-------------------------------------------------------");
	
	//name으로 받아옴
	svc = (Service) context.getBean("ss");
	svc.prn();
	} // end main()

} // end class
