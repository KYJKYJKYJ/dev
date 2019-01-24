package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.InformationDTO;
import DAO.InformationDAO;

public class InformationDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static InformationDAO dao = new InformationDAO();
	
	public static InformationDAO getInstance() {
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
	
	//information DB 안 이미지 주소경로 받아서 출력
	public List<InformationDTO> printContent(int num) {
		List<InformationDTO> aList = new ArrayList<InformationDTO>();
		try {
			conn = init();
			String sql = "select info_upload, info_text from information where info_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();			
			
			while(rs.next()) {
				InformationDTO dto = new InformationDTO();
				dto.setInfo_upload(rs.getString("info_upload"));
				dto.setInfo_text(rs.getString("info_text"));
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
	}

}