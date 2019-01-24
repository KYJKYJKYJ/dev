package KHGYM_Actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewBoardDAO;

public class Review_FileDownLoadAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		String filename = dao.file(num);

		try {
			// 파일명 한글처리
			String convName = URLEncoder.encode(filename, "UTF-8");
			convName = convName.replace("+", " "); // 이부분 주석시 파일명 공백이 +

			// 컨텐트 타입 **
			resp.setContentType("application/octet-stream");

			// 다운로드 파일명 (객체에서 받아오는 것, 정해져 있는 방법임 Content-Disposition, attachment;filename)
			// **
			resp.setHeader("Content-Disposition", "attachment;filename=" + convName + ";");

			// 파일 내용 받아옴
			
			String path = req.getServletContext().getRealPath("/");
			//이 경로에 파일을 저장하게 하는것이 서로 동일하게 작업할수 있게함, 직접적인 폴더 경로 설정해서 하는 것은 적절하지 않음
			//System.out.println("path : " + path);		
			String saveDirectory = path + "/temp";
			
			File file = new File(saveDirectory, filename);

			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bs = new BufferedInputStream(is);

			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());

			byte buffer[] = new byte[1024];
			int len = 0;
			// 읽어올 내용이 있으면 write하고 flush
			while ((len = bs.read(buffer)) > 0) {
				bo.write(buffer, 0, len);
				bo.flush();
			}

			bs.close();
			is.close();
			bo.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end execute()

}// end class
