package part05_emp_Answer;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import part05_emp_Answer.EmpDTO;

public class EmpDaoImp implements EmpDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	public EmpDaoImp() {
	
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<EmpDTO> searchMethod(HashMap<String, Integer> map) {
		
		return sqlSessionTemplate.selectList("emp.search",map);
	}
}
