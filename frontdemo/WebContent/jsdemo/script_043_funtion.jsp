<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_043_funtion</title>
</head>
<body>
<script type="text/javascript">
	var num = 0;
	
	function testFun() {
		num++;
		document.write(num + "<br/>");
		if(num == 10) return;
		testFun();
		document.write("==="+num+"===<br/>");
		//함수 안에서 자기 자신을 호출 : 재귀함수
	}
testFun(); 
</script>
</body>
</html>