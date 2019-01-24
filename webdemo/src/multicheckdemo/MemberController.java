package multicheckdemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi") // 메소드가 다를 때 하나의 url로 송신 가능
public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberDTO> aList = dao.search();
		req.setAttribute("aList", aList);
		RequestDispatcher dis = req.getRequestDispatcher("/multicheckview/list.jsp");
		dis.forward(req, resp); // 클라이언트-클라이언트 간 이동
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] chk = req.getParameterValues("chk"); // 다중값이 넘어올 경우 getParameterValues 사용 , String배열로 값이 넘어옴
		MemberDAO dao = MemberDAO.getInstance();
		dao.deleteMethod(chk);		
		resp.sendRedirect("multi"); // 다시 이동 // 서버-클라이언트 간 이동
	}
}
