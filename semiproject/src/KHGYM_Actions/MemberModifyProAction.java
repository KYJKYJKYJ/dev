package KHGYM_Actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemDAO;
import DTO.MemDTO;

public class MemberModifyProAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		
		MemDTO dto = new MemDTO();
		MemDAO dao = MemDAO.getInstance();
		//파라미터 - 입력된정보 가져오기
		dto.setuser_id(req.getParameter("user_id"));
		dto.setuser_pw(req.getParameter("user_pw"));
		dto.setuser_pw2(req.getParameter("user_pw2"));
		dto.setuser_name(req.getParameter("user_name"));
		dto.setuser_email(req.getParameter("user_email"));
		dto.setuser_phone(req.getParameter("user_phone"));
		//입력된정보를 dto에 넣기 ->나중에 dto에있는 값을 getdto로 받아서 출력
		dao.modify(dto);
	

	}// end execute()
}
