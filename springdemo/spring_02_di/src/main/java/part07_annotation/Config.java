package part07_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//현재 클래스(Config)를 스프링 환경설정으로 사용함을 의미
@Configuration
public class Config {
	public Config() {
		
	}
	
	public User user() {
		return new User("kim", "a1234");
	}
	
	/*
	 <bean id="svc" class="part07_annotation.ServiceImp">
	 	<consturctor-arg ref="user" />
	 </bean>
	 */
	// 여기서 가르키는 user는 위의 user를 말함
	
	
	//@Bean을 선언할때 이름속성을 지정하지 않으면 메소드명이 빈ID가 된다
	@Bean
					//id 값
	public ServiceImp svc() {
		return new ServiceImp(user());
							//선언한 user는 위의 user
	}
	//위 주석안 코드와 동일한 기능 수행
	
	//이름값을 가지고 호출
	@Bean(name="ss")
	public ServiceImp svc2() {
		return new ServiceImp(user());
	}
} // end class
