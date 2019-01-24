<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_044_function</title>
</head>
<body>
	<script type="text/javascript">
	/* function outer() { //2
		var num = 10; //3
		function inner() { //함수안에 함수를 정의가 가능하다. //5
			document.write(num); //6
		}
		inner(); //4
	}
	outer(); //1 //외부함수가 끝나면 내부함수로 접근할 수 있는 방법이 없음 (closure 함수로만 접근이 가능) */
	
	function outer() {
		var sum = 50;
		
		return function() {
			return sum;
		}		
	}
	
	var result = outer();
	/* var result = function() {
		return sum;
	}	 */ //위와 동일	
	
	/*
		클로저(closure) 함수는 외부함수가 종료가 되더라도 내부함수를 통해 외부에서 외부함수의 자원을 참조할 수 있는 함수이다.
	*/
	
	document.write(result); // 함수 자체를 출력
	document.write("<hr/>");
	
	document.write(result()); // 함수의 결과가 출력
	</script>
</body>
</html>