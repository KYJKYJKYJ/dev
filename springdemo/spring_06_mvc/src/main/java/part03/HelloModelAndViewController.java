package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//http://localhost:8090/myweb/helloModelView.htm

//컨트롤러는 스프링에서 어노테이션 꼭 필요
@Controller 
public class HelloModelAndViewController {
	@RequestMapping("/helloModelView.htm")
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kim");
		mav.addObject("age", 30);
		mav.setViewName("view/part03/helloModelView");
		return mav;
	}

}
