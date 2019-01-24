<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH & GYM</title>
<link rel="stylesheet"

   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



 
<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
 
 
<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">
 
 <!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   //회원탈퇴 버튼
   $('#deletebtn').on('click', function() {
        $('form').attr('action', 'delete.do');//뒤에는 서블릿주소
        alert('회원탈퇴가 완료되었습니다.');
        $('form').submit();
     });
   
   //프로그램 취소
   $('#btn_delete').on('click', function() {
        if (!$('.check').val()) {
           alert('예약된 정보가 없습니다.');
        } else {
           $('form').attr('action', 'registerDelete.do');
           $('form').submit();
        }
     });
   
   
});
</script>

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
            <a href="main.do"><img
               src="../images/KHGYM_logo.png" alt="KH & GYM" id="mainlogotop"></a>
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
   </div>

   <div id="">
      <article class="container">
      
         <div class="page-header">
            <div class="col-md-6 col-md-offset-3">
               <br/>
               <h3>회원정보</h3>
            </div>
         </div>
         <div class="col-sm-6 col-md-offset-3">
            <form action="MyPagePro.do" method="post" role="form">
               <table class="table" style="width: 100%">
                  <tr>
                     <td rowspan='5' width="40%"><img src="../images/id-card.png"
                        width="100%"></td>
                        
                     <th id="title">아이디</th>
                     <td>${dto.user_id}</td>
                  </tr>

                  <tr>
                     <th id="title">이름</th>
                     <td>${dto.user_name}</td>
                  </tr>

                  <tr>
                     <th id="title">생년월일</th>
                     <td>${dto.user_birth}</td>
                  </tr>

                  <tr>
                     <th id="title">이메일 주소</th>
                     <td>${dto.user_email}</td>
                  </tr>

                  <tr>
                     <th id="title">휴대폰 번호</th>
                     <td>${dto.user_phone}</td>
                  </tr>
               </table>
               <div class="form-group text-center">
               
                  <button type="submit" class="btn btn-primary">
                     회원정보 수정<i class="fa fa-check spaceLeft"></i>
                  </button>
               
                  <button type="submit" class="btn btn-warning" id="deletebtn">
                     회원탈퇴<i class="fa fa-times spaceLeft"></i>
                  </button>

        
               </div>
            </form>
               <div><br/><br/></div>
            
        <form name="deleteform" id="deleteform" method="post" role="form">
               <div class="register_info">
                  <h3>프로그램 등록 정보</h3>
               </div>
               <div>
                  <table class="table" style="width: 100%">
                     <thead>
                        <tr>
                           <th>프로그램 종목</th>
                           <th>날짜</th>
                           <th>운동시간</th>
                           <th>선택</th>
                        </tr>
                     </thead>
                     <tbody>

                        <c:forEach items="${requestScope.dto2}" var="dto2">
                           <tr>
                              <td>${dto2.sports}</td>
                              <td>${dto2.register_date}</td>
                              <td>${dto2.register_time}</td>
                              <td><input class="check" type="checkbox" name="num"
                                 value="${dto2.register_num}"></td>
                           </tr>
                        </c:forEach>

                     </tbody>

                  </table>
                  <div class="form-group text-center">
                     <input type="button" id="btn_delete" value="프로그램 취소"
                        class="btn btn-primary">

                  </div>
               </div>
            </form>
         </div>
      </article>
   </div>



     <div id="wrap">
       <!-- section end -->
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
     </div>
      <!-- footer end -->

   <!-- wrap end -->


</body>
</html>