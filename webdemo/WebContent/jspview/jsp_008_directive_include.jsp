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
	<%@ include file="jsp_008_directive_value.jsp"%>

	<%
		//include지시어(directive)
		//jsp_008_directive_value.jsp 페이지에 자원을 현제페이지에서
		//사용할 수 있도록 페이지를 include한다.
		int x = 20;
		out.print(x + y);
	%>
</body>
</html>