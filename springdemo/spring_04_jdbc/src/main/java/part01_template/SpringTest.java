package part01_template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part01_template/jdbc.xml");
		
		MemDAO dao = (MemDAO) context.getBean("dao");
		
		//dao.insertMethod(new MemDTO("홍길동", 25, "대구"));
		
		//dao.updateMethod(new MemDTO(40, "길나사"));
		
		//dao.deleteMethod(new MemDTO(39));
		
		//MemDTO mdto = dao.one(37);
		//System.out.printf("%d %s %d %s\n", mdto.getNum(), mdto.getName(), mdto.getAge(), mdto.getLoc());
		
		System.out.println("count: "+dao.countMethod());
		
		//List<MemDTO> list = dao.list();
		/*for(MemDTO dto : list) {
			System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());
		}*/
	}
}
