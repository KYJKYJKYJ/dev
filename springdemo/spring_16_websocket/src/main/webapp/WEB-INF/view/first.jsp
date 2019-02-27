<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/sockjs.js"></script>
	<script>
	//웹 소켓 객체를 변수 선언
	var websocket;
	$(document).ready(function() {
		//입장 버튼을 클릭시 이벤트 처리
		$('#enterBtn').on('click', function() {
			//웹 소켓 연결
			websocket = new WebSocket("ws://localhost:8090/mywebsocket/chatws.do");
			
			//웹 소켓 이벤트 처리
			websocket.onopen = onOpen;
			websocket.onmessage = onMessage;
			websocket.onclose = onClose;
		});
		
		//메세지 전송 이벤트
		$('#sendBtn').on('click', function() {
			//전송 버튼을 누르면 닉네임과 메세지를 서버에 전송
			var nick = $('#nickname').val();
			var msg = $('#message').val();
			
			//메세지 전송 //연결된 웹 소켓 객체값을 이용한다!
			websocket.send(nick + ":" + msg);
			
			//메세지 입력창 초기화
			$('#message').val('');
		});
		
		//message 창에서 Enter를 눌렀을 때도 메세지를 전송
		//키보드를 누를 때 이벤트 처리
		$("#message").keypress(function(event) {
			if(event.keyCode == 13) {
				//전송 버튼을 누르면 닉네임과 메세지를 서버에 전송
				var nick = $('#nickname').val();
				var msg = $('#message').val();
				
				//메세지 전송 //연결된 웹 소켓 객체값을 이용한다!
				websocket.send(nick + ":" + msg);
				
				//메세지 입력창 초기화
				$('#message').val('');
			}
		});
		
		//나가기 버튼을 누를 때 이벤트 처리
		$('#exitBtn').on('click', function() {
			//웹 소켓 연결을 해제함
			websocket.close();
		});
		
		//브라우저 창을 종료해도 소켓 연결이 끊켜야함
		$(window).on('close', function() {
			websocket.close();
		});
	});
	
	//WebSocket이 연결된 경우 호출되는 함수
	function onOpen(evt) {
		console.log("웹 소켓에 연결 성공");
	}
	
	//서버에서 메세지가 왔을 때 호출되는 함수
	function onMessage(evt) {
		//서버가 전송한 메세지 가져오기
		var data = evt.data;
		//메세지를 출력
		$("#chatMessageArea").append(data + "<br />");
	}
	
	//연결 해제시 호출되는 함수
	function onClose(evt) {
		 console.log("웹 소켓에 연결 해제");
	}
	</script>
</head>
<body>
<body>
	<span>이름:</span>
	<input type="text" id="nickname" />
	<input type="button" id="enterBtn" value="입장" />
	<input type="button" id="exitBtn" value="나가기" />

	<h1>채팅 영역</h1>
	<div id="chatArea">
		<div id="chatMessageArea"></div>
	</div>
	
	<span>전송할 메시지:</span>
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="전송" />
</body>
</html>