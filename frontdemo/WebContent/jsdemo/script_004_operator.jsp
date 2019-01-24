<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_004_operator</title>
</head>
<body>
	<script type="text/javascript">
		/*
		연산자
		1. 산술연산자
		2. 문자결합연산자(+)
		3. 대입연산자
		4. 증감연산자
		5. 비교연산자 (===, !==, ==, !=)
		6. 논리연산자
		7. 삼항조건연산자
		8. 데이터타입연산자 (typeof, instanceof)
		*/
		
		var x = 10;
		var y = "10";
		
		document.write((x==y) + "<br/>"); // 값만 비교함
		document.write((x===y) + "<br/>"); // 값과 함께 데이터 타입도 비교함
		
		document.write((typeof x + "<br/>")); // number
		
		document.write((x instanceof Number) + "<br/>"); // instanceof 는 객체만 비교가능 (typeof로 해서 object만)
		//x는 변수라서 비교가 안됨
		
		var nb = new Number(x);
		document.write((typeof nb + "<br/>")); // object
		document.write((nb instanceof Number) + "<br/>");
	</script>
</body>
</html>