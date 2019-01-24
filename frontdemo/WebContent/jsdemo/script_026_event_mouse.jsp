<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_026_event_mouse</title>
</head>
<body>
<h1 id = "title">마우스 아웃</h1>
	<a href = "#" id="btn">
		<img src = "images/aa.jpg" alt = "버튼" width = "100" height = "100" />
	</a>
	<p id = "img_src"></p>
	
	<script type="text/javascript">
	/* 
		(원래 표준에는 요소에 직접 이벤트를 걸어서 실행하지 않음)
		
		[문서 개체에 이벤트를 적용하는 방법]
		요소선택.이벤트종류 = function() { 실행문장; };
		
		요소선택.이벤트종류 = process;
		function process() {};
	*/
	
	var theBtn = document.getElementById("btn");
	
	theBtn.onmouseover = function() {
		document.getElementById("title").innerText = "mouseover";
		document.getElementsByTagName("img")[0].src = "images/bag.jpg";
	}; // 익명 메소드 이용
	
	theBtn.onmouseout = function() {
		document.getElementById("title").innerText = "마우스 아웃";
		document.getElementsByTagName("img")[0].src = "images/aa.jpg";
	};
	</script>
</body>
</html>