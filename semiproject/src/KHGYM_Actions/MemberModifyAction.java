package KHGYM_Actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;
import DTO.MemDTO;

public class MemberModifyAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		String user_id = req.getParameter("user_id");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		MemDAO dao = MemDAO.getInstance();
		MemDTO dto = new MemDTO();

		req.setAttribute("dto", dto);
		dao.modify(dto);

	}// end execute()
}
