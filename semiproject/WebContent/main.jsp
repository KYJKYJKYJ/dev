<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH & GYM</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../font/bootstrap.min.css">


<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">

<!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>

<!-- location 맵 js -->
<script
   src="//maps.googleapis.com/maps/api/js?key=AIzaSyA1ZvigA9nlrvCEkKzxjOWmZTYFKjyWcYo"
   async="" defer="defer" type="text/javascript"></script>
<script type="text/javascript" src="../js/main_mini_location.js"></script>
<style type="text/css">

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
                               out.write("alert('즐거운 시간 보내세요!')");
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
      <div id="section">
         <!-- 회전목마 효과 (부트스트랩) -->
         <div id="programCarousel" class="carousel silde" data-ride="carousel"
            data-pause="hover">
            <h1 id="carousel_title">Program.</h1>
            <ol class="carousel-indicators">
               <li data-target="#programCarousel" data-slide-to="0" class="active"></li>
               <li data-target="#programCarousel" data-slide-to="1"></li>
               <li data-target="#programCarousel" data-slide-to="2"></li>
               <li data-target="#programCarousel" data-slide-to="3"></li>
            </ol>

            <!-- 이미지 등록 -->
            <div class="carousel-inner">
               <div class="item active">
                  <a href="aboutprogram.do"> <img
                     class="img-responsive center-block" src="../images\main1.jpg"
                     alt="PT" style='height: 100%; width: 70%; object-fit: container' />
                  </a>
                  <div class="carousel-caption">
                     <h3>PT</h3>
                  </div>
               </div>

               <div class="item">
                  <a href="aboutprogram.do"> <img
                     class="img-responsive center-block" src="../images\main2.jpg"
                     alt="Spinning"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
                  <div class="carousel-caption">
                     <h3>Spinning</h3>
                   
                  </div>
               </div>

               <div class="item">
                  <a href="aboutprogram.do"> <img
                     class="img-responsive center-block" src="../images\main3.jpg"
                     alt="Yoga"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
                  <div class="carousel-caption">
                     <h3>Yoga</h3>
                  
                  </div>
               </div>

               <div class="item">
                  <a href="aboutprogram.do"> <img
                     class="img-responsive center-block" src="../images\main4.jpg"
                     alt="Pilates"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
                  <div class="carousel-caption">
                     <h3>Pilates</h3>
                  
                  </div>
               </div>
            </div>
         </div>

         <!-- 왼쪽, 오른쪽 버튼 -->
         <div>
            <a class="left carousel-control" href="#programCarousel"
               data-slide="prev"> <span
               class="glyphicon glyphicon-chevron-left"></span> <span
               class="sr-only">Prev</span>
            </a> <a class="right carousel-control" href="#programCarousel"
               data-slide="next"> <span
               class="glyphicon glyphicon-chevron-right"></span> <span
               class="sr-only">Next</span>
            </a>
         </div>

         <!-- 강사들 프리뷰 -->
         <!-- 회전목마 효과 (부트스트랩) -->
         <div id="instructorCarousel" class="carousel silde"
            data-ride="carousel" data-pause="hover">
            <h1 id="carousel_title">Instructor.</h1>
            <ol class="carousel-indicators">
               <li data-target="#instructorCarousel" data-slide-to="0"
                  class="active"></li>
               <li data-target="#instructorCarousel" data-slide-to="1"></li>
               <li data-target="#instructorCarousel" data-slide-to="2"></li>
               <li data-target="#instructorCarousel" data-slide-to="3"></li>
            </ol>

            <!-- 이미지 등록 -->
            <div class="carousel-inner">
               <div class="item active">
                  <a href="instructor.do"> <img
                     class="img-responsive center-block" src="../images\han.PNG"
                     alt="gosu"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
               </div>

               <div class="item">
                  <a href="instructor.do"> <img
                     class="img-responsive center-block" src="../images\jinpyo.PNG"
                     alt="gongyou"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
               </div>
               

               <div class="item">
                  <a href="instructor.do"> <img
                     class="img-responsive center-block" src="../images\Moon.PNG"
                     alt="bear"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
               </div>
               
                    <div class="item">
                  <a href="instructor.do"> <img
                     class="img-responsive center-block" src="../images\sona.PNG"
                     alt="bear"
                     style='height: 100%; width: 70%; object-fit: container' />
                  </a>
               </div>

               <div class="item">
                  <a href="instructor.do"> <img
                     class="img-responsive center-block" src="../images\0je.PNG"
                     alt="han" style='height: 100%; width: 70%; object-fit: container' />
                  </a>
               </div>
            </div>
         </div>

         <!-- 왼쪽, 오른쪽 버튼 -->
         <div>
            <a class="left carousel-control" href="#instructorCarousel"
               data-slide="prev"> <span
               class="glyphicon glyphicon-chevron-left"></span> <span
               class="sr-only">Prev</span>
            </a> <a class="right carousel-control" href="#instructorCarousel"
               data-slide="next"> <span
               class="glyphicon glyphicon-chevron-right"></span> <span
               class="sr-only">Next</span>
            </a>
         </div>
         <div id="mini_location">
            <h1>Location.</h1>
            <div id="mini_map_view" style="width: 70%; height: 298px;"></div>
         </div>
      </div>

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
      <!-- footer end -->
   </div>
   <!-- end wrap -->
<%--    <h3><%=session.getAttribute("user_id") %></h3> --%>
</body>
</html>