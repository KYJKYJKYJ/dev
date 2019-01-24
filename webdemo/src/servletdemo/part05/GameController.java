package servletdemo.part05;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game")
public class GameController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part05/input.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post 한글 출력
		req.setCharacterEncoding("UTF-8");
		String gg = req.getParameter("gg");
		
		Random rand = new Random();
		int randomInt = rand.nextInt(3);
		
		String result = gg;
		String com_result = "";
		
		if(randomInt == 0)
			com_result = "가위";
		else if(randomInt == 1)
			com_result = "바위";
		else if(randomInt == 2)
			com_result = "보";
		
		req.setAttribute("result", result);
		req.setAttribute("com_result", com_result);
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part05/result.jsp");
		dis.forward(req, resp);
	}
}
