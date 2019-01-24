<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_027_process</title>
</head>
<body>
<%
	String my_id = request.getParameter("my_id");
	String my_pass = request.getParameter("my_pass");
%>

<p><%=my_id %> / <%=my_pass %></p>
</body>
</html>