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

@WebServlet("/home/replyInput")
public class ReviewReplyInputController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		String content = req.getParameter("content");
		String user_id = req.getParameter("userreplyid");
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		ReviewReplyDTO dto = new ReviewReplyDTO();
		
		dto.setReview_num(num);
		dto.setRe_content(content);
		dto.setUser_id(user_id);
		dao.replyInsert(dto); // 굳이 정보를 객체로 만들어서 하나에 담아 보내는 이유, mybatis는 한개의 값만 받아서 처리하기 때문에
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(num);
	}
}
