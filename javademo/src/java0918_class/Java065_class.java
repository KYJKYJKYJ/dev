package java0918_class;

public class Java065_class {
	
	public static void main(String[] args) {
		Person ps;
		ps = new Person();
		
		ps.name = "홍길동";
		ps.age = 25;
		ps.gen = 'M';
		
		System.out.printf("%d, %c, %s\n", ps.age, ps.gen, ps.name);
		ps.eat();
		ps.run();
		
		Person pn = new Person(); // 힙 영역에 메모리 확보
		pn.name = "이영희";
		pn.age = 25;
		pn.gen = 'W';
		
		System.out.printf("%d, %c, %s\n", pn.age, pn.gen, pn.name);
		pn.eat();
		pn.run();
	}

}


