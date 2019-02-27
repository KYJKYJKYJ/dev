package part02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import part02.dto.PersonDTO;

@Controller
public class LoginController {
	// http://localhost:8090/myinter/login.do
	@RequestMapping("/login.do")
	public String loginProcess() {
		return "part02/loginForm";
	}
	
	@RequestMapping("/logpro.do")
	public String logCheckProcess(String returnUrl, PersonDTO dto, HttpSession session) {
																	//스프링에서는 단순히 HttpSession을 선언하는 것으로 Session객체 생성함
		if(dto.getId().equals("kim") && dto.getPass().equals("1234")) {
			session.setAttribute("chk", dto.getId());
			if(returnUrl != "") {
				return "redirect:/"+returnUrl;
			}
		}
		
		return "redirect:/index.do";
	}
	
	@RequestMapping("/logout.do")
	public String logoutProcess(HttpSession session) {
		session.removeAttribute("chk");
		return "redirect:/index.do";
	}
}
