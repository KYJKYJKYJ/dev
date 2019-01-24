<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_021_dom_parentNode</title>
</head>
<body>
	<div id="wrap">
		<p id="p1">content1</p><p id="p2">content2</p><p id="p3">content3</p>
	</div>
	
	<script type="text/javascript">
		document.getElementById("p2").parentNode.style.color = "blue"; //p2의 부모노드를 가져와라 -> div
		document.getElementById("p2").previousSibling.style.fontSize="20px";
		document.getElementById("p2").nextSibling.style.border="1px solid black";	
	</script>
	
</body>
</html>