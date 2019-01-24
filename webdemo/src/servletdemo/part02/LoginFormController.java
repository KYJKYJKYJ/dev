package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 환경설정
 * 1. xml
 * 2. Annotation
 * 3. Properties => 환경설정에서 상수값이 필요할 경우 Properties 사용하여 저장 후 사용함
 * 
 * http://localhost:8090/webdemo/loginForm 처럼 파라미터 값이 나타나지 않음 (Annotation)
 * http://http://localhost:8090/webdemo/servlet/servletdemo.part02 예전방식

 */

@WebServlet("/loginForm")
public class LoginFormController extends HttpServlet {
	@Override					//응답하기 위해서					//응답받기 위해서
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part02/form.jsp");
		dis.forward(req, resp);
	}
} //end class
