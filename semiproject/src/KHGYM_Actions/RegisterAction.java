package KHGYM_Actions;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import DAO.RegisterDAO;
import DTO.RegisterDTO;

public class RegisterAction {
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest multi=null;
		String saveDirectory="c:/temp";
		String encoding="UTF-8";
		
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		try {
			multi = new MultipartRequest(req, saveDirectory, encoding);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		RegisterDAO dao=RegisterDAO.getInstance();
		RegisterDTO dto=new RegisterDTO();
		
		String register_date=multi.getParameter("register_date");
		

		//값넘어오는지 확인
		  System.out.println(multi.getParameter("sports"));
		System.out.println(register_date);
		dto.setUser_id(user_id);
		dto.setSports(multi.getParameter("sports"));
		dto.setRegister_date(Date.valueOf(register_date));
		dto.setRegister_time(multi.getParameter("register_time"));
		dao.insertMethod(dto);
		return multi;
	}
}//
