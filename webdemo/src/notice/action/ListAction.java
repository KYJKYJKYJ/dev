package notice.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dao.NoticeDAO;
import notice.dto.PageDTO;

public class ListAction extends HttpServlet{

	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum==null || pageNum.equals("null")) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		NoticeDAO dao = NoticeDAO.getInstance();
		int cnt = dao.rowTotalCount();
		
		if(cnt>0) {
			PageDTO pdto = new PageDTO(currentPage, cnt);
			
			req.setAttribute("pdto", pdto);
			req.setAttribute("aList", dao.listMethod(pdto));
		}
	}

}
