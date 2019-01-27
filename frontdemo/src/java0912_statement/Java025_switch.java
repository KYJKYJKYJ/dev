package java0912_statement;

public class Java025_switch {

	public static void main(String[] args) {
		/*
		 * switch(식) {
		 * 	case (식의 결과값 (정수,문자)) :
		 * 	행하는 문장;
		 * 	break;
		 * 
		 * 	case (...) :
		 * 	행하는 문장;
		 * 	break; // 조건문을 빠져나와 다음 문장 수행
		 * 
		 * 	default :
		 * 	행하는 문장;
		 * }
		 * 
		 * 식의 결과값 타입 : byte, short, int, char, enum(jdk7), String(jdk7)
		 * 
		 */
		
		int jumsu = 82;
		char res;
		
		if(jumsu > 100) { res = 'A'; System.out.println(res + "등급"); return;}
		
		switch(jumsu / 10) {
			case (10) : case (9) :
				res = 'A';
				System.out.println(res + "등급");
			break;
			
			case (8) :
				res = 'B';
				System.out.println(res + "등급");
			break;
			
			case (7) :
				res = 'C';
				System.out.println(res + "등급");
			break;
			
			case (6) :
				res = 'D';
				System.out.println(res + "등급");
			break;
			
			default :
				res = 'F';
				System.out.println(res + "등급");
		}
		
	}

}
