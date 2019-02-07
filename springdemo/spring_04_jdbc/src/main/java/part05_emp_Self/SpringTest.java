package part05_emp_Self;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		/*
		 * Employees테이블에서 salary이  높은 5-10랭크에 해당하는
		 * employee_id, first_name, salary, hire_date을
		 * 출력하시오.
		 */
		
		
		
		
		
		ApplicationContext context=
		 new ClassPathXmlApplicationContext("part05_emp/jdbc.xml");
		EmpDAO dao=(EmpDAO)context.getBean("dao");
		
		HashMap<String, Integer> map=new
				HashMap<String, Integer>();
		map.put("startRow", 5);
		map.put("endRow", 10);
		List<EmpDTO> list=dao.searchMethod(map);
		for(EmpDTO dto: list)
			System.out.printf("%s %s %d %s\n",
					dto.getEmployee_id(),
					dto.getFirst_name(),
					dto.getSalary(),
					dto.getHire_date());

	}//end main( )

}//end class
