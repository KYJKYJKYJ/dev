package servletdemo.part03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empList")
public class EmpListContorller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeesDAO dao = EmployeesDAO.getInstance();
		
		/*List<EmployeesDTO> aList = dao.search();
		req.setAttribute("aList", aList);*/
		
		//위와 동일
		req.setAttribute("aList", dao.search());
		
		//forward() 해줄 페이지를 동록함
		/*RequestDispatcher dis = req.getRequestDispatcher("/servletview/part03/empList.jsp");*/
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part03/empList2.jsp");
		
		//페이지 이동
		dis.forward(req, resp);
	}
}
