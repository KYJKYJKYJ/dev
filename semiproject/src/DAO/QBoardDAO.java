package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTO.QBoardDTO;
import DTO.QPageDTO;

public class QBoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public QBoardDAO() {

	}

	private static QBoardDAO dao = new QBoardDAO();

	public static QBoardDAO getInstance() {
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

	public List<QBoardDTO> listMethod(String col, String word, QPageDTO pdto) {
		List<QBoardDTO> aList = new ArrayList<QBoardDTO>();

		try {
			conn = init();
			  if(col.equals("none")) {


			
			 String sql = "SELECT b.*"
			 		+ "FROM (SELECT rownum rm, a.* " + 
	                  "FROM (select *"
	                + "from qna "
	                + "where q_writer like ? or q_subject like ? or q_content like ? order by q_ref desc, q_num asc )a)b " + 
	                  "WHERE rm >= ? and rm <= ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");
				pstmt.setInt(4, pdto.getStartRow());
				pstmt.setInt(5, pdto.getEndRow());

			} else if(col.equals("q_writer")) {
		        String sql = "SELECT b.* "
		            		+ "FROM (SELECT rownum rm, a.* " 
		            		+ "FROM (select * "
		            		+ "from qna "
		            		+ "where q_writer like ? order by q_ref desc, q_num asc)a)b "
		            		+ "WHERE rm >= ? and rm <= ?";
	            pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, pdto.getStartRow());
				pstmt.setInt(3, pdto.getEndRow());
				
			} else if (col.equals("q_subject")) {
				String sql = "SELECT b.* "
						+ "FROM (SELECT rownum rm, a.* "
						+ "FROM (select * "
						+ "from qna "
						+ "where q_subject like ? order by q_ref desc, q_num asc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, pdto.getStartRow());
				pstmt.setInt(3, pdto.getEndRow());
				
			} else if (col.equals("q_content")) {
				String sql = "SELECT b.* "
						+ "FROM (SELECT rownum rm, a.* "
						+ "FROM (select * "
						+ "from qna "
						+ "where q_content like ? order by q_ref desc, q_num asc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, pdto.getStartRow());
				pstmt.setInt(3, pdto.getEndRow());
				
			} else if (col.equals("q_content")) {
				String sql = "SELECT b.* "
						+ "FROM (SELECT rownum rm, a.* "
						+ "FROM (select * "
						+ "from qna "
						+ "where q_subject like ? or q_content like ? order by q_ref desc, q_num asc)a)b "
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setInt(3, pdto.getStartRow());
				pstmt.setInt(4, pdto.getEndRow());
			} else {
				String sql = "SELECT b.* "
						+ "FROM (SELECT rownum rm, a.* "
						+ "FROM (select * "
						+ "from qna order by q_ref desc, q_num asc)a)b " 
						+ "WHERE rm >= ? and rm <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pdto.getStartRow());
				pstmt.setInt(2, pdto.getEndRow());
			}
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QBoardDTO dto = new QBoardDTO();
				dto.setQ_num(rs.getInt("q_num"));
				dto.setQ_writer(rs.getString("q_writer"));
				dto.setQ_subject(rs.getString("q_subject"));
				dto.setQ_re_level(rs.getInt("q_re_level"));
				dto.setQ_upload(rs.getString("q_upload"));
				dto.setQ_reg_date(rs.getString("q_reg_date"));
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
	}// end listMethod()


	/* num을 가져오기 위한 메소드 */
	public QBoardDTO viewMethod(int q_num) {
		QBoardDTO dto = null;

		try {
			conn = init();
			String sql = "select * from qna where q_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new QBoardDTO();
				dto.setQ_num(rs.getInt("q_num"));
				dto.setQ_writer(rs.getString("q_writer"));
				dto.setQ_subject(rs.getString("q_subject"));
				dto.setQ_content(rs.getString("q_content"));
				dto.setQ_upload(rs.getString("q_upload"));
				dto.setQ_ref(rs.getInt("q_ref"));
				dto.setQ_re_step(rs.getInt("q_re_step"));
				dto.setQ_re_level(rs.getInt("q_re_level"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}// end viewMethod()
	
	public int rowTotalCount(String col, String word) {
		int cnt = 0;
		
		try {
			conn = init();
			if (col.equals("none")) {
				String sql = "select count(*) "
						+ "from qna "
						+ "where  q_writer like ? or q_subject like ? or q_content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");
				
			}else if(col.equals("q_writer")) {
	            String sql = "select count(*) "
	            		+ "from qna "
	            		+ "where q_writer like ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + word + "%");
	            
			} else if (col.equals("q_subject")) {
				String sql = "select count(*) "
						+ "from qna "
						+ "where q_subject like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				
			}else if (col.equals("q_content")) {
	            String sql = "select count(*) "
	            		+ "from qna "
	            		+ "where q_content like ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + word + "%");
	            
	        }else if (col.equals("q_content")) {
	            String sql = "select count(*) "
	            		+ "from qna "
	            		+ "where q_subject like ? or q_content like ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + word + "%");
	            pstmt.setString(2, "%" + word + "%");
	            
	        } else {
	            String sql = "select count(*) "
	            		+ "from qna";
	            pstmt = conn.prepareStatement(sql);
	         }

			
			/*String sql = "select count(*) from qna";
			pstmt = conn.prepareStatement(sql);*/
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				cnt = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {
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
	}//end rowTotalCount()
	
	public void insertMethod(QBoardDTO dto) {
		try {
			conn = init();
			/*제목글일때 실행해야하기 때문에 조건을 건다.*/
			if(dto.getQ_re_level() == 0) {
				/*제목글이면..*/
			/*제목글을 처리하기위한 쿼리문*/
			String sql = "insert into qna(q_num, q_writer, q_subject, q_reg_date, q_ref, q_re_step, q_re_level, q_content, q_ip, q_upload) "
						+ "values(qna_q_num_seq.nextval,?,?,sysdate, qna_q_num_seq.nextval,0,0,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQ_writer());
			pstmt.setString(2, dto.getQ_subject());
			pstmt.setString(3, dto.getQ_content());
			pstmt.setString(4, dto.getQ_ip());
			pstmt.setString(5, dto.getQ_upload());
			} else {
				/*답변글이면..*/
				String sql = "insert into qna(q_num, q_writer, q_subject, q_reg_date, q_ref, q_re_step, q_re_level, q_content, q_ip, q_upload) "
							+ "values(qna_q_num_seq.nextval,?,?,sysdate, ?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getQ_writer());
				pstmt.setString(2, dto.getQ_subject());
				
				/*추가*/
				pstmt.setInt(3, dto.getQ_ref());
				pstmt.setInt(4, dto.getQ_re_step());
				pstmt.setInt(5, dto.getQ_re_level());
				
				pstmt.setString(6, dto.getQ_content());
				pstmt.setString(7, dto.getQ_ip());
				pstmt.setString(8, dto.getQ_upload());
			}
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
	}//end insertMethod()
	
	/*답변글인 경우 insertMethod() 하기 전에 reStepMethod()을 해줘야 한다.*/
	public void reStepMethod(HashMap<String, Integer> map) {
		try {
			conn = init();
			String sql = "update qna "
					+ "set q_re_step = q_re_step+1 "
					+ "where q_ref = ? and q_re_step > ?";
			/*답변글 같은 경우 가장 최근에 입력된게 먼저 출력되게 하기 위해서 업데이트를 한다.*/
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, map.get("q_ref"));
			pstmt.setInt(2, map.get("q_re_step"));
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
	}//end reStepMethod()
	
	public String fileMethod(int num) {
		String fileName = null;
		try {
			conn = init();
			String sql = "select q_upload"
						+ "from qna where q_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
				fileName = rs.getString("q_upload");
		} catch (ClassNotFoundException | SQLException e) {
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
	}//end fileMethod()
	
	public void updateMethod(QBoardDTO dto) {
		try {
			conn = init();
			String sql = "update qna set q_subject = ?, q_content = ?, q_upload = ?"
						+ "where q_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getQ_subject());
			pstmt.setString(2, dto.getQ_content());
			pstmt.setString(3, dto.getQ_upload());
			pstmt.setInt(4, dto.getQ_num());
			pstmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end updateMethod()
	
	public void deleteMethod(int num) {
		try {
			conn = init();
			String sql = "delete from qna"
					+ " where q_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end deleteMethod()
	
	
	
	
}// end class
