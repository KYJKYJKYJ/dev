package java0226_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.internal.OracleTypes;

/*
1. Stored Procedure
Stored Procedure는 DB 내에 프로시저를 선언하여 클라이언트가 필요할 때마다 호출하여 사용하도록 하는 단위로 저장된 프로시저이다. 이는 클라이언트에서 SQL 문을 실행하는 것이 아니라 DB에 프로시저가 존재하는 것이므로 클라이언트에서 저장된 프로시저를 실행만 해주면 그 내용이 oracle 내에서 바로 처리된다. 따라서 속도가 빠르며 부하가 적고 DB 내 존재하는 특성이 있다.

2. CallableStatement
CallableStatement는 DB 내의 Stored Procedure을 호출하기 위한 객체로,
이 객체는 PreparedStatement 객체를 상속받아 사용한다.
이 객체에서 registeroutParameter() 메소드는 프로시저에서 넘어오는 값을 반환 받기 위해서는 필요하며,
프로시저로부터 넘어오는 값의 타입을 지정해주는 역할을 한다. 

3. 자바에서  PL-SQL select 
-조회결과를 볼 수 있는 제어권을 자바로 넘기기 위해서 사용하는 커서  (SYS_REFCUSOR)
-procedure에서는 커서를 open만 한다.
- fetch, close를 하지 않는다.

프로시저 생성
create or replace procedure pl_emplist
	(v_deptno in number,
	 --app에서 값을 사용하기 위해서(Multi row)
	 v_cursor out sys_refcursor)
is
begin
	open v_cursor
	for 
		select employee_id, first_name, salary, department_id
		from employees
		where department_id=v_deptno; 
end;
/
*/
public class Java242_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;
	
	public Java242_plsql() {
	
	}
	
	public void process() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "a1234";
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "{call pl_emplist(?, ?)";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, 20); //입력값
			//java build path - Libraries - Add External JARs - ojdbc6.jar
			cstmt.registerOutParameter(2, OracleTypes.CURSOR); //반환값
			cstmt.executeQuery();
			//cstmt의 2인덱스에 있는 값을 가져와서 ResultSet 타입 객체에 넣어준다.
			rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				System.out.printf("%d %s %d %d\n",
							rs.getInt("employee_id"), rs.getString("first_name"),
							rs.getInt("salary"), rs.getInt("department_id"));
			}
			System.out.println("program end");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//연결종료
		}
	}
	
	public static void main(String[] args) {
		new Java242_plsql().process();
	}
}
