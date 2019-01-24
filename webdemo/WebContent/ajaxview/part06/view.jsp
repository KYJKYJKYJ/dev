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

<script type="text/javascript" src="ajaxview/part06/jquery.js"></script>

<style type="text/css">
	#divUpdate {
		display: none;
	}
</style>
</head>
<body>
	<a href="disList">토론 리스트 목록</a>

	<table border="1" width="80%">
		<tr>
			<th width="20%">제목</th>
			<td>${requestScope.dto.title}</td>
		</tr>

		<tr>
			<th>내용</th>
			<td>${requestScope.dto.content}</td>
		</tr>
	</table>

	<!-- 댓글목록출력 -->
	<p>댓글내용</p>
	<div id="commentList">
		<script type="text/javascript">
			listView("${requestScope.dto.num}");
		</script>
	</div>

	<!-- 댓글수정 -->
	<div id="divUpdate">
		<input type="hidden" id="textCol" />
		<textarea id="textUpdate" rows="10" cols="20"></textarea>
		<input type="button" id="btnUpdate" value="수정" />
	</div>

	<!-- 댓글입력 -->
	<div id="commentAdd">
		<textarea id="textInput"></textarea>
		<input type="button" id="btnInput" value="댓글 입력" />
	</div>

</body>
</html>