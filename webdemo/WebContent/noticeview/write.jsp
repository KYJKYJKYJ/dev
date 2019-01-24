<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부트스트랩 -->
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- css 적용 -->
<link rel="stylesheet" href="../css\main.css">
<link rel="stylesheet" href="../css\nav_accordian.css">

<link rel="stylesheet" href="../noticeview/css/view.css" />
<script type="text/javascript">
	$(document).ready(
			function() {//enter눌른게 줄바뀜이 되도록 /n을 br로 바꿔준다
				$('form').on(
						'submit',
						function() {
							//name이라는 속성에서 컨텐츠값을 가지고와서 html에 br로 바꾸어서 넣어주어야 한다.
							//속성으로 접근, 정규화표현식 사용(/\n/gi : 모든 enter값)

							$('[name=content]').val(
									$('[name=content]').val().replace(/\n/gi,
											'<br/>'))
						});
			});
</script>
<style type="text/css">
#table table-striped table-bordered{
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<form action="main" method="get">
				<h1>
					<a href="http://localhost:8090/semiproject/main"><img
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
									<li><input type="submit" name="navBtn" value="greeting" />Greeting</li>
									<li><a href="http://localhost:8090/semiproject/instructor">Instructor</a></li>
									<li><a href="http://localhost:8090/semiproject/loungeview">Lounge
											View</a></li>
									<li><a href="http://localhost:8090/semiproject/location">Location</a></li>
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
									<li><a
										href="http://localhost:8090/semiproject/aboutprogram">About
											Program</a></li>
									<li><a
										href="http://localhost:8090/semiproject/registration">Registration</a></li>
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
									<li><a href="http://localhost:8090/semiproject/notice/*">Notice</a></li>
									<li><a href="http://localhost:8090/semiproject/qna">Q
											& A</a></li>
									<li><a href="http://localhost:8090/semiproject/review">Review</a></li>
									<li><a
										href="http://localhost:8090/semiproject/information">Information</a></li>
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
									<li><a href="">Login</a></li>
									<li><a href="MemberJoinForm.jsp">Join</a></li>
									<li><a href="#">My Page</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</form>
		</div>

		<!-- header end -->

		<form name="frm" action="write.do" method="post"
			enctype="multipart/form-data">
			<div id="contentForm">
				<div class="input-group input-group-sm" role="group"
					aria-label="...">
					<table class="table table-striped table-bordered" style="width:700px">
						<thead>
							<tr>
								<th width="300px">글쓴이</th>
								<td width="700px">관리자</td>
							</tr>
							<tr>
								<th style="padding-top: 15px">제목</th>
								<td><input type="text" name="title" class="form-control"
									aria-describedby="basic-addon1"></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2"><textarea class="form-control" rows="20"
										name="content"></textarea></td>
							</tr>
							<tr>
								<th style="padding-top: 15px">첨부파일</th>
								<td><input type="file" class="btn btn-default"
									name="fileName"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn-group btn-group-sm" role="group" aria-label="...">
					<input type="submit" class="btn btn-default" value="등록하기">
					<input type="button" class="btn btn-default" value="취소"
						onclick="document.location.href='list.do'">

				</div>
			</div>
		</form>
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