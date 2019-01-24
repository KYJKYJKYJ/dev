package notice.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dao.NoticeDAO;

public class DeleteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String saveDirectory="c:/temp/"; 
		NoticeDAO dao = NoticeDAO.getInstance();
		int num =Integer.parseInt(req.getParameter("num"));
		
		String filename = dao.fileMethod(num);
		if(filename != null) {
			File file = new File(saveDirectory, filename);
			file.delete();
		}
		
		dao.deleteMethod(num);
	}
}
