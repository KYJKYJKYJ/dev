<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/header.css" type="text/css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var chk = '${empty sessionScope.chk}' == 'true' ? true : false;
		init(chk);
	});
		// chk 안에 값이 들어있으면 true 없으면 false
</script>
</head>
<body>
	<!-- 헌재 로그인 상태가 아니면 로그인이 보임 -->
	<p id="logInPage">
		<a href="login.do?returnUrl=${param.returnUrl}">로그인</a>
	</p>
	
	<!-- 현재 로그인 상태이면 로그아웃이 보임 -->
	<p id="logOutPage">
		<a href="logout.do">로그아웃</a>
	</p>
	
	<div>
		<p>index page</p>
	</div>
</body>
</html>