package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPro")
public class LoginProController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("fid");
		String fpass = req.getParameter("fpass");
		
		MemberDTO dto = new MemberDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);
		
		req.setAttribute("dto", dto);
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part02/result.jsp");
		dis.forward(req, resp);
	} // end doPost()
}
