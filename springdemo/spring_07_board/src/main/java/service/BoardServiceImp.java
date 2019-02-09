package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService{
	private BoardDAO dao;

	public BoardServiceImp() {

	}
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		dao.save(dto);		
	}

	@Override
	public BoardDTO contentProcess(int num) {
		dao.readCount(num);
		return dao.content(num);
	}
	
	//답변 글 , reStepCount, save 두 가지 사용
	@Override
	public void reStepProcess(BoardDTO dto) {
		dao.reStepCount(dto);
		dto.setRe_step(dto.getRe_step() + 1); // 답변글 이니 하나씩 증가
		dto.setRe_level(dto.getRe_level() + 1); // 답변글 이니 하나씩 증가
		dao.save(dto);		
	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		return dao.updateNum(num);
	}

	@Override
	public void updateProcess(BoardDTO dto, HttpServletRequest request) {
		MultipartFile file = dto.getFilename();
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			//중복파일명 처리를 위해 난수
			UUID random = UUID.randomUUID();
			
			//경로값 가져오기
			String root = request.getSession().getServletContext().getRealPath("/");
			
			//root + "temp/"
			String saveDirectory = root + "temp" + File.separator; // /, \ 를 구분해주는 separator
			File fe = new File(saveDirectory); // saveDirectory 인 temp가 존재하지 않으면 만들어라!
			if(!fe.exists())
				fe.mkdir();
			
			File ff = new File(saveDirectory, random + "_" + fileName); // 저장할 경로, 파일명 생성하여 저장
			
			try {
				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(ff));
			} catch (IOException e) {
				e.printStackTrace();
			} // 파일 정보를 읽어와서 ff를 통해 저장해라
			
			if(fileName != null) {
				File oldFile = new File(saveDirectory, dao.getFile(dto.getNum()));
				//board 테이블에 첨부파일을 삭제함
				oldFile.delete();
				dto.setUpload(random + "_" + fileName); //dto로 지정한 파일명대로 보내주어야 데이터베이스에 반영됨
			} else {
				dto.setUpload(dao.getFile(dto.getNum()));
			}
			
		}
		
		dto.setSubject(dto.getSubject());
		dto.setEmail(dto.getEmail());
		dto.setContent(dto.getContent());
		dto.setNum(dto.getNum());
		dto.setIp(request.getRemoteAddr());
		dao.update(dto);
		
	}
	
	@Override
	public void deleteProcess(int num, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("/");
		String saveDirectory = root + "temp" + File.separator;
		if(dao.getFile(num) != null) {
			File oldFile = new File(saveDirectory, dao.getFile(num));
			oldFile.delete();
		}
		dao.delete(num);
		
	}
	
	
}
