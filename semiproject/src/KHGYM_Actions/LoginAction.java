package KHGYM_Actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;
import DTO.MemDTO;

public class LoginAction extends HttpServlet {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		MemDTO dto = new MemDTO();
		dto.setuser_id(user_id);
		dto.setuser_pw(user_pw);
		MemDAO dao = MemDAO.getInstance();
		int cnt = dao.memCheck(user_id, user_pw);
		
		// client과 server의 연결을 지속시킬 목적
		HttpSession session = req.getSession();
		PrintWriter out =resp.getWriter();
		
		if(cnt == 1) {//로그인됨
			session.setAttribute("user_id", user_id);//세션 scope객체에 user_id라는 이름으로  회원의 id값 저장
			session.setMaxInactiveInterval(30 * 60);//가만히 있을때 30분 로그인 유지시간
			//out.println("<script> alert('로그인 됨~'); </script>");
			RequestDispatcher dis = req.getRequestDispatcher("/main.jsp");
			dis.forward(req, resp);
			
		} else if(cnt==0){//pw불일치
			out.println("<script> alert('비밀번호가 일치하지 않습니다!'); </script>");
			out.println("<script> history.back(); </script>");
			out.println("<script> location.reload(); </script>");	
		}else {//id없음
			out.println("<script>alert('아이디가 없습니다!');</script>");
			out.println("<script>history.back();</script>");
			out.println("<script>location.reload();</script>");	
		}

	}
}
