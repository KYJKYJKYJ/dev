<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_028_option</title>
</head>
<body>
	<form name="frm" method="get" action="#">
		<p>과일선택</p>
		<select name = "fruit">
			<option value = "fruit">
				과일을 선택하세요</option>
			<option value = "apple">사과</option>
			<option value = "kiwi">키위</option>
			<option value = "banana">바나나</option>
		</select>
		<input type="submit" value="commit" />
	</form>

	<script type="text/javascript">
	/*
		[폼요소에서 select option요소 선택]
		1. document.폼요소명.입력요소이름.options[index];
			: <select>요소에 <option>을 선택할 때
		2. var i = document.폼요소명.입력요소이름.selectedIndex;
			: select 요소에서 선택된 option요소의 인덱스를 리턴
	*/
	
	/* window.onload = function() {
		var selFruit = document.frm.fruit.options;
		alert(selFruit[0].value+"\n" + 
			  selFruit[1].value+"\n" +
			  selFruit[2].value+"\n" +
			  selFruit[3].value);
	}; */
	
	//submit 이벤트가 발생되면 select에서 선택된 option 인덱스의 value 속성값을 알림창으로 띄운다.
	document.frm.onsubmit = function() {
		var optFruit = document.frm.fruit;
		alert(optFruit.selectedIndex + "=" + optFruit.options[optFruit.selectedIndex].value);
	};
	
	</script>
</body>
</html>