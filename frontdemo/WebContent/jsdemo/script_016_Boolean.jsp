<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_016_Boolean</title>
</head>
<body>
	<script type="text/javascript">
		document.write(Boolean(3 > 2) + "<br/>"); //Global Function인 Boolean //true
		document.write(Boolean("korea") + "<br/>"); //true //값이 있으면 true
		document.write(Boolean("") + "<br/>"); //false
		document.write(Boolean(10) + "<br/>"); //true
		document.write(Boolean(-10) + "<br/>"); //true
		document.write(Boolean(0) + "<br/>"); //false
		document.write(Boolean(3+2+7) + "<br/>"); //true
		document.write(Boolean(3.5) + "<br/>"); //true
		//NaN
		document.write(Boolean(3/"H") + "<br/>") //false
		document.write(Boolean(undefined) + "<br/>") //false
		document.write(Boolean(null) + "<br/>") //false
	</script>
</body>
</html>