package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://127.0.0.1:8090/myweb/hello.htm
@Controller
public class HelloController {
	@RequestMapping("/hello.htm")
	public String search() {
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += i;
			System.out.printf("i=%d sum=%d\n", i, sum);
		}
		return "view/part01/hello";
		// view에 대한 정보만 있음, 설정은 환경설정에서 해줘야 한다.
		// 스프링에선 웹 환경설정 정보를 WEB-INF에 저장 해야함
	}
}
