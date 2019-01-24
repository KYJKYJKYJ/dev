package java0918_class;

/*
 * 도서관리 프로그램
 * 
 * 제목, 대출여부
 * 
 * [객체 모델링]
 * 특징 : 제목, 대출여부
 * 기능 : 대출여부 처리
 */

class Library {
	String title;
	boolean borrowchk;
	
	String process() {
		if(borrowchk) {
			return "대출 가능";
		} else {
			return "대출 중";
		}
	}
}


public class Java066_class {
	
	public static void main(String[] args) {
	
		Library Lib1 = new Library();
		
		Lib1.title = "칼의 노래";
		Lib1.borrowchk = false;
		
		Library Lib2 = new Library();
		
		Lib2.title = "어두운 상점의 거리";
		Lib2.borrowchk = true;

		System.out.printf("%s %s\n", Lib1.title, Lib1.process());
		System.out.printf("%s %s\n", Lib2.title, Lib2.process() );
	}

}
