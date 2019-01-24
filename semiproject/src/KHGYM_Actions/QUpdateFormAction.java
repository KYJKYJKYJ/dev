package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QBoardDAO;
import DTO.QBoardDTO;

public class QUpdateFormAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("q_num"));
		QBoardDAO dao = QBoardDAO.getInstance();
		QBoardDTO dto = dao.viewMethod(num);
		
		req.setAttribute("dto", dto);
	}//end execute()
}//end class
