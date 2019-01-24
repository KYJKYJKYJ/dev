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
import DTO.ReviewBoardDTO;
import DTO.ReviewReplyDTO;

public class ReviewBoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static ReviewBoardDAO dao = new ReviewBoardDAO();

	public static ReviewBoardDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "khgym";
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
	
	
	//항목 갯수 파악
	public int rowTotalCount(String col, String word) {
		int cnt = 0;
		
		try {
			conn = init();
			if(col.equals("none")) {
				String sql = "select count(*) from review where user_id like ? or review_title like ? or review_content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");
			} else if(col.equals("user_id")) {
				String sql = "select count(*) from review where user_id like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("title")) {
				String sql = "select count(*) from review where review_title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("content")) {
				String sql = "select count(*) from review where review_content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("title_content")) {
				String sql = "select count(*) from review where review_title like ? or review_content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
			} else {
				String sql = "select count(*) from review";
				pstmt = conn.prepareStatement(sql);
			}
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
				cnt=rs.getInt(1);
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
	
	//검색 기능이 더 해진 리스트 출력
		public List<ReviewBoardDTO> writingList(String col, String word, PageDTO pdto) {
			List<ReviewBoardDTO> searchList = new ArrayList<ReviewBoardDTO>();
			
			try {
				conn = init();
				if(col.equals("none")) {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review where user_id like ? or review_title like ? or review_content like ? order by review_num desc )a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word + "%");
					pstmt.setString(2, "%" + word + "%");
					pstmt.setString(3, "%" + word + "%");
					pstmt.setInt(4, pdto.getStartRow());
					pstmt.setInt(5, pdto.getEndRow());
				} else if(col.equals("user_id")) {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review where user_id like ? order by review_num desc)a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word + "%");
					pstmt.setInt(2, pdto.getStartRow());
					pstmt.setInt(3, pdto.getEndRow());
				} else if (col.equals("title")) {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review where review_title like ? order by review_num desc)a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word + "%");
					pstmt.setInt(2, pdto.getStartRow());
					pstmt.setInt(3, pdto.getEndRow());
				} else if (col.equals("content")) {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review where review_content like ? order by review_num desc)a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word + "%");
					pstmt.setInt(2, pdto.getStartRow());
					pstmt.setInt(3, pdto.getEndRow());
				} else if (col.equals("title_content")) {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review where review_title like ? or review_content like ? order by review_num desc)a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word + "%");
					pstmt.setString(2, "%" + word + "%");
					pstmt.setInt(3, pdto.getStartRow());
					pstmt.setInt(4, pdto.getEndRow());
				} else {
					String sql = "SELECT b.* FROM (SELECT rownum rm, a.* " + 
							"FROM (select * from review order by review_num desc)a)b " + 
							"WHERE rm >= ? and rm <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, pdto.getStartRow());
					pstmt.setInt(2, pdto.getEndRow());
				}
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ReviewBoardDTO dto = new ReviewBoardDTO();
					dto.setReview_num(rs.getInt("review_num"));
					dto.setUser_id(rs.getString("user_id"));
					dto.setReview_title(rs.getString("review_title"));
					dto.setReview_content(rs.getString("review_content"));
					dto.setReview_date(rs.getString("review_date"));
					dto.setReview_upload(rs.getString("review_upload"));

					searchList.add(dto);
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
			
			return searchList;
		}
	
	// 게시글 보기
	public ReviewBoardDTO writingView(int num) {
		ReviewBoardDTO dto = null;

		try {
			conn = init();
			String sql = "select * from review where review_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new ReviewBoardDTO();
				dto.setUser_id(rs.getString("user_id"));
				dto.setReview_title(rs.getString("review_title"));
				dto.setReview_content(rs.getString("review_content"));
				dto.setReview_upload(rs.getString("review_upload"));
				dto.setReview_date(rs.getString("review_date"));
				dto.setReview_num(rs.getInt("review_num"));
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

	//게시글 입력
		public void writingInsert(ReviewBoardDTO dto) {
			try {
				conn = init();
				String sql = "insert into review(review_num, user_id, review_date, review_title, review_content, review_upload) " +
						     "values(review_num.nextval, ?, sysdate, ?, ?, ?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getUser_id());
				pstmt.setString(2, dto.getReview_title());
				pstmt.setString(3, dto.getReview_content());
				pstmt.setString(4, dto.getReview_upload());		
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
		}
		
		//첨부파일
		public String file(int num) {
			String fileStr = "";
			try {
				conn = init();
				String sql = "select review_upload from review where review_num = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();			
				
				if(rs.next())
					fileStr=rs.getString("review_upload");			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
					
			return fileStr;
		}
		
		//게시글 수정
		public void writingUpdate(ReviewBoardDTO dto) {
			try {
				conn = init();
				String sql = "update review set review_title = ?, ";
				sql += "review_content = ?, review_upload = ? where review_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getReview_title());
				pstmt.setString(2, dto.getReview_content());
				pstmt.setString(3, dto.getReview_upload());
				pstmt.setInt(4, dto.getReview_num());
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
		}
		
		//게시글 삭제
		public void writingDelete(int num) {
			try {
				conn = init();
				String sql = "delete from review where review_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
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
		}
		
	//댓글 목록 출력
	public List<ReviewReplyDTO> replyList(int num) {
		List<ReviewReplyDTO> replyList = new ArrayList<ReviewReplyDTO>();

		try {
			conn = init();
			String sql = "select * from review_reply where review_num = ? order by re_col";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewReplyDTO dto = new ReviewReplyDTO();
				dto.setRe_col(rs.getInt("re_col"));
				dto.setReview_num(rs.getInt("review_num"));
				dto.setRe_content(rs.getString("re_content"));
				dto.setUser_id(rs.getString("user_id"));
				replyList.add(dto);
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
		return replyList;
	}
	
	//댓글 입력
	public void replyInsert(ReviewReplyDTO dto) {
		 try {
			conn = init();
			String sql = "insert into review_reply(re_col, review_num, re_content, user_id) values(review_num.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getReview_num());
			pstmt.setString(2, dto.getRe_content());
			pstmt.setString(3, dto.getUser_id());
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
	}
	
	//댓글 수정
	public void replyUpdate(ReviewReplyDTO dto) {
		try {
			conn = init();
			String sql = "update review_reply set re_content = ? where re_col = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRe_content());
			pstmt.setInt(2, dto.getRe_col());
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
	}
	
	//댓글 삭제
	public void replyDelete(int col) {
		try {
			conn = init();
			String sql = "delete from review_reply where re_col = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, col);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
