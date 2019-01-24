<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH & GYM</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('form').on('submit', function() {
			//제목, 내용 빈칸일시 경고
			var title = $('input[name=review_title]').val();
			if (title == "") {
				alert("제목을 입력하세요!");
				return false;
			}

			var contents = $('textarea[name=review_content]').val();
			if (contents == "") {
				alert("내용을 입력하세요!");
				return false;
			}
		});
			  
		//업로드 파일 확장자
		$('[name=review_upload]').change(function() {
			var fileext = $('[name=review_upload]').val();
			if(fileext != "") {
				var checkext = fileext.split(".").pop().toLowerCase();
				//배열 내의 값을 찾아서 인덱스를 반환합니다.(요소가 없을 경우 -1을 반환).
				if($.inArray(checkext, ["gif","jpg","jpeg","png"]) == -1) {
					alert("gif, jpg, jpeg, png 파일만 업로드 가능합니다.");
					$('[name=review_upload]').val("");
					return false;
				}
			}	
		});
			
		//글 작성 시 이미지 미리보기
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(data) {
					$('#beforeview').attr('src', data.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		
		//사이즈 제한
		function sizeChk(input) {
			var maxSize = 5*1024*1024;
			var fileSize = 0;
			
			fileSize = input.files[0].size;
			
			if(fileSize > maxSize) {
				alert("이미지는 5MB까지 업로드 가능합니다.")
				$('[name=review_upload]').val("");
				return false;
			}
		}
		
		$("#imgfile").change(function(){
			sizeChk(this);
			readURL(this);
		});
		
		$('[name=review_content]').val($('[name=review_content]').val().replace(/\n/gi, '<br/>'));
		
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
                             //  out.write("alert('즐거운 시간 보내세요!')");
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
      <div id = "reviewwritesection">
	<div id = "img">
		<img src="../images/Review.png" width=100% >
	</div>
	<div><img src="../images/Reviewlogo_write.png"></div>
	<form name="frm" method="post" enctype="multipart/form-data" action="rwrite.do">
	<table id = "reviewwritetable">
        <!--  <tr>
            <td align="right" colspan="2"><a href="rlist.do">리스트</a></td>
         </tr> -->

         <tr>
            <td width="20%" align="center">ID.</td>
            <td width="80%"><input type="text" name="user_id" id = "writeinput1" readonly="readonly"
            value="${sessionScope.user_id}"/></td> <!-- 자바로 세션 아이디를 받아오자 -->
         </tr>

         <tr>
            <td width="20%" align="center">Subject.</td>
            <td width="80%">
				<input type="text" name="review_title" id="writeinput2" />                
            </td>
         </tr>
		 <tr>
		 	<td width="20%" align="center">Thumbnail.</td>
		 	<td width="80%"><img id="beforeview" src="../images/noimage.gif" style="width: 100%; height: 300px; object-fit: fit;"/></td>
		 </tr>	
		</table>
			
		<table>	
         <tr>
           <td>           
           <textarea name="review_content" id="writetextarea" rows="13" cols="40" style="width: 1200px; resize: none;"></textarea>
			</td>         
         </tr>
         </table>
		<table>
         <tr>
            <td width="200px" align="center">File.</td>
            <td width="80%" id="fileDiv"><input type="file" name="review_upload" id="imgfile" value="Upload"/></td>
         </tr>
		
		
         <tr>
            <td colspan="2" align="center">
            <div id ="rev_reg">
            <input type="image" src="../images/qna_register.png" width=75px height=42px; />
            </div>
            
            <div id ="rev_cancel">
            <a href="rlist.do"><img src="../images/qna_cancel.png" width=75px height=42px;></a>
         	</div>
         </tr>
      </table>
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