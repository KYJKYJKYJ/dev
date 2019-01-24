package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QBoardDAO;
import DTO.QPageDTO;

public class QListAction {
	/*실직적인 작업이 이뤄지는 곳*/
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		//////////////////////////
		 String col = req.getParameter("col");
	      if (col == null || col.equals("null")) {
	         col = "";
	      }
	      String word = req.getParameter("word");
	      if (word == null || word.equals("null")) {
	         word = "";
	      }
		///////////////////////////////////
	      
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null || pageNum.equals("null")||pageNum == "") {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		QBoardDAO dao = QBoardDAO.getInstance();
		
		int cnt = dao.rowTotalCount(col, word);
		
		if(cnt > 0) {
			/*list.jsp에서 필요하다. 출력값 때문에*/
			QPageDTO pdto = new QPageDTO(currentPage, cnt);
			req.setAttribute("pdto", pdto);
			req.setAttribute("aList", dao.listMethod(col, word, pdto));
		}
	}//end excute()
}//end class
