package picturedemo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/previewDel")
public class PreviewDeleteController extends HttpServlet {	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] chk = req.getParameterValues("chk");
		PreviewDAO dao = PreviewDAO.getInstance();
		
		//list.jsp로 넘어갈때 num을 이용해서 파일명을 넘김
		List<String> aList = dao.fileList(chk);
		for(String fileData : aList) {
			File file = new File("c:/temp/", fileData); //삭제시키려는 파일 위치
			file.delete(); // 파일 삭제
		}
		
		dao.deleteMethod(chk);
		resp.sendRedirect("previewList");
	}
}
