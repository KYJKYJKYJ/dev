<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice 게시판입니다.</title>
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
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript" src="../js/main_navaccordian.js"></script>


<link rel="stylesheet" type="text/css" href="../css/Qlist.css" />
<link rel="stylesheet" href="../font/seoulhangangjangm.eot">
<link rel="stylesheet" href="../font/seoulhangangjangm.ttf">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff2">

<link rel="stylesheet" type="text/css" href="../QBoardView/css/Qlist.css" />


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
            <a href="main.do"><img src="../noticeview/images/KHGYM_logo.png"
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

</div>

 <div class="container">	
<div id="notice_section">
         <img id="notice_content1" src="../images/notice_img.png"
            width="100%"> <br/><br/><br/> <img id="notice_content2" width="27%"
            src="../images/notice.png" style="display: block; margin: 0 auto; padding: 40px;"/>
      </div>
      
      <div class="boardwrap">
         <table class="type1" style="width:1200px" >
            <thead>
               <tr>
                  <th width="10%">번호</th>
                  <th width="40%">제목</th>
                  <th width="10%">작성자</th>
                  <th width="20%">작성일</th>
                  <th width="20%">첨부파일</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${requestScope.aList}" var="dto">
                  <tr>
                     <td>공지</td>
                     <td><a
                        href="nview.do?num=${dto.notice_num}&pageNum=${pdto.currentPage}">${dto.notice_title}</a></td>
                     <td>관리자</td>
                     <td>${dto.notice_date}</td>
                     <td><c:if test="${!empty dto.notice_upload}">
                           <img src="../images/save.gif" />
                        </c:if></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>

         <div class="writecheck" style="width:1200px; margin: 0 auto; text-align: right;">
            <c:if test="${sessionScope.user_id == 'admin'}">
               <a href="nwriteForm.do" id="notice_write_btn"
                  class="btn btn-default" >글쓰기</a>
            </c:if>
         </div>
         
         
            <div id="paging" style="text-align: center;">
               <!-- 이전 처리 -->
               <!-- 이전으로 이동할 것이 있을 경우에만 이전이 뜨도록 -->
               <!-- 이전 4 5 6 / 이전을 누르면 1 2 3이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
               <!-- 이전의 조건 : 현재페이지의 값이 1보다 클때 , 현재페이지-한블럭에보여줄페이지 (4-3=1페이지가 선택되어서 나옴) -->
               <c:if test="${requestScope.pdto.startPage > 1 }">
                  <span><a class="aPage"
                     href="nlist.do?pageNum=${pdto.startPage-pdto.blockPage }"><img id="pagemove_prev" src = "../QBoardView/images/prev.png" style="width:20px; padding-bottom: 10px"/></a></span>
               </c:if>

               <!-- 페이지 이동하는 부분 -->
               <c:forEach begin="${requestScope.pdto.startPage }"
                  end="${requestScope.pdto.endPage }" var="i">
                  <span><a class="aPage" href="nlist.do?pageNum=${i}" style="font-size: 1.5em; font-style: bold ">${i}</a></span>
               </c:forEach>

               <!-- 다음 처리 -->
               <!-- 다음으로 이동할 것이 있을 경우에만 다음이 뜨도록 -->
               <!-- 1 2 3 다음 / 다음을 누르면 4 5 6이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
               <!-- 다음의 조건 : 현재 마지막 페이지보다 토탈페이지가 더 클때, 현재페이지+한블럭에보여줄페이지 (1+3=4페이지가 선택되어서 나옴) -->
               <!-- 리퀘스트 영역에 있는 값들은 '이름.값'으로 가지고 와도 됨(생략해서 많이 사용, 생략하지 않고 다 쓰는것이 정석이기는 함)  -->
               <c:if
                  test="${requestScope.pdto.endPage < requestScope.pdto.totalPage }">
                  <span><a class="aPage"
                     href="nlist.do?pageNum=${pdto.startPage+pdto.blockPage }"><img id="pagemove_next" src = "../QBoardView/images/next.png" style="width:20px; padding-bottom: 10px"/></a></span>
               </c:if>
            </div>

         </div>

      
      <div class='searchbar' style="width:1200px; margin: 0 auto; text-align: center; ">
      <form name='frm' method='GET' action='nlist.do'>    
         <div >
            <table>
               <tr>
                  <td><select name='col' class="form-control">
                        <!-- 검색 컬럼 -->
                        <option value='none'>전체 목록</option>
                        <option value='title'>제목</option>
                        <option value='contents'>내용</option>
                        <option value='title_content'>제목+내용</option>
                  </select></td>
                  <td><input style="width: 300px" type='text' name='word' value=''
                     placeholder="특수문자는 사용할수 없습니다." class="form-control"></td>
                  <td><button type='submit' class="btn btn-default">검색</button></td>
               </tr>
            </table>
         </div>

      </form>
   </div>
  </div>
      
      <div id="wrap">
   <div id="footer">
      <a href="http://localhost:8090/semiproject/main"> <img
         src="../images/KHGYM_logo.png" alt="KH & GYM" id="mainlogofooter">
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