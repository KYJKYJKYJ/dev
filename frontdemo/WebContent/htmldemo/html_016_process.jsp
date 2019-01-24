<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>html_016_process</title>
</head>
<body>
<% //자바 스크립트를 사용하기 위해서 % 줘야함
	//html_016_process.jsp?fid=nananan1213&fpass=1213
	String fid = request.getParameter("fid");
	String fpass = request.getParameter("fpass");
	//request는 응답 받는 것을 위해 기본으로 생성 되어있는 객체
%>

<p><%=fid %> / <%=fpass %> </p>
</body>
</html>