package java0226_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
--테이블생성
create table pltest(
	num number,
	message varchar2(50)
);

--프로시저 생성
create or replace procedure projdbc01
(msg in varchar2)
is
begin
	for i in 1..10 loop
		insert into pltest values(i,msg);
	end loop;
	commit;
end;
/
*/

public class Java240_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
	public Java240_plsql() {
	
	}
	
	public void process() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "a1234";
			conn = DriverManager.getConnection(url, user, password);
			
			//String sql = "begin projdbc01(?); end;";
			String sql = "{call projdbc01(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "message");
			cstmt.executeUpdate();
			System.out.println("program end");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//jdbc연결 종료
		}
	}

	public static void main(String[] args) {
		new Java240_plsql().process();
	}
}
