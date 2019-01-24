<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_012_Date</title>
</head>
<body>
	<script type="text/javascript">
		var date = new Date();
		document.write(date + "<br/>");
		
		document.write(date.getFullYear() + "<br/>"); // 년도만
		document.write(date.getMonth()+1 + "<br/>"); // 월
		document.write(date.getDate() + "<br/>"); // 일
		document.write(date.getDay() + "<br/>"); // 요일 		0 -> 일요일	 1 -> 월요일 ...
	</script>
</body>
</html>