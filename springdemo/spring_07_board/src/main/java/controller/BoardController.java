package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

// http://localhost:8090/board/list.sb

@Controller
public class BoardController {
	private BoardService service;
	private int currentPage;
	private PageDTO pdto;
	
	public BoardController() {
	
	}
	
	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping("/list.sb")
	public ModelAndView listMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countProcess();
		if(totalRecord >= 1) {
			if(pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			pdto = new PageDTO(currentPage, totalRecord);
			mav.addObject("pv", pdto);
			mav.addObject("aList", service.listProcess(pdto));
		}
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.contentProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/view");
		return mav;
	}
	
	@RequestMapping(value = "/write.sb", method=RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv, BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		if(dto.getRef() != 0) {
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto", dto);
		}
		mav.setViewName("board/write");
		return mav;
	}
	
	@RequestMapping(value = "/write.sb", method=RequestMethod.POST)
	public String writeProMethod(BoardDTO dto, HttpServletRequest request) {
		  // multipart/form-data를 처리해야한다.///////////////
	      // MultipartFile 타입의 filename을 
	      // String 타입의 upload에 넣어줘야 한다.
		
		MultipartFile file = dto.getFilename();
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			//중복파일명 처리를 위해 난수
			UUID random = UUID.randomUUID();
			
			//경로값 가져오기
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println(root);
			
			//root + "temp/"
			String saveDirectory = root + "temp" + File.separator;
			File fe = new File(saveDirectory); // saveDirectory 인 temp가 존재하지 않으면 만들어라!
			if(!fe.exists())
				fe.mkdir();
			
			File ff = new File(saveDirectory, random + "_" + fileName); // 저장할 경로, 파일명 생성하여 저장
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			} // 파일 정보를 읽어와서 ff를 통해 저장해라
			
			dto.setUpload(random + "_" + fileName); //dto로 지정한 파일명대로 보내주어야 데이터베이스에 반영됨
		}
		
		// 아이피 주소를 받을 때 request 사용함
		dto.setIp(request.getRemoteAddr());
		
		// 답변글
		if(dto.getRef() != 0) {
			service.reStepProcess(dto);
		} else { // 제목글
			service.insertProcess(dto);
		}
		
		return "redirect:/list.sb";
	}
}
