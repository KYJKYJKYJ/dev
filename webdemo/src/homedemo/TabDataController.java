package homedemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tabdata")
public class TabDataController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gubun = req.getParameter("gubun");
		
		HomeDAO dao = HomeDAO.getInstance();
		
		if(gubun.equals("employees")) {
			List<EmpDTO> tabList = dao.getEmpList();					
			req.setAttribute("tabList", tabList);	
		}else if(gubun.equals("board")) {
			List<BoardDTO> tabList = dao.getBoardList();					
			req.setAttribute("tabList", tabList);	
		}else if(gubun.equals("mem")) {
			List<MemDTO> tabList = dao.getMemList();					
			req.setAttribute("tabList", tabList);	
		}
		
		RequestDispatcher dis = req.getRequestDispatcher("/home/tabdata.jsp");
		dis.forward(req, resp);
	}
}//end class
