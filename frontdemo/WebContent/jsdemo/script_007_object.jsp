<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_007_object</title>
</head>
<body>
	<script type="text/javascript">
	var data = 10; // number
	var obj = new Number(data); // object
	
	document.write(typeof data + "<br/>"); //number
	document.write(typeof obj + "<br/>"); // object
	
	document.write(typeof data.toString() + "<br/>"); //string (String은 객체!) (string은 그냥 문자형 타입)
	document.write(typeof obj.toString() + "<br/>");  //string
	
	//false
	document.write((obj.toString() instanceof String) + "<br/>");
	
	var str1 = new String(data);
	var str2 = new String(obj);
	document.write(typeof str1 + "<br/>"); // object
	document.write(typeof str2 + "<br/>"); // object
	
	//true
	document.write((str1 instanceof String) + "<br/>");
	//true
	document.write((str2 instanceof String) + "<br/>");
	
	//number
	document.write(typeof obj.valueOf() + "<br/>"); // 객체의 값을 가져오는 valueOf
	//string
	document.write(typeof str1.valueOf() + "<br/>");
	
	/*
	number => new Number(number)
	string => new String(string)
	
	new Number(number).valueOf() => number
	new String(string).valueOf() => string
	*/
	</script>
</body>
</html>