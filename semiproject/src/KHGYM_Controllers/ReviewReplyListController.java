package KHGYM_Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DAO.ReviewBoardDAO;
import DTO.ReviewReplyDTO;

@WebServlet("/home/replyList")
public class ReviewReplyListController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		List<ReviewReplyDTO> list = dao.replyList(num);
		// json으로 바꾸기
		JSONArray arr = new JSONArray();
		for (ReviewReplyDTO dto : list) {
			JSONObject obj = new JSONObject();
			obj.put("col", dto.getRe_col());
			obj.put("userreplyid", dto.getUser_id());
			obj.put("num", dto.getReview_num());
			obj.put("content", dto.getRe_content());
			arr.add(obj);
		}

		// 보내는 text를 json으로 처리
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(arr);
		// System.out.println(arr);
	}
}
