package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/mywebsocket/start.do

@Controller
public class StartController {
	@RequestMapping("/start.do")
	public String process() {
		return "first";
	}
}
