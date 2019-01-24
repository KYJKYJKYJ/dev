<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Q & A 게시판입니다.</title>

<link rel="stylesheet" type="text/css" href="../css/Qlist.css" />
<link rel="stylesheet" href="../font/seoulhangangjangm.eot">
<link rel="stylesheet" href="../font/seoulhangangjangm.ttf">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff">
<link rel="stylesheet" href="../font/seoulhangangjangm.woff2">
<link rel="stylesheet" type="text/css" href="../QBoardView/css/Qlist.css" />

<style type="text/css">

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
		var param = window.location.search.substring(1);
		var num = param.substring(8);
		$("span>a[href='qlist.do?qpageNum=" + num + "']").css('color', 'red');
	});
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<h1>
				<a href="main.do"><img src="..//images/KHGYM_logo.png"
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
		<div class="wrap1">
			<div id="main_intro">
				<img id="mainimg" src="../QBoardView/images/qna_main.png">
				<img id="maintext" src="..//QBoardView/images/qna_main_text.png">
			</div>
<div id="boardwrap">
			<table id="type1">
				<thead>
					<tr>
						<th id="no">NO.</th>
						<th id="subject">SUBJECT</th>
						<th id="id">ID</th>
						<th id="date">DATE</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${requestScope.aList}" var="dto">
						<tr class="list">
							<td class="numlist">${dto.q_num}</td>
							<td class="subjectlist">
							<c:if test="${dto.q_re_level!=0}">
									<img src="../QBoardView/images/level.gif"
										width="${10 * dto.q_re_level}">
									<img src="../QBoardView/images/re.gif" />
								</c:if> <a
								href="qview.do?q_num=${dto.q_num}&pageNum=${pdto.currentPage}">${dto.q_subject}</a>
							</td>

							<td class="user_idlist">${dto.q_writer}</td>
							<td class="datelist">${dto.q_reg_date}</td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
			
			<c:if test="${sessionScope.user_id != null}">
			<div id="writecheck">
				<a href="qwriteForm.do">
				<img id="writebtn_on" src="../QBoardView/images/qna_write.png" />
				
				</a>
				</div>
			</c:if>
				</div>	
			

			<!-- 이전 -->
		<!-- 이전 페이지가 있는 경우만 이전 출력 / 4페이지가 끝이라면 4페이지만 출력.-->
		<!-- startPage가 1보다 큰 경우에 4, 7, ... startPage에서 -3만큼한다. -->
		<%-- blockPage = 3;  한 블록에 보여줄 페이지수 --%>
		<div id="pagemove">
			<c:if test="${requestScope.pdto.startPage > 1}">
				<a href="qlist.do?pageNum=${pdto.startPage - pdto.blockPage}">
				<img id="pagemove_prev" src = "../QBoardView/images/prev.png" /></a>
			</c:if>

			<!-- 페이지 -->
			<c:forEach begin="${requestScope.pdto.startPage}"
				end="${requestScope.pdto.endPage}" var="i">
				<span><a href="qlist.do?pageNum=${i}">${i}</a></span>
			</c:forEach>

			<!-- 다음 -->
			<!-- 현재 마지막 페이지보다 토탈 페이지가 더 큰 경우 다음 가능. -->
			<c:if
				test="${requestScope.pdto.endPage < requestScope.pdto.totalPage}">
				<a href="qlist.do?pageNum=${pdto.startPage + pdto.blockPage}">
				<img id="pagemove_next" src = "../QBoardView/images/next.png" /></a>
				<p></p>
			</c:if>
		</div>

		<div class='searchbar'>
			<form name='frm' method='GET' action='qlist.do'>
				<div id='search' >
					<select name='col' id='optionbox'>
						<!-- 검색 컬럼 -->
						<option value='none'>전체 목록</option>
						<option value='q_writer'>이름</option>
						<option value='q_subject'>제목</option>
						<option value='q_content'>내용</option>
						<option value='qtitle_content'>제목+내용</option>
					</select>
					
						<input id="searchtext" type='text' name='word' value='' placeholder="내용 입력">
						<input id="searchbox" type="image" src="../QBoardView/images/qna_search.png" >
				</div>
			</form>
		</div>
	</div>
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