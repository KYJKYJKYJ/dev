<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_034_window_setInterval</title>
<script type="text/javascript">
	var i = 0;
	window.onload=function() {
		//이벤트에 등록 되어있는 함수를 callback 함수라고 한다.
		
	    //setInterval("실행한 스크립트", 시간 간격);
		//일정한 시간 간격으로 실행한 스크립트를 반복하여 실행시킬 때 사용한다. (시간간격은 밀리초 단위)
		
		//3초가 지나면 함수를 수행한다.
		//var auto = window.setInterval("console.log(i++)", 3000)
		
		var auto = window.setInterval(function() {
			var pNode = document.getElementById("cnt");
			pNode.innerText = ++i;
		}, 1000);
		
		var btn = document.getElementById("stop").onclick = function() {
			//clearInterval(참조변수);
			//auto에 참조되어 있는 setInterval()을 삭제함
			window.clearInterval(auto); //window 객체는 생략 가능함!
		};
	};
</script>
</head>
<body>
	<p id="cnt">&nbsp;</p>
    <button id="stop">정지버튼</button>
</body>
</html>