<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_011_String</title>
</head>
<body>
	<script type="text/javascript">
		//It's alright
		var data = 'It\'s alright';
		document.write(data + "<br/>");
		
		//length : 문자열 길이 리턴
		//12
		document.write(data.length + "<br/>");
		
		/*
		특정범위 데이터를 리턴해주는 3가지 메소드
		1. slice(start, end);
		2. substring(start, end); // 자바에서 사용했던 방법
		3. substr(start, length); // 오라클에서 사용했던 방법
		*/
		
		var str = "Apple, Banana, Kiwi";
		//7 인덱스부터 13미만 인덱스까지
		//Banana
		document.write(str.slice(7,13) + "<br/>");
		document.write(str.slice(-12, -6) + "<br/>");
		document.write(str.substring(7, 13) + "<br/>"); //서브 스트링은 음수값 지원 안함, 13미만 인덱스 까지
		document.write(str.substr(7, 6) + "<br/>"); //7인덱스 부터 6자리를 뽑아냄
		document.write(str.substr(-12, 6) + "<br/>"); //-12인덱스 부터 6자리를 뽑아냄
		
		str = "Please visit Microsoft! and microsoft Microsoft";
		document.write(str.replace("Microsoft", "W3Schools") + "<br/>"); // 치환 (제일 먼저 발견된 부분만)	
		document.write(str.replace(/Microsoft/ig, "W3Schools") + "<br/>"); // 정규식을 사용하여 치환
		//ig -> i : 대소문자 구분없이, g : 모든 문자열에 해당하도록 = 대소문자 상관없이 주어진 문자열에 해당한다면 해당하는 모든 문자열을 치환하라
		
		var text1 = "Hello World";
		//HELLO WORLD
		document.write(text1.toUpperCase() + "<br/>");
		//hello world
		document.write(text1.toLowerCase() + "<br/>");
		
		var text2 = "javascript";
		//Hello World, javascript
		document.write(text1.concat(", ", text2) + "<br/>"); // ", "를 추가하여 두 문자열을 이어 붙여줌
		
		var str2 = "HELLO WORLD";
		document.write(str2.charAt(0) + "<br/>"); // H
		
		//아스키 코드값 리턴
		document.write(str2.charCodeAt(0) + "<br/>"); // 72
		
		var txt = "a, b, c, d, e";
		document.write(typeof txt + "<br/>"); //string
		
		var arr = txt.split(",");
		//object true
		document.write(typeof arr + " " + (arr instanceof Array) + "<br/>");
		
		for(var index in arr)
			document.write(arr[index] + "<br/>");
		
		var txt2 = "hijklmn";
		var arr2 = txt2.split(""); //문자 하나하나씩 그냥 나눔
		for(var index in arr2)
			document.write(arr2[index] + "<br/>");
		
		var str3 = "The rain in SPAIN stays mainly in the plain";
		var res = str3.match(/ain/g);
		
		//검색데이터와 일치하는 문자열이 없으면 null반환
		//ain, ain, ain
		document.write(res + "<br/>");
		
		//인덱스값을 리턴해주는 search
		document.write("<hr/>");
		
		res = str3.search("ain");
		//검색데이터와 일치하는 문자열이 없으면 -1리턴
		//5
		document.write(res + "<br/>");
		
		document.write("<hr/>");
		var data = 10;
		//number, string
		document.write(typeof data + "," + typeof String(data) + "<br/>");
		
	</script>
</body>
</html>