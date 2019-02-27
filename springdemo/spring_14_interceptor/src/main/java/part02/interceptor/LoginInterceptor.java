package part02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public LoginInterceptor() {
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor");
		
		String uri = request.getRequestURI();
		//uri : /myinter/noticeList.do
		
		uri = uri.substring(uri.lastIndexOf("/") + 1);
		//uri : noticeList.do //이 uri를 가져오는게 핵심
		System.out.println("uri : " + uri);
		
		//session 객체를 기존 방법대로 받아야함 (오버라이딩 상태라서)
		HttpSession session = request.getSession();
		
		//login 상태가 아니면
		if(session.getAttribute("chk") == null) {
			response.sendRedirect("login.do?returnUrl=" + uri); // 로그인 화면으로 이동한다. uri는 저장된 상태
			return false;
		} else {
			return true;
		}
	
		//요청하는 컨트롤러가 실행되기 전 실행됨
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
