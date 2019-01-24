<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_09_forToken</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%
	StringTokenizer stn = new StringTokenizer("java/jsp,spring", "/,");
	while(stn.hasMoreTokens())
		out.print(stn.nextToken() + " ");
%>
<hr/>
<p>문자열을 구분해주는 StringTokenizer와 같은 기능을 제공하는 forToken태그</p>
<c:forTokens items="java/jsp,spring" delims="/," var="data">
<p><c:out value="${data}" /></p>
</c:forTokens>
</body>
</html>