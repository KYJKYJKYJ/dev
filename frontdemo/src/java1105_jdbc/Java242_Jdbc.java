package java1105_jdbc;

import java.util.ArrayList;
import java.util.List;

//Data Transfer Object : 각 계층간 데이터 교환을 위한 객체를 의미
//DTO 안의 변수 이름과 DB table안의 컬럼명과 이름 같이 해주어야 자동적으로 처리 될 수 있다.

public class Java242_Jdbc {

	public static void main(String[] args) {
		JoinDAO dao = JoinDAO.getInstance();
		List<EmpDTO> aList = dao.listMethod();
		for(EmpDTO dto : aList) {
			System.out.printf("%d %s %d %d %s\n",
					dto.getEmployee_id(),
					dto.getFirst_name(),
					dto.getSalary(),
					dto.getDept().getDepartment_id(),
					dto.getDept().getDepartment_name());
		}

	}

}
