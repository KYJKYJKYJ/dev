<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>script_035_setInterval</title>
<script type="text/javascript">
	window.onload = function() {
		var autoTime = window.setInterval(function() {
			var date = new Date();
			var day;	// 요일 구하기
			var amOrpm; // 오전 오후 구분하기
			var hour; // 12시간제로 나누기
			var min; // 10분 이하의 경우 0을 앞에 붙여주기
			var sec; // 10초 이하의 경우 0을 앞에 붙여주기
			
			var tNode = document.getElementById("time");

			//요일 구하기
			switch (date.getDay()) {
			case 0:
				day = "일";
				break;
			case 1:
				day = "월";
				break;
			case 2:
				day = "화";
				break;
			case 3:
				day = "수";
				break;
			case 4:
				day = "목";
				break;
			case 5:
				day = "금";
				break;
			case 6:
				day = "토";
				break;
			}

			//오전, 오후 구분 및 12시간제로
			if (date.getHours() > 12) {
				amOrpm = "오후";
				hour = date.getHours() - 12;
			} else {
				amOrpm = "오전";
				hour = date.getHours();
			}

			//10분 이하일 경우 앞자리 0 붙여줌
			if (date.getMinutes() > 10) {
				min = date.getMinutes();
			} else {
				min = "0" + date.getMinutes()
			}
			
			//10초 이하일 경우 앞자리 0 붙여줌
			if (date.getSeconds() > 10) {
				sec = date.getSeconds();
			} else {
				sec = "0" + date.getSeconds();
			}
			
			//시계
			var timeStr = date.getFullYear() + "년 " + (date.getMonth() + 1)
					+ "월 " + date.getDate() + "일 " + day + "요일 " + amOrpm + " "
					+ hour + ":" + min + ":" + sec;
			
			//시계 출력
			tNode.innerText = timeStr;
		}, 1000);

		//시계 멈추기
		var btn = document.getElementsByTagName("input");
			btn[0].onclick = function() {
			window.clearInterval(autoTime);
		};
	};
</script>
</head>
<body>
	<div id="time">Time</div>
	<input type="button" value="Stop Timer" />
</body>
</html>