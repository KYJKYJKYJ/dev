package KHGYM_Actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.QBoardDAO;
import DTO.QBoardDTO;

public class QWriteAction {
	 public MultipartRequest execute(HttpServletRequest req, HttpServletResponse res) {
		 try {
			 req.setCharacterEncoding("UTF-8");
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	      MultipartRequest multi=null;
	      /*String path=req.getServletContext().getRealPath("/");
	      
	      System.out.println("path:"+path);
	      String saveDirectory=path+"/temp"; */
	      
	      
	      String saveDirectory = "c:/temp";
	      
	      File file=new File(saveDirectory);
	      if(!file.exists()) {//c:/에 temp폴더가 없다면...
	         file.mkdir();
	      }
	      int maxPostSize = 1000000000;//1GB
	      String encoding = "UTF-8";
	      try {
	         multi=new MultipartRequest(req,saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		QBoardDAO dao = QBoardDAO.getInstance();
		QBoardDTO dto = new QBoardDTO();
		dto.setQ_writer(multi.getParameter("q_writer"));
		dto.setQ_subject(multi.getParameter("q_subject"));
		dto.setQ_content(multi.getParameter("q_content"));
	      dto.setQ_upload(multi.getFilesystemName("q_upload"));
	      dto.setQ_ip(req.getRemoteAddr());//ip주소를 받아온다.
		/*제목글, 답변글 이 부분은 똑같다, 단 답변글일때는 ref, re_level, re_step 값을처리.*/
		
		/*답변글이면..*/
		/*얘는 그냥 dto에 넣어주면된다.*/
		/*re_step, re_level은 +1한 값을 넣어준다.*/
		if(multi.getParameter("q_re_level") != null) {
			/*답변글인 경우 insertMethod() 하기 전에 reStepMethod()을 해줘야 한다.*/
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			/*가장최근에 입력한 답변을 가장최근에 출력하기위해 하는 작업*/
			map.put("q_ref", Integer.parseInt(multi.getParameter("q_ref")));
			map.put("q_re_step", Integer.parseInt(multi.getParameter("q_re_step")));
			map.put("q_re_level", Integer.parseInt(multi.getParameter("q_re_level")));
			dao.reStepMethod(map);
			
			dto.setQ_ref(Integer.parseInt(multi.getParameter("q_ref")));
			dto.setQ_re_step(Integer.parseInt(multi.getParameter("q_re_step"))+1);
			dto.setQ_re_level(Integer.parseInt(multi.getParameter("q_re_level"))+1);
		}
		
		/*답변글을 저장하기 위해 하는 작업*/
		dao.insertMethod(dto);
		
		return multi;
	}// end execute()
}// end class
