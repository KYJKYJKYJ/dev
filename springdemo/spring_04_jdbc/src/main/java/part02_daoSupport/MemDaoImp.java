package part02_daoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/*
 * Template 클래스
 * 1. 개발자가 중복된 코드를 입력해야 하는 작업을 줄일 수 있도록 돕고 있다.
 * 2. JDBC뿐만 아니라 myBatis, JMS와 같은 다양한 기술에 대해 템플릿을 제공한다.
 * 3. 예로 Jdbc인 경우 getJdbcTemplate()클래스를 제공하고 있으며, getJdbcTemplate()클래스를
 *    사용함으로써 try~cath~finally 및커넥션 관리를 위한 중복된 코드를 줄이거나
 *    없앨 수 있다.
 *    
 *                             Java JDBC              Spring JDBC
 *    select  				   executeQuery( )         query( )
 *    insert, update, delete   executeUpdate( )        update( )
 */

//JdbcDaoSupport: JdbcTemplate클래스를 상속받아 구현
public class MemDaoImp extends JdbcDaoSupport implements MemDAO {
	
	public MemDaoImp() {
	
	}
	
	@Override
	public List<MemDTO> list() {
		String sql="select * from mem order by num desc";
		List<MemDTO> list=getJdbcTemplate().query(sql, new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				   MemDTO dto=new MemDTO();
				   dto.setNum(rs.getInt("num"));
				   dto.setName(rs.getString("name"));
				   dto.setAge(rs.getInt("age"));
				   dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
		
		return list;
	}

	@Override
	public void insertMethod(MemDTO dto) {
		String sql="insert into mem values(mem_num_seq.nextval,?,?,?)";
		Object[] args=new Object[] {dto.getName(), dto.getAge(), dto.getLoc()};
		getJdbcTemplate().update(sql,args);		
		
	}

	@Override
	public void updateMethod(MemDTO dto) {
		String sql = "update mem set name=? where num=?";
		Object[] args = new Object[] { dto.getName(), dto.getNum()};
		getJdbcTemplate().update(sql, args);		
	}

	@Override
	public void deleteMethod(int num) {
		String sql = "delete from mem where num=?";
		Object[] args = new Object[] { num };
		getJdbcTemplate().update(sql, args);
		
	}

	@Override
	public MemDTO one(int num) {
		String sql = "select * from mem where num=?";
		Object[] args = new Object[] { num };
		return getJdbcTemplate().queryForObject(sql,args,
				                   new RowMapper<MemDTO>() {
			@Override
			public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				 MemDTO dto=new MemDTO();
				   dto.setNum(rs.getInt("num"));
				   dto.setName(rs.getString("name"));
				   dto.setAge(rs.getInt("age"));
				   dto.setLoc(rs.getString("loc"));
				return dto;
			}
		});
		
	}

	@Override
	public int countMethod() {
		String sql = "select count(*)  from mem";
		
		return getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return rs.getInt(1);
			}
		});
	}
	
	
}//end class






