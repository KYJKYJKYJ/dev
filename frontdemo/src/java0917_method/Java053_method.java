package java0917_method;

// 회원, 포인트 적립

public class Java053_method {

	public static void process(String name, boolean chk) { //3
		if(chk) { //4
			System.out.println(name + "님은 회원입니다."); //5
		} else { //6
			System.out.println(name + "님은 비회원입니다.");
		}
	} //7
	
	public static void test(int point) { //9
		System.out.println(point+"가 적립되었습니다."); //10
	} //11
	
	public static void main(String[] args) { //1
		/*boolean chkaccount = false;
		String name = "홍길동";
		
		if(name == "홍길동") {
			chkaccount = true;
		} else { 
			chkaccount = false;
		}*/
				
		// 메소드 호출시 매개변수에 정의된 데이터타입과 일치하는 값을 넘겨주어야함 
		/*if(chkaccount) {
			process(name, chkaccount);
			test(3000);
		} else {
			process(name, chkaccount);
		}*/
		
		process("홍길동", true); //2
		test(3000); //8
	} //12

}
