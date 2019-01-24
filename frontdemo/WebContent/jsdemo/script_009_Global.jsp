<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_009_Global</title>
</head>
<body>
<!-- 
	Global객체에서 제공하는 number타입으로 변환해주는 메소드 3개
	1. Number()
	2. parseInt()
	3. parseFloat()
-->

	<script type="text/javascript">
		var data = true;
		
		//1 number (true는 1, false는 0)
		document.write(Number(data) + " " + typeof Number(data) + "<br/>");
		
		//0 number
		data = false;
		document.write(Number(data) + " " + typeof Number(data) + "<br/>");
		
		
		//NaN(Not A Number)
		//string 형만 숫자로 바꿔주는 parse 함수 **
		document.write(parseInt(data) + "<br/>");
		
		var sn = "10";
		document.write(parseInt(sn) + " " + typeof parseInt(sn) + "<br/>");
		
		sn = "10.9";
		document.write(parseFloat(sn) + " " + typeof parseFloat(sn) + "<br/>");
	</script>
</body>
</html>