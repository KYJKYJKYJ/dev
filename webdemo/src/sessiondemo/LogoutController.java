package sessiondemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String fid=(String)session.getAttribute("logOk");
		
		if(fid != null) {
			//세션 연결 종료
			session.invalidate();
		}
		resp.sendRedirect("login");
	}
	
	//회원일때는 session에 logOk 값을 가져와서 회원만 볼수 있는 페이지로 넘어가게 설정
	//비회원일때는 session 접근 필요가 없이 비회원이 볼 수 있는 메세지나, 페이지로..
}
