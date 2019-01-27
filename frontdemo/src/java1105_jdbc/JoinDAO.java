package java1105_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JoinDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static JoinDAO dao = new JoinDAO();
	// 싱글톤 패턴 사용을 위해 static 으로 객체 생성
	
	private JoinDAO() {
		
	} // end JoinDAO()
	
	public static JoinDAO getInstance() { // 추후 객체 생성은 getInstance 로 대체하기 위하여 static으로..
		return dao;
	} // end getInstance()
	
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
	
	public List<EmpDTO> listMethod() {
		List<EmpDTO> aList = new ArrayList<EmpDTO>();
		try {
			conn = init();
			stmt = conn.createStatement();
			
			String sql = "SELECT e.employee_id, e.first_name, e.salary," + 
						 "d.department_id, d.department_name " + 
						 "FROM employees e, departments d " + 
						 "WHERE e.department_id = d.department_id " + 
						 "ORDER BY e.employee_id";
			
			rs = stmt.executeQuery(sql);
			// RS에는 결과가 저장되어 있음.
			
			while(rs.next()) {
				EmpDTO edto = new EmpDTO();
				edto.setEmployee_id(rs.getInt("employee_id"));
				edto.setFirst_name(rs.getString("first_name"));
				edto.setSalary(rs.getInt("salary"));
				
				DeptDTO dept = new DeptDTO();
				dept.setDepartment_id(rs.getInt("department_id"));
				dept.setDepartment_name(rs.getString("department_name"));
				edto.setDept(dept); // 아래 저장 문제를 해결하기 위해 employeeDTO 안에 get, setter를 DeptDTO도 저장 할 수 있도록 추가해주었음
				
				aList.add(edto); // 이러면 employee의 DTO 정보만 저장이 됨. Dept도 저장하려면 edto 안에 저장해주어야함
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
	}
	
} // end JoinDAO
