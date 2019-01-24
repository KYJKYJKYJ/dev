package KHGYM_Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewBoardDAO;
import DTO.ReviewReplyDTO;

@WebServlet("/home/replyUpdate")
public class ReveiwReplyUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int col = Integer.parseInt(req.getParameter("col"));
		String content = req.getParameter("content");
		int num = Integer.parseInt(req.getParameter("num"));
		
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		ReviewReplyDTO dto = new ReviewReplyDTO();
		dto.setRe_col(col);
		dto.setRe_content(content);
		dao.replyUpdate(dto);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(num);
	}
}
