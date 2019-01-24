package KHGYM_Actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;

public class MyPageDeleteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		RegisterDAO dao = RegisterDAO.getInstance();
		int num = Integer.parseInt(req.getParameter("num"));
		dao.registerDelete(num);
	}
}
