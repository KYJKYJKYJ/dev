package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProcess(BoardDTO dto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProcess(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
	
	
}
