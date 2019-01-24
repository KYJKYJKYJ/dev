package ajaxdemo.part07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private EmployeesDAO() {
	}

	private static EmployeesDAO dao = new EmployeesDAO();

	public static EmployeesDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
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
	
	public List<EmployeesDTO> listMethod(int startRow, int cntRow){
		List<EmployeesDTO> aList=new ArrayList<EmployeesDTO>();
		
		 try {
			conn=init();			
			String sql ="SELECT b.* " + 
					"FROM(SELECT rownum rm, a.* " + 
					"FROM(SELECT * FROM employees ORDER BY employee_id)a)b " + 
					"WHERE b.rm>=? AND b.rm<=?";
			pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1, startRow);
		    pstmt.setInt(2, startRow+cntRow-1);
		    rs=pstmt.executeQuery();
			while(rs.next()) {
				EmployeesDTO dto = new EmployeesDTO( );
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				aList.add(dto);
			}
			
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aList;
	}//end search()
    
}//end class









