package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.PageDTO;
import DTO.NoticeDTO;

public class NoticeDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public NoticeDAO() {
	}

	private static NoticeDAO dao = new NoticeDAO();

	public static NoticeDAO getInstance() {
		return dao;
	}

	// 1.Connection 객체값 받아오기 (DriverManager에 있는 getConnection를 이용)
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

	// ----------------------------------------------------------------------------
	// 총 레코드수 반환을 위한 작업
	public int search_rowTotalCount(String col, String word) {
		int cnt = 0;

		try {
			conn = init();

			if (col.equals("none")) {
				String sql = "select count(*) from notice where  notice_title like ? or notice_contents like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
			} else if (col.equals("title")) {
				String sql = "select count(*) from notice where notice_title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("content")) {
				String sql = "select count(*) from notice where notice_contents like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("title_content")) {
				String sql = "select count(*) from notice where notice_title like ? or notice_contents like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");

			} else {

				String sql = "select count(*) from notice";
				pstmt = conn.prepareStatement(sql);
			}
			rs = pstmt.executeQuery();

			if (rs.next())
				cnt = rs.getInt(1); // count(*)

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

		return cnt;
	}// end rowTotalCount()
		// ------------------------------------------------------------------------------

	// 테이블에 저장되어 있는 레코드 값을 받아와야 함
	public List<NoticeDTO> listMethod(String col, String word, PageDTO pdto) { // pdto에서 startRow와 endRow를 사용 (시작레코드,
																				// 끝레코드)
		List<NoticeDTO> aList = new ArrayList<NoticeDTO>();

		try {
			conn = init();
			if (col.equals("none")) {
				String sql = "SELECT b.* FROM (SELECT rownum rm, a.* "
						+ "FROM (select * from notice where notice_title like ? or notice_contents like ? order by notice_num desc )a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setInt(3, pdto.getStartRow());
				pstmt.setInt(4, pdto.getEndRow());

			} else if (col.equals("title")) {
				String sql = "SELECT b.* FROM (SELECT rownum rm, a.* "
						+ "FROM (select * from notice where notice_title like ? order by notice_num desc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, pdto.getStartRow());
				pstmt.setInt(3, pdto.getEndRow());

			} else if (col.equals("content")) {
				String sql = "SELECT b.* FROM (SELECT rownum rm, a.* "
						+ "FROM (select * from notice where notice_contents like ? order by notice_num desc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, pdto.getStartRow());
				pstmt.setInt(3, pdto.getEndRow());

			} else if (col.equals("title_content")) {
				String sql = "SELECT b.* FROM (SELECT rownum rm, a.* "
						+ "FROM (select * from notice where notice_title like ? or notice_contents like ? order by notice_num desc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setInt(3, pdto.getStartRow());
				pstmt.setInt(4, pdto.getEndRow());

			} else {

				// String sql = "select * from notice order by num desc";
				// String sql = "select * from board order by ref desc, re_step"; //ref의 내림차순하고
				// 겹치는 건 re_step의 오름차순으로 정리 (FILO의 형태로 출력할때 사용함)
				String sql = "select b.* " + "from(select rownum rm, a.* " + "from(select * " + "from notice "
						+ "order by notice_num desc)a)b " + "where rm>=? and rm<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pdto.getStartRow()); // 시작레코드값
				pstmt.setInt(2, pdto.getEndRow()); // 끝레코드값
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNotice_num(rs.getInt("notice_num"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_contents(rs.getString("notice_contents"));
				dto.setNotice_upload(rs.getString("notice_upload"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setNotice_date(rs.getString("notice_date"));

				aList.add(dto);
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
		return aList;
	}// end listMethod()

	// 글제목 눌렀을때---------------------------------------------------------------------
	public NoticeDTO viewMethod(int num) {
		NoticeDTO dto = null;
		try {
			conn = init();
			String sql = "select * from notice where notice_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new NoticeDTO();
				dto.setNotice_num(rs.getInt("notice_num"));
				dto.setNotice_title(rs.getString("notice_title"));
				dto.setNotice_contents(rs.getString("notice_contents"));
				dto.setNotice_upload(rs.getString("notice_upload"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setNotice_date(rs.getString("notice_date"));
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

		return dto;
	}

	// 글쓰기
	// ---------------------------------------------------------------------------
	public void insertMethod(NoticeDTO dto) {
		try {
			conn = init();
			String sql = "insert into notice(user_id,notice_date,notice_num,notice_title,notice_contents,notice_upload)"
					+ " values(?,to_char(sysdate,'YY-MM-DD'),notice_num_seq.nextval,?,?,?)";

			pstmt = conn.prepareStatement(sql); // pstmt로 한다 -> 여기의 sql은 컴파일 끝난상태
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getNotice_title());
			pstmt.setString(3, dto.getNotice_contents());
			pstmt.setString(4, dto.getNotice_upload());
			pstmt.executeUpdate();
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

	}
	// ------------------------------------------------------------------------------

	// 다운로드 파일명 리턴
	public String fileMethod(int num) {
		String fileName = null;
		try {
			conn = init();
			String sql = "select notice_upload from notice where notice_num =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next())
				fileName = rs.getString("notice_upload");

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

		return fileName;
	}

	// ------------------------------------------------------------------------------

	public void updateMethod(NoticeDTO dto) {
		try {
			conn = init();
			String sql = "update notice set notice_date=to_char(sysdate,'YY-MM-DD'), notice_title=?, notice_contents=?, notice_upload=? where notice_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_contents());
			pstmt.setString(3, dto.getNotice_upload());
			pstmt.setInt(4, dto.getNotice_num());
			pstmt.executeUpdate();
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
	}// end updateMethod()

	public void deleteMethod(int num) {
		try {
			conn = init();
			String sql = "delete from notice where notice_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
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
	}// end deleteMethod()

}
