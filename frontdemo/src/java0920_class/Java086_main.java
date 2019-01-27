package java0920_class;

public class Java086_main {

	public static void main(String[] args) { // Run as > configurations > Main class 잡아준 후 > tab에 Argument
		/*System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);*/
		
		//main 메소드의 매개변수 값을 받아서 처리함
		
		for(String data : args) {
			System.out.println(data);
		}
		
	}

}
