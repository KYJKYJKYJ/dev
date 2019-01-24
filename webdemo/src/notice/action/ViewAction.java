package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dao.NoticeDAO;

public class ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(num));
	}
}
