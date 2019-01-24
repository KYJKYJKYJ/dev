package boarddemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;
import boraddemo.dto.BoardDTO;

public class UpdateFormAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.viewMethod(num);
		
		req.setAttribute("dto", dto);
	}
}
