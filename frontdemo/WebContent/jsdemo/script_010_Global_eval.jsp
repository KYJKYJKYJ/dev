<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_010_Global_eval</title>
</head>
<body>
	<script type="text/javascript">
		//eval(String) : 수식의 결과를 리턴, 문자열을 숫자로 리턴
		var data = eval("3 + 2"); // 수식의 결과를 리턴
		
		//number data = 5
		document.write(typeof data + " data = " + data + "<br/>");
		
		//number data = 32
		data = eval("3" + "2") // 문자열 연결하여 리턴
		document.write(typeof data + " data = " + data + "<br/>");
		
		//number data = 3
		data = eval("3");
		document.write(typeof data + " data = " + data + "<br/>");
		
		//number data = 5
		data = eval("3") + eval("2");
		document.write(typeof data + " data = " + data + "<br/>");
		
		/* data = eval("ab");
		document.write(typeof data + "<br/>"); ab is not defined 오류! 어차피 문자형이니 그냥 쓰라는 것*/
		
		//string [1,2,3,4,5]
		var arr = '[1,2,3,4,5]';
		document.write(typeof arr + " " + arr + "<br/>");
		
		//서버에서 클라이언트로 배열을 넘겨줄때, 클라이언트는 string으로 받는다. 이걸 다시 배열로 바꿔줘야하는데 이때 eval을 사용한다.
		//배열값을 스트링으로 받고 다시 배열로 1
		//string -> array(object)
		data = eval(arr);
		//object 1,2,3,4,5
		document.write(typeof data + " data = " + data + " " + (data instanceof Array) + "<br/>");
		//서버에서 클라이언트로 데이터를 넘겨 줄때 string으로 넘겨주게 되는데 이걸 배열로 풀어서 표시할 때 사용하므로 알아두자
		
		//data[0] = 1
		document.write("data[0] = " + data[0] + "<br/>");
		
		//string {one : "java", two : "jsp"}
		var obj = '{one : "java", two : "jsp"}'
		document.write(typeof obj + " " + obj + "<br/>");
		
		//서버로 보낼 때는 객체 클라이언트로 받을 때는 string
		//배열값을 스트링으로 받고 다시 배열로 2
		data = eval("(" + obj + ")"); //배열을 표시하는 형식이므로 외워야한다.
		//object [object Object]
		document.write(typeof data + " data = " + data + "<br/>");
		
		//java, jsp
		document.write(data.one + ", " + data.two + "<br/>");
		
		//클라이언트 에서 서버 로 주고받을 때 eval을 사용한다.. ajax 할때 사용하므로 미리 공부해야할듯?
	</script>
</body>
</html>