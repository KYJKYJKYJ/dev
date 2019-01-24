<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_042_function</title>
	<script type="text/javascript">
		var color = ["white", "yellow", "aqua", "purple"];
		var i = 0;
		
		//현재페이지가 메모리에 로드가 되면 함수를 수행한다 (특정한 이벤트가 실행되면 수행하는 함수를 callback 함수라고 한다)
		window.onload = function() {
			document.getElementsByTagName("button")[0].onclick = colorBg; //colorBg 함수를 정의해야함
		
			var autoColor = window.setInterval(colorBg, 3000);
			autoColor();
		};
		
		function colorBg() {
			i++;
			if(i >= color.length)
				i=0;
			var bodyTag = document.getElementsByTagName("body")[0];
			bodyTag.style.backgroundColor = color[i];
		}
		
	</script>
</head>
<body>
	<button>background color change</button>
</body>
</html>