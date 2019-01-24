<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_011_url</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<!-- <a href="jstl_11_call.jsp?num=10&data=20"> 파라미터값 보냄
	jstl
</a> --> <!-- 보내는 파라미터값이 복잡하거나 어려울 경우엔 활용하기가 쉽지 않음 -->

<c:url var="user" value="jstl_11_call.jsp">
	<c:param name="num" value="10" />
	<c:param name="data" value="20" />
</c:url>

<a href="${user}">jstl</a>
</body>
</html>