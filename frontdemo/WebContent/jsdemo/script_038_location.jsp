<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_038_location</title>
</head>
<body>
	<script type="text/javascript">
		/*
			location : 현재 주소 영역에 참조주소(url) 정보를 나타낸다.
			location 객체는 로컬 컴퓨터에서는 href속성만 지원하므로 웹 호스팅(웹 서버)에 올리고 테스트를 해야만 정상적으로 실행된다.
		*/
		
		//localhost:8090/frontdemo/jsdemo/script_038_location.html#home
		document.write("href : " + location.href + "<br/>");
			
		//#home
		document.write("hash : " + location.hash + "<br/>");
		
		//localhost
		document.write("hostname : " + location.hostname + "<br/>");
		
		//localhost:8090
		document.write("host : " + location.host + "<br/>");
		
		//http:
		document.write("protocol : " + location.protocol + "<br/>");
		
		//http://localhost:8090/frontdemo/jsdemo/script_038_location.jsp?pageNum=10
		//?pageNum=10
		document.write("search : " + location.search + "<br/>");
		
		//document.write("reload : " + location.reload() + "<br/>"); // 계속 새로고침 실행
		
		
	</script>
</body>
</html>