<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DTO.RegisterDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){

});
</script>

<link rel="stylesheet" type="text/css" href="../css/Qlist.css" />
<link rel="stylesheet" href="../font/seoulhangangjangm.eot">
<link rel="stylesheet" href="../font/seoulhangangjangm.ttf">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff2">
<style type="text/css">
/* 폰트 받아오기 */
@font-face {
	font-family: 'seoul-hangang-jang-m';
	src: url('../font/seoulhangangjangm.eot');
	src: url('../font/seoulhangangjangm.eot?#iefix')
		format('embedded-opentype'), url('../font/seoulhangangjangm.woff2')
		format('woff2'), url('../font/seoulhangangjangm.woff') format('woff'),
		url('../font/seoulhangangjangm.ttf') format('truetype'),
		url('../font/seoulhangangjangm.svg#seoul-hangang-jang-m')
		format('svg');
	font-weight: normal;
	font-style: normal;
}

/* 모든 전체 폰트 적용하기 */
* {
	font-family: seoul-hangang-jang-m
}

</style>
</head>
<body>
	<option value="">선택</option>
	<c:forEach items="${requestScope.aList}" var="re_time">	
		
		<c:set var="nodata" value="nodata"/>
		
	<c:if test="${re_time eq nodata}">
		<option value="12:00~13:00" id="12:00~13:00">12:00~13:00</option>
		<option value="19:00~20:00" id="19:00~20:00">19:00~20:00</option>
		<option value="20:00~21:00" id="20:00~21:00">20:00~21:00</option> 
	</c:if>
	
	<c:if test="${re_time ne nodata}">
		<option id="re_time" value="${re_time}">${re_time}</option>
	</c:if>

	</c:forEach>
	
</body>
</html>