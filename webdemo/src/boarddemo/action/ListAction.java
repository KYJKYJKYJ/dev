package boarddemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;
import boraddemo.dto.PageDTO;

public class ListAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String pageNum=req.getParameter("pageNum");
		if(pageNum==null || pageNum.equals("null")) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		BoardDAO dao = BoardDAO.getInstance();
		int cnt = dao.rowTotalCount();
		if(cnt > 0) {
			PageDTO pdto = new PageDTO(currentPage, cnt);
			req.setAttribute("pdto", pdto);
			req.setAttribute("aList", dao.listMethod(pdto));
		}
				
	}
}
