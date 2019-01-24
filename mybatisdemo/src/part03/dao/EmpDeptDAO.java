package part03.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import part03.dto.DeptDTO;
import part03.dto.EmpDTO;

public class EmpDeptDAO {
	private SqlSession session;
	public EmpDeptDAO() {
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
	}// end EmpDeptDAO() ////////////////////////////////////////////////////
	
	public List<EmpDTO> emp_deptMethod() {
		return session.selectList("join.emp_dept");
	}
	
	public List<DeptDTO> dept_empMethod() {
		return session.selectList("join.dept_emp");
	}
	
	public List<EmpDTO> partMethod() {
		return session.selectList("join.dnator");
	}
}
