package homedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private HomeDAO() {}
	
	private static HomeDAO dao = new HomeDAO();
	
	public static HomeDAO getInstance() {
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
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}// end exit()
	
	//공지사항 - employees
	public List<EmpDTO> getEmpList(){
		List<EmpDTO> aList = new ArrayList<EmpDTO>();
		try {
			conn = init();
			String sql = "select rownum ,  A.* from ( " + 
							  "select  employee_id , first_name, hire_date from employees order by employee_id desc " + 
							  ") A where rownum<=5";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setHire_date(rs.getDate("hire_date"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aList;
	}
	
	//질문과 답변 - board
	public List<BoardDTO> getBoardList(){
		List<BoardDTO> aList = new ArrayList<BoardDTO>();
		try {
			conn = init();
			String sql = "select rownum ,  A.* from ( " + 
							 "select  num, subject, reg_date from board order by reg_date desc) A "+ 
							 "where rownum<=5";			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setReg_date(rs.getDate("reg_date"));				
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aList;
	}
	
	//저자문의 - mem - num, name, age
	public List<MemDTO> getMemList(){
		List<MemDTO> aList = new ArrayList<MemDTO>();
		try {
			conn = init();
			String sql = "select rownum ,  A.* from ( " + 
								"select  num, name, age from mem order by num desc ) A " + 
								"where rownum<=5";		
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemDTO dto = new MemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));								
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aList;
	}
	
	public List<HomeDTO> getHomeList(){
		List<HomeDTO> aList = new ArrayList<HomeDTO>();
		
		try {
			conn = init();
			String sql = "select rownum , 'emp' as gubun,  A.* from ( ";
						sql += "select  employee_id as num , first_name as title from employees order by employee_id desc ) A ";
						sql += "where rownum<=5 ";
						sql += "union all ";
						sql += "select rownum , 'dep' as gubun , B.* from ( ";
						sql += "select  department_id as num , department_name as title from Departments order by department_id desc ) B ";
						sql += "where rownum<=5 ";
						sql += "union all ";
						sql += "select rownum , 'loc' as gubun , C.* from ( ";
						sql += "select  location_id as num , city as title from locations order by location_id desc) C ";
						sql += "where rownum<=5 ";
						
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HomeDTO dto = new HomeDTO();
				dto.setGubun(rs.getString("gubun"));
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				aList.add(dto);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return aList;
	}
	
	
}//end class
