<%@page import="multicheckdemo.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#allchkBtn").click(function() {
			var chk = $(this).prop("checked");
			if(chk) {
				$(".chk").prop("checked", true);
			} else {
				$(".chk").prop("checked", false);
			}
		});
		
		$("#delBtn").on('click', function() {
			var cnt=$(".chk:checked");
			if(cnt.length == 0) {
				alert("삭제할 데이터를 선택하세요");
			
				return false;
			}
		 /* form 요소 밖에서 button을 사용할 때는 명시해야한다. */
		 /* $('form').submit(); */
		});
	});
</script>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse; /* 테두리간 여백을 없애버림 */
}

th {
	text-align: center;
	border: 1px solid black;
}

td {
	border: 1px solid black;
}
</style>
</head>
<body>
<div class="wrap">
<form action="multi" method="post">
	<button id="delBtn">삭제</button> <!-- 폼 밖에 있으면 $('form').submit() 해줘야함 -->
<table>
	<thead>
		<tr>
			<th><input type="checkbox" id="allchkBtn" />전체선택</th>
			<th>num</th>
			<th>name</th>
			<th>age</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.aList}" var="dto">
		<!-- 데이터를 끌어올 때 반드시 명시해야하는 requestScope -->
		<tr>
			<td><input type="checkbox" class="chk" name="chk" value="${dto.num}" /> </td>
			<td><c:out value="${dto.num}"></c:out></td>
			<td><c:out value="${dto.name}"></c:out></td>
			<td><c:out value="${dto.age}"></c:out></td>
			<td><c:out value="${dto.loc}"></c:out></td>
			<!-- 객체변수.멤버변수의 이름만 대줘도 알아서 get 메소드를 호출해서 데려옴 -->
		</tr>
		</c:forEach>
	</tbody>
</table>
</form>
</div>
</body>
</html>