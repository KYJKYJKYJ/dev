package sessiondemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/sessionview/login.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("fid");
		String fpass = req.getParameter("fpass");
		
		//아이디 값과 패스워드 값을 받아서 DTO로 넘겨 주어서 DAO에서 메소드를 불러 검사할 것임
		MemDTO dto = new MemDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);
		
		MemDAO dao = MemDAO.getInstance();
		int cnt = dao.memCheck(dto);
		
		//로그인 값이 맞는지 아닌지 1, 0 으로 구분
		//System.out.println(cnt);
		
		//클라이언트 고유정보를 session에 저장해 놓고 있음 (로그인 상태), 저장하지 않고 있음 (로그아웃 상태)
		//클라이언트와 서버의 연결을 지속시킬 목적으로 사용
		HttpSession session = req.getSession();
		if(cnt == 1) {
			session.setAttribute("logOk", fid); //logOk로 회원의 아이디 값을 저장함
			session.setMaxInactiveInterval(30*60); // 30분 동안 저장 (아무것도 안할시 시간이 흘러감)
		} else {
			req.setAttribute("id", fid);
		}
		
		RequestDispatcher dis = req.getRequestDispatcher("/sessionview/login.jsp");
		dis.forward(req, resp);
	}
}
