package java1105_jdbc;

public class EmpDTO {
	private int employee_id;
	private String first_name;
	private int salary;
	private DeptDTO dept; // deptDTO를 저장하기 위해
	
	public EmpDTO() {
		
	}
	
	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}


	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
		
} // end class
