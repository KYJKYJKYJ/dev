package java0920_access;

class MemberDAO {
	//2 객체를 static으로 생성
	private static MemberDAO dao = new MemberDAO(); // 외부에서도 선언할 수 있게 static으로 선언함
	
	//1 생성자의 접근제어자를 private로 선언
	private MemberDAO() {
		
	}
	
	//3 객체를 리턴해줄 메소드 정의
	public static MemberDAO getInstance() { // 외부에서도 선언할 수 있게 static으로 선언함 (static은 static 끼리)
		return dao;
	}
	
	public void display() {
		System.out.println("display");
	}
	
	//하나의 객체만을 생성해서 참조하는 방식 (Singleton)
}

public class Java090_singleton{

	public static void main(String[] args) {
		MemberDAO dp = MemberDAO.getInstance();
		dp.display();

	}

}
