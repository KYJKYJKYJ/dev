package ajaxdemo.part04;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchProcess")
public class SearchProcessController extends HttpServlet{
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String data = req.getParameter("data");
      EmployeesDAO dao = EmployeesDAO.getInstance();
      List<EmployeesDTO> aList = dao.search(data);
      req.setAttribute("aList", aList);
      RequestDispatcher dis = req.getRequestDispatcher("/ajaxview/part04/searchProcess.jsp");
      dis.forward(req, resp);
   }
}