package java1031_jdbc;

// Data Transfer Object : 각 계층간 데이터 교환을 위한 객체를 의미
// DTO 안의 변수 이름과 DB table안의 컬럼명과 이름 같이 해주어야 자동적으로 처리 될 수 있다.
// getter, setter를 이용하여 데이터 교환

public class DepartmentDTO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	public DepartmentDTO() {
		
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	
	
}
