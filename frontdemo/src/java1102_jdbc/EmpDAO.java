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

public class EmpDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static EmpDAO dao = new EmpDAO();

	private EmpDAO() {

	}

	public static EmpDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");

		// 2. 서버연결
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
	}// end init()

	private void exit() throws SQLException {
		if (rs != null)
			rs.close();

		if (stmt != null)
			stmt.close();

		if (pstmt != null)
			pstmt.close();

		if (conn != null)
			conn.close();

	}// end exit()

	//SELECT 실행시 executeQuery() 로 실행해야함 (리턴타입 ResultSet) **
	//INSERT, UPDATE, DELETE 실행시 excuteUpdate() 로 실행해야함 (리턴타입 Int) **		
	public List<EmpDTO> rangeMethod(HashMap<String, Integer> map) {
		List<EmpDTO> aList = new ArrayList<EmpDTO>();
		try {
			conn = init();
			/*String sql = "SELECT b.* FROM(SELECT rownum rm, a.* FROM (SELECT * FROM employees) a) b WHERE b.rm >= ? AND b.rm <= ?";*/
			String sql = "SELECT b.* " + 
						 "FROM(SELECT rownum rm, a.* " + 
						 "FROM (SELECT * FROM employees) a) b " + 
						 "WHERE b.rm >= ? AND b.rm <= ?"; // 이런식으로 줄이 많을 때는 끝에 한칸을 띄워주면서 더하면 된다.
			
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, map.get("start"));
			pstmt.setInt(2, map.get("end"));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setSalary(rs.getInt("salary"));
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
	}//end rangeMethod()/////////////////////////////
	
	public List<EmpDTO> searchMethod(String word) {
		List<EmpDTO> aList = new ArrayList<EmpDTO>();
		
		try {
			conn = init();
			String sql = "SELECT * FROM employees WHERE UPPER(first_name) LIKE UPPER(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%"); //word.toUpperCase() 활용 가능
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setSalary(rs.getInt("salary"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aList;		
	}
}//end class
