package java0226_plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/*
create or replace procedure pro04_outmode
    (v_id in employees.employee_id%type, --값을 받아들임
     v_name out employees.first_name%type, --값을 내보냄
     v_salary out employees.salary%type, --값을 내보냄
     v_avg_salary out employees.salary%type, --값을 내보냄
     v_deptname out departments.department_name%type) --값을 내보냄
is
    v_deptid number; --쿼리문에서 사용할 변수 선언
begin
     --사원번호가 받아들인 값과 같은 사람의 first_name, salary, department_id 추출
    select first_name, salary, department_id
    into v_name, v_salary, v_deptid
    from employees
    where employee_id = v_id;

    --선택한 사원이 속한 부서명과 부서의 평균 salary 추출   
    select d.department_name, a.avg_sal
    into v_deptname, v_avg_salary
    from departments d, (select round(avg(salary)) avg_sal
                                from employees
                                where department_id = v_deptid) a
    where d.department_id = v_deptid;
end;
/

variable g_name varchar2(20)
variable g_salary number
variable g_avg number
variable g_deptname varchar2(20)
execute pro04_outmode(100, :g_name, :g_salary, :g_avg, :g_deptname);

print g_name; --하나씩 출력
print; --한번에 출력
*/

public class Java244_plsql {
	private Connection conn;
	private CallableStatement cstmt;
	
	public Java244_plsql() {
	
	}
	
	public void process() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "a1234";
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "{call pro04_outmode(?, ?, ?, ?, ?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, 100);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.execute();
			System.out.printf("%s %d %d %s\n",
							cstmt.getString(2), cstmt.getInt(3), 
							cstmt.getInt(4), cstmt.getString(5));
			System.out.println("program end");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//연결종료
		}
	}
	
	public static void main(String[] args) {
		new Java244_plsql().process();
	}
}
