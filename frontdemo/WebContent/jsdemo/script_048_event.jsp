<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_048_event</title>
<style type="text/css">
	div {
		border: 1px solid balck;
	}
	
	#red {
		width: 300px;
		height: 300px;
		background-color: red;
	}
	
	#green {
		width: 200px;
		height: 200px;
		background-color: green;
	}
	
	#blue {
		width: 100px;
		height: 100px;
		background-color: blue;
	}
</style>

<script type="text/javascript">
	function func1(event) {
		alert('red');
		event.stopPropagation();
	}
	
	function func2(event) {
		alert('green');
		event.stopPropagation();
	}
	
	function func3(event) {
		alert('blue');
		event.stopPropagation();
	}
	
	window.onload = function() {
		var red = document.getElementById('red');
		var green = document.getElementById('green');
		var blue = document.getElementById('blue');
		
		//이벤트가 전파되는 방향에 따라서 캡처링, 버블링
		//캡처링 : 부모요소 -> target(자신객체) : true
		//버블링 : target(자신객체) -> 부모요소 : false
		red.addEventListener('click', func1, false);
		green.addEventListener('click', func2, false);
		blue.addEventListener('click', func3, false);
	}
</script>
</head>
<body>
	<div id = "red">
		<div id = "green">
			<div id = "blue">&nbsp;</div>
		</div>
	</div>
</body>
</html>