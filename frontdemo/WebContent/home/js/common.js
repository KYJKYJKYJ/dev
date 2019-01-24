// 로그인

$(document).ready(function(){
	//로그인 버튼
	//자식요소로 a가 있으면
	$('.login_wrap>a').on('click', function() {
		$('#login_f').animate({top:'20px'}, 500);
		return false;
	});
	
	//로그인 창에서 닫기 버튼, 로그인 눌렀을 때 닫아짐
	//#login_f 는 찾기 쉽게 하기 위해 넣은 것 (안넣어도 됨, 단 우선순위가 필요할 때는 넣어야됨)
	$('#login_f .login_close_btn>a, .input[alt="로그인버튼"]').on('click', function() {
		$('#login_f').animate({top:'-500px'}, 500);
		return false; // 버튼을 누르면 submit 되어 링크가 이동 되는 것을 막기 위해 return false;
	});

	//아이디 비밀번호에서 포커스를 받으면
								//다중 이벤트 등록
	$('#user_id, #user_pw').on('click focus', function() {
		$(this).prev().css({left: '-3000px'}) //지금 아이디, 비밀번호 칸에 있는게 placeholder 가 아님, 이미지임
	});
	
	//아이디 , 비밀번호가 포커스를 잃으면
	$('#user_id, #user_pw').on('blur', function() {
		if($(this).val() == "") {
			$(this).prev().css({left: '2px'});
		}
	});
	
	//프린터 버튼
	$(".print_btn").on('click', function() {
		window.print();
		return false;
	});
	
	//gnb메뉴 
	//현재 이벤트 상태를 저장하기 위한 변수 (마우스 위치가 바뀌면 over가 일어나다가 out으로 바꾸어야 할 때 사용함)
	var beforeEl;
	$('#gnb>li>a').on('mouseover focus', function() {
		var current = $('img', this).attr('src');
		var prev = $('img', beforeEl).attr('src');
		console.log("prev:" + prev + " current:" + current);
		
		if(beforeEl) { //beforeEl은 a까지만 정보가 저장되어 있음..
			$('img', beforeEl).attr('src', $('img', beforeEl).attr('src').replace('over.gif', 'out.gif'));
			$(beforeEl).next().slideUp('fast');
		}
						//images/gnb_2_out.gif          //images/gnb_2_over.gif
		$('img', this).attr('src', $('img', this).attr('src').replace('out.gif', 'over.gif'));
		//this : 현재 이벤트가 발생한 이미지 객체 (a)
		
		//ul의 객체 값
		$(this).next().slideDown('normal');
		beforeEl = $(this); // 현재 이벤트 객체를 저장해줌
	});
	
	//전체 메뉴 보이기
	$('#total_btn a').on('click', function(){
		$('#total_menu').slideDown('normal');
							//images/allmenu_btn_out.gif
		$('img', this).attr('src', $('img', this).attr('src').replace('out.gif', 'over.gif'));
		return false;
		
	});
	
	//전체 메뉴 닫기 버튼
	$('#total_close a').on('click', function() {
		$('#total_menu').slideUp('fast');
		$('#total_btn a img').attr('src', $('#total_btn a img').attr('src').replace('over.gif', 'out.gif'));
		return false;
	});
	
	//날짜 값
	var date = new Date();
	$('#date_wrap .year').text(date.getFullYear());
	$('#date_wrap .month').text(date.getMonth()+1);
	$('#date_wrap .date').text(date.getDate());
	
	//관련 사이트 이동
	$('form[name="rel_f"]').on('submit',function() {
		var url = $('select', this).val();
		window.open(url);
		return false;
	});
	
	//퀵 메뉴
	var defaultTop=parseInt($('#quick_menu').css("top")); //기본 빈공간 마련
	console.log(defaultTop);
	$(document).on('scroll', function() {
		var scv=$(document).scrollTop();
		$('#quick_menu').stop().animate({top:defaultTop+scv}, 500)
	});
});//////////////////////////













