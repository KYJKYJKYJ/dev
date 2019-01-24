<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_037_screen</title>
</head>
<body>
	<script type="text/javascript">
		//screen.width : 화면의 너비값 리턴
		//screen.width/2 - object.width/2 로 화면 중앙을 나누어 중앙 좌표를 계산하는 경우에 쓰인다.
		//height도 마찬가지
		document.write("width: " + screen.width + "<br/>");
	
		//screen.height : 화면의 높이값 리턴
		document.write("height: " + screen.height + "<br/>");
	
		//screen.availWidth : 작업표시줄을 제외한 화면의 너비 리턴
		document.write("availWidth: " + screen.availWidth + "<br/>");
	
		//screen.availHeight : 작업표시줄을 제외한 화면의 높이 리턴
		document.write("availHeight: " + screen.availHeight + "<br/>");
	
		//사용자 모니터가 표현 가능한 컬러 bit리턴
		document.write("colorDepth: " + screen.colorDepth + "<br/>");
	</script>
</body>
</html>