package java0921_inheritance;

class Universe {
	String name;
	int age;
	
	public Universe() {
		
	}
	
	public Universe(String name, int age) { //5
		this.name = name; //6
		this.age = age; //7
	} //8
}

class Sun extends Universe {
	String dept;
	public Sun() { }
	public Sun(String name, int age, String dept) { //3
		//////////////////////////////
		super(name, age); //4
		this.dept = dept; //9
		//////////////////////////////
	} //10
	
	public void prn() { //12
		System.out.printf("%s %d %s\n", name, age, dept); //13
	} //14
}

public class Java095_inheritance {

	public static void main(String[] args) { // 1
		Sun ss = new Sun("안드로메다", 50, "은하계"); //2
		ss.prn(); //11
	} // 15

}
