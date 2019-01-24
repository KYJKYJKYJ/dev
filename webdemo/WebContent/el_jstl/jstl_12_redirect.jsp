<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_12_redirect</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%-- sendRedirect()와 같은 기능을 제공해주는 태그 --%>
<c:redirect url="el_03.jsp" />

<%--
foward : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request, response 객체를 공유한다.
redirect : 새로운 페이지에서는 request, response객체가 새롭게 생성된다.

첫째, URL의 변화여부(변화 O -> redirect, 변화 X -> forward)
둘째, 객체의 재사용여부(재사용 O -> forward, 재사용 X -> redirect)
--%>
</body>
</html>