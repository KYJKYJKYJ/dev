<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		window.onload = function() {
			var btn = document.getElementById("btn");
			//한 객체에 같은 이벤트를 여러개 등록할 수 없다.
			btn.onclick = function() {
				alert('test1');
			}
			
			btn.onclick = function() { // 마지막에 있는 이벤트만 적용됨
				alert('test2');
			}
		}
		
	</script>
</head>
<body>
	<button id="btn">button</button>
</body>
</html>