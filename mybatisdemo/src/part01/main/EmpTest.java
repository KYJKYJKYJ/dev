package part01.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import part01.dao.EmployeesDAO;
import part01.dto.EmployeesDTO;

public class EmpTest {
	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		
		System.out.printf("recored count:%d\n", dao.countMethod());
		List<EmployeesDTO> list = dao.allMethod();
		
		for(EmployeesDTO dto1 : list)
			System.out.printf("%s %d %s\n", dto1.getFirst_name(), dto1.getSalary(), dto1.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
				
		System.out.printf("recored count:%d\n", dao.countMethod());
		
		List<EmployeesDTO> slist = dao.searchMethod("lex");
				
		for(EmployeesDTO dto2 : slist)
			System.out.printf("%s %d %s\n", dto2.getFirst_name(), dto2.getSalary(), dto2.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
		
		EmployeesDTO dto = dao.oneMethod(100);
		System.out.printf("%s %d %s\n",
							dto.getFirst_name(),
							dto.getSalary(),
							dto.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
		
		List<EmployeesDTO> ylist = dao.yearMethod(2007);
		
		for(EmployeesDTO dto3 : ylist)
			System.out.printf("%s %d %s\n", dto3.getFirst_name(), dto3.getSalary(), dto3.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
		
		//파라미터가 다중일 경우 DTO로 선언해 놓고 여기서 set으로 값을 설정 후 리스트로 반영시켜서 받으면 되는 듯 함
		EmployeesDTO dt = new EmployeesDTO();
		dt.setFirst_name("lex");
		dt.setSalary(9000);
		List<EmployeesDTO> dlist = dao.dtoMethod(dt);
		
		for(EmployeesDTO dto4 : dlist)
			System.out.printf("%s %d %s\n", dto4.getFirst_name(), dto4.getSalary(), dto4.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
		
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		hp.put("losalary", 5000); // CDATA로 문자열 그대로 파싱 받은 부분에 대입됨
		hp.put("hisalary", 6000); // CDATA로 문자열 그대로 파싱 받은 부분에 대입됨
		List<EmployeesDTO> mlist = dao.moneyMethod(hp);
		
		for(EmployeesDTO dto5 : mlist)
			System.out.printf("%s %d %s\n", dto5.getFirst_name(), dto5.getSalary(), dto5.getHire_date());
		
		System.out.println("--------------------------------------------------------------");
		
		HashMap<String, Integer> hp2 = dao.salaryMap();
		System.out.println(hp2.keySet());
		System.out.println(hp2.values());
		
		// Map에 Iterator 활용법 **
		Set<String> keySet = hp2.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " = " + hp2.get(key));
		}
		
		System.out.printf("%s, %s\n",
				hp2.get("LOW"), // 컬럼명 가져올 때 전부 대문자로 리턴되는 것에 유의하기
				hp2.get("HIGH"));
		// System.out.println( (hp2.get("MIN(SALARY)")) instanceof Number);
		// 객체로 받아오기 때문에 Number
		
		// value가 타입이 BigDecimal 인데 상위 클래스는 Number이다.
		// 근데 Integer와 상위 Number만 같지 전혀 상관이 없는 타입이기 때문에 먼저 Number로 형태를 만들어 준 후
		// .intValue를 사용하여 교환해줌
		Number maxval = hp2.get("HIGH");
		Number minval = hp2.get("LOW");
		
		System.out.printf("%d, %d\n",
				maxval.intValue(),
				minval.intValue());
	}
}
