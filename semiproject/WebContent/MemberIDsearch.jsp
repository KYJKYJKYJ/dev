<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   String id = (String) session.getAttribute("searchId");
   boolean login = id == null ? false : true;
%>

<%
   if (login) {
%>
ID:
<%=(String) session.getAttribute("searchId")%>

<%
   } else {
%>
ID:아이디가 없습니다.
<%
   }
%>