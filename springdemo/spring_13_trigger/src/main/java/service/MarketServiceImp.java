package service;

import java.util.List;

import dao.MarketDAO;
import dto.ItemDTO;
import dto.SalesDTO;
import dto.WarehouseDTO;

public class MarketServiceImp implements MarketService {
	private MarketDAO dao;
	
	public MarketServiceImp() {

	}
	
	public void setDao(MarketDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertProcess(WarehouseDTO dto) {
		dao.inputInsertMethod(dto);
		
	}

	@Override
	public void salesInsertProcess(SalesDTO dto) {
		int price = dao.salesSelectMethod(dto.getCode()); // 상품 코드에 해당하는 가격을 가져옴
		dto.setSaprice(price*dto.getSacnt()); // 팔린 갯수랑 곱해서 계산
		dao.salesInsertMethod(dto);		
	}
	
	@Override
	public List<ItemDTO> itemSelectProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemDTO> pnameSelectProcess() {
		return dao.pnameSelectMethod();
	}


}
