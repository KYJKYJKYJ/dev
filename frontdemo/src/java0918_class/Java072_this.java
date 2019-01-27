package java0918_class;

class Employees {
	String name;
	String dept;
	int salary;
	
	public Employees() {
		this("홍길동", "보류", 3000);
	}
	
	public Employees(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	public void prn() {
		System.out.printf("%s %s  %d\n", name, dept, salary);
	}
}

public class Java072_this {

	public static void main(String[] args) {
		Employees emp = new Employees("용팔이", "기획", 5000);
		Employees emp2 = new Employees();
		emp.prn();
		emp2.prn();
	}

}
