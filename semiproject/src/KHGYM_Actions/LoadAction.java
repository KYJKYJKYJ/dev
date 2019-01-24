package KHGYM_Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InformationDAO;
import DTO.InformationDTO;

@WebServlet("/load")
public class LoadAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Integer num=Integer.parseInt(req.getParameter("num"));
		System.out.println(num);
		InformationDAO dao=InformationDAO.getInstance();
		String result=dao.printContent(num);
		req.setAttribute("result", result);
		req.setAttribute("num", num);
		
		
		RequestDispatcher dis=req.getRequestDispatcher("/result.jsp");
		dis.forward(req, resp);
		*/
	}
}
