package boarddemo.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boarddemo.dao.BoardDAO;
import boraddemo.dto.BoardDTO;

public class WriteAction {
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse resp) {
		MultipartRequest multi = null;
		/*String path = req.getServletContext().getRealPath("/");
		//이 경로에 파일을 저장하게 하는것이 서로 동일하게 작업할수 있게함, 직접적인 폴더 경로 설정해서 하는 것은 적절하지 않음
		System.out.println("path : " + path);		
		String saveDirectory = path + "/temp";*/
		
		String path = req.getServletContext().getRealPath("/");
		//이 경로에 파일을 저장하게 하는것이 서로 동일하게 작업할수 있게함, 직접적인 폴더 경로 설정해서 하는 것은 적절하지 않음
		System.out.println("path : " + path);		
		String saveDirectory = path + "/temp";
		
		//아래와 같이 c:/temp 처럼 직접 경로를 설정해서 하는 건 옳지않음
		//String saveDirectory = "c:/temp";
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		
		int maxPostSize = 1000000000; //1gb
		String encoding = "UTF-8";
		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());				
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(multi.getParameter("writer"));
		dto.setEmail(multi.getParameter("email"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));
		dto.setUpload(multi.getFilesystemName("upload")); //첨부파일만 getFileSystemName
		dto.setIp(req.getRemoteAddr()); // 현재 ip 주소 받기
		
		//답변 글일 경우
		if(multi.getParameter("re_level") != null) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("ref", Integer.parseInt(multi.getParameter("ref")));
			map.put("re_step", Integer.parseInt(multi.getParameter("re_step")));
			
			dao.reStepMethod(map);
			dto.setRef(Integer.parseInt(multi.getParameter("ref")));
			dto.setRe_step(Integer.parseInt(multi.getParameter("re_step"))+1);
			dto.setRe_level(Integer.parseInt(multi.getParameter("re_level"))+1);
		//답변글 저장하기 위해 값을 가져옴
		}
		
		dao.insertMethod(dto);
		
		return multi;
	}
}
