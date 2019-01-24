<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_08_foreach</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%
	ArrayList<Integer> aList = new ArrayList<Integer>();
	aList.add(new Integer(10));
	aList.add(new Integer(20));
	aList.add(new Integer(30));
	aList.add(new Integer(40));
	aList.add(new Integer(50));
	for(int i = 0; i < aList.size(); i++)
		out.print(aList.get(i)+ " ");
	
	request.setAttribute("aList", aList);
%>
<hr/>
<c:forEach items="${requestScope.aList}" var="data">
<%-- 어떤 영역에 속해있는지 명시해주는 것이 좋다. 그냥 ${aList}도 가능하긴 하다 --%>
<p>
   <c:out value="${data}" />
</p>
</c:forEach>
</body>
</html>