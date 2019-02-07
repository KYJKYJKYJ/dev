package part04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//http://127.0.0.1:8090/myweb/mem.htm

@Controller
public class HelloCommandController {
	@RequestMapping(value="/mem.htm", method=RequestMethod.GET)
	public String form() {
		return "view/part04/memForm";
	}
	
	
	/*@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	//memForm의 값 받기
	//form 안에 변수들과 name을 똑같이 해주면 form에서 submit되서 넘어오는 값을 자동으로 받아온다!
	public ModelAndView submit(String name, int age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.setViewName("view/part04/memPro");
		return mav;
	}*/
	
	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public String submit(@ModelAttribute("dto") MemDTO dto) { // 받아올 데이터 이름 지정하는 ModelAttribute
		return "view/part04/memPro"; 
	}
	
	//개별 name, age 뽑아서 사용할 때는 ModelAndView 를 사용해야하지만, 전체를 뽑아낼 때는 String형으로 dto 받아올 수 있음!
}
