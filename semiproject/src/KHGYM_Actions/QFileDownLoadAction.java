package KHGYM_Actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QBoardDAO;

public class QFileDownLoadAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		int num = Integer.parseInt(req.getParameter("q_num"));
		QBoardDAO dao = QBoardDAO.getInstance();
		String filename = dao.fileMethod(num);

		try {
			// 파일명 한글처리
			String convName = URLEncoder.encode(filename, "UTF-8");
			/*공백이 있는 파일명 같은 경우 +로 이어지는데 아래 문장을 통해 공백 처리가 된다.*/
			convName = convName.replace("+", " ");

			// 컨텐트 타입 주의!!!
			resp.setContentType("application/octet-stream");

			// 다운로드 파일명 주의!! 
			resp.setHeader("Content-Disposition", "attachment;filename=" + convName + ";");

			File file = new File("c:/temp/", filename);

			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bs = new BufferedInputStream(is);
			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());

			byte buffer[] = new byte[1024];
			int len = 0;
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
