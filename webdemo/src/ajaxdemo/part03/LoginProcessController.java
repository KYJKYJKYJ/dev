package ajaxdemo.part03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginProcess")
public class LoginProcessController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		
		String chk="";
		if(id.equals("kim") && pass.equals("1234"))
			chk=id+"님 로그아웃";
		else
			chk=id+"님 비회원";
		req.setAttribute("login", chk);
		RequestDispatcher dis = req.getRequestDispatcher("/ajaxview/part03/result.jsp");
		dis.forward(req, resp);
		
	}	//end doPost()
}	//end class
