<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_041_function</title>
</head>
<body>
	<script type="text/javascript">
	/*
	   함수 정의 방법
	   1. function 키워드를 이용
	    function 함수명(매개변수1...){
		   실행문장;
		  return 반환값;
	   }
	   
	   2. 함수 리터널을 이용
	      var 변수명=function(매개변수...){
		      실행문장;
		   return 반환값;
	   } 
	   
	         호출 : 변수명(매개변수 값);
	   :funtion 함수 내용이 값이 되어버린다고 생각하면 됨
	   
	   3. 익명함수
	     (function(매개변수...){}){
		   실행문장;
		   return 반환값;	
	     }
	   : 함수를 만들어 재사용하는 것이 목적이 아니라 다른 함수간의
	     충돌을 막기 위해서 사용한다.
	   : jQuery플러그인 제작 시 다른 플러그인과의 충돌을 막기 위해서 사용함 
	   
	   4. Function객체를 이용
	     var 함수명=new Function(매개변수1...,함수본체);
	           호출 : 함수명(매개변수 값...);
	   */
	   
	   var i = 0;
	   
	   //선언적 함수 정의
	   function myFun() {
		   i++;
		   document.write("hello"+i);
	   }
	   
	   myFun();
	   document.write("<hr/>");
	   
	   //함수 리터널
	   var test = function(x) {
			return "hello"+x;
	   }
	   
	   var process = function() {
			document.write("process:");
	   }
	   //어떤 형태의 함수도 출력가능 (자바스크립트는 변수의 값으로 함수도 출력가능)
	   
	   document.write(test); //함수 자체를 출력해줌
	   document.write("<hr/>");
	   
	   document.write(test(10)); //함수의 결과값을 출력해줌
	   //둘의 차이를 알아둘 것
	   document.write("<hr/>");
	   
	   document.write(process); //process에 저장된 함수를 그대로 출력
	   document.write("<hr/>")
	   
	   process(); //리턴 값이 없는 함수 이므로 document.write 함수로 출력할 수 없음
	   document.write("<hr/>")
	   
	   var fn = new Function("x", "y", "return x+y"); // 매개변수1, ..., 리턴
	   document.write(fn(10, 20));
	</script>
</body>
</html>