package part04_daoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * Template 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3. 예로 Jdbc인 경우 JdbcTemplate클래스를 제공하고 있으며, JdbcTemplate클래스를
 *    사용함으로써 try~cath~finally 및커넥션 관리를 위한 중복된 코드를 줄이거나
 *    없앨 수 있다.
 *    
 *                             Java JDBC              Spring JDBC
 *    select  				   executeQuery( )         query( )
 *    insert, update, delete   executeUpdate( )        update( )
 */
public class MemDaoImp extends SqlSessionDaoSupport implements MemDAO {
	public MemDaoImp() {

	}

	@Override
	public List<MemDTO> list() {

		return getSqlSession().selectList("group.all");
	}

	@Override
	public void insertMethod(MemDTO dto) {
		getSqlSession().insert("group.ins", dto);
	}

	@Override
	public void updateMethod(MemDTO dto) {
		getSqlSession().update("group.upt",dto);	
	}

	@Override
	public void deleteMethod(int num) {
		getSqlSession().delete("group.del",num);
	}

	@Override
	public MemDTO one(int num) {
		return getSqlSession().selectOne("group.one",num);
	}

	@Override
	public int countMethod() {
		return getSqlSession().selectOne("group.cnt");
	}

	@Override
	public List<MemDTO> searchMethod(int num) {		
		return getSqlSession().selectList("group.search",num);
	}
}// end class








