package KHGYM_Actions;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QBoardDAO;

public class QDeleteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		/*temp 경로 저장*/
		String saveDirectory = "c:/temp/";
		
		QBoardDAO dao = QBoardDAO.getInstance();
		
		int num = Integer.parseInt(req.getParameter("q_num"));
		
		/*파일 가져오기*/
		String filename = dao.fileMethod(num);
		
		if(filename != null) {
			/*board 테이블의 첨부파일을 삭제*/
			File file = new File(saveDirectory, filename);
			file.delete();
		}
		
		dao.deleteMethod(num);
	}//end execute()
}//end class
