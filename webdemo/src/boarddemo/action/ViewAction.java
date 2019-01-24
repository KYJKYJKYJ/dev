package boarddemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;

public class ViewAction {
   
   //view.do를 요청하면 파라미터값을 뷰에대한 상세처리를 하기위한 별도의 클래스를 만들어서. req를 통해서 num값을 가지고 올 수가 있다. 
   public void execute(HttpServletRequest req, HttpServletResponse resp) {
      int num = Integer.parseInt(req.getParameter("num"));
      
      /*상세페이지 들어가면 조회수가 나온다. 그래서 이 num에 해당하는 레코드를 가져오기 전에 readcount라는 컬럼에 증가값을 해줘야 조회수를 해줄수 있다. 현재 내가 보는거 까지 누적이 되도록 해줘야한다.*/
      //상세페이지 할 떄 디비를 두번 접근해야하는데 처음에 먼저 증가시키고, 넘에 해당하는 레코드를 가져와서 뷰.jsp에다 뿌려주면 된다.(Update하고 Select)
      
      BoardDAO dao = BoardDAO.getInstance();
      dao.readCountMethod(num);
      req.setAttribute("dto", dao.viewMethod(num));
      
   }//end execute()
   
}//end class




















