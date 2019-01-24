<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_022_dom_childNodes</title>
</head>
<body>
	<div id="wrap"> <!-- 엔터1 -->
		<p>content</p> <!-- 엔터2 -->
		<a href="">세미나 장소</a> <!-- 엔터3 -->
		<span><a href="">정보</a></span> <!-- 엔터4 -->
	</div>

	<script type="text/javascript">
		//div요소의 모든 자식노드를 리턴
		var divChildNode = document.getElementById("wrap").childNodes; //모든 자식 노드를 다 가져옴
		//length:7 (요소:3, 엔터:4)
		console.log("length:" +divChildNode.length);
		
		var divChildren = document.getElementById("wrap").children; //자식 노드 중 element node만 가져옴
		//length:3
		console.log("length:" +divChildNode.length);
		
		var sNode = document.getElementsByTagName("span")[0];
		//sNode[0].firstChild; == var sNode = document.getElementsByTagName("span")[0];
		var sFirstChild = sNode.firstChild; // <span>
		sFirstChild.style.backgroundColor="red"; // <a href="" ~>
	</script>
</body>
</html>