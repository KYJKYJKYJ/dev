package servletdemo.part01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//doGet이 오버라이딩 되어야함 (첫 화면은 무조건 get방식)
@WebServlet("/Basic") // 서블릿을 실행하기 위한 url을 @(어노테이션)을 이용하여 입력해야함
public class Basic extends HttpServlet{
//웹문서를 서비스 하려면 무조건 HttpServlet을 상속받아야함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part01/nameview.jsp");
		dis.forward(req, resp); //페이지를 이동해주는 메소드
		
	} // end doGet()
	
} // end class
