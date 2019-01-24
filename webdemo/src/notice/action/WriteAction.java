package notice.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.dao.NoticeDAO;
import notice.dto.NoticeDTO;


public class WriteAction {
	
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse res) {
		//첨부파일이 있기 때문에 필요
		MultipartRequest multi = null;
		//저장되는 위치 실제 url을 가져와서
		//String path=req.getServletContext().getRealPath("/");
		//String path=req.getServletContext().getContextPath();///webdemo
		//System.out.println("path:"+path);
		//String saveDirectory = path+"/temp";
		
		//MultipartRequest에 필요한 값 준비
		String saveDirectory = "c:/temp"; //저장장소
		File file = new File(saveDirectory);
		if(!file.exists())//파일이 존재하지 않으면
			file.mkdir(); //파일생성, 패키지가 여러개이면 mkdirs로 생성
		int maxPostSize = 1000000000;
		String encoding = "UTF-8";
		
		try {
			//리퀘스트, 첨부파일저장장소, 최대크기, 한글인코딩, 중복명제거(서버에 이미 존재되는 파일명이 있는 경우 번호를 붙여서 구분)
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//제목글+답변글 공통 처리하는 부분----------------------------------------------------------------------------------
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeDTO dto = new NoticeDTO();
		
		//첨부파일을 제외한 파라미터의 값을 받을때는 getParameter
		//첨부파일의 파라미터 값을 받을때는 getFilesystemName
		//ip는 req.getRemoteAddr()
		dto.setUser_id("관리자");
		dto.setNotice_title(multi.getParameter("title"));
		dto.setNotice_contents(multi.getParameter("content"));
		dto.setNotice_upload(multi.getFilesystemName("fileName")); //첨부파일을 가지고 올때는 getFilesystemName를 사용해야 한다.
		dto.setIp(req.getRemoteAddr()); //클라이언트의 ip주소값 처리, 클라이언트가 입력하는 것이 아니라 자동으로 처리가 된다.
		
		//-----------------------------------------------------------------------------------------------

		//-----------------------------------------------------------------------------------------------
		//각각의 경우를 처리한후 필요한 값들을 insert
		dao.insertMethod(dto);
		return multi;	
		
	}//end execute()//////////////////////////////////////////////
	
}
