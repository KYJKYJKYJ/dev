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

import DAO.NoticeDAO;

public class Notice_FileDownLoadAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int num = Integer.parseInt(req.getParameter("notice_num"));
		//System.out.println(num);
		NoticeDAO dao= NoticeDAO.getInstance();
		String filename=dao.fileMethod(num);
		
		try {
			//파일명 한글처리
			String convName=URLEncoder.encode(filename,"UTF-8");
			convName=convName.replace("+", " "); //첨부파일명중 공백이 +로 나오게 됨, 공백은 공백으로 나오도록 해주기 위한 작업
			
			//컨텐트 타입
			resp.setContentType("application/octet-stream"); //첨부파일이 뜨게 하기위해서는 컨텐트 타입을 이렇게 잡아 주어야 한다.
			
			//다운로드 파일명
			resp.setHeader("Content-Disposition",
					   "attachment;filename="+convName+";"); //다운로드 파일명을 띄워줄때는 setHeader라는 메소드를 사용해서 넘겨줌, attachment;filename는 정해져있는 부분(오타없이 정확히 입력되어 있어야 함)
			
			File file=new File("c:/temp/",filename);
			
			FileInputStream is=new FileInputStream(file); //파일에 있는 내용을 읽어와야 하기 때문에 Stream
			
			//서버에서는 읽어오고 클라이언트에는 써줄때 필요한 입출력 스트림
			BufferedInputStream bs = new BufferedInputStream(is);
			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());
			
			//저장되어 있는 크기만큼 읽어옴
			byte buffer[]=new byte[1024];
			int len=0;
			while((len=bs.read(buffer))>0) {
				bo.write(buffer,0,len);
				bo.flush();
			}
			
			//다 읽어오면 닫아주기
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
		
	}
}
