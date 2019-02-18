package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.ReplyDTO;
import service.BoardService;

//http://localhost:8090/mycomment/boardList.do

@Controller
public class BoardController {
	private BoardService service;
	private String path;

	public BoardController() {

	}
	
	public void setService(BoardService service) {
		this.service = service;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@RequestMapping("/boardList.do")
	public ModelAndView boardListPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.boardListProcess());
		
		mav.setViewName("boardList");
		return mav;
	}// end boardListPage()	
	
	
	@RequestMapping("/boardView.do")
	public ModelAndView boardViewPage(int bno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", service.boardViewProcess(bno));
		
		//mav.setViewName("boardView");
		//mav.setViewName("boardView2");
		mav.setViewName("boardView3");
		return mav;
	}
	
	//<mvc:annotation-driven/>
	@RequestMapping("/replyInsertList.do")
	public @ResponseBody List<ReplyDTO> replyListPage(ReplyDTO rdto, HttpServletRequest request) {
		//System.out.println("replyListPage");
		//파일명 받기
		MultipartFile file = rdto.getFilename();
		
		//파일명 통해 파일정보 받기
		if(file != null) { //isEmpty는 참조 주소는 있는 상태라서 null값이 아닌 0값이랑 비슷한듯
			String fileName = file.getOriginalFilename();
			
			//경로값 가져오기
			//String root = request.getSession().getServletContext().getRealPath("/");
			//System.out.println(root);
			
			//root + "path/"
			String saveDirectory = path;
			File fe = new File(saveDirectory); // path가 존재하지 않으면 만들어라!
			if(!fe.exists())
				fe.mkdir();
			
			//중복제거 위한 난수값을 붙여서 DB에 저장
			UUID random = UUID.randomUUID();
			
			File ff = new File(saveDirectory, random + "_" + fileName); // 저장할 경로, 파일명 생성하여 저장
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			} // 파일 정보를 읽어와서 ff를 통해 저장해라
			
			rdto.setRupload(random + "_" + fileName);
		}
		return service.replyListProcess(rdto);
	}
	
	@RequestMapping("/replyDelete.do")
	public @ResponseBody List<ReplyDTO> replyDeleteListPage(ReplyDTO rdto) {
		/*String saveDirectory = path;
		if( ) != null) {
			File oldFile = new File(saveDirectory, );
			oldFile.delete();
		}*/
		return service.replyDeleteProcess(rdto);
	}
	
	@RequestMapping("/replyUpdate.do")
	public @ResponseBody List<ReplyDTO> replyUpdateListPage(ReplyDTO rdto) {
		return service.replyUpdateProcess(rdto);
	}
	
}//end class














