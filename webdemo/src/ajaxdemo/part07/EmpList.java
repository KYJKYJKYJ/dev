package ajaxdemo.part07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//무한 스크롤
//https://twitter.com/facebook

@WebServlet("/datascroll")
public class EmpList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/ajaxview/part07/empList.jsp");
		dis.forward(req, resp);
	}//end doGet()///////////////////////

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeesDAO dao = EmployeesDAO.getInstance();
		int startRow = Integer.parseInt(req.getParameter("startRow"));
		int cntRow = Integer.parseInt(req.getParameter("cntRow"));
		System.out.println(startRow+" "+cntRow);
		List<EmployeesDTO> aList = dao.listMethod(startRow, cntRow);
		
		//System.out.println(aList);
		JSONArray arr=new JSONArray();
		for(EmployeesDTO dto : aList){
			JSONObject obj=new JSONObject();
			obj.put("employee_id", dto.getEmployee_id());
			obj.put("first_name", dto.getFirst_name());
			obj.put("salary", dto.getSalary());
			arr.add(obj);		
		}
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(arr);		
	}// end doPost()///////////////////
}// end class
