<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_031_event_click</title>
</head>
<body>
	<img src="images/car1.jpg" usemap="#intro" />
	
	<map name = "intro">
		<area shape="rect" coords="100,100,300,300"
			href="#" alt="창닫기" onclick="window.close();" />
			
	</map>
</body>
</html>