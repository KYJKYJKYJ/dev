package java0928_binding.prob;
/*
 * [데이타]
 * 이름       부서     구분        급여          수당         근무일         일당
 * 홍길동    영업부   정직원        450000      1000
 * 갑동이    기획부   계약직                                    20     10000
 * 
 * [출력결과]
 * 홍길동  총급여  451000
 * 갑동이  총급여  200000
 * 
 * 위의 [데이타]를 참조하여 [출력결과]가 나오도록 프로그램을 구현하세요.
 */

abstract class Worker {
	private String name;
	private String dept;
	private String divide;
	private int salary;
	private int allowance;
	private int workday;
	private int dailypay;
	
	Worker() { }
	Worker(String name, String dept, String salary) {
		this.name = name;
		this.name = dept;
		this.name = salary;
	}
	
	protected String getName() { return name; }
	protected String getDept() { return dept; }
	protected String getDivide() { return divide; }
	protected int getSalary() { return salary; }
	protected void setSalary(int salary) { this.salary = salary; }
	protected int getAllowance() { return allowance; }
	protected void setAllowance(int allowance) { this.allowance = allowance; }
	protected int getWorkday() { return workday; }
	protected void setWorkday(int workday) { this.workday = workday; }
	protected int getDailypay() { return dailypay; }
	protected void setDailypay(int dailypay) { this.dailypay = dailypay; }

	abstract int Cal_pay();
	abstract public String toString();
}

class Full_Time extends Worker {
	Full_Time() { }
	Full_Time(String name, String dept, String divide, int salary, int allowance) {
		super(name, dept, divide);
		setSalary(salary);
		setAllowance(allowance);
	}
	
	@Override
	int Cal_pay() {
		int fullTime_Pay = getSalary() + getAllowance();
		return fullTime_Pay;
	}
	
	@Override
	public String toString() {
		return getName() + " 총 급여 " + Cal_pay();
	}
}

class Part_Time extends Worker {
	Part_Time() { }
	Part_Time(String name, String dept, String divide, int workday, int dailypay) {
		super(name, dept, divide);
		setWorkday(workday);
		setDailypay(dailypay);	
	}
	
	@Override
	int Cal_pay() {
		int partTime_Pay = (getWorkday() * getDailypay());
		return partTime_Pay;
	}
	
	@Override
	public String toString() {
		return getName() + " 총 급여 " + Cal_pay();
	}
	
}

public class Prob003_binding {

	public static void main(String[] args) {
		Worker[] w = new Worker[] { new Full_Time("홍길동", "영업부", "정직원", 450000, 1000),
									new Part_Time("갑동이", "기획부", "계약직", 20, 10000) };
		
		for(int i = 0; i < w.length; i++) {
			System.out.println(w[i].toString());
		}

	}//end main()

}//end class
