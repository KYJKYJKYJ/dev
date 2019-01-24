package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.MemDTO;

public class MemDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private MemDAO() {
		// TODO Auto-generated constructor stub
	}

	private static MemDAO dao = new MemDAO();

	public static MemDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String user = "khgym";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end init()

	// 2.연결종료
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

	// 중복체크
	public boolean idCheck(String user_id) {

		boolean result = false;
		try {
			conn = init();
			String SQL = "select user_id from member where user_id=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = true;//이미아이디가 있음 (중복o)
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 회원가입
	public void register(MemDTO dto) {
		try {
			conn = init();
			String SQL = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getuser_id());
			pstmt.setString(2, dto.getuser_pw());
			pstmt.setString(3, dto.getuser_pw2());
			pstmt.setString(4, dto.getuser_name());
			pstmt.setString(5, dto.getuser_birth());
			pstmt.setString(6, dto.getuser_email());
			pstmt.setString(7, dto.getuser_phone());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}// end register()//////////////////////////////////////

	// 회원 탈퇴를 위한 메소드
	public void delete(String user_id) {
		try {
			conn = init();
			String sql = "delete from member where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
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
	}// end deleteMethod()

	// 회원정보 수정
	public void modify(MemDTO dto) {
		try {
			conn = init();
			String sql = "UPDATE member SET user_pw=?, user_pw2=?, user_name=?, user_email=?, user_phone=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getuser_pw());
			pstmt.setString(2, dto.getuser_pw2());
			pstmt.setString(3, dto.getuser_name());
			pstmt.setString(4, dto.getuser_email());
			pstmt.setString(5, dto.getuser_phone());
			pstmt.setString(6, dto.getuser_id());
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

	}// end modify()

	// 로그인 유효성 검사
	public int memCheck(String user_id, String user_pw) {

		try {
			conn = init();
			String sql = "SELECT user_pw FROM member WHERE user_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(user_pw) || rs.getString(1) == user_pw)
					return 1;// 로그인성공
				else
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디없음
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return -2; // db오류
	}// end memCheck()/////////////////////////////////////////////////////////

	// 아이디 찾기 : 이메일과 이름입력하면 해당 아이디가 나옴
	public String searchID(MemDTO dto) {
		String user_id = "";
		try {
			conn = init();
			String SQL = "SELECT user_id FROM member WHERE user_name=? AND user_email=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getuser_name());
			pstmt.setString(2, dto.getuser_email());
			rs = pstmt.executeQuery();// 컬럼에 내가 입력한 행이 모두 들어가 있는 상태 //결과값

			while (rs.next()) {
				// if (!(rs.getString(1).equals(user_name) &&
				// rs.getString(2).equals(user_email))) {
				// return 1;// 아이디 존재
				// } else
				// return 0;// 아이디없다
				// if(rs.getString(1).equals(user_id))
				user_id = rs.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user_id;

		// return -2;// db에없다
	}// end searchID///////////////////////////////////////////////

	// 비밀번호 찾기 : 아이디와 이메일 입력하면 해당 비밀번호가 나옴
	public String searchPW(String user_id, String user_email) {
		String searchPW = "";
		try {
			conn = init();
			String SQL = "SELECT user_pw FROM member WHERE user_id=? AND user_email=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_email);
			rs = pstmt.executeQuery();// 컬럼에 내가 입력한 행이 모두 들어가 있는 상태 //결과값

			while (rs.next()) {
				// if (!(rs.getString(1).equals(user_name) &&
				// rs.getString(2).equals(user_email))) {
				// return 1;// 아이디 존재
				// } else
				// return 0;// 아이디없다
				// if(rs.getString(1).equals(user_id))
				searchPW = rs.getString(1);
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
		return searchPW;

	}// end searchPW///////////////////////////////////////////////

	// 마이페이지에 정보를 나오게 하기 위한 메소드
	public MemDTO myPage(String user_id) {
		MemDTO dto = null;
		try {
			conn = init();
			String sql = "SELECT * FROM member WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemDTO();
				dto.setuser_id(rs.getString("user_id"));
				dto.setuser_name(rs.getString("user_name"));
				dto.setuser_birth(rs.getString("user_birth"));
				dto.setuser_email(rs.getString("user_email"));
				dto.setuser_phone(rs.getString("user_phone"));
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
		return dto;
	}// end myPage()//////////////////////////////////

}// end class