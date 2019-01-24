<%@page import="servletdemo.part03.EmployeesDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
<%
	//page import 하는거 잊지말기
	List<EmployeesDTO> aList = (List<EmployeesDTO>) request.getAttribute("aList");		
%>

<table>
	<thead>
	</thead>
	 <tr>
	 	<th>employee_id</th>
	 	<th>first_name</th>
	 	<th>salary</th>
	 </tr>
	<tbody>
	<%
		for(int i = 0; i < aList.size(); i++) {
			EmployeesDTO dto = aList.get(i);
	%>		
		<!-- 스크립트 사이에 HTML 활용할 때 이런 식으로 -->
		<tr>
			<td><%=dto.getEmployee_id() %></td>
			<td><%=dto.getFirst_name() %></td>
			<td><%=dto.getSalary() %></td>
		</tr>
	<%
		}
	%>
	</tbody>
</table>
</body>
</html>