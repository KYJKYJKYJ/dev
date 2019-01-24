$(document).ready(function(){	
	window.mySwipe = $('#mySwipe').Swipe({
		auto : 3000, //3초 간격으로 배너가 이동
		continuous : true, //반복해서 롤링
		callback:function(index, element) {
			//console.log(index + " " + element);
			//배너 바뀌면 동그라미(bullet)도 바뀜
			
			//클래스 "active"를 포함하는 불릿 버튼을 비활성화 버튼으로 만들고, active 클래스를 삭제함
			//배너 이미지가 바뀌기 전에 img에 active가 설정 되어 있는데 이것을 on에서 off로 바꾸고 active를 제거함
			$('.touch_bullet .active').attr('src', $('.touch_bullet .active').attr('src').replace('on.png', 'off.png')).removeClass('active');
			
			//인덱스에 해당하는 불릿버튼을 활성화된 버튼으로 만들고, active 클래스르 생성함
			//바뀐 인덱스에 해당하는 불렛 이미지는 off에서 on으로 바꾸어 주고 active 추가함
			$('.touch_bullet img').eq(index).attr('src',$('.touch_bullet img').eq(index).attr('src').replace('off.png','on.png')).addClass('active');
			//eq = equals			
		} 
	}).data('Swipe');
	
	//현재 버튼을 누르면 자동으로 바뀌는 게 무효화됨, api보고 한번 찾아보자.
	//이전 버튼을 눌렀을 때
	$('.touch_left_btn a').on('click', function() {
		mySwipe.prev(); //이전 배너로
		return false; //이벤트만 실행하지 submit되어 링크로 이동하면 안되므로 return false
	});
	
	$('.touch_right_btn a').on('click', function() {
		mySwipe.next(); // 다음 배너로
		return false;
	});
	
	//알림판 롤링버튼 매너
	//첫번째 배너를 제외하고 전부 숨김
	$('#roll_banner_wrap dd').not(':first').hide();
	
	//첫번째 버튼의 <a>를 저장
	var onBtn = $('#roll_banner_wrap dt a:first');
	
	//버튼 1~4를 클릭시
	$('#roll_banner_wrap dt a').on('click',function() {
		//노출 되어 있는 배너를 숨긴다.
		$('#roll_banner_wrap dd:visible').hide();
		
		//onBtn에 하위 요소 <img>에 "src" 속성을 비활성화된 이미지 경로로 바꾼다.
		$('img', onBtn).attr('src', $('img', onBtn).attr('src').replace('over.gif', 'out.gif'));
		
		//현재 선택한 인덱스를 num을 받아옴
		var num = $('#roll_banner_wrap dt a').index(this); //this는 a객체, 클릭했을 때 a 객체 값과 일치하는 인덱스를 가져옴
		//console.log('num='+num);
		//클릭한 버튼에 인덱스 값과 일치하는 <dd>요소만 나타냄
		$('#roll_banner_wrap dd').eq(num).show();
		
		//버튼 1,4 이미지 교체
		//클릭한 <a>에 하위<img>에 "src" 속성을 활성화된 버튼 이미지 경로로 교체
		$('img', this).attr('src', $('img', this).attr('src').replace('out.gif', 'over.gif'));
		
		onBtn=$(this); //객체 정보 저장
		
		return false; //기본이벤트 비활성화
	});
	
	var btnNum = 0;
	
	//1~4버튼이 순서대로 강제클릭 이벤트가 발생되는 함수
	function autoPlay() {
		btnNum++;
		if(btnNum == 4)
			btnNum = 0;
		
		$('#roll_banner_wrap dt a').eq(btnNum).trigger('click');
		//$('#roll_banner_wrap dt a').eq(btnNum).click(); 과 같음
		auto1 = setTimeout(autoPlay, 4000);
		//재귀라서 반복함 (setInterval 같은 효과를 주기 위해)
	}
	
	//로딩시 3초후 autoPlay() 호출
	var auto1 = setTimeout(autoPlay, 3000);
	//setInterval은 로딩이 된 후 반복, setTimeout은 로딩 된 후 한번만 실행
	//setInterval(autoPlay, 3000);
	
	//스톱에서 클릭이벤트 발생
	$('.stopBtn').on('click', function() {
		//auto1에 할당된 setTimeout()제거
		clearTimeout(auto1);
		//스톱 버튼에 "src"속성을 활성화된 버튼이미지로 바꿈.
		$('img', this).attr('src', $('img', this).attr('src').replace('off.gif', 'on.gif'));
		//재생 버튼에 "src"속성을 비활성화된 버튼이미지로 바꿈.
		$('img', '.playBtn').attr('src', $('img', '.playBtn').attr('src').replace('on.gif', 'off.gif'));
		//$('.playBtn img').attr('src', $('.playBtn img').attr('src').replace('on.gif', 'off.gif'));
		return false;
	});
	
	//재생에서 클릭이벤트 발생
	$('.playBtn').on('click', function() {
		//auto1에 할당된 setTimeout()제거
		clearTimeout(auto1);
		//플레이 중에 누를 경우 꼬이는 것 방지
		
		//재생 중인지 정지 중인지 확인
		var data = $('img', this).attr('src');
		if(data.includes('on.gif')) { // src 속성값을 가져와서 확인
			return false;
		}
		
		//3초 후에 autoPlay 함수 실행
		setTimeout(function() {
			autoPlay();
		}, 3000);
		//재생 버튼에 "src"속성을 활성화된 버튼이미지로 바꿈.
		$('img', this).attr('src', $('img', this).attr('src').replace('off.gif', 'on.gif'));
		//스톱 버튼에 "src"속성을 비활성화된 버튼이미지로 바꿈.
		$('img', '.stopBtn').attr('src', $('img', '.stopBtn').attr('src').replace('on.gif', 'off.gif'));
		//$('.stopBtn img').attr('src', $('.stopBtn img').attr('src').replace('on.gif', 'off.gif'));
		return false;
	});
	
	// 탭메뉴
	// 초기에 활성화된 첫 번째 탭 버튼 <a>만 변수 onTab에 할당
	var onTab = $('#tabmenu dt a:first');
	$('#tabmenu dt a').on('mouseover focus', function() {
		//현재 보이는 게시물 목록을 숨김
		$('#tabmenu dd:visible').hide();
		
		//클릭한 <a>의 부모요소인 <dt>에 다음 요소만 노출시킴
		$(this).parent().next().show();
		
		//onTab에 할당된 요소의 하위 <img>에 "src"속성을 비활성화 버튼 이미지로 바꿈
		$("img", onTab).attr('src', $("img", onTab).attr('src').replace("over.gif", "out.gif"));
		
		//클릭한 <a>에 하위 버튼 이미지를 활성화된 이미지로 바꿈
		$("img", this).attr('src', $("img", this).attr("src").replace("out.gif", "over.gif"));
		
		//클릭할 때마다 클릭한 요소에 <a>가 onTab에 할당.
		onTab = $(this); //현재 이벤트가 발생된 정보를 담아두어야 mouseover가 발생이 되면 onTab에 있는 정보가 지워지면서 바뀜
		
		return false;
	});
	
	
	$('#tabmenu dd p').on('click', function() {
		var chktab = $('#tabmenu dd p').index(this); // 구별자
		if(chkP==0) // 인덱스 번호에 따라..
			window.open('first.html');
		else if(chkP==1)
			window.open('second.html');
		else if(chkP==2)
			window.open('third.html');		
	});
	
	//베스트북 슬라이더
	var mySlider = $("#best_bg ul").bxSlider({
		mode : "horizontal",
		speed : 500,
		moveSlides : 1,
		slideWidth : 125,
		minSlides : 5,
		maxSlides : 5,
		slideMargin : 30,
		auto : true,
		autoHover : true,
		controls : false,
		pager : false // 페이지 번호
	});
	
	$(".prev_btn").on("click", function() {
		mySlider.goToPrevSlide();
		return false;
	}); //이전 버튼
	
	$(".next_btn").on("click", function() {
		mySlider.goToNextSlide();
		return false;
	}) //다음 버튼
	
	//팝업 연동
	//클라이언트에 정보를 저장하는 것은 쿠키
	//서버의 정보를 저장하는 것은 섹션
	if($.cookie('pop') != 'no')
		$('#pop_wrap').show();
	
	//팝업창 드래그
	$('#pop_wrap').css({'cursor' : 'move'}).draggable();
	
	//팝업창 닫기
	$('#pop_wrap area:eq(0)').on('click', function() {
		$('#pop_wrap').fadeOut('fast');
		return false;
	});
	
	//쿠키 저장
	$('#pop_wrap area:eq(1)').on('click', function() {
		$.cookie('pop', 'no', {expires:1});
		//pop 방식으로 전달하는데, 값은 no로, 기한은 하루
		$('#pop_wrap').fadeOut('fast');
		return false;
	});
});//////////////////////////


