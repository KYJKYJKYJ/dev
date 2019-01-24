<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_025_dom_attribute</title>
</head>
<body>
<!-- 
	요소의 속성값 변경 및 불러오는 방법
	요소선택.속성명						: 요소로 지저안 속성값을 불러옴
	요소선택.속성명 = "값" 				: 요소로 지정한 속성값을 새값으로 변경
	요소선택.getAttribute("속성")		: 요소로 지정한 속성값을 불러옴
	요소선택.setAttribute("속성", "값")	: 요소로 지정한 속성값을 새값으로 변경
-->

<img src="images/aa.jpg" width="100" height="100" />
<img src="images/aa.jpg" width="100" height="100" />

<script type="text/javascript">
	var imgNode = document.getElementsByTagName("img")[0];
	// imgNode는 img 요소 중 첫번째껄 담고 있음
	imgNode.src = "images/bag.jpg"; //속성명을 직접 호출하여 속성을 변경
	// http://localhost:8090/frontdemo/jsdemo/images/bag.jpg
	console.log(imgNode.src);
	
	imgNode = document.getElementsByTagName("img")[1];
	imgNode.setAttribute("src","images/pg.jpg"); // setAttribute 메소드를 이용해서 속성값 변경
	// images/pg.jpg
	console.log(imgNode.getAttribute("src")); // 이미지를 불러오는 getAttrribute 메소드
</script>
</body>
</html>