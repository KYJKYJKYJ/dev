package KHGYM_Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;

@WebServlet("/PwSearchgo")
public class MemberPWSearchAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id=req.getParameter("user_id");
		String user_email=req.getParameter("user_email");
		
		MemDAO dao=MemDAO.getInstance();
		String user_pw=dao.searchPW(user_id, user_email);
		
		//값불러오는지 확인
		System.out.println(user_id);
		System.out.println(user_pw);
		
		//새션에 비밀번호 저장
		HttpSession session = req.getSession();
		session.setAttribute("user_pw", user_pw);//세션 scope객체에 user_pw라는 이름으로  회원의 pw값 저장
        session.setMaxInactiveInterval(1 * 30);//가만히 있을때 30초
		
		RequestDispatcher dis=req.getRequestDispatcher("/MemberPWsuccess.jsp");
		dis.forward(req, resp);
	}
}
