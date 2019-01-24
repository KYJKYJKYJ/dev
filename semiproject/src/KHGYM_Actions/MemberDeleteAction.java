package KHGYM_Actions;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;


@WebServlet("/delete.do")
public class MemberDeleteAction {
	 public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String user_id = (String)session.getAttribute("user_id");
		 
		 MemDAO dao = MemDAO.getInstance();
		 dao.delete(user_id);
		 
		 session.invalidate();
		 System.out.println(user_id);
		/*
		 * RequestDispatcher dis = req.getRequestDispatcher("/main.jsp");
		 * dis.forward(req, resp);
		 */
	   }// end execute()
}
