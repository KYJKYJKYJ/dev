<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>KH & GYM</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:import url = "../loginCheck.jsp"></c:import>
<meta charset="UTF-8">

<title>프로그램 등록</title>

<!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>

<link rel="stylesheet" href="../css/reserve.css" />
<!-- 부트스트랩 (샐랙트박스) class="form-control"-->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- css 적용 -->
<link rel="stylesheet" href="../css\main.css">
<link rel="stylesheet" href="../css\nav_accordian.css">

<script type="text/javascript" src="../registerview/registration_time.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		$('#btn_register').on('click',function(){
			if(!$('#sports').val() || !$('#time').val()){
				alert('조건을 선택해주세요');
			}else{
				$('form').attr('action','reg_Process.do');
				$('form').submit();	
			}
		});
		
	});
</script>

<!-- 달력 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" type="text/css" href="../css/Qlist.css" />
<link rel="stylesheet" href="../font/seoulhangangjangm.eot">
<link rel="stylesheet" href="../font/seoulhangangjangm.ttf">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff2">
<style type="text/css">
/* 폰트 받아오기 */
@font-face {
	font-family: 'seoul-hangang-jang-m';
	src: url('../font/seoulhangangjangm.eot');
	src: url('../font/seoulhangangjangm.eot?#iefix')
		format('embedded-opentype'), url('../font/seoulhangangjangm.woff2')
		format('woff2'), url('../font/seoulhangangjangm.woff') format('woff'),
		url('../font/seoulhangangjangm.ttf') format('truetype'),
		url('../font/seoulhangangjangm.svg#seoul-hangang-jang-m')
		format('svg');
	font-weight: normal;
	font-style: normal;
}

/* 모든 전체 폰트 적용하기 */
* {
	font-family: seoul-hangang-jang-m
}

</style>
</head>
<body>
<div id="wrap">
<div id="header">
			<h1>
				<a href="main.do"><img src="../images/KHGYM_logo.png"
					alt="KH & GYM" id="mainlogotop"></a>
			</h1>
			<div style="position: relative;">
				<div class="nav_accordian" id="center_accordian">
					<ul id="navmenu">
						<li>
							<h3>
								<span class="aboutcenter"></span>About Center
							</h3>
							<ul id="aboutcenter_sub">
								<li><a href="greeting.do">Greeting</a></li>
								<li><a href="instructor.do">Instructor</a></li>
								<li><a href="loungeview.do">Lounge View</a></li>
								<li><a href="location.do">Location</a></li>
							</ul>
					</ul>
				</div>
				<div class="nav_accordian" id="program_accordian">
					<ul id="navmenu">
						<li>
							<h3>
								<span class="program"></span>Program
							</h3>
							<ul id="program_sub">
								<li><a href="aboutprogram.do">About Program</a></li>
								<li><a href="registration.do">Registration</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="nav_accordian" id="community_accordian">
					<ul id="navmenu">
						<li>
							<h3>
								<span class="community"></span>Community
							</h3>
							<ul id="community_sub">
								<li><a href="notice.do">Notice</a></li>
								<li><a href="qna.do">Q & A</a></li>
								<li><a href="review.do">Review</a></li>
								<li><a href="information.do">Information</a></li>
							</ul>
						<li>
					</ul>
				</div>
				<div class="nav_accordian" id="account_accordian">
					<ul id="navmenu">
						<li>
							<h3>
								<span class="account"></span>Account
							</h3>
							<ul id="account_sub">
								    <%
                           String id = (String) session.getAttribute("user_id");
                           boolean login = id == null ? false : true;
                        %>

                        <%
                           if  (login) {
                        	   out.write("<script type='text/javascript'>\n");
                              // out.write("alert('즐거운 시간 보내세요!')");
                               out.write("</script>\n");
                        	   
                        %>
                        
                        <li><a href="Logout.do">Logout</a></li>
                        <%
                           } else {
                        	  
                        %>
                        <li><a href="Login.do">Login</a></li>
                        <%
                           }
                        %>
                        
                        <%
                           if (login == false) {
                        %>
                           <li><a href="Mem.do">Join</a></li>
                        <%
                           }
                        %>
                        
                        <%
                           if (login) {
                        %>
                           <li><a href="MyPage.do">My Page</a></li>
                        <%
                           }
                        %>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		</div>
		<!-- header end -->
 <div class="container">	
<form name="frm" method="post" enctype="multipart/form-data" action="reg_Process.do">

	<img src="../images/program_register_top.png" alt="program_top" width="100%" />
	<img src="../images/program_registration_top.png" id="registration_top" width="80%"
	style="display: block; margin: 0 auto; padding: 100px;"/>
	<form>
	<table id="searchform" style="border: 1px solid LightGray; border-radius:10px; padding-top: 10px;
    padding-bottom: 10px;">
		<tr>
			<td width="20%" align="center" >운동</td>
			<td width="65%"><select id="sports" name="sports" class="form-control">
			<option value="">선택</option>
			<option value="PT" id="PT">PT</option>
			<option value="스피닝">스피닝</option>
			<option value="요가">요가</option>
			<option value="필라테스">필라테스</option>
			</select></td>
			<td width="15%"></td>
		</tr>
		
		<tr>
			<td width="20%" align="center">날짜 </td>
			<td><input type="text" id="datepicker" name="register_date" width="65%" class="form-control">
    <script>
        $(function() {
            //input을 datepicker로 선언
            $("#datepicker").datepicker({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                /* ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트               */  
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
            });                    
            
            //초기값을 오늘 날짜로 설정
            $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
        });
        
        
    </script></td>
   		 <td><input type=button id="test" value="조회" width="15%" class="btn btn-primary"
   		 style="cursor:pointer; background-color:Tan; border-style:none; display: block;
	margin: 0 auto;"></td>
		</tr>
		
		<tr>
			<td width="20%" align="center">시간</td>
			<td width="65%" id="timenext">
				<select id="time" name="register_time" class="form-control">
				<option value="">조회를 눌러주세요</option>
				</select>
			</td>
			<td width="15%"></td>
		</tr>
		
		<!-- <input type="text" name="user_id" value="나"/>
		 -->
	</table>
	</form>
	<button id="btn_register">등록</button>
</form>
</div>

<div id="wrap">
			<div id="footer">
				<a href="main.do"> <img src="../images/KHGYM_logo.png"
					alt="KH & GYM" id="mainlogofooter">
				</a>
				<div style="position: relative">
					<p id="footer_copyright">KH & GYM corp. copyleftⓒ</p>
					<p id="footer_company">상표명 : KH & GYM</p>
					<p id="footer_location">주소 : 서울특별시 강남구 역삼동 강남구 테헤란로14길</p>
					<p id="footer_manager">사업자 : 한윤희</p>
					<p id="footer_tel">TEL : 02) 0123-4567</p>
				</div>
			</div>
			<!-- footer end -->

	</div>
		<!-- end wrap -->
</body>
</html>