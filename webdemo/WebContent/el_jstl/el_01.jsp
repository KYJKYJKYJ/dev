<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_01</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</head>
<body>
<%--
	EL(Expression Language) : 표현언어
	1. jsp스크립트를 대신해서 속성값들을 편리하게 출력할 수 있도록 제공되는 언어이다.
	2. ${}
	
	
--%>

<%
	//page영역에 p1이름으로 page값이 저장된다.
	//page영역은 현재 페이지에서만 참조 가능하다. 지역변수 처럼 사용 가능
	pageContext.setAttribute("p1", "page");
	
	//request영역에 p2이름으로 request값이 저장된다.
	//클라이언트로부터 하나의 요청이 들어와서 서버가 일을 수행한 후 응답을 보낼 때까지 계속 사용할 수 있는 scope
	request.setAttribute("p2", "request");
	
	//session영역에 p3이름으로 session값이 저장된다.
	session.setAttribute("p3", "session"); //한 클라이언트만
	
	//application p4이름으로 application값이 저장된다.
	application.setAttribute("p4", "application"); //모든 클라이언트가 공유		
%>

<p>
	${pageScope.p1} / ${requestScope.p2} / ${sessionScope.p3} / ${applicationScope.p4}
</p>

<%--
	속성값을 가져올때 영역을 명시하지 않으면
	page -> request -> session -> application 순으로 검색을 함	
--%>
<p>
	${p3}
</p>
</body>
</html>