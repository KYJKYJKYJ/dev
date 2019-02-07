package part05_emp;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDaoImp implements EmpDAO {
	private SqlSessionTemplate sqlSession;
	
	public EmpDaoImp() {

	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<EmpDTO> searchMethod(HashMap<String, Integer> map) {
		return sqlSession.selectList("emp.search", map);
	}
}
