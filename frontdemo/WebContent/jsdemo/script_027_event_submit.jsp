<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_027_event_submit</title>
</head>
<body>
	<form name="log_f" method="get" action="script_027_process.jsp">
		<fieldset>
			<legend>회원 로그인</legend>
			<label for="my_id">아이디</label>
			<input type="text" name="my_id" id="my_id" />
			<label for="my_pass">비밀번호</label>
			<input type="password" name="my_pass" id="my_pass" />
			<!-- <input type="submit" value="login" /> --> <!-- submit은 하나만 존재 가능 (폼 요소에서 요청하는 페이지가 하나만 있을 경우) -->
			
			<input type="button" value="login" id="btn" />
			<!-- 만약 여러개의 submit이 필요할 경우 (액션페이지가 여러개 일 경우)
			일단 버튼을 만들고 스크립트에서 각각 버튼마다 호출해야될 페이지를 따로따로 지정해준다.
			submit 이벤트를 수동으로 발생시켜줘야 한다. -->
			
			<!-- <button value="login">login</button> --> <!-- 위와 동일해 보이지만  자동으로 submit 이벤트가 발생함. -->
		</fieldset>
		
		<script type="text/javascript">
			// <input type="button" value="login" id="btn" /> 을 썼을 때
			var btn = document.getElementById("btn");
			btn.onclick = function() {
				var idNode=document.getElementById("my_id");
				var passNode=document.getElementById("my_pass");
				
				if(idNode.value == "") { //not null로 db에서 설정 한 것은 이런 검사 과정을 반드시 거쳐야함
					alert("아이디를 입력하세요.");
					return false;
				}
				
				if(passNode.value == "") {
					alert("비밀번호를 입력하세요.");
					return false;
				}
				
				document.log_f.action = "script_027_process.jsp"
				document.log_f.submit(); // 버튼일 때는 액션으로 페이지를 지정하고 submit 이벤트가 작동하도록 해줘야함
			};
		
			// <input type="submit" value="login" /> 을 썼을 때
			document.log_f.onsubmit = function() { // 액션으로 페이지를 지정가능
				var idNode=document.getElementById("my_id");
				var passNode=document.getElementById("my_pass");
				
				if(idNode.value == "") { //not null로 db에서 설정 한 것은 이런 검사 과정을 반드시 거쳐야함
					alert("아이디를 입력하세요.");
					return false;
				}
				
				if(passNode.value == "") {
					alert("비밀번호를 입력하세요.");
					return false;
				}
			};
		</script>
	</form>
</body>
</html>