package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.RegisterDTO;

public class RegisterDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private RegisterDAO() {
	}

	private static RegisterDAO dao = new RegisterDAO();

	public static RegisterDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "khgym";
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

	public void insertMethod(RegisterDTO dto) {
		try {
			conn = init();
			// user_id sports register_date register_time
			String sql = "insert into register(register_num, user_id, sports, register_date, register_time) "
					+ "values(register_num_seq.nextval,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id()); // 아이디
			pstmt.setString(2, dto.getSports()); // 운동종류
			pstmt.setString(3, String.valueOf(dto.getRegister_date())); // 날짜
			pstmt.setString(4, dto.getRegister_time()); // 시간
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}// end insertMethod

	// 프로그램 예약 불가능 시간제거
	// DB에 예약된 데이터와 스포츠,날짜가 일치하는 시간값 리턴
	public List<String> getRegisterTime(String sports, String register_date) {
		List<String> aList = new ArrayList<>();

		try {
			conn = init();
			String sql = "SELECT register_time FROM register WHERE sports=? AND register_date=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sports);
			pstmt.setString(2, register_date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				aList.add(rs.getString("register_time"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return aList;
	}// getRegisterTime

	public List<RegisterDTO> registerInfo(String user_id) {
		List<RegisterDTO> aList = new ArrayList<>();
		RegisterDTO dto2 = null;
		try {
			conn = init();
			String sql = "select * from register where user_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto2 = new RegisterDTO();
				dto2.setRegister_num(rs.getInt("register_num"));
				dto2.setUser_id(rs.getString("user_id"));
				dto2.setSports(rs.getString("sports"));
				dto2.setRegister_date(rs.getDate("register_date"));
				dto2.setRegister_time(rs.getString("register_time"));
				aList.add(dto2);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
	
	public void registerDelete(int register_num) {
	      try {
	         conn=init();
	         String sql="DELETE FROM register WHERE register_num=?";
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, register_num);
	         pstmt.executeUpdate();
	         
	      } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            exit();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }

}
