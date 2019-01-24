<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<p>
	page:<%=pageContext.getAttribute("p1") %></p>
<p>
	request:<%=request.getAttribute("p2") %></p>
<p>
	session:<%=session.getAttribute("p3") %></p>
<p>
	application:<%=application.getAttribute("p4") %></p>
</body>
</html>