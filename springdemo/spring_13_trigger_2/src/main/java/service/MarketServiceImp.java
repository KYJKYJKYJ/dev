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
	public void salesInsertProcess(SalesDTO dto) throws Exception {
		int itemCnt = dao.itemCntSelectMethod(dto.getCode());
		System.out.println("재고:"+itemCnt);
		int saleCnt = dto.getSacnt();
		System.out.println("구매수량:"+saleCnt);
		
		if(itemCnt >= saleCnt) {
			int price = dao.salesSelectMethod(dto.getCode());
			dto.setSaprice(price*dto.getSacnt());
			dao.salesInsertMethod(dto);
		} else {
			throw new Exception("재고가 부족합니다.");
		}
	}

	@Override
	public List<ItemDTO> itemSelectProcess() {
		return dao.itemSelectMethod();
	}

	@Override
	public List<String> pnameSelectProcess() {
		return dao.pnameSelectMethod();
	}
}
