<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="../noticeview/css/view.css" />
<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">
<link rel="stylesheet" href="../css/list.css" />
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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

      //목록
      $('#list').on('click', function() {
         $('form').attr('action', 'notice.do'); //'*'를 하면 목록으로 돌아오긴 함,처음에 들어갈때는 *로 들어가지만 그다음에 목록으로 돌아갈때에는 list.do로 처리
         $('form').submit();
      });

      //수정
      //수정버튼을 눌렀을때는 form요소에 뿌려주어야 한다.(그래야 읽어오기와 쓰기가 모두 가능하기 때문)
      $('#update').on('click', function() {
         $('form').attr('action', 'nupdateForm.do');
         $('form').submit();
      });

      //삭제
      //삭제 버튼을 누르면 delete.do로 서브밋해라
      $('#del').on('click', function() {
         var chk = confirm("삭제하시겠습니까?");
         if (chk == true) {
            $('form').attr('action', 'ndelete.do');
            $('form').submit();
         }
      });

   });
</script>

</head>
<body>
   <div id="wrap">
          <div id="header">
         <h1>
            <a href="../main.do"><img src="../images/KHGYM_logo.png"
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
      </div>
      <!-- header end -->
<div class="container">
	<div id="notice_section">
                        <img id="notice_content1" src="../images/notice_img.png"
                           width="100%"> <br /><br /><br /> <img
                           id="notice_content2" width="27%" src="../images/notice.png" style="display: block; margin: 0 auto; padding: 40px;">
      </div>
      <hr />

   <div id="contentForm" style="width: 1200px; margin: 0 auto">
      <table class="table table-bordered" 
         style="width: 1200px; border-color: black;" >
         <thead>
            <tr style="width: 100px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #efefef;">
               <th width="80px">글쓴이</th>
               <th>관리자</th>
               <th width="20%">작성일</th>
               <th>${dto.notice_date}</th>

            </tr>
         </thead>
         </tbody>
         <tr>
            <td style="width: 50px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #efefef;">제목</td>
            <td colspan="3">${dto.notice_title}</td>
         </tr>

         <tr>
            <td style="width: 50px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #efefef;">내용</td>

            <td colspan="3">${dto.notice_contents}</td>
         </tr>

         <tr>
            <td style="width: 50px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #efefef;">파일</td>
            <td colspan="4"><a
               href="download.do?notice_num=${dto.notice_num}">${dto.notice_upload}</a>
            </td>
         </tr>
         <tbody>
      </table>
         <!-- form에 설정되어 있는 버튼이 여러개 이기 때문에 action을 지정해두지 않고 각각의 버튼 마다 스크립트에서 따로 지정해 주어야 한다. -->
         <form name="frm" method="post">
            <!-- 모두 가져다 쓸 필요는 없음, 필요한 값만 가져다 쓰면됨 -->
            <input type="hidden" name="num" value="${dto.notice_num}" /> <input
                              type="hidden" name="pageNum" value="${param.pageNum}" />
            <!-- 파라미터 값으로 받으므로 리퀘스트 영역에 저장하는 것이 아니라 파라미터 값으로 넘겨 주어야함 -->
            <!-- view.do에서 넘겨준 파라미터값을 forward해준 view.jsp에서도 사용가능함, 여기서 그냥 param.pageNum로 값을 받아올 수 있음  -->

            <div class="btn-group btn-group-sm" role="group" aria-label="...">
               <input type="button" value="목록" class="btn btn-default" id="list" />
         <c:if test="${sessionScope.user_id == 'admin'}">
            <input type="button" value="수정" class="btn btn-default" id="update" />
            <input type="button" value="삭제" class="btn btn-default" id="del" />
         </c:if>
            </div>
         </form>
      </div>
      <div id="wrap">
      <div id="footer">
         <a href="http://localhost:8090/semiproject/main"> <img
                              src="../images/KHGYM_logo.png" alt="KH & GYM"
                              id="mainlogofooter">
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
  </div>

                  </body>
</html>