package part03_template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part03_template/jdbc.xml");
		MemDAO dao = (MemDAO) context.getBean("dao");
		
		//dao.insertMethod(new MemDTO("펭돌이", 3, "강남"));
		//dao.updateMethod(new MemDTO(40, "펭순이"));
		//dao.deleteMethod(40);
		
		/*MemDTO dto = dao.one(41);
		System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());*/
		
		//System.out.println("count: "+dao.countMethod());
		
		//전체 리스트
		//List<MemDTO> list = dao.list();
		
		//num이 15미만 리스트
		List<MemDTO> list = dao.searchMethod(40);
		for(MemDTO dto : list) {
			System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());
		}
	}
}
