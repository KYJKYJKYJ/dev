package part01_basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 컨테이너(Container)
 * 애플리케이션과 그 실행에 필요한 라이브러리, 바이너리, 구성 파일 등을 패키지로 묶어 배포하는 것
 * 1. BeanFactory - getBean()
 * 2. ApplicationContext - container 생성될  때
 * 3. WebApplicationContext - was(tomcat) 실행 될 때
 * 
 *  
 *  **결합도를 낮추려면 참조하는 곳에서 변경이 최소화가 되어야함
 *  
 *  bean : 자주 사용하는 객체를 Singleton 객체로 생성해놓고 어디서든 불러서 쓸 수 있는 것 (스프링 프레임워크가 초기화시 직접 객체를 생성해줌 (인스턴스화))
 *  협업의 기초 **
 *  
 *  객체 지향 프로그래밍에서, 어떤 클래스에 속하는 각 객체를 인스턴스라 한다
 *  class : 붕어빵틀, Object : 붕어빵, Instance : 각각의 붕어빵들 (슈크림도 있을꺼고.. 탄거도 있을꺼고..)
 */
public class SpringTest {

	public static void main(String[] args) {
		String path="part01_basic/di.xml";
		
		//xml 읽어와서 객체로 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		//BeanFactory context = new ClassPathXmlApplicationContext(path);
		//BeanFactory 생성될 때 환경설정에 기본 객체도 생성함
		
		//xml에 등록한 id 값으로 getBean하는데 Service형으로 받는 것이 기본
		//di.xml을 고치면 결과값이 달라짐 - 참조하는 곳에서 변경이 없음 (결합도가 낮다)
		
		//이를 의존성 주입(Dependency Injection) 이라고 한다.
		//(프로그래밍에서 구성요소간의 의존 관계가 소스코드 내부가 아닌 외부의 설정파일 등을 통해 정의되게 하는 디자인 패턴)
		
		Service svc = (Service)context.getBean("svc"); svc.prn();
		 
	} // end main()

} // end class
