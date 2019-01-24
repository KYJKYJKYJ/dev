package KHGYM_Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import DAO.ReviewBoardDAO;
import KHGYM_Actions.LoginAction;
import KHGYM_Actions.LogoutAction;
import KHGYM_Actions.MemberDeleteAction;
import KHGYM_Actions.MemberIDChechkAction;
import KHGYM_Actions.MemberJoinAction;
import KHGYM_Actions.MemberModifyAction;
import KHGYM_Actions.MemberModifyProAction;
import KHGYM_Actions.MyPageAction;
import KHGYM_Actions.MyPageDeleteAction;
import KHGYM_Actions.Notice_DeleteAction;
import KHGYM_Actions.Notice_FileDownLoadAction;
import KHGYM_Actions.Notice_ListAction;
import KHGYM_Actions.Notice_UpdateFormAction;
import KHGYM_Actions.Notice_UpdateProAction;
import KHGYM_Actions.Notice_ViewAction;
import KHGYM_Actions.Notice_WriteAction;
import KHGYM_Actions.QDeleteAction;
import KHGYM_Actions.QFileDownLoadAction;
import KHGYM_Actions.QListAction;
import KHGYM_Actions.QUpdateFormAction;
import KHGYM_Actions.QUpdateProAction;
import KHGYM_Actions.QViewAction;
import KHGYM_Actions.QWriteAction;
import KHGYM_Actions.RegisterAction;
import KHGYM_Actions.Review_DeleteAction;
import KHGYM_Actions.Review_FileDownLoadAction;
import KHGYM_Actions.Review_ListAction;
import KHGYM_Actions.Review_UpdateFormAction;
import KHGYM_Actions.Review_UpdateProAction;
import KHGYM_Actions.Review_WriteAction;

@WebServlet("/home/*")
public class MainController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}// end doGet()////////////////////////////

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);

	}// end doPost()///////////////////////////

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String uri = req.getRequestURI();
		// System.out.println(uri);
		String action = uri.substring(uri.lastIndexOf("/"));
		// System.out.println(action);
		String path = "";

		// 최초 실행시 메인페이지
		if (action.equals("/*") || action.equals("/main.do")) {
			path = "/main.jsp";

			// 메인에서 Join 버튼을 눌렀을때 -> 회원가입 페이지로 이동
		} else if (action.equals("/Mem.do")) {
			path = "/MemberJoinForm.jsp";

			// 회원가입 완료 버튼 누르고 나서 main으로 이동
		} else if (action.equals("/MemberPro.do")) {
			MemberJoinAction join = new MemberJoinAction();
			join.execute(req, resp);
			resp.sendRedirect("main.do");

			// 메인에서 최초 로그인 버튼 눌렀을때 페이지 이동
		} else if (action.equals("/Login.do")) {
			path = "/LoginForm.jsp";

			// 로그페이지에서 로그인 눌렀을때
		} else if (action.equals("/LoginPro.do")) {
			LoginAction login = new LoginAction();
			login.execute(req, resp);

			// resp.sendRedirect("main.do");

			// 로그인창에 있는 아이디 찾기 눌렀을때
		} else if (action.equals("/IdSearch.do")) {
			path = "/MemberIDSearchForm.jsp";

			// 로그인 창에 있는 비밀번호 찾기 눌렀을 때
		} else if (action.equals("/pwSearch.do")) {
			path = "/MemberPWSearchForm.jsp";

			// 아이디찾기 과정을 다 수행 했을때
		} else if (action.equals("/IdSearchPro.do")) {
			/*
			 * MemberIDSearchAction search = new MemberIDSearchAction(); search.execute(req,
			 * resp); // 아이디찾기끝나면 로그인페이지로 이동 resp.sendRedirect("Login.do");
			 */
			// 로그아웃시 메인페이지이동
		} else if (action.equals("/Logout.do")) {
			LogoutAction logout = new LogoutAction();
			logout.execute(req, resp);
			resp.sendRedirect("main.do");
		}
///////////////////////////////////////////////////////////////////
		// 마이페이지 눌렀을때
		else if (action.equals("/MyPage.do")) {
			MyPageAction mypage = new MyPageAction();
			mypage.execute(req, resp);
			path = "/MypageForm.jsp";

			// 마이페이지에서 회원정보 수정 눌렀을때
		} else if (action.equals("/MyPagePro.do")) {
			MyPageAction mypage = new MyPageAction();
			mypage.execute(req, resp);
			path = "/MemberModifyForm.jsp";

			// 회원정보 수정을 다하고, 수정완료를 눌렀을때
		} else if (action.equals("/MemberModifyPro.do")) {
			MemberModifyProAction modify = new MemberModifyProAction();
			modify.execute(req, resp);

			MyPageAction mypage = new MyPageAction();
			mypage.execute(req, resp);

			path = "/MypageForm.jsp";
		}

		// 회원탈퇴
		else if (action.equals("/delete.do")) {
			MemberDeleteAction delete = new MemberDeleteAction();
			delete.execute(req, resp);
			resp.sendRedirect("main.do");

////////////////////////////////////////////////////////////////////////////			

		}
		// KH-GYM소개 페이지
		else if (action.equals("/greeting.do")) {
			path = "/greeting.jsp";

			// 강사진 페이지
		} else if (action.equals("/instructor.do")) {
			path = "/instructor.jsp";

			// 라운지뷰 페이지
		} else if (action.equals("/loungeview.do")) {
			path = "/loungeview.jsp";

			// 헬스장 위치 페이지
		} else if (action.equals("/location.do")) {
			path = "/location.jsp";

			// 프로그램 소개 페이지
		} else if (action.equals("/aboutprogram.do")) {
			path = "/aboutprogram.jsp";

			// 프로그램등록 페이지
		} else if (action.equals("/registration.do")) {
			path = "../registerview/registration.jsp";

			// 프로그램등록Pro
		} else if (action.equals("/reg_Process.do")) {
			RegisterAction regProcess = new RegisterAction();
			regProcess.execute(req, resp);
			path = "../registerview/registration_success.jsp";

			// 프로그램 취소
		} else if (action.equals("/registerDelete.do")) {
			MyPageDeleteAction delProcess = new MyPageDeleteAction();
			delProcess.execute(req, resp);
			path = "/home/MyPage.do";

///////////////////////////////////////////////////////////////////////////////
			// 공지사항 게시판
		} else if (action.equals("/notice.do") || action.equals("/nlist.do")) {
			Notice_ListAction list = new Notice_ListAction();
			list.execute(req, resp);
			path = "../noticeview/list.jsp";

		} else if (action.equals("/nview.do")) {
			Notice_ViewAction view = new Notice_ViewAction();
			view.execute(req, resp);
			path = "../noticeview/view.jsp";

		} else if (action.equals("/nwriteForm.do")) { /* 글쓰기 버튼누름(글쓰는 화면) */
			path = "../noticeview/write.jsp";

		} else if (action.equals("/nwrite.do")) { /* 글 입력(insert), 제목글입력, 답변글입력 () */
			Notice_WriteAction write = new Notice_WriteAction();
			MultipartRequest multi = write.execute(req, resp); // 글이 저장됨
			resp.sendRedirect("nlist.do?npageNum=" + multi.getParameter("npageNum"));

		} else if (action.equals("/ndownload.do")) {
			Notice_FileDownLoadAction download = new Notice_FileDownLoadAction();
			download.execute(req, resp);
		} else if (action.equals("/nupdateForm.do")) { /* 수정 페이지로 이동 */
			Notice_UpdateFormAction updateForm = new Notice_UpdateFormAction();
			updateForm.execute(req, resp);
			path = "../noticeview/update.jsp";
		} else if (action.equals("/nupdatePro.do")) { /* 수정하기 */
			Notice_UpdateProAction updatePro = new Notice_UpdateProAction();
			MultipartRequest multi = updatePro.execute(req, resp);
			resp.sendRedirect("nlist.do?npageNum=" + multi.getParameter("npageNum"));
		} else if (action.equals("/ndelete.do")) {// temp에 있는것도 삭제되는지 확인하자
			Notice_DeleteAction write = new Notice_DeleteAction();
			write.execute(req, resp);
			resp.sendRedirect("nlist.do?pageNum=" + req.getParameter("pageNum"));
			// path = "../noticeview/list.jsp";
///////////////////////////////////////////////////////////////////////////////
			// Q&A 게시판
		} else if (action.equals("/qna.do") || action.equals("/qlist.do")) {
			QListAction list = new QListAction();
			list.execute(req, resp);
			path = "../QBoardView/Qlist.jsp";

		} else if (action.equals("/qview.do")) {
			// 뷰액션 생성하고 ~~호출한 다음에 페이지로 가야되니까
			QViewAction view = new QViewAction();
			view.execute(req, resp);
			path = "../QBoardView/Qview.jsp";

		} else if (action.equals("/qwriteForm.do")) {
			path = "../QBoardView/Qwrite.jsp";

		} else if (action.equals("/qwrite.do")) {
			QWriteAction write = new QWriteAction();
			MultipartRequest multi = write.execute(req, resp);
			/* 특정 페이지에서 답변쓰고 난 후 해당 페이지로 돌아오기. */
			resp.sendRedirect("qlist.do?qpageNum=" + multi.getParameter("qpageNum")); /* 여기서 응답이 한번되었다면 */

		} else if (action.equals("/qdownload.do")) {
			QFileDownLoadAction download = new QFileDownLoadAction();
			download.execute(req, resp);

		} else if (action.equals("/qupdateForm.do")) {
			QUpdateFormAction updateFrom = new QUpdateFormAction();
			updateFrom.execute(req, resp);
			path = "../QBoardView/Qupdate.jsp";

		} else if (action.equals("/qupdatePro.do")) {
			QUpdateProAction updatePro = new QUpdateProAction();
			MultipartRequest multi = updatePro.execute(req, resp);
			resp.sendRedirect("qlist.do?qpageNum=" + multi.getParameter("qpageNum"));

		} else if (action.equals("/qdelete.do")) {
			QDeleteAction write = new QDeleteAction();
			write.execute(req, resp);
			resp.sendRedirect("qlist.do?qpageNum=" + req.getParameter("qpageNum"));
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			// review게시판 첫화면
		} else if (action.equals("/review.do") || action.equals("/rlist.do")) {
			Review_ListAction list = new Review_ListAction();
			list.execute(req, resp);
			path = "../reviewview/Review_list.jsp";
		} else if (action.equals("/rview.do")) {
			int num = Integer.parseInt(req.getParameter("num"));
			ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
			req.setAttribute("dto", dao.writingView(num));
			RequestDispatcher dis = req.getRequestDispatcher("../reviewview/Review_view.jsp");
			dis.forward(req, resp);
			/*
			 * Review_ViewAction view = new Review_ViewAction(); view.execute(req, resp);
			 * path = "../reviewview/Review_view.jsp"; path="../view.do";
			 */
		} else if (action.equals("/rwriteForm.do")) {
			path = "../reviewview/Review_write.jsp";
		} else if (action.equals("/rwrite.do")) {
			Review_WriteAction write = new Review_WriteAction();
			MultipartRequest multi = write.execute(req, resp);
			resp.sendRedirect("rlist.do?rpageNum=" + multi.getParameter("rpageNum"));
		} else if (action.equals("/rdownload.do")) {
			Review_FileDownLoadAction download = new Review_FileDownLoadAction();
			download.execute(req, resp);
		} else if (action.equals("/rupdateForm.do")) {
			Review_UpdateFormAction updateForm = new Review_UpdateFormAction();
			updateForm.execute(req, resp);
			path = "../reviewview/Review_update.jsp";
		} else if (action.equals("/rupdatePro.do")) {
			Review_UpdateProAction updatePro = new Review_UpdateProAction();
			MultipartRequest multi = updatePro.execute(req, resp);
			resp.sendRedirect("rlist.do?rpageNum=" + multi.getParameter("rpageNum"));
		} else if (action.equals("/rdelete.do")) {
			Review_DeleteAction write = new Review_DeleteAction();
			write.execute(req, resp);
			resp.sendRedirect("rlist.do?rpageNum=" + req.getParameter("rpageNum"));
			/////////////////////////////////////////////////////////////////////////////////////////
			// 인포메이션 무한스크롤
		} else if (action.equals("/information.do")) {
			path = "/information.jsp";

			// id중복체크
		} else if (action.equals("/IDsearch.do")) {
			MemberIDChechkAction idcheck = new MemberIDChechkAction();
			idcheck.execute(req, resp);
		}

		if (path != "") {
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		}

	}// end doProcess()/////////////////////////
}// end class