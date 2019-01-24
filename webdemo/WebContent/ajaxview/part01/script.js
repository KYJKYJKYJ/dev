var httpRequest;

window.onload = function() {
	var btn = document.getElementById("btn");
	btn.onclick = process;
};

function process() {
	//alert('call');
	//1. ajax를 처리하기 위한 브라우저별 객체를 생성한다.
	if(window.XMLHttpRequest) {
		//현재 대부분 사용하는 방식
		httpRequest = new XMLHttpRequest();
	} else {
		//IE 8버전 이하의 구버전을 위해서 해주어야함
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//2. 서버가 응답한 데이터를 처리하기 위한 함수를 정의한 후 onreadystatechange에 등록한다.
	httpRequest.onreadystatechange = viewMessage;
	
	//3. 서버에 요청준비를 한다.
					//method(대문자), url, 동기화 여부 (true : 비동기화, false : 동기화)
	httpRequest.open('GET', 'ajaxview/part01/sample.txt', true);
	
	//4. 서버에 요청을 한다.
	//ajax에 요청하고 받을 때는 스크립트 형식으로 받게됨
	httpRequest.send();
}

//서버의 응답을 받아 처리해 줄 함수 정의
function viewMessage() {
	//readyState가 4면 정상적으로 요청을 한 것
	//status가 200이면 정상적으로 요청을 받은 것, 정상적으로 응답
	if(httpRequest.readyState == 4 && httpRequest.status == 200) {
		document.getElementById("div").innerHTML = httpRequest.responseText;
	}
		
}

