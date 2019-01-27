package java1031_jdbc;

import java.util.List;

/*
 * MVC 패턴 : 컴퓨터 소프트웨어 개발의 구조적 패턴
 * Model : 데이터에 관련된 작업 (DepartmentDTO, DepartmentDAO)
 * View : 클라이언트에 보여줄 화면(Java236_Jdbc)
 * Controller : 요청, 응답처리(Java236_Jdbc)
 */

public class Java236_Jdbc {

	public static void main(String[] args) {
		DepartmentDAO dao = DepartmentDAO.getInstance();
		//List<DepartmentDTO> aList = dao.listMethod();
		List<DepartmentDTO> aList = dao.searchMethod("IT");
		for(int i = 0; i < aList.size(); i++) {
			DepartmentDTO dto = aList.get(i);
			System.out.printf("%d %s %d %d \n",
					dto.getDepartment_id(),
					dto.getDepartment_name(),
					dto.getManager_id(),
					dto.getLocation_id());
		}

	}

}
