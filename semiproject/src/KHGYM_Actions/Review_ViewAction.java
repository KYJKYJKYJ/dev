package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewBoardDAO;

public class Review_ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		/* num 증가 / 다시 접근 num가져오기 */
		/* update / select */
		int num = Integer.parseInt(req.getParameter("num"));
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		req.setAttribute("dto", dao.writingView(num));

				
		
	}// end execute()
}
