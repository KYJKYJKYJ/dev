package java0928_binding.answ;
/*
 * [데이타]
 * 이름       부서     구분        급여          수당         근무일         일당
 * 홍길동    영업부   정직원   450000  1000
 * 갑동이    기획부   계약직                                    20     10000
 * 
 * [출력결과]
 * 홍길동  총급여  451000
 * 갑동이  총급여  200000
 * 
 * 위의 [데이타]를 참조하여 [출력결과]가 나오도록 프로그램을 구현하세요.
 */

//사원클래스
abstract class Employment {
	private String name;
	private String dept;
	private String section;

	public Employment() {

	}

	public Employment(String name, String dept, String section) {
		this.name = name;
		this.dept = dept;
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getSection() {
		return section;
	}

	@Override
	public String toString() {
		return name + " " + dept + " " + section;
	}

	abstract public long count();

}// end Member

//정직원 급여
class Regular extends Employment {
	private int salary;
	private int allowance;

	public Regular() {

	}

	public Regular(String name, String dept, String section, int salary, int allowance) {
		super(name, dept, section);
		this.salary = salary;
		this.allowance = allowance;
	}

	@Override
	public String toString() {
		return getName() + " " + getDept() + " " + getSection() + " " + salary + " " + allowance;
	}

	@Override
	public long count() {
		return salary + allowance;
	}

}// end Regular

//계약직 급여
class Worker extends Employment {
	int numDays;
	int numPay;

	public Worker() {

	}

	public Worker(String name, String dept, String section, int numDays, int numPay) {
		super(name, dept, section);
		this.numDays = numDays;
		this.numPay = numPay;
	}

	@Override
	public String toString() {
		return getName() + " " + getDept() + " " + getSection() + " " + numDays + " " + numPay;
	}

	@Override
	public long count() {
		return numDays * numPay;
	}
}// end Worker

public class Prob003_binding {
	public static void main(String[] args) {
		Regular rman = new Regular("홍길동", "영업부", "정직원", 450000, 1000);
		display(rman);
		Worker wman = new Worker("갑동이", "기획부", "계약직", 20, 10000);
		display(wman);
				
	}// end main()

	public static void display(Employment emp) {
		System.out.printf("%s 총급여:%d\n", emp.getName(), emp.count());
	}
}// end class
