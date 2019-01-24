<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	border: 0
}

div.wrap {
	width: 606px;
	margin: auto;
}

div.line {
	width: 200px;
	height: 220px;
	border: 1px solid black;
	margin-bottom: 10px;
	float: left
}

.chk {
	float: left;
	width: 20px;
	height: 17px;
}

p {
	float: left;
	width: 150px;
	height: 17px;
	overflow:hidden;
	font-family: serif;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	 $('button').on('click',function(){
		 $('form').submit();
	 });
});

</script>
</head>
<body>
<!-- <Context docBase="c:/temp" path="/webdemo/images"
					reloadable="true" /> -->
	<a href="insertMain">이미지 삽입</a>
	<h3>이미지 목록</h3>
	<!-- 실제 경로를 사용하면 안됨. 이 경로를 url로 바꿔줘야지 출력이 됨 -->
	<!-- Servers 안에 server.xml에 engine 위에 url 경로 추가해주어야함 -->
	<div class="wrap">
	<button>이미지 삭제</button>
	<form method="post" action="previewDel">
		<c:forEach items="${requestScope.aList}" var="dto">
			<div class="line">
				<img src="images/${dto.filepath}" width="200" height="200" /> 
				<input type="checkbox" name="chk" class="chk"
					      value="${dto.num}" />

				<p>${dto.filepath}</p>
			</div>
		</c:forEach>
		</form>
	</div>
</body>
</html>








