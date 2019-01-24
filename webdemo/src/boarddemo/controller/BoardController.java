package boarddemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import boarddemo.action.DeleteAction;
import boarddemo.action.FileDownLoadAction;
import boarddemo.action.ListAction;
import boarddemo.action.UpdateFormAction;
import boarddemo.action.UpdateProAction;
import boarddemo.action.ViewAction;
import boarddemo.action.WriteAction;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		// uri : /board/*
		// System.out.println("uri : " + uri);
		
		// uri : /board/* 에서 두번째 / 부터 마지막 가지 가져옴
		String action = uri.substring(uri.lastIndexOf("/"));
		// /* 출력, 제목1 누르면 view.do 만 출력
		//System.out.println("action : " + action);
		
		
		//진입점을 하나로 만들어서 분리하여 작업하기
		String path="";
		if(action.equals("/*") || action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);		
			path = "/boardview/list.jsp";
		} else if(action.equals("/view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path="/boardview/view.jsp";
		} else if(action.equals("/writeForm.do")) {
			path="/boardview/write.jsp";
		} else if(action.equals("/write.do")) {
			WriteAction write = new WriteAction();
			MultipartRequest multi = write.execute(req, resp);
			resp.sendRedirect("list.do?pageNum="+multi.getParameter("pageNum"));
			//리스트를 다시 받을때 WriteAction을 거치고 DAO를 통해 DB에 저장이 됨
			//여기서 근데 foward 방식을 사용하면 write된 리스트를 받는게 아니라
			//그냥 리스트를 다시 전달 받기 때문에 write된 리스트를 받지 못함
			//response 방식(sendredirect)를 이용하여 적용된 리스트를
			//list.do를 통해 전달 받으라고 요청해야지 받을 수 있음
		} else if(action.equals("/download.do")) {
			FileDownLoadAction download = new FileDownLoadAction();
			download.execute(req, resp);
		} else if(action.equals("/updateForm.do")) {
			UpdateFormAction updateForm = new UpdateFormAction();
			updateForm.execute(req, resp);
			path="/boardview/update.jsp";
		} else if(action.equals("/updatePro.do")) {
			UpdateProAction updatePro = new UpdateProAction();
			MultipartRequest multi = updatePro.execute(req, resp);
			resp.sendRedirect("list.do?pageNum=" + multi.getParameter("PageNum"));
		} else if(action.equals("/delete.do")) {
			DeleteAction delete = new DeleteAction();
			delete.execute(req, resp);
			resp.sendRedirect("list.do?pageNum=" + req.getParameter("PageNum"));
			
		} 
		
		if(path != "") {
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		}
	}
}
