<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view 보이는 부분입니다아아</title>
<link rel="stylesheet" type="text/css" href="../css/Qview.css" />

<link rel="stylesheet" href="../font/seoulhangangjangm.eot">
<link rel="stylesheet" href="../font/seoulhangangjangm.ttf">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff2">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- css 적용 -->
<link rel="stylesheet" href="../css\main.css">
<link rel="stylesheet" href="../css\nav_accordian.css">
<link rel="stylesheet" href="../css\greeting.css" />

<!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>


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
<script type="text/javascript">
	$(document).ready(function() {
		$('.qlist').on('click', function(){
		$('form').attr('action', 'qlist.do');
		$('form').submit();
		});
		
		$('#reply_on').on('click', function(){
			$('form').attr('action', 'qwriteForm.do');
			$('form').submit();
		}); 
		
		$('#updatebtn_on').on('click', function(){
			$('form').attr('action', 'qupdateForm.do');
			$('form').submit();
		});
		
		$('#deletebtn_on').on('click', function(){
			$('form').attr('action', 'qdelete.do');
			$('form').submit();
		});
		
	});
</script>

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
                               //out.write("alert('즐거운 시간 보내세요!')");
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
		<!-- header end -->
	<div>
		<img id="mainimg" src="../QBoardView/images/qna_main.png">
		<img id="qna" src="../QBoardView/images/qna.png" />
	</div>

	<div class="replycheck">
	<c:if test="${sessionScope.user_id == 'admin'}">
	<img id="reply_on"
		src="../QBoardView/images/qna_reply.png" /> 
	 
	 </c:if>
	</div>

	<div class="wrap2">
		<table id="type2">
			<tr>
				<th>SUBJECT</th>
				<td>${dto.q_subject}</td>
			</tr>

			<tr>
				<th>NAME</th>
				<td>${dto.q_writer}</td>
			</tr>

			<tr>
				<th>DATE</th>
				<td>${dto.q_reg_date}</td>
			</tr>

			<tr>
				<!-- <th>CONTENT</td> -->
				<td id="cont_space" colspan="2">${dto.q_content}</td>
			</tr>

		</table>
	
	
	<span id="listcheck">
	<a href="qlist.do">
	<img id="listbtn_on" src="../QBoardView/images/qna_list.png"/>
	
	 </a>
	 </span>
	
	<c:if test="${sessionScope.user_id != null}">
	 <span id="updatecheck">
	<%-- <a href="qupdateForm.do"> --%>
	 <img id="updatebtn_on" src="../QBoardView/images/qna_modify.png"/>
	 
	 <%-- </a> --%>
	 </span>
	 
	 <span id="deletecheck">
	 <!-- <a href="qdelete.do"> -->
	 <input type="image" id="deletebtn_on" src="../QBoardView/images/qna_delete.png"/>
	 <!-- </a> -->
	 </span>
	 </c:if>
	 	
	</div>
	
	<form name="frm" method="post">
		<input type="hidden" name="q_num" value="${dto.q_num}" /> <input
			type="hidden" name="q_subject" value="${dto.q_subject}" />
			<%-- <input type="hidden" name="q_reg_date" value="${dto.q_reg_date}" /> --%>

		<!-- 제목 + 답변글 그룹 -->
		<input type="hidden" name="q_ref" value="${dto.q_ref}" />

		<!-- 출력 순서  // 제목 : 최근 입력 먼저 출력 // 답변 : 최근 입력 먼저 출력-->
		<!-- 출력 순서  // 제목 : 최근 입력 나중 출력 // 답변 : 최근 입력 먼저 출력 = 저장 방법이 달라진다.-->
		<input type="hidden" name="q_re_step" value="${dto.q_re_step}" />

		<!-- 출력할 때 들여쓰기 -->
		<input type="hidden" name="q_re_level" value="${dto.q_re_level}" />
		
	</form>
		<!-- section end -->
      <div id="footer">
         <a href="main.do">
         <img src="../images/KHGYM_logo.png" alt="KH & GYM" id="mainlogofooter">
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
</body>
</html>











