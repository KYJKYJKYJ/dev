<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_047_event</title>

<script type="text/javascript">
	window.onload = function() {
		function func1() {
			alert('test1');
		}
		
		function func2() {
			alert('test2');
		}
		
		var btn = document.getElementById("btn");
		
		if(window.addEventListener) {
			//사파리, 크롬, IE9 이상의 브라우저에서 제공
			btn.addEventListener('click', func1, false);
			btn.addEventListener('click', func2, false);
		} else {
			//IE8 이하의 브라우저에서 제공
			btn.attachEvent('onclick', func1);
			btn.attachEvent('onclick', func1);
		}
	}
</script>
</head>
<body>
	<button id="btn">button</button>
</body>
</html>