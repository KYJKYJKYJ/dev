<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH & GYM _ Review</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>

<!-- 부트스트랩 -->
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- css 적용 -->
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/nav_accordian.css">
<link rel="stylesheet" href="../css/Reviewlist.css">

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
      <!-- header end -->
		<div id = "reviewlistsection">
		<div id = "img">
			<img src="../images/Review.png" width=100% >
			<img src="../images/Review2.png" width="100%" >
		</div>
		<div id = "borderline">
		<table id = "reviewlisttable">
			<thead>
				<tr>
					<th id = "rev_no">No.</th>
					<th id = "rev_thumb">Thumbnail</th>
					<th id = "rev_subject">Subject</th>
					<th id = "rev_id">ID</th>
					<th id = "rev_date">DATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.aList}" var="dto">
					<tr>
						<td>${dto.review_num}</td>
						<c:choose>
							<c:when test="${dto.review_upload != null}">
								<td><img
									src="http://localhost:8090/semiproject/temp/${dto.review_upload}"
									style="width: 500px; height: 200px; object-fit: fit" /></td>
							</c:when>
							<c:otherwise>
								<td><img
									src="../images/noimage.gif"
									style="width: 500px; height: 200px; object-fit: fit" /></td>
							</c:otherwise>
						</c:choose>
						<td><a href="rview.do?num=${dto.review_num}&pageNum=${pdto.currentPage}">${dto.review_title}</a></td>
						<td>${dto.user_id}</td>
						<td>${dto.review_date}</td>
						<%-- <td><c:if test="${dto.review_upload != null}">
								<img src="../images/save.gif" />
							</c:if></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class='searchbar'>
			<form name='frm' method='GET' action='rlist.do'>
				<div id = 'search' style='float: left;'>
					<select name='col'>
						<!-- 검색 컬럼 -->
						<option value='none'>전체 목록</option>
						<option value='user_id'>이름</option>
						<option value='title'>제목</option>
						<option value='content'>내용</option>
						<option value='title_content'>제목+내용</option>
					</select>
					<input type='text' name='word' value='' placeholder="특수문자는 X">
					<div><input type='image' id="searchbtn" src="../images/qna_search.png" /></div>
				</div>
			</form>
			<c:if test = "${sessionScope.user_id != null}">
		<p id = "Reviewlistwrite">
			<a href="rwriteForm.do">
			<img id="rev_write_on" src="../images/qna_write.png">
			</a>
		</p>
		</c:if>
		</div>


		<div id="paging">
			<!-- 이전 처리 -->
			<!-- 이전으로 이동할 것이 있을 경우에만 이전이 뜨도록 -->
			<!-- 이전 4 5 6 / 이전을 누르면 1 2 3이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
			<!-- 이전의 조건 : 현재페이지의 값이 1보다 클때 , 현재페이지-한블럭에보여줄페이지 (4-3=1페이지가 선택되어서 나옴) -->
			<c:if test="${requestScope.pdto.startPage > 1 }">
				<span><a class="aPage"
					href="rlist.do?pageNum=${pdto.startPage-pdto.blockPage }">
					<img id="rev_prev" src = "../images/prev.png" /></a></span>
			</c:if>

			<!-- 페이지 이동하는 부분 -->
			<c:forEach begin="${requestScope.pdto.startPage }"
				end="${requestScope.pdto.endPage }" var="i">
				<span><a class="aPage" href="rlist.do?pageNum=${i}">${i}</a></span>
			</c:forEach>

			<!-- 다음 처리 -->
			<!-- 다음으로 이동할 것이 있을 경우에만 다음이 뜨도록 -->
			<!-- 1 2 3 다음 / 다음을 누르면 4 5 6이 보이도록, 누르면 가장 첫번째 것이 선택이 되도록 -->
			<!-- 다음의 조건 : 현재 마지막 페이지보다 토탈페이지가 더 클때, 현재페이지+한블럭에보여줄페이지 (1+3=4페이지가 선택되어서 나옴) -->
			<!-- 리퀘스트 영역에 있는 값들은 '이름.값'으로 가지고 와도 됨(생략해서 많이 사용, 생략하지 않고 다 쓰는것이 정석이기는 함)  -->
			<c:if
				test="${requestScope.pdto.endPage < requestScope.pdto.totalPage }">
				<span><a class="aPage"
					href="rlist.do?pageNum=${pdto.startPage+pdto.blockPage }">
					<img id="rev_next" src = "../images/next.png" />
					</a></span>
			</c:if>
		</div>
		
		<!-- <a href="list.do">리스트</a> -->
		</div>
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