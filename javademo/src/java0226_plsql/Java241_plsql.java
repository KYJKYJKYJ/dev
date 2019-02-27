package java0226_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
프로시저: pro06_othermode
begin
	pro06_othermode('정소라', '대전');
end;
/
*/
public class Java241_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
	public Java241_plsql() {

	}

	public void process() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "a1234";
			conn = DriverManager.getConnection(url, user, password);
			
			//String sql = "begin pro06_othermode(?, ?); end;";
			String sql = "{call pro06_othermode(?, ?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "정소라");
			cstmt.setString(2, "대전");
			cstmt.executeUpdate();
			System.out.println("program end");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	public static void main(String[] args) {
		new Java241_plsql().process();
	}
}
