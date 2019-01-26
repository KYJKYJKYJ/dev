package part12_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String path="part12_exam/di.xml";
		ApplicationContext context=
			new ClassPathXmlApplicationContext(path);
		Service svc=(Service)context.getBean("svc");
		svc.process();
		/*
		 * [출력결과]
		 * java
		 * jsp
		 * spring
		 */
	}

}
