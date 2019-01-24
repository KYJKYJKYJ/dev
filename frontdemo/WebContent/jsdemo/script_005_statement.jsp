<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_005_statement</title>
</head>
<body>
<!-- 
	제어문
	1. 선택문 : if-else, switch-case
	2. 반복문 : for, while, do-while, for-in
	3. 기타 : break, continue
-->
	<script type="text/javascript">
		var data = 2;
		switch(data) {
			case 1:
				document.write(10+"<br/>");
				break;
			case 2:
				document.write(20+"<br/>");
				break;
			default : document.write("<br/>");
		}
		
		document.write("<hr/>");
		
		data = true;
		switch(data) {
			case true:
				document.write("OK");
				break;
			case 2:
				document.write("FAIL");
				break;
		}
		
		//자바와 사용법이 동일하다.
		document.write("<hr/>");
		
		var arr = [ 10, 20, 30, 40, 50 ];
		for(var i = 0; i < arr.length; i++) {
			document.write(arr[i] + " ");
		}
		
		document.write("<hr/>");
		
		for(var index in arr) //그냥 배열의 인덱스 값을 사용함 
			document.write(arr[index] + "<br/>");
		//자바와의 차이 : for(int data : arr) 배열의 요소 타입값에 맞게 해줘야함
			
	</script> 
</body>
</html>