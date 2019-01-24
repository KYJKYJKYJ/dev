package KHGYM_Actions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NoticeDAO;
import DTO.PageDTO;

public class Notice_ListAction extends HttpServlet{

	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	      String col = req.getParameter("col");
	      if (col == null || col.equals("null")) {
	         col = "";
	      }
	      String word = req.getParameter("word");
	      if (word == null || word.equals("null")) {
	         word = "";
	      }
		
		
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum==null || pageNum.equals("null")) {
			pageNum="1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		int cnt = dao.search_rowTotalCount(col, word);

		
		if(cnt>0) {
			PageDTO pdto = new PageDTO(currentPage, cnt);
			
			req.setAttribute("pdto", pdto);
			 req.setAttribute("aList", dao.listMethod(col, word, pdto));
		}
	}

}
