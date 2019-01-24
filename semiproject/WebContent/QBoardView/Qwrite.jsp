<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 인코딩
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" type="text/css" href="../css/Qwrite.css" />

<!-- 부트스트랩 (샐랙트박스) class="form-control"-->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

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
  	$(document).ready(function(){
  		/* 내용부분 enter 적용시키기 */
  		$('form').on('submit', function(){
  			var title = $('input[name=q_subject]').val();
 	         if (title == "") {
 	            alert("제목을 입력하세요!");
 	            return false;
 	         }

 	         var contents = $('textarea[name=q_content]').val();
 	         if (contents == "") {
 	            alert("내용을 입력하세요!");
 	            return false;
 	         }
 	         
  			$('[name=q_content]').val($('[name=q_content]').val().replace(/\n/gi, '<br/>'));
  			
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
	<form name="frm" method="post" enctype="multipart/form-data" action="qwrite.do">
		<!-- 답변 -->
		<!-- core를 이용해서 받을때는 param.num으로 받을수 있다. -->
		<!-- 답변글이면. -->
		<c:if test = "${!empty param.q_num}">
			<input type = "hidden" name = "q_num" value = "${param.q_num}" />
			<input type = "hidden" name = "q_ref" value = "${param.q_ref}" />
			<input type = "hidden" name = "q_re_step" value = "${param.q_re_step}" />
			<input type = "hidden" name = "q_re_level" value = "${param.q_re_level}" />
			<input type = "hidden" name = "pageNum" value = "${param.pageNum}" />
		</c:if>
		
		<img id="mainimg" src="../QBoardView/images/qna_main.png" width="100%"/>
		<img id="qna" src="../QBoardView/images/qna.png" />
		
		<table id="type4">
			<tr>
				<th>SUBJECT</th>
				<td id="type4_td">
				<c:if test = "${!empty param.q_num}">
						<span>[Re]</span>
				</c:if>
				   <input id="sub_write" type="text" name="q_subject" value ="${param.q_subject}" placeholder="제목을 입력하세요"/>			 		
				</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<th>NAME</th>
				<td><input id="name_write" type="text" value="${sessionScope.user_id}" name="q_writer" readonly="readonly"/></td>
			</tr>

			<tr>
				<!-- <td>내용</td> -->
				<td colspan="2"><textarea id="cont_write" name="q_content" ></textarea></td>
			</tr>
			
			<tr>
			
				<td id="123">
					
				</td>
				<td></td>
				
				
				
				
				<!-- <td style="float:right;"><input type="submit" value="글쓰기" id="btn_write"/> -->
				<!-- <input type="reset" value="취소" id="btn_cancel" onclick="history.back()" /></td> -->
			</tr>
		</table>

		<div id="please">
		<span class="registercheck">
			<input type="image" id="regibtn_on" src="../QBoardView/images/qna_register.png" />
			<!-- <img id="regibtn_out" src="../QBoardView/images/qna_register_over.png" /> -->
		
		
		<span class="cancelcheck">
			<a href="qlist.do" id="btn_list">
				<img id="listbtn_on" src="../QBoardView/images/qna_cancel.png">
			</a>
			</span>
		</span>
		</div>
		
	</form>
	<!-- header end -->
	
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