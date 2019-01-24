<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%-- 
	jsp:include액션태그와 같은 기능을 처리함
--%>
<p>before</p>
<c:import url="jstl_10_top.jsp">
	<c:param name="data" value="100" />
</c:import>
<p>after</p>
</body>
</html>