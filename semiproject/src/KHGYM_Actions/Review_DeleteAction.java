package KHGYM_Actions;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewBoardDAO;

public class Review_DeleteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//글을 삭제하기 전에 첨부파일 먼저 삭제해야함
		
		String path = req.getServletContext().getRealPath("/");
		//이 경로에 파일을 저장하게 하는것이 서로 동일하게 작업할수 있게함, 직접적인 폴더 경로 설정해서 하는 것은 적절하지 않음
		/*System.out.println("path : " + path);	*/	
		String saveDirectory = path + "/temp";
		/*String saveDirectory = "c:/temp/";*/
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		int num = Integer.parseInt(req.getParameter("num"));
		String filename = dao.file(num);
		
		//파일 이름이 null이 아니면 파일이 있는 것이므로 삭제
		if(filename != null) {
			//board 테이블의 첨부파일을 삭제
			File file = new File(saveDirectory, filename);
			file.delete();
		}
		
		
		dao.writingDelete(num);
	}
}
