<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	function process() {
		var fname = document.frm.fname;
		console.log(fname.value);
		console.log(fname.defalutValue);
		return false;
	}
	</script>
	
	<form name="frm">
		<label for="fname">이름</label>
		<input type="text" name="fname" id="fname" value="이름..." />
		<input type="text" name="fpass" id="fpass" placeholder="비밀번호를 입력하세요." />
		<button onclick="return process()">click</button>
	</form>
	
</body>
</html>