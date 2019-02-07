package part05_emp_Answer;

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
		 * 
		 * [출력결과]
		 *  146 Karen 13500 Wed Jan 05 00:00:00 KST 2005
			201 Michael 13000 Tue Feb 17 00:00:00 KST 2004
			108 Nancy 12008 Sat Aug 17 00:00:00 KST 2002
			205 Shelley 12008 Fri Jun 07 00:00:00 KST 2002
			147 Alberto 12000 Thu Mar 10 00:00:00 KST 2005
			168 Lisa 11500 Fri Mar 11 00:00:00 KST 2005
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
