<%@page import="DAO.MemDAO" %>
<%@page import="DTO.MemDTO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KH & GYM</title>
<!-- Bootstrap -->

<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link href="../css/font-awesome.min.css" rel="stylesheet">
<!-- Custom Style -->
<link href="../css/style.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/..js/bootstrap.min.js"></script>
<script type="text/javascript" src="../jquery.js"></script>


 
<!-- 부트스트랩 -->
<script src="..js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">


<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">


 <!-- js 적용 -->
 <script type="text/javascript" src="../js/main_navaccordian.js"></script>
 
 <!-- location 맵 js -->
<script
	src="//maps.googleapis.com/maps/api/js?key=AIzaSyA1ZvigA9nlrvCEkKzxjOWmZTYFKjyWcYo"
	async="" defer="defer" type="text/javascript"></script>
<script type="text/javascript" src="js/main_mini_location.js"></script>
 

<script type="text/javascript">

 
</script>
<style type="text/css">
.col-md-3{
   margin: 0 auto;
   float: inherit;
}
.page-header{
	text-align : center;
}
</style>
</head>
<body>
<div id="wrap">
		<div id="header">
			  	<a href="main.do"><img src="../images/KHGYM_logo.png"
               		alt="KH & GYM" id="mainlogotop"></a>
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
								<li><a href="main.do">Logout</a></li>								
								<li><a href="MyPage.do">My Page</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>	
		</div>
	</div>
 <div class="container">
      <div class="row">
         <div class="page-header">
            <h2>KHGYM 로그인</h2>
         </div>
         <div class="col-md-3">
            <div class="login-box well">
               <form accept-charset="UTF-8" role="form" method="post" action="LoginPro.do">
          			      <legend>로그인</legend>
                  <div class="form-group">
                  
                     <label for="username-email">아이디</label> <input name="user_id"  id="user_id"
                        placeholder="ID" type="text"
                        class="form-control" />
                  </div>
                  
                  <div class="form-group">
                     <label for="password">비밀번호</label> <input name="user_pw" id="user_pw"  
                     placeholder="Password" type="password"
                        class="form-control" />
                  </div>
                  
                  <div class="form-group">
                     <input type="submit"
                        class="btn btn-default btn-login-submit btn-block m-t-md" 
                        value="Login" />
                  </div>
                 <span class='text-center'><a href="IdSearch.do"
                     class="text-sm">아이디 찾기</a></span> 
                     
                        <span>/</span>
                     
                  <span class='text-center'><a href="pwSearch.do"
                     class="text-sm">비밀번호 찾기</a></span>
                  <hr />
                
               </form>
           
            </div>
         </div>
      </div>
   </div>
     <div id="wrap">
		<div id="footer">
			<a href="http://localhost:8090/semiproject/main">
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
	 
	 
	<!-- wrap end -->
</body>
</html>