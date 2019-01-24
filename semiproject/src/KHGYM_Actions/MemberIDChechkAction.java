package KHGYM_Actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemDAO;


@WebServlet("/IDsearch.do")
public class MemberIDChechkAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String user_id = req.getParameter("user_id");//ajax에서 보낸 데이터를 받는다.
		MemDAO dao = MemDAO.getInstance();
		boolean result  = dao.idCheck(user_id);
		PrintWriter out =resp.getWriter();
		//System.out.println("action진입성공벙공");
		//System.out.println(user_id);
		//System.out.println(result);
		
		if (result) {
			//jsp파일에 true데이터를 보냄
			out.print("true");//ID중복
			
			//중복0
		} else if(result == false){
			out.print("false");//중복아님
		}
	}// end execute()
}
