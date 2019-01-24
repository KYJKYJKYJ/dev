package KHGYM_Actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemDAO;
import DTO.MemDTO;

@WebServlet("/IDsearch")
public class MemberIDSearchAction extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String searchId = null;
      req.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter out =resp.getWriter();
   
      MemDTO dto = new MemDTO();
      MemDAO dao = MemDAO.getInstance();
      
      String user_name = req.getParameter("user_name");
      String user_email = req.getParameter("user_email");
      
      dto.setuser_name(user_name);
      dto.setuser_email(user_email);
      searchId=dao.searchID(dto);
      System.out.println("searchId:"+searchId);
      
      HttpSession session = req.getSession();
      
      
   /*   if(searchId.isEmpty()) {//아이디 있음
         session.invalidate();
         
      } else {*/
         session.setAttribute("searchId",searchId );//세션 scope객체에 user_id라는 이름으로  회원의 id값 저장
         session.setMaxInactiveInterval(1 * 60);//가만히 있을때 30분 로그인 유지시간
         //out.println("<script> alert('로그인 됨~'); </script>");
         System.out.println("아이디 있음요");
         System.out.println(searchId);
         
         
   //   }
            
   //}
      System.out.println("아무거나 나와보셈");
      System.out.println(searchId);
      RequestDispatcher dis= req.getRequestDispatcher("/MemberIDsearch.jsp");
      dis.forward(req, resp);
   
   }
   
   
   /*@Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String searchId = null;
      req.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter out =resp.getWriter();
   
      MemDTO dto = new MemDTO();
      MemDAO dao = MemDAO.getInstance();
      
      String user_name = req.getParameter("user_name");
      String user_email = req.getParameter("user_email");
      
      dto.setuser_name(user_name);
      dto.setuser_email(user_email);
      searchId=dao.searchID(dto);
      System.out.println("searchId:"+searchId);
      
      HttpSession session = req.getSession();
      
      
      if(searchId.isEmpty()) {//아이디 있음
         session.invalidate();
         
      } else {
         session.setAttribute("searchId",searchId );//세션 scope객체에 user_id라는 이름으로  회원의 id값 저장
         session.setMaxInactiveInterval(1 * 60);//가만히 있을때 30분 로그인 유지시간
         //out.println("<script> alert('로그인 됨~'); </script>");
         System.out.println("아이디 있음요");
         System.out.println(searchId);
         
         
   //   }
            
   //}
      System.out.println("아무거나 나와보셈");
      System.out.println(searchId);
      RequestDispatcher dis= req.getRequestDispatcher("/MemberIDsearch.jsp");
      dis.forward(req, resp);
   }*/
}