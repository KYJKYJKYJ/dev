package part13_listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*
 * 1) BeanNameAware은 빈객체가 자신의 이름을 알아야 할때 사용된다.
 *    (스프링에서 제어권을 가지고 직접 만들고 관계를 부여하는 오브젝트
 * 
 * 2) BeanFactoryAware은 빈에 대한 정보를 알려준다.
 *    (스프링의 IoC를 담당하는 핵심컨테이너)
 * 
 * 3) ApplicationContextAware은 ApplicationContext를 빈에 전달할때 사용된다.
 *    (bean factory를 확장하는 IoC컨테이너)
 * 
 * 4)InitializingBean은 객체를 생성하고 프로퍼티를 초기화하고, 컨테이너에 관련 설정을 
 *   완료한 뒤에 호출되는 메서드를 정의하고 있다.
 *   
 *  5)DisposableBean : 컨테이너에서 빈 객체를 제거할때 빈 객체는 사용하던 자원을 반납해야한다.
 *  소켓통신을 하고 있었다면 소켓을 종료해야 하고, 쓰레드를 통해 백그라운드로 작업을 수행
 *  하고 있었다면 쓰레드를 알맞게 종료해야 한다. 이를 위해서   
 *  스프링은 빈 객체를 컨테이너에서 제거하기 전에 DisPosableBean인터페이스에
 *  정의된 메서드를 호출하여 빈 객체가 자원을 반납할 수 있도록 하고 있다.
 */

public class ServiceImp implements Service, BeanNameAware, BeanFactoryAware,
ApplicationContextAware, InitializingBean, DisposableBean {
	
	private String beanName;
	
	public ServiceImp() {
		System.out.println("constructor");
	}

	@Override
	public void prn() {
		System.out.println("prn");
	}
	
	public void before() {
		System.out.println("before");
	}
	
	public void end() {
		System.out.println("end");
	}

	@Override
	public void setBeanName(String name) {
		this.beanName=name;
		System.out.println("beanName : " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("factory:"+beanFactory.getBean(beanName));
		System.out.println("factory:"+beanFactory.containsBean(beanName));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("context:"+applicationContext.getBeanDefinitionCount());
		//현재 생성된 빈의 갯수
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("빈 생성 완료");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destory");
		
	}
}
