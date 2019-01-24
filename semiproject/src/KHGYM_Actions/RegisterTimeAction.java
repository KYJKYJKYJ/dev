package KHGYM_Actions;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;


@WebServlet("/ReTimeActionn")
public class RegisterTimeAction extends HttpServlet{		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegisterDAO dao=RegisterDAO.getInstance();
		
		String sports=req.getParameter("sports");
		String register_date=req.getParameter("datepicker");

		//값넘어오는지 확인
		/*  System.out.println(sports);
		System.out.println(register_date);*/
		
		List<String> aList = dao.getRegisterTime(sports, register_date);
		
		ArrayList<String> timeTable=new ArrayList<String>();
		timeTable.add(new String("12:00~13:00"));
		timeTable.add(new String("19:00~20:00"));
		timeTable.add(new String("20:00~21:00"));
		
		//예약이 되지 않은 경우=>DB에 저장된 시간값이 비어있을 경우
		if(aList.isEmpty()) {
			String nodata = "nodata";
			aList.add(nodata);
			req.setAttribute("aList", aList);//리퀘스트영역에 저장
			
		//예약이 되어있을 경우=> DB에 저장된 시간값(aList)을 timetable에서 제거해준다.
		}else {
			
			for (int i = 0; i < timeTable.size(); i++) {
				for (int j = 0; j < aList.size(); j++) {
					if((timeTable.get(i)).equals(aList.get(j))) {
						timeTable.remove(aList.get(j));
						if(timeTable.isEmpty()) {
							timeTable.add(new String("예약가능한 시간이 없습니다!"));
						}
					}
				}
			}
			req.setAttribute("aList", timeTable);//리퀘스트영역에 저장	
			
		}
		
		
		RequestDispatcher dis=req.getRequestDispatcher("/registerview/regi_timeSelect.jsp");
		dis.forward(req, resp);
	}
	
}
