package part01;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceImp implements Service {
	private MemDAO dao;
	private TransactionTemplate transactionTemplate;
	
	public ServiceImp() {

	}
	
	public void setDao(MemDAO dao) {
		this.dao = dao;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void insertProcess() {
		/*dao.insertMethod(new MemDTO(50, "용팔이", 50, "경기"));
		dao.insertMethod(new MemDTO(51, "유대위", 20, "대전"));*/
		
		/*dao.insertMethod(new MemDTO(52, "용팔이", 50, "경기"));
		//같은 트랜젝션으로 설정해서 아래거에 문제가 생기면 위에것도 취소되게 해야함(현재는 위에 값만 저장이 됨)
		dao.insertMethod(new MemDTO(52, "유대위", 20, "대전"));*/
		
		//같은 트랜젝션 설정
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					/*dao.insertMethod(new MemDTO(53, "용팔이", 50, "경기"));
					dao.insertMethod(new MemDTO(54, "유대위", 20, "대전"));*/
					dao.insertMethod(new MemDTO(55, "용팔이", 50, "경기"));
					dao.insertMethod(new MemDTO(55, "유대위", 20, "대전"));
					return "ok";
				} catch(Exception ex) {
					status.setRollbackOnly(); //취소
					return ex.toString();
				}
			}
		});
		
		System.out.println("result: "+result+"//end result");
	}

}
