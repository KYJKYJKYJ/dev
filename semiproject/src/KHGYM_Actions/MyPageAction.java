package KHGYM_Actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;
import DAO.RegisterDAO;

public class MyPageAction {
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

      HttpSession session = req.getSession();
      String user_id = (String) session.getAttribute("user_id");
      
      MemDAO dao = MemDAO.getInstance();
      req.setAttribute("dto", dao.myPage(user_id));
      
      RegisterDAO dao2 = RegisterDAO.getInstance();
      req.setAttribute("dto2", dao2.registerInfo(user_id));
      
      
   }// end execute()
}