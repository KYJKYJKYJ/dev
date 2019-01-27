package homework_answ;

/*
로봇만들기 답안

[문제]
로봇을 조립합니다.
인터페이스를 이용해 Arm 클래스를 구현하세요.
나머지 Leg, Body, Head 클래스를 상속, 인터페이스를 이용하여 구현하세요.
각 결합이 전부 되면 로봇 완성! 하나라도 빠지면 로봇 미완성! 출력문이 나오게 구현하세요.
[주석을 제거하고 상속문을 이용하세요] 

[출력결과]
팔 부분이 결합되었습니다.
다리 부분이 결합되었습니다.
몸통 부분이 결합되었습니다.
머리 부분이 결합되었습니다.
로봇 완성!

or

팔 부분이 없습니다.
다리 부분이 결합되었습니다.
몸통 부분이 결합되었습니다.
머리 부분이 결합되었습니다.
로봇 미완성!

*/
  
interface checkSystem {
	String Check();
}

class Arm implements checkSystem {
	String armCheck = "O";
	String arm = "팔";
	
	Arm() {
		
	}
	
	@Override
	public String Check() {
		if(armCheck == "O") {
			return arm + " 부분이 결합되었습니다.";
		} else {
			return arm + " 부분이 없습니다.";
		}
	}
}

class Leg extends Arm {
	String legCheck = "O";
	String leg = "다리";
	
	Leg() {
		
	}
	
	@Override
	public String Check() {
		if(legCheck == "O") {
			return leg + " 부분이 결합되었습니다.";
		} else {
			return leg + "부분이 없습니다.";
		}
	}
}

class Body extends Leg {
	String bodyCheck = "O";
	String body = "몸통";
	
	Body() {
		
	}
	
	@Override
	public String Check() {
		if(bodyCheck == "O") {
			return body + " 부분이 결합되었습니다.";
		} else {
			return body + " 부분이 없습니다.";
		}
	}
}

class Head extends Body {
	String headCheck = "O";
	String head = "머리";
	
	Head() {
		
	}
	
	@Override
	public String Check() {
		if(headCheck == "O") {
			return head + " 부분이 결합되었습니다.";
		} else {
			return head + " 부분이 없습니다.";
		}
	}
	
}

class Robot extends Head {
	Robot() {
		
	}
	
	@Override
	public String Check() {
		if(armCheck == "O" && legCheck == "O" && bodyCheck == "O" && headCheck == "O") {
			return "로봇 완성!";
		} else { 
			return "로봇 미완성!";
		}
	}
}



public class Make_Robot_answ extends Head {

	public static void main(String[] args) {
		Arm a = new Arm();
		Leg l = new Leg();
		Body b = new Body();
		Head h = new Head();
		Robot r = new Robot();
		
		System.out.println(a.Check());
		System.out.println(l.Check());
		System.out.println(b.Check());
		System.out.println(h.Check());
		System.out.println(r.Check());
		

	}

}
