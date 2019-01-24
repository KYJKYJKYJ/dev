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
<%
	//scope(영역) : 데이터를 참조 할 수 있도록 저장해놓은 공간
	
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

<jsp:forward page="jsp_010_next.jsp" />
</body>
</html>