package ajaxdemo.part06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/disView")
public class DisViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		DiscussDAO dao = DiscussDAO.getInstance();
		req.setAttribute("dto", dao.getView(num));
		RequestDispatcher dis = req.getRequestDispatcher("/ajaxview/part06/view.jsp");
		dis.forward(req, resp);
	}
}
