<%@page import="java.util.List"%>
<%@page import="servletdemo.part03.EmployeesDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList2</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<table>
<thead>
	 <tr>
	 	<th>employee_id</th>
	 	<th>first_name</th>
	 	<th>salary</th>
	 </tr>
</thead>
<tbody>
	<c:forEach items="${requestScope.aList}" var="dto">
	<tr>
		<td><c:out value="${dto.employee_id}" /></td>
		<td><c:out value="${dto.first_name}" /></td>
		<td><c:out value="${dto.salary}" /></td>
		<!-- 객체변수.멤버변수의 이름만 대줘도 알아서 get 메소드를 호출해서 데려옴 -->
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>