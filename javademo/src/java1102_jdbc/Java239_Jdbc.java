package java1102_jdbc;

import java.util.HashMap;
import java.util.List;

public class Java239_Jdbc {

	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();

		HashMap<String, Integer> map = 
				  new HashMap<String, Integer>();
		map.put("start", 11);
		map.put("end", 20);

		List<EmpDTO> aList = dao.rangeMethod(map);
		
		for (EmpDTO dto : aList)
			System.out.printf("%d %s %d %s\n", 
					dto.getEmployee_id(), 
					dto.getFirst_name(), 
					dto.getSalary(),
					dto.getHire_date());

	}// end main( )

}// end class
