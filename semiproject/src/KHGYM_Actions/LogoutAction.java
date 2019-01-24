package KHGYM_Actions;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {

		HttpSession session = req.getSession();
		session.invalidate();

	}// end execute()
}
