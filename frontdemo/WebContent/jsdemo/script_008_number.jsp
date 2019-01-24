<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_008_number</title>
</head>
<body>
	<script type="text/javascript">
	var data = 123;
	var str = data.toString();
	var obj = new Number(123);
	
	//123, 123, 123
	document.write(data + "," + str + "," + obj + "<br/>");
	
	//number, string, object
	document.write(typeof data + "," + typeof str + "," + typeof obj + "<br/>");
	
	var res = data / "korea";
	var res2 = data / "10";
	
	//NaN, 12.3
	document.write(res + "," + res2 + "<br/>");
	
	var a = new Number(100);
	var b = new Number(100);
	var c = 100;
	var d = 100;
	
	//false, true
	document.write((a==b) + "," + (c==d) + "<br/>");
	
	//valueOf : 객체에 저장된 값을 리턴
	//number
	document.write(typeof a.valueOf() + "<br/>");
	
	//true
	document.write((a.valueOf() == b.valueOf()) + "<br/>");
	
	//////////
	
	var k = 200;
	//toString() : 숫자를 문자열로 변환
	
	//string
	document.write(typeof k.toString() + "<br/>");
	
	//string
	document.write(typeof true.toString() + "<br/>");
	
	var arr = [10, 20, 30];
	document.write(arr + " " + typeof arr + " " + arr.toString() + " " + typeof arr.toString() + "<br/>");
	
	var m = "5.4";
	var p = "3.5";
	
	var m2 = 5.4;
	//5.43.5
	document.write((m+p) + "<br/>"); // 문자열 연결의미의 +로 쓰임
	document.write((m2+p) + "<br/>"); // 하나만 숫자형이라도 그냥 문자형으로 바뀌어 계산됨
	document.write((m-p) + "<br/>"); // -는 그냥 Number 형으로 바꾸어 계산
	
	//string 형임
	document.write(typeof m.valueOf() + "<br/>");
	
	//5 number
	document.write(parseInt(m) + " " + typeof parseInt(m) + "<br/>");
	
	//3.5 number
	document.write(parseFloat(p) + " " + typeof parseFloat(p) + "<br/>");
	
	//parseInt와 parseFloat은 Global객체가 제공하는 기본 함수! (parseDouble은 없으니 주의!)
	</script>
</body>
</html>