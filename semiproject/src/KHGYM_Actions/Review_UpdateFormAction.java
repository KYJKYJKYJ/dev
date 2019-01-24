package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewBoardDAO;
import DTO.ReviewBoardDTO;

public class Review_UpdateFormAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		ReviewBoardDTO dto = dao.writingView(num);
		
		req.setAttribute("dto", dto);
	}
}
