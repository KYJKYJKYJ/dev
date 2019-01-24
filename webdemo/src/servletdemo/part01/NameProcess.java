package servletdemo.part01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//method=post ==> doPost() overriding 필요
@WebServlet("/NamePro") // url 이름을 NamePro로 지정
public class NameProcess extends HttpServlet{ //웹문서를 처리할 서블릿은 HttpServlet을 상속 받아야함
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get 방식은 주소창에 지정하면서 해야됨 //post 방식은 method를 지정해주어야함
		//post 방식일 때 한글처리
		/*req.setCharacterEncoding("UTF-8");*/
		
		String fname = req.getParameter("fname");
		req.setAttribute("fname", fname); // 응답해주는 jsp에서 사용하기 위해서
		
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part01/result.jsp");
		dis.forward(req, resp); // 포워드 시키는 건 클라이언트가 응답할 페이지		
	} // end doPost()
} // end class
