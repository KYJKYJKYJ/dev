package sessiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static MemDAO dao = new MemDAO();

	private MemDAO() {

	}

	public static MemDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
	}

	private void exit() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
	
	public int memCheck(MemDTO dto) {
		//클라이언트가 입력한 아이디, 패스워드 값이 존재하면 1, 없으면 0
		int cnt = 0;
		
		try {
			conn=init();
			String sql = "select count(*) from memtab where fid=? and fpass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFid());
			pstmt.setString(2, dto.getFpass());
			rs=pstmt.executeQuery();
			
			if(rs.next())
				cnt=rs.getInt("count(*)"); // 또는 그냥 인덱스를 이용해서 1 넣어도 됨
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

}
