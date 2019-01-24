package part04.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part04.dao.MemDAO;

@WebServlet("/myList")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemDAO dao = new MemDAO();
		String[] arr = req.getParameterValues("chk");
		
		if(arr != null)
			dao.deleteMethod(arr);
		
		req.setAttribute("aList", dao.allMethod());
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		dis.forward(req, resp);
	}
}
