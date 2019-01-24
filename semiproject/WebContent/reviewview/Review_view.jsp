<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH & GYM</title>

<style type="text/css">
#replyUpdate {
	display : none;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="../js/review.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
      $('.list').on('click', function() {
    	  $('form').attr('action', 'rlist.do');
    	  $('form').submit();
      });
      
      $('.reply').on('click', function() {
    	 $('form').attr('action', 'rwriteForm.do');
    	 $('form').submit();
      });
      
      $('.update').on('click', function() {
    	  $('form').attr('action', 'rupdateForm.do');
    	  $('form').submit();
      });
      
      $('.del').on('click', function() {
    	  $('form').attr('action', 'rdelete.do');
    	  $('form').submit();
      });
   });  
</script> 
 
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
<link rel="stylesheet" href="../css/Reviewwrite.css">

<!-- js 적용 -->
<script type="text/javascript" src="../js/main_navaccordian.js"></script>
 
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
      <div id ="reviewwritesection">
      <div id ="img">
      	<img src="../images/Review.png" width=100%>
      </div>
      
      <div><img src="../images/Reviewlogo_write.png"></div>
 <table id="reviewwritetable">
      <tr>
         <td>ID.</td>
         <td>${dto.user_id}</td>
      </tr>

      <tr>
         <td>Subject.</td>
         <td colspan="3">${dto.review_title}</td>
      </tr>

      <tr>
         <td>Date.</td>
         <td colspan="3">${dto.review_date}</td>
      </tr>

	  <tr>
         <td>Thumbnail.</td>
         <c:choose>
         	<c:when test="${dto.review_upload != null}">
        	 <td><img id="beforeview" src="http://localhost:8090/semiproject/temp/${dto.review_upload}"
        	 style="width: 100%; height: 300px; object-fit: fit;"/></td>
      	 	</c:when>
      	 	<c:otherwise>
      	 	 <td><img id="beforeview" src="../images/noimage.gif"
        	 style="width: 100%; height: 300px; object-fit: fit;"/></td>
      	 	</c:otherwise>
      	 </c:choose>
      </tr>

      <tr>
         <td colspan="3">
         ${dto.review_content}
         </td>
      </tr>

      <tr>
         <td>File.</td>
         <td colspan="3"><a href="rdownload.do?num=${dto.review_num}">${dto.review_upload}</a>
         </td>
      </tr>
   </table>
   
   <!-- 입력된 내용을 처리하는 서버 프로그램의 URI를 지정하는 역할 -->
   <form name="frm" method="post">
   <input type="hidden" id="textCol" name="col"/>
    <input type="hidden" name="num" value="${dto.review_num}" />
    <input type="hidden" name="pageNum" value="${param.pageNum}" />
   <input type="image" value="목록" class="list" src="../images/qna_list.png" width="75px" height="35px" /> 
    <input type="hidden" id="sessionUserid" data-value="<%= (String) session.getAttribute("user_id") %>" />
    
   <!-- 세션과 데이터베이스의 아이디 비교하여 일치시만 메뉴 출력 -->
   <c:if test="${sessionScope.user_id == dto.user_id}">   
   	<input type="image" value="수정" class="update" src="../images/qna_modify.png" width="75px" height="35px"/>
   	<input type="image" value="삭제" class="del" src="../images/qna_delete.png" width="75px" height="35px"/>
   </c:if>

	<!-- 댓글목록출력 -->
	<div><img src=""></div>
	
	<div id="replyList">
		<script type="text/javascript">
			listView("${requestScope.dto.review_num}");
		</script>
	</div>
	
	<!-- 회원들만 입력, 수정 가능하도록 설정 -->
	<c:if test="${sessionScope.user_id != null}">
	<!-- 댓글수정 -->
	<div id="replyUpdate">
		<input type="hidden" id="textCol" name="col"/>
		<div>댓글 수정하기</div>
		<input type="text" value="${sessionScope.user_id}" id="replyid" readonly="readonly" style="width:10%"/>
		<textarea id="textUpdate" rows="10" cols="20" style="resize: none; width: 100%; height: 30%"></textarea>
		<input type="button" id="updateBtn" value="수정" />
	</div>

	<!-- 댓글입력 -->
	<div id="replyInsert">
		<input type="text" value="${sessionScope.user_id}" id="replyid" readonly="readonly" style="width:10%"/>
		<textarea id="textInput" style="width:80%; resize: none; position: relative; top: 11px;"></textarea>
		<input type="button" id="inputBtn" value="댓글 입력" />
	</div>
	</c:if>
   </form>
   
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
      </div>
</body>
</html>