package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NoticeDAO;

public class Notice_ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(num));
	}
}
