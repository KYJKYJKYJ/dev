$(document).ready(function(){
	//■■■ 로그인 관련 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	/*로그인 버튼 클릭 시*/
	$('.login_wrap>a').on('click',function(){
		
		$("#login_f").animate({top:'20px'},500);
		
		return false;
	});
	
	/*로그인 폼 닫기 버튼 */
	$('.login_wrap .login_close_btn, input[alt="로그인버튼"]').on('click',function(){
		$("#login_f").animate({top:'-500px'},500);
		return false;
	});
	
	/*아이디, 비밀번호 포커스 받는경우*/
	$('#user_id, #user_pw').on('focus',function(){
		$(this).prev().css({left:'-3000px'});
	});
	
	/*아이디 비번에서  포커스를 읽으면*/
	$('#user_id, #user_pw').on('blur', function(){
		//값이 있는지 확인
		if($(this).val()== ""){
			$(this).prev().css({left:'1px'});
		}		
	});
	
	//■■■ 헤더 : 로그인 제외  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	/*인쇄버튼*/
	$('.print_btn').on('click', function(){
		window.print();
		return false;
	});
	
	//■■■  메뉴 gnb ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	var beforeEl; //그전에 이벤트가 발생된거
	$('#gnb>li>a').on('mouseover focus',function(){
		
		if(beforeEl){ //그 전에 이벤트가 발생된 값을 가지고 있으면 , 없으면 undefined라서 안들어감 
			//자식요소, 부모요소 : 부모요소가 변수로 저장되어있을때 부모요소의 자식요소 찾아가는 방법
			$('img', beforeEl).attr('src',$('img', beforeEl).attr('src').replace('over.gif','out.gif'));
			$(beforeEl).next().slideUp('fast');
		}
		
		$('img', this).attr('src',$('img', this).attr('src').replace('out.gif','over.gif'));
		$(this).next().slideDown('normal');
		
		beforeEl = $(this);		
	});
	
	//페이지 로딩 후 홈 기본 선택
	/*beforeEl = $('#gnb>li:first a');	
	$('img', beforeEl).attr('src', $('img', beforeEl).attr('src').replace('out.gif','over.gif'));
	$(beforeEl).next().show();
	*/
	
	//이벤트 강제 실행
	$('#gnb>li>a:eq(0)').mouseover();
	
	//■■■  전체 메뉴 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	//전체 메뉴 보기
	$('#total_btn a').on('click', function(){
		if($('#total_menu').is(':visible')){
			$('#total_menu').slideUp('fast');
			$('img', this).attr('src',$('img', this).attr('src').replace('over.gif','out.gif'));
		}else{
			$('#total_menu').slideDown('normal');
			$('img', this).attr('src',$('img', this).attr('src').replace('out.gif','over.gif'));
		}
		
		return false;
	});	
	
	//전체 메뉴 닫기
	$('#total_close a').on('click', function(){
		$('#total_menu').slideUp('fast');
		$('#total_btn a img').attr('src',$('#total_btn a img').attr('src').replace('over.gif','out.gif'));
		return false;
	});
	
	
	//■■■  오늘의 날짜 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	var today = new Date();	
	$('.year').text(today.getFullYear());
	$('.month').text((today.getMonth()<10 ?"0"+(today.getMonth()+1):(today.getMonth()+1) ));
	$('.date').text((today.getDate()<10 ?"0"+today.getDate():today.getDate()));

	//■■■  관련 사이트 이동  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	//$('#relSite_wrap form input[type="image"]').on('click',function(){
	//$('#relSite_wrap input[type="image"]').on('click',function(){
	
	/*$('#relSite_wrap form input[type="image"]').on('click',function(){
		var selUrl = $('#relSite_wrap form select option:selected').val();
		$(this).parents('form').prop('action',selUrl);
	});*/
	
	$('form[name="rel_f"]').on('submit',function(){				
		var selUrl = $('select',this).val();
		window.open(selUrl);
		return false;		
	});
	
	//■■■  퀵 메뉴  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	var defaultTop = parseInt($("#quick_menu").css('top'));
	
	$(document).on('scroll',function(){
		var scv = $(document).scrollTop();		
		$("#quick_menu").stop().animate({top:defaultTop+scv},500);		
	});
	
	
});//end ready
















