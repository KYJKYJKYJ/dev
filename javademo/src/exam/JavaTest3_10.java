package exam;

abstract class Employee {
	private String name;
	private int number;
	private String department;
	private int salary;
	
	public Employee() {	}
	public Employee(String name, int number, String department, int salary) {	
		this.name = name; this.number = number; this.department = department; this.salary = salary;
	}
	
	abstract public double tax();
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getNumber() { return number; }
	public void setNumber(int number) { this.number = number; }
	public String getDepartment() { return department; }
	public void setDepartment(String department) { this.department = department; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
		
}

interface Bonus {
	public void incentive(int pay);
}

class Secretary extends Employee implements Bonus {
	public Secretary() { }
	public Secretary(String name, int number, String department, int salary) {
		super(name,number,department,salary);
	}
	
	@Override
	public double tax() {
		return (getSalary() * 0.1);
	}
	
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 0.8));
	}
}

class Sales extends Employee implements Bonus {
	public Sales() { }
	public Sales(String name, int number, String department, int salary) {
		super(name,number,department,salary);
	}
	
	@Override
	public double tax() {
		return (getSalary() * 0.13);
	}
	
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 1.2));
	}
}

public class JavaTest3_10 { //문제상 클래스 이름은 Company

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		
		Secretary sc = new Secretary("Hilery", 1, "secretary", 800);
		employees[0] = sc;
		
		Sales sl = new Sales("Clinten", 2, "sales", 1200);
		employees[1] = sl;
		
		System.out.println("name" + "\t" + "department" + "\t" + "salary");
		System.out.println("--------------------------------------------");
		for(int i = 0; i < employees.length; i++) {
			System.out.printf("%-10s %-10s %-10d\n", employees[i].getName(), 
					employees[i].getDepartment(), employees[i].getSalary());
		}
			
		System.out.println("\n" + "인센티브 100 지급");
		sc.incentive(100);
		sl.incentive(100);
		System.out.println("name" + "\t" + "department" + "\t" + "salary" + "\t" + "tax");
		System.out.println("--------------------------------------------");
		for(int i = 0; i < employees.length; i++) {
			System.out.printf("%-10s %-10s %-10d %-10.1f\n", employees[i].getName(), 
					employees[i].getDepartment(), employees[i].getSalary(), employees[i].tax());
		}

	}

}
