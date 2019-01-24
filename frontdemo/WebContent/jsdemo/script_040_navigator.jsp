<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_040_navigator</title>
</head>
<body>
<script type="text/javascript">
	/*
		navigator 객체 : 현재 방문자가 사용하는 브라우저 정보와 운영체제의 정보를 제공해주는 객체
	*/
	
	//브라우저 버전
	document.write("appVersion : " + navigator.appVersion + "<br/>");
	
	//브라우저에 사용된 언어
	document.write("language : " + navigator.language + "<br/>");
	
	//브라우저에 사용된 엔진정보
	document.write("product : " + navigator.product + "<br/>");
	
	//브라우저가 실행된 운영체제정보
	document.write("platform : " + navigator.platform + "<br/>");
	
	//이 정보들은 헤더에 담겨져서 시스템이 알아서 보내줌, navigator 객체로 그냥 사용해 주기만 하면 정보가 출력된다
</script>
</body>
</html>