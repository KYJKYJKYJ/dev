package java0927_abstract_interface;
/* 
 * -(private) +(public) *(protected)
 * class와 interface를 이용하여 성적처리
 * 클래스명 : User
 *  -name:String
 *  +User()
 *  +User(name:String)
 *  +toString():String
 *  
 *  인터페이스명 : Score
 *  +sol:int  (초기값:20)
 *  +getScore():int
 *  
 *  인터페이스명 : Print
 *  +toPaint():String
 *  
 *  클래스명 :UserTest에 위에서 정의한 클래스,인터페이스 상속받음
 *  [출력화면]
 *  이름 : 홍길동
 *  점수 : 60점
 */


class User {
	private String name;
	
	public User() { }
	public User(String name) { this.name = name; }
	public String toString() { return name; }
}

interface Score {
	public int sol = 20;
	
	public int getScore();
}

interface Print {
	public String toPaint();
}

class UserTest extends User implements Score, Print {	
	@Override
	public String toPaint() {
		return "이름 : " + toString() + "\n점수 : " + score;
	}

	@Override
	public int getScore() {
		return sol;
	}
	
	int score = getScore();
	
	UserTest() { }
	UserTest(String name, int score) {
		super(name);
		this.score *= score;
	}
		
}

public class Java107_interface {

	public static void main(String[] args) {
		// 실행시 주석해제
	
		 UserTest ut = new UserTest("홍길동", 3); 
		 System.out.println(ut.toPaint());
		 
		
	}// end main( )

}// end class
