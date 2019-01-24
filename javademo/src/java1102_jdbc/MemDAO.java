package java1102_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemDAO() {
		
	}
	
	private static MemDAO dao = new MemDAO();
	
	public static MemDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		//1.드라이버 연결
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. 서버연결
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234"; 
		return DriverManager.getConnection(url, username, password);		
	}
	
	private void exit() throws SQLException {
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();
		if(pstmt != null)
			pstmt.close();
		if(conn != null)
			conn.close();
	} // end exit()
	
	//SELECT 실행시 executeQuery() 로 실행해야함 (리턴타입 ResultSet)
	//INSERT, UPDATE, DELETE 실행시 excuteUpdate() 로 실행해야함 (리턴타입 Int)		
	public List<MemDTO> listMethod() {
		List<MemDTO> aList = new ArrayList<MemDTO>();
		try {
			conn = init();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM mem ORDER BY num";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setAge(rs.getInt("age"));
				dto.setLoc(rs.getString("loc"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aList;
	} // end listMethod()
	
	//SELECT 실행시 executeQuery() 로 실행해야함 (리턴타입 ResultSet)
	//INSERT, UPDATE, DELETE 실행시 excuteUpdate() 로 실행해야함 (리턴타입 Int)	
	public List<MemDTO> insertMethod(MemDTO dto) {
		List<MemDTO> aList = new ArrayList<MemDTO>();
		try {
			conn = init();
			/*stmt = conn.createStatement();
			String sql = "INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval,'" + dto.getName() + "', " + dto.getAge() + ",'"+dto.getLoc()+"')";
			rs = stmt.executeQuery(sql);*/
			
			String sql = "INSERT INTO mem(num,name,age,loc) VALUES(mem_num_seq.nextval, ?, ?, ?)";
			//conn.setAutoCommit(false); // 기본값은 true라서 밑에 Update에서 자동으로 커밋되고 있음
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());		
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			/*try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}*/
		} finally {
			try {
				exit(); //close 될 때 오토커밋을 false를 시켜도 이상이 없으므로 자동 커밋됨
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aList;
	} // end insertMethod()
	
	/*
	 * 5, 10 인덱스 사이를 참조해야 한다고 할 때
	 * dto.setNum(5);
	 * dto.setNum(10);
	 * SELECT * FROM mem WHERE num >= dto.getNum() AND num <= dto.getNum(); 한다고 5 >= , <= 10 되는게 아니라
	 * 10 >=, <= 10 이 되어버린다. 이럴 때 MAP을 활용하면 된다.
	 * 
	 * map.put("start", 5);
	 * map.put("end", 10); 으로 활용하자.
	 */
	
	public void updateMethod(HashMap<String, Object> map) {
		try {
			conn = init();
			String sql = "UPDATE mem SET name = ? WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("name"));
			pstmt.setInt(2, (Integer) map.get("num"));
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	} // end updateMethod()
	
	public void deleteMethod(int num) {
		try {
			conn = init();
			String sql = "DELETE FROM mem WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // end deleteMethod()
} // end class
