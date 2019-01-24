package KHGYM_Actions;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.NoticeDAO;
import DTO.NoticeDTO;

public class Notice_UpdateProAction {
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse resp) {
		MultipartRequest multi = null;
		
		String saveDirectory = "c:/temp";
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		int maxPostSize = 1000000000;
		String encoding = "UTF-8";
		
		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NoticeDTO dto = new NoticeDTO();
		NoticeDAO dao = NoticeDAO.getInstance();
		int num = Integer.parseInt(multi.getParameter("num"));
		
		String filename = dao.fileMethod(num);
		
		if(multi.getFilesystemName("notice_upload") != null) {
			//서버에 있는 기존 첨부파일을 삭제해 주어야 한다.
			//기존 첨부파일이 있으면
			if(filename != null) {
				//board 테이블의 첨부파일을 삭제
				File oldFile = new File(saveDirectory, filename);
				oldFile.delete(); //saveDirectory에 있는 filename의 첨부파일이 삭제가 됨
			}
			
			//기존의 첨부파일이 없는 경우에도 새로운 첨부파일을 넣어주어야함
			//새로운 첨부파일을 넣어줌
			dto.setNotice_upload(multi.getFilesystemName("notice_upload"));
			
		}else {
			//수정 첨부파일이 없으면 (새로운 첨부파일이 없으면)
			//기존의 첨부파일 값을 위에서 무조건 한번 가지고 오도록 되어 있으므로 다시 넣어주는 형태로 수행
			if(filename != null) { //기존 첨부파일이 있으면
				dto.setNotice_upload(filename);
			}
		}
		
		dto.setNotice_title(multi.getParameter("title"));
		dto.setNotice_contents(multi.getParameter("content"));
		dto.setIp(req.getRemoteAddr()); //클라이언트의 ip주소값 처리, 클라이언트가 입력하는 것이 아니라 자동으로 처리가 된다.
		dto.setNotice_num(Integer.parseInt(multi.getParameter("num")));

		//각각의 경우를 처리한후 필요한 값들을 update
		dao.updateMethod(dto);
		
		
		
		return multi;
	}
}
