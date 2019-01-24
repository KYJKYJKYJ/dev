package KHGYM_Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NoticeDAO;
import DTO.NoticeDTO;


public class Notice_UpdateFormAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num")); //view.jsp에서 넘어온 num이라는 값을 받아옴, 테이블에서 int로 사용되고 있으므로 넘어온 String 파라미터값을 int로 바꿈
		
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeDTO dto = dao.viewMethod(num); //num에 해당하는 값들 가지고 옴
		
		req.setAttribute("dto", dto); //리퀘스트 영역에 값을 넘겨줌
		
	}//end execute()//////////////////////////////////////////////

}
