package ajaxdemo.part06;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/disList")
public class DisListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiscussDAO dao = DiscussDAO.getInstance();
		List<DiscussDTO> aList = dao.getList();
		req.setAttribute("list", aList);
		RequestDispatcher dis = req.getRequestDispatcher("/ajaxview/part06/list.jsp");
		dis.forward(req, resp);
	}
}
