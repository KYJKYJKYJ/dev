package java1031_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


//Data Access Object의 약자로 데이터베이스의 data에 접근하기 위한 객체
//쿼리문 작업은 DAO에서 수행

/*
 * 1. ClassNotFoundException 
*  해결) JRE System Library에서 ojdbc14.jar파일 확인
 *      Class.forName(): 경로확인
 *      
 * 2. java.sql.SQLException: 
 *     IO예외 상황:  The Network Adapter...
 *                 Listener refused.....  
 *                 
 *     해결) 제어판->관리도구->서비스->OracleServiceXE,
 *            OracleXETNSListener을 다시 시작한다.
 *         작업관리자 -서비스로 들어가서 다시 시작해도 됨.
 *            
* java.sql.PreparedStatement
 * 1 반복되는 쿼리문의 수행에 사용한다.
 * 2 미리 정의된 SQL문을 수행하기 때문에 Statement에 비해 속도가 빠르다.
 * 3 위치표시자(placeholder)(?)를 사용하여 쿼리문을 간략하게 작성한다.
 */    

/*
 * 싱글톤 패턴
 *  : 하나의 객체만을 생성해서 사용할 수 있도록 설계한 구조이다.
 *  1 생성자의 접근제어자는 private
 *  2 객체자신을 생성을 한다.
 *  3 생성된 객체를 넘겨줄 수 있는 메소드를 정의한다.
 */

public class DepartmentDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static DepartmentDAO dao = new DepartmentDAO(); // 싱글톤 패턴.
	private DepartmentDAO() {
		
	}
	
	public static DepartmentDAO getInstance() {
		return dao;
	}
	
	private Connection init() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2. 서버연결
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
		
	} // end init()
	
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
	
	public List<DepartmentDTO> listMethod() {
		List<DepartmentDTO> aList = new ArrayList<DepartmentDTO>();
		
		try {
			conn = init();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM departments ORDER BY department_id";
			rs = stmt.executeQuery(sql);
			//DepartmentDTO dto = new DepartmentDTO();
			//DTO를 while문 밖에서 수행하면 DTO 공간이 하나만 생성되어 같은 공간에 주소값만 달라져버림. 그래서 마지막 데이터의 값 주소로만 채워져버림.
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO(); 
				dto.setDepartment_id(rs.getInt("department_id")); 
				dto.setDepartment_name(rs.getString("department_name"));
				dto.setLocation_id(rs.getInt("location_id"));
				dto.setManager_id(rs.getInt("manager_id"));
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit(); // 연결을 끊어주는 작업을 반드시 해야함. 자칫 잘못하면 계속 접근한다고 착각되어 데이터 베이스가 멈출 수 있음.
				// null 이 아닌 상태에서 close 됨. 자동으로 rs가 리턴됨
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aList;
	} // end listMethod()


	public List<DepartmentDTO> searchMethod(String data) {
		List<DepartmentDTO> aList = new ArrayList<DepartmentDTO>();
		try {
			conn = init();
			//일반적인 쿼리문 사용 //실행할 때마다 쿼리문이 작성되어야함
			/*stmt = conn.createStatement();
			String sql = "SELECT * FROM departments WHERE LOWER(department_name) LIKE LOWER('%" + data + "%')";
			rs = stmt.executeQuery(sql);*/
			
			//Prepared 사용 //반복 사용에 강점
			String sql = "SELECT * FROM departments WHERE LOWER(department_name) LIKE LOWER(?)";
			//변수값을 받아서 처리할 때는 ?를 사용 (placeholder)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + data + "%"); // ?의 순서대로 인덱스 번호가 붙음 //?가 저 값으로 설정됨
			rs = pstmt.executeQuery(); // 쿼리문이 preparedstmt에 들어가서 사용됨, excuteQuery에 들어가지 않움
			
			while(rs.next()) {
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(rs.getInt("department_id")); 
				dto.setDepartment_name(rs.getString("department_name"));
				dto.setLocation_id(rs.getInt("location_id"));
				dto.setManager_id(rs.getInt("manager_id"));
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
	}
}