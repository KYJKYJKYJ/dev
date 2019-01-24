package part01.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part01.dto.EmployeesDTO;

public class EmployeesDAO {
	private SqlSession session;
	
	public EmployeesDAO() {
		// 1. 트랜잭션으로 설정되어 있는 파일의 경로를 정의
		String resource = "config/configuration.xml";
		
		try {
			// 2. 설정파일을 로딩하기 위하여 입력스트림과 연결함
			Reader reader = Resources.getResourceAsReader(resource);
			
			// 3. 설정파일을 저장하기 위한 팩토리를 생성해줄 수 있는 빌더를 생성함
			SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
			
			// 4. 설정파일의 정보를 읽어와 sqlBuilder에 생성함
			SqlSessionFactory factory = sqlBuilder.build(reader);
			
			// 5. 쿼리문에 접근할 수 있도록 sqlSession 객체를 리턴한다.
			// openSession()의 기본값은 false 이다.
			// 자동으로 커밋을 설정 하고 싶다면 openSession(true) 로 설정해주면 됨
			session = factory.openSession(true);
			
			// 6. 입력스트림의 연결을 종료함
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end EmployeeDAO() //////////////////////////////////////////
	
	public List<EmployeesDTO> allMethod() {
		return session.selectList("emp.all"); //nameplace.id 형태
		// 값을 가져올 때 <리스트 형태>로 받는데, 다양한 컬림 값을 받으므로 selectList 메소드를 통해
		// Mapper의 이름.select의 id 형태로 접근하여 값을 받는다
		
	}
	
	public int countMethod() {
		return session.selectOne("emp.cnt");
		//한개의 값만 리턴할때는 selectOne
	}
	
	public List<EmployeesDTO> searchMethod(String name) {
		return session.selectList("emp.search", name);
	}
	
	public EmployeesDTO oneMethod(int num) {
		return session.selectOne("emp.num", num);
	}
	
	public List<EmployeesDTO> yearMethod(int year) {
		return session.selectList("emp.year", year);
	}
	
	public List<EmployeesDTO> dtoMethod(EmployeesDTO dto) {
		return session.selectList("emp.dtoList", dto);
	}
	
	public List<EmployeesDTO> moneyMethod(HashMap<String, Integer> map) {
		return session.selectList("emp.moneyList", map);
	}
	
	public HashMap<String, Integer> salaryMap() {
		return session.selectOne("emp.dataMap");
	}
	
}
