package homedemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myhome")
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//첫접근 시 공지사항(emp) 값 설정
		HomeDAO dao = HomeDAO.getInstance();
		List<EmpDTO> aList = dao.getEmpList();
		//List<HomeDTO> aList = dao.getHomeList();		
		req.setAttribute("aList", aList);		
		RequestDispatcher dis = req.getRequestDispatcher("/home/index.jsp");
		dis.forward(req, resp);
	}//end doGet()
	
	
	
	
}//end class
