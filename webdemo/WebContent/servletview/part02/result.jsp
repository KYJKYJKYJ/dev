<%@page import="servletdemo.part02.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>
<p><%=dto.getFid() %> / <%=dto.getFpass() %></p>
</body>
</html>