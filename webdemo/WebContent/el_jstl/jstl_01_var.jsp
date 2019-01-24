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
<!--
	커스텀 태그 (custom tag)
	1. jsp에서 사용할 수 있도록 사용자 정의 태그를 의미한다.
	2. jstl(JSP Standard Tag Library)는 jsp페이지에서 많이 사용되는 논리적 판단, 반복문 처리, 데이터베이스 처리를 위한 표준 커스텀 태그이다.
	(현재는 데이터베이스 처리에는 쓰이지 않음, servlet의 등장)
-->

<!-- 
	int data = 10;
-->

<!-- 변수선언 -->
<c:set var="data" value="10" />
<p>${ data }</p>
<p><c:out value="${ data }" /></p>

<!-- data 변수 제거 -->
<c:remove var="data" />
<p>data:${ data }</p>

<%
	int num = 20;
%>

<p>num:${num}</p> <!-- 출력안됨 -->
<p>num:<c:out value="<%=num%>" /></p>

<%
	request.setAttribute("st", "request");
%>
<p><c:out value='<%=request.getAttribute("st") %>' /></p>
<!-- 내부에 큰따옴표가 있어서 작은 따옴표로 감쌈 -->
</body>
</html>