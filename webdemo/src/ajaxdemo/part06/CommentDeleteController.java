package ajaxdemo.part06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commentDelete")
public class CommentDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int col = Integer.parseInt(req.getParameter("col"));
		int num = Integer.parseInt(req.getParameter("num"));
		DiscussDAO dao = DiscussDAO.getInstance();
		dao.commDelete(col);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(num);
	}// end doGet()
}// end class
