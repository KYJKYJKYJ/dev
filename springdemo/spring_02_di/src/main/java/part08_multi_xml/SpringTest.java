package part08_multi_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		String data[] = new String[2];
		data[0] = "part08_multi_xml/di1.xml";
		data[1] = "part08_multi_xml/di2.xml";
		
		//같은 컨테이너에 각각 알아서 반영되는데, 따로따로 분리해서 선언해도 무방하다
		ApplicationContext context = new ClassPathXmlApplicationContext(data);
		
		String sn = (String)context.getBean("sn");
		System.out.println("문자열 : "+sn);
		
		Integer it = (Integer)context.getBean("it");
		System.out.println("정수 : "+it);
	}

}
