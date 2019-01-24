<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_024_dom_html_value</title>
</head>
<body>
	<input type="text" name="data" id="data" />
	<div id="dv"></div>
	
	<script type="text/javascript">
		document.getElementById("data").value="value속성";
		//document.getElementById("dv").innerText="<p>Text</p>";
		document.getElementById("dv").innerHTML="<p>Text</p>";
		
		//value속성
		console.log(document.getElementById("data").value);
		
		//Text
		console.log(document.getElementById("dv").innerText); // 자손들의 문자열 값만 가져 오겠다.
		
		//HTML
		console.log(document.getElementById("dv").innerHTML); // 자손들의 HTML 요소만 가져오겠다.
	</script> 
</body>
</html>