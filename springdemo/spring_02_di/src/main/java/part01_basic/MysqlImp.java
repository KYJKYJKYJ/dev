package part01_basic;

public class MysqlImp implements Service {

	//인자값이 없는 생성자가 객체 생성에 권유되므로 인자값이 없어야함에 유의
	public MysqlImp() {
		System.out.println("Mysql constructor");
	}
	
	@Override
	public void prn() {
		System.out.println("mysql prn");
	}
	
}
