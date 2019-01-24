package ajaxdemo.part06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commentUpdate")
public class CommentUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int col = Integer.parseInt(req.getParameter("col"));
		String content = req.getParameter("content");
		int num = Integer.parseInt(req.getParameter("num"));
		
		DiscussDAO dao = DiscussDAO.getInstance();
		CommentDTO dto = new CommentDTO();
		dto.setCol(col);
		dto.setContent(content);
		dao.commUpdate(dto);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(num);
	}
}
