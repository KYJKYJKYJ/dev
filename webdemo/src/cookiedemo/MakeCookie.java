package cookiedemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeCookie")
public class MakeCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션과 쿠키의 공통점 : 클라이언트의 정보를 담음
		//세션은 서버쪽에 저장되고, 쿠키는 클라이언트쪽에 저장됨(생성은 서버쪽에서 이루어짐)
			Cookie cookie = new Cookie("cookieName", "cookieValue");
			//쿠키 유효시간 -> 1시간
			cookie.setMaxAge(60*60);
			//쿠키를 클라이언트에 응답
			resp.addCookie(cookie);
			
			RequestDispatcher dis = req.getRequestDispatcher("/cookieview/makecookie.jsp");
			dis.forward(req, resp);
	}
}
