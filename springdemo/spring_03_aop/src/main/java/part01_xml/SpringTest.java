package part01_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * AOP(Aspect Oriented Programming)
 * 1. AOP는 문제를 바라보는 관점을 기준으로 프로그래밍하는 기법이다.
 * 2. AOP는 문제를 해결하기위한 핵심 관심사항과 전체에 적용되는 공통관심사항을 기준으로 프로그래밍함으로써 공통 모듈을 여러 코드에 쉽게 적용할수 있게 해준다.
 */

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part01_xml/aop.xml");
		Service svc = (Service) context.getBean("svc");
		//svc.prn1();
		//svc.prn1(10);
		//svc.prn1(20, 30);
		//svc.prn2;
		//svc.prn3();
		svc.prn4();
	} // end main()

} // end class
