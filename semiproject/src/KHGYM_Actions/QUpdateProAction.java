package KHGYM_Actions;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.QBoardDAO;
import DTO.QBoardDTO;

public class QUpdateProAction {
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse resp) {
		MultipartRequest multi = null;

		String saveDirectory = "c:/temp";

		File file = new File(saveDirectory);

		/* 파일이 존재하니? */
		/* 존재하지 않을 때 true가 되게끔해서 생성 */
		if (!file.exists())
			file.mkdir();

		int maxPostSize = 1000000000; // 1GB
		String encoding = "UTF-8";
		/* 첨부파일의 중복메소드를 제거하기위해서 사용하는게 new DefaultFileRenamePolicy() */
		try {
			/* 저장위치, 저장공간크기, encoding 형태, 중복메소드 제거 */
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}

		QBoardDTO dto = new QBoardDTO();
		QBoardDAO dao = QBoardDAO.getInstance();
		int num = Integer.parseInt(multi.getParameter("q_num"));
		// board 테이블에 첨부파일의 저장여부 검색
		String filename = dao.fileMethod(num);

		// 수정 첨부파일이 있으면
		if (multi.getFilesystemName("upload") != null) {
			// 기존 첨부파일이 있으면
			if (filename != null) {
				// board 테이블의 첨부파일을 삭제
				File oldfile = new File(saveDirectory, filename);
				oldfile.delete();
			}
			
			dto.setQ_upload(multi.getFilesystemName("q_upload"));
		} else {
			// 수정 첨부파일이 없으면
			if(filename != null) {
				dto.setQ_upload(filename);
			}
		}
		
		dto.setQ_subject(multi.getParameter("q_subject"));
		dto.setQ_content(multi.getParameter("q_content"));
		dto.setQ_num(Integer.parseInt(multi.getParameter("q_num")));
		
		dao.updateMethod(dto);
		return multi;
	}// end execute()
}// end class
