package picturedemo;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/insertMain")
public class PreviewInsertContoller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/pictureview/insert.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MultipartRequest multi = null;
		String saveDirectory = "c:\\temp"; //클라이언트에서 데이터를 받을 임시경로
		File file = new File(saveDirectory);
		if(!file.isDirectory())
			file.mkdir();
		
		int maxPostSize = 1*1000*1000*1000;
		// kb, mb gb, 즉 1gb;
		String encoding = "UTF-8";
		
		multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		//DefaultFileRenamePolicy는 서버에 저장된 첨부파일 중복 되는 것 제거하기 위해서 (뒤에 숫자가 붙음)
		
		//첨부파일이 아닐 때
		//multi.getParameter("name");
		//<input type="text" /> 와 같은 경우
		
		//첨부파일의 경우
		//<input type="file" /> 일때는 getFilesystemName();
		String filepath = multi.getFilesystemName("filepath");
		PreviewDAO dao = PreviewDAO.getInstance();
		dao.insertMethod(filepath);
		
		resp.sendRedirect("previewList");
		
		
	}
}
