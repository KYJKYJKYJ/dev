package java0921_inheritance.prob;

/*
 * [주의]테스트를 할때 main( )메소드의 주석을 해제하세요.
 * 
  [main메소드와 Human클래스는 수정하지 마세요]
 1 Human 클래스를 상속 받은 StudentExam 클래스를 구현하시오.
 2 3개의 StudentExam 객체를 생성 하여 배열에 셋팅 한 후 각각의 
   객체의 나이, 신장 출력 한다.

 [출력결과]
 name	나이	신장	 몸무게	학번
 홍길동	15	171	 81	   201101
 정길동	13	183	 72	   201102
 박길동	16	175	 65	   201103
 */

class Human {
	String name;
	int age;
	int height;
	int weight;

	Human() {
	}

	Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String toString() {
		String data = name + "\t" + age + "\t" + height + "\t" + weight;
		return data;
	}
}//end Human

//자손클래스를 여기에 구현하시오.
class StudentExam extends Human {
	String sc_num;
	
	StudentExam() {
		
	}
	
	StudentExam(String name, int age, int height, int weight, String sc_num) {
		super(name, age, height, weight);
		this.sc_num = sc_num; 
	}
	
	@Override
	public String toString() {
		String data = name + "\t" + age + "\t" + height + "\t" + weight+ "\t" + sc_num;
		return data;
	}
}

public class Prob02_inheritance {
	public static void main(String args[]) {
		//테스트를 할때 아래 주석을 해제하세요.
		
		
		StudentExam se[]=new StudentExam[3];
		se[0]=new StudentExam("홍길동",15,171, 81, "201101");
		se[1]=new StudentExam("정길동",13,183, 72, "201102");
		se[2]=new StudentExam("박길동",16,175, 65, "201103");
		
		System.out.printf("%4s %5s %8s %8s %8s\n","name","나이","신장","몸무게","학번");
		
		for(StudentExam sm : se)
		System.out.println(sm.toString());
		
	}//end main()
}//end class






