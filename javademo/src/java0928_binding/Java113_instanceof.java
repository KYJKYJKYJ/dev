package java0928_binding;

//a instanceof A
//a객체가 A타입이면 true, 아니면 false

class ExamA {
	void prn() {
		
	}
}

class ExamB extends ExamA {
	void prn() {
		
	}
}

class ExamC extends ExamB {
	
}

public class Java113_instanceof {

	public static void main(String[] args) {
		ExamB bb = new ExamB();
		System.out.println(bb instanceof ExamA); //A를 상속한거라 true
		
		ExamA aa = new ExamA();
		System.out.println(aa instanceof ExamB);
		
		ExamA ea = new ExamB();
		System.out.println(ea instanceof ExamA); //실제로 가르키는게 ExamA라서 true
		System.out.println(ea instanceof ExamB);
		System.out.println(ea instanceof ExamC); //B보다 하위클래스라서 false
	}

}
