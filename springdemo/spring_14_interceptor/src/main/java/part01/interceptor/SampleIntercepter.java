package part01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * preHandle() - 컨트롤러에 들어가기 전 접근
 * postHandle() - 컨트롤러 접근 후 view 페이지 접근 전
 * afterCompletion() - 컨트롤러와 view 페이지 모두 접근 후
 * 
 * preHandle() - [컨트롤러 접근] - postHandle() - [view 페이지 접근] - afterCompletion()
 * 
 * 접근점을 둘 수 있어서 로그인처리, 다운로드처리 등에 유용
 * 
 */

public class SampleIntercepter extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle...");
		return true;
		//return false; //preHandle 단계에서 더 이상 진행이 안됨		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle...");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion...");
	}
}
