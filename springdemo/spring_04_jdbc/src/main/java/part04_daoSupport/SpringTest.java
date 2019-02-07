package part04_daoSupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part04_daoSupport/jdbc.xml");
		MemDAO dao=(MemDAO)context.getBean("dao");
		
		//dao.insertMethod(new MemDTO("박나리",40,"서울"));
		//dao.updateMethod(new MemDTO(10,"길나사"));
		//dao.deleteMethod(10);
		
		
		//List<MemDTO> list=dao.list();
		
		//10미만
		List<MemDTO> list=dao.searchMethod(40);	
		for(MemDTO dto : list)
			System.out.printf("%d %s %d %s\n",
					dto.getNum(), dto.getName(),
					dto.getAge(), dto.getLoc());
		
		/*MemDTO dto=dao.one(8);
		System.out.printf("%d %s %d %s\n",
				dto.getNum(), dto.getName(),
				dto.getAge(), dto.getLoc());*/
		
		//System.out.println("count:"+dao.countMethod());
	}//end main()

}//end class







