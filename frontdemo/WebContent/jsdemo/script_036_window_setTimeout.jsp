<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_036_window_setTimeout</title>
<script type="text/javascript">
	var i = 0;
	window.onload = function(){
		//setTimeout("실행한 스크립트", 시간간격);
		//일정한 시간 후 스크립트를 한번만 실행시킬 때 사용한다.
		
		//3초가 지나면 함수를 수행한다
		//var auto = window.setTimeout ()
		//	"console.log(i++);", 3000);
		
		var pNode = document.getElementById("cnt");
		var auto = window.setTimeout(function() {
			pNode.innerHTML = ++i;
		}, 1000)
		
		var bNode = document.getElementById("stop");
		bNode.onclick = function() {
			//clearTimeout(참조변수);
			//auto에 참조된 setTimeout()을 삭제함
			window.clearTimeout(auto);
		}
	};
</script>
</head>
<body>
	<p id = "cnt">&nbsp;</p>
	<button id = "stop">정지버튼</button>
</body>
</html>