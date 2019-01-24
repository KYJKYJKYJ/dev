<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json_02</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	});
</script>
</head>
<body>
	<%
		//java, jsp에서 JSONArray(제이손배열)을 생성하는 방법이다.
		JSONArray array = new JSONArray();
		array.add("java");
		array.add("jsp");
		array.add("spring");
		out.print(array);
		//["java","jsp","spring"]
		//스크립트에선 배열을 []로 감싸서 보내줌..
	%>
</body>
</html>