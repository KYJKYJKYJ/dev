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
	String fname = (String) request.getAttribute("fname");
	//jsp에서는 request라는 기본 객체가 제공되는데 이게 HttpServletRequest의 객체이다.
%>

<p><%=fname %></p>
</body>
</html>