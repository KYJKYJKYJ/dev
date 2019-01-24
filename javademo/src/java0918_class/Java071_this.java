package java0918_class;
/*
 * this는 메모리에 생성된 자신을 의미함
 * this.멤버변수;
 * this.메소드();
 * this(); 생성자
 * 
 */

class Product {
	String code;
	String pname;
	int cnt;
	
	public Product() {
		
	}
	
	public Product(String code, String pname, int cnt) { //3
		//멤버변수와 매개변수의 이름이 같을 때 멤버변수에 this 키워드 명시
		this.code = code; //4
		this.pname = pname; //5
		this.cnt = cnt; //6
	}

	public void prn() { //9
		System.out.printf("%s %s %d\n", code, pname, cnt); //10
	} //11
	
	public void call() {
		//prn();
		this.prn();
	}
}

public class Java071_this {
	public static void main(String[] args) { //1
		Product pt = new Product("a001", "육류", 1); //2 
		pt.prn(); //8
	} //12
}
