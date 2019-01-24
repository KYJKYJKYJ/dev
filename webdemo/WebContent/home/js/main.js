$(document).ready(function(){
	//■■■ 터치 슬라이드 비주얼 영역 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	window.mySwipe = $('#mySwipe').Swipe({
		auto:3000, 			//3초마다 이동
		continuous:true,	//반복해서 롤링
		callback:function(index, element){
			//배너 바뀌면서 pager부분도 변경 처리: touch_bullet 영역
			//console.log(index + "," + element)
			
			//기존꺼 off로 변경, 클래스 삭제
			$('.touch_bullet .active').attr('src',$('.touch_bullet .active').attr('src').replace('on.png','off.png')).removeClass('active');
			//현재꺼 변경, 클래스 추가
			$('.touch_bullet img').eq(index).attr('src', $('.touch_bullet img').eq(index).attr('src').replace('off.png','on.png')).addClass('active'); 
			
		}
	}).data('Swipe'); //~.data('Swipe')를 해서 처리된 결과값을 window.mySwipe에 입력해야지 이동됨
	
	//이동 버튼 - 이전
	$('.touch_left_btn a').on('click', function(){		
		mySwipe.prev(); //이전 배너 이동
		return false;
	});
	
	//이동 버튼 - 이후
	$('.touch_right_btn a').on('click', function(){
		mySwipe.next(); //다음 배너 이동
		return false;
	});
	
	//■■■ 알림판 롤링 버튼 배너 영역 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	//첫번째 배너 제외한 나머지 숨기기
	$('#roll_banner_wrap dd').not(":first").hide();
	
	//첫 번째 버튼의 <a>를 저장
	var onBtn = $('#roll_banner_wrap dt a:first');
	
	//버튼 1~4 클릭을 하면
	$('#roll_banner_wrap dt a').on('click',function(){
		//현재 보이고 있는 이미지를 감춤
		$('#roll_banner_wrap dd:visible').hide();
		//이전 버튼 이미지 변경
		$('img', onBtn).attr('src', $('img', onBtn).attr('src').replace('over.gif','out.gif'));
		
		//현재 선택된 인덱스 값을 받아옴
		var num = $('#roll_banner_wrap dt a').index(this);	
		//이미지 보여주기
		$('#roll_banner_wrap dd').eq(num).show();
		//선택 버튼 이미지 변경
		$('img', this).attr('src', $('img', this).attr('src').replace('out.gif','over.gif'));
		
		onBtn = $(this);
		
		return false; //링크 차단
	});
	
	//롤링 자동 재생
	var btnNum = 0;
	function autoPlay(){
		btnNum++;
		if(btnNum==4)
			btnNum = 0;
		
		$('#roll_banner_wrap dt a').eq(btnNum).trigger('click');
		//$('#roll_banner_wrap dt a').eq(btnNum).click();		
		auto1 = setTimeout(autoPlay,4000);//등록
	}		
	//최초 로딩 시 3초 후에  autoPlay() 호출
	var auto1 = setTimeout(autoPlay,3000);
	//var auto1 = setInterval(autoPlay,3000);
	
	//재생, 정지 버튼 
	$('.playBtn').on('click', function(){		
		//auto1 = setInterval(autoPlay,3000);
		clearTimeout(auto1); //플레이 상태일때 플레이 누를경우 대비
		
		btnNum = $('#roll_banner_wrap dt a').index(onBtn);
		//1초마다 autoPlay 함수 실행
		auto1 = setTimeout(autoPlay,1000);
		
		$('.stopBtn img').attr('src',$('.stopBtn img').attr('src').replace('on.gif','off.gif'));
		$('img', this).attr('src',$('img', this).attr('src').replace('off.gif','on.gif'));
		
		return false;
	});	
	
	$('.stopBtn').on('click', function(){
		//auto1에 할당된 setTimeout() 제거
		clearTimeout(auto1);
		//clearInterval(auto1);
		
		$('.playBtn img').attr('src',$('.playBtn img').attr('src').replace('on.gif','off.gif'));
		$('img', this).attr('src',$('img', this).attr('src').replace('off.gif','on.gif'));
		return false;
	});
	
	//■■■ 탭 메뉴 영역 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	var onTab = $('#tabmenu dt a:first');
	
	$('#tabmenu dt a').on('mouseover focus',function(){
		
		$('#tabmenu dd:visible').hide();		
		$(this).parent().next().show();
		
		//alert($(this).parent().prop("class"));
		ajaxCallTabData($(this).parent().prop("class"));
		
		//onTab에 할당된 요소의 하위 <img>에 "src" 속성을 비활성화 버튼 이미지로 바꿈
		$('img',onTab).attr('src',$('img',onTab).attr('src').replace('over.gif','out.gif'));
		//mouseover <a>하위 버튼 이미지를 활성화된 이미지로 바꿈
		$('img',this).attr('src',$('img',this).attr('src').replace('out.gif','over.gif'));		
		
		
		onTab = $(this);
		
		/*var num = $('#tabmenu dt a').index(this);
		$('#tabmenu dd').eq(num).show();					
		*/
		
		return false;
	});
	
	//strDtCls : 마우스 오버한 탭의 클래스 명
	function ajaxCallTabData(strDtCls){
		var gubun = "";
		if(strDtCls=="tab_btn1"){
			gubun = "employees";			
		}else if(strDtCls == "tab_btn2"){
			gubun = "board";
		}else{
			gubun = "mem";
		}
		
		
		$.ajax({
			type:"GET",
			dataType:"json",
			url:"tabdata?gubun="+gubun,
			success:function(res){
				//alert(res);
				var str = "";				
				for(i in res){
					if(gubun=="employees"){
						str += "<li><a href='#'>"+res[i].first_name+"(no."+res[i].employee_id+")</a>";
						str +="<span>"+res[i].hire_date+"</span></li>";
					}else if(gubun=="board"){
						str += "<li><a href='#'>"+res[i].subject+"</a>";
						str +="<span>"+res[i].reg_date+"</span></li>";
					}else{
						str += "<li><a href='#'>"+res[i].name+"</a>";
						str +="<span>나이:"+res[i].age+"</span></li>";
					}
				}	
				
				//alert(strDtCls);				
				var tab= $("."+strDtCls).next();				 
				$('ul', tab).empty();
				$('ul', tab).append(str);
			}			
		});
	}
	/*function ajaxCallTabData(objUl){
		$.ajax({
			url:'tabdata',
			success : function(responseText){
				objUl.empty();
				<c:forEach items="${requestScope.aList}" var="dto">
					<c:if test='${dto.gubun=="emp" }'>						
					objUl.append("<li><a href='#'>${dto.title}</a><span>no.${dto.num}</span></li>");
		    		</c:if>					
				</c:forEach>
			}
		});
	}*/
	
	//더보기 
	$('#tabmenu dd p a').on('click', function(){
		
		var num = $('#tabmenu dd p a').index(this);
		
		switch(num){
		case 0: window.open('first.html'); break;
		case 1: window.open('second.html'); break;
		case 2: window.open('third.html'); break;
		}
		
		return false;
	});
	
	//■■■ 책 롤링 영역 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	var mySlider = $('#best_bg ul').bxSlider({
		mode:"horizontal",
		speed:500,
		pager:false,
		moveSlides:1,
		slideWidth:125,
		minSlides:5,
		maxSlides:5,
		slideMargin:30,
		auto:true,
		autoHover:true,
		controls:false		
	});
	
	$('.prev_btn').on('click',function(){
		mySlider.goToPrevSlide();
		return false;
	});
	
	$('.next_btn').on('click',function(){
		mySlider.goToNextSlide();
		return false;
	});
	
	//■■■ 팝업 영역 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	//$('#pop_wrap').show();
	
	
	
});//end ready


















