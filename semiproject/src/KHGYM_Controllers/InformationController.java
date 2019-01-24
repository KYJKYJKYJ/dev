package KHGYM_Controllers;

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

import DAO.InformationDAO;
import DTO.InformationDTO;

@WebServlet("/home/information.do")
public class InformationController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/information.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		InformationDAO dao = InformationDAO.getInstance();	
		List<InformationDTO> aList = dao.printContent(num);
		
		//ajax에선 json
		JSONArray arr = new JSONArray();
		for(InformationDTO dto : aList) {
			JSONObject obj = new JSONObject();
			obj.put("info_upload", dto.getInfo_upload());
			obj.put("info_text", dto.getInfo_text());
			arr.add(obj);
		}
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(arr);
	}
}