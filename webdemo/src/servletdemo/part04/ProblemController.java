package servletdemo.part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/problem") //하나의 서블릿에 2개의 url 실행하기 (메소드 방식이 다르면 됨, get이나 post 구분)
public class ProblemController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part04/form.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식에서 한글 출력하기
		req.setCharacterEncoding("UTF-8");
		String ko /*form.jsp에서 name값*/ = req.getParameter("ko");
		System.out.println(ko);
		
		String res = "";
		if(ko.equals("서울")) {
			res = ko+"는 정답입니다.";
		}else {
			res = ko+"는 정답이 아닙니다.";
		}
		
		req.setAttribute("res", res);
		
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part04/result.jsp");
		dis.forward(req, resp);
	} // end doPost()
}
