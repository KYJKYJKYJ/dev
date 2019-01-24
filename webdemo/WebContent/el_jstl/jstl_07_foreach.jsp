<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_07_foreach</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%
	int[] num = new int[] {10, 20, 30, 40, 50};
	for(int i = 0; i < num.length; i++)
		out.print(num[i] + " ");
%>
<hr/>
<%-- 스크립트릿에 선언되어있는 변수 또는 자원들을 참조할 때나 출력할 때에는 표현식()을 이용 
태그에서 선언되어있는 변수(jstl)들은 표현언어(${})를 이용하면 된다. --%>
<c:forEach items="<%=num %>" var="i">
	<p><c:out value="${i}" /></p>
</c:forEach>

<!-- varStatus : 반복상태를 갖는 속성이다. -->
<c:forEach items="<%=new int[]{10,20,30,40,50} %>" var="i" varStatus="status" step="2">
<p>
	<span>count:${ status.count }</span> <!-- 반복문 돌린 횟수 리턴 -->
	<span>[${status.index}]=</span> <!-- 요소의 인덱스 리턴 -->
	<c:out value="${i}" />
</p>

<%-- html용 주석(<!-- -->)안에 ${}가 포함되면 주석으로 인정이 안되서 오류나니까 조심 --%>

</c:forEach>
</body>
</html>