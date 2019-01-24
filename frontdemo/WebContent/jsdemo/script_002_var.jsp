<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_002_var</title>
	<script type="text/javascript">
		/*
		변수 : 프로그램이 어떤 값을 메모리에 저장해두기 위한 공간이다.
		var키워드 : 자바스크립트에서 메모리 공간을 확보하기 위해서 변수선언시 사용한다.
		
		int num = 10; (JAVA는 데이터 타입을 명시해야함)
		var num = 10; (Javascript는 데이터 타입이 저장되는 값에 의해 결정됨)
			num = "javascript"; (저장되는 값에 의해 데이터타입이 명시되므로 아무 제한 없이 값 저장 가능)
			
		식별자 규칙
		1. 첫번째 문자는 A-Za-z_$만 사용한다.
		2. 나머지 문자는 A-Za-z0-9만 사용한다.
			korea_score (가능)
			averageScore (가능)
			1234Test (불가능)
		3. 자바스크립트 예약어는 사용할 수 없다.
		
		*/
		
		var data = 10; //전역변수
		var na;
		var b,c;
		var d=0, f=4;
		var g=6, h
		
		function process() {
			var np = 20; //지역변수
			document.write(data + " " + typeof(data) + "<br/>"); //document는 기본으로 제공해주는 객체
			//typeof(data) data의 현재 데이터 타입을 확인 가능
			//스크립트에서 태그 사용시 ""로 감싸줘야함
			//자바스크립트에서 문자던 문자열이건 " 나 ' 로 사용가능함!
			
			documunt.write(na); // 값이 지정되지 않은 변수 호출시 undefined 오류 발생
			
		}
	</script>
</head>
<body>
	<button onclick="process()">click</button> <!-- 버튼을 누르면 process() 호출하라 -->
</body>
</html>