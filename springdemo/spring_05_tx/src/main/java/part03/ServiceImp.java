package part03;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceImp implements Service{
	private MemDAO dao;
	

	public ServiceImp() {
	
	}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	

	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() {		
		/*dao.insertMethod(new MemDTO(57,"용팔이",50,"경기"));
		dao.insertMethod(new MemDTO(58,"유대위",20,"대전"));*/
		dao.insertMethod(new MemDTO(59,"용팔이",50,"경기"));
		dao.insertMethod(new MemDTO(59,"유대위",20,"대전"));
	}//end insertProcess()
	
}//end class










