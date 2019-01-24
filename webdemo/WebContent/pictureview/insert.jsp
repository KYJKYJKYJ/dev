<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 이미지 삽입 체크 -->
<script type="text/javascript">
	$(document).ready(function() {
		$('form').on('submit', function() {
			var str = $('#filepath').val();
			
			//이미지 등록 안하고 커밋 막음
			if(str.length < 1) {
				alert('이미지를 선택하세요');
				return false;
			}
		});
	
		//이미지를 선택하면 change 이벤트 발생하고 value를 이용해서 img에 src 속성에 넣기
		$('#filepath').on('change', function() {
			var str = $('#filepath').val();
			
			//이미지 첨부파일인지 체크
			var patt=/(.jpg$|.gif$|.png$)/g;
			var result=str.match(patt);
			console.log('result:'+result);
			if(!result) {
				alert('jpg, gif, png 파일만 가능합니다');
				$('#filepath').val('');
				$('img').removeAttr('src');
				return false;
			}
			
			//파일첨부 사이즈 체크
			console.log(this.files + "," + this.files[0]);
				if(this.files && this.files[0]) {
					if(this.files[0].size>1000000) { // 정해놓은 크기 그대로 해야..
						alert('1MB바이트 이하만 첨부 가능합니다.');
						$('#filepath').val('');
						return false;
					}
				}
			
			//파일을 읽기위한 FileReader 객체 생성
			var reader = new FileReader();
			
			//파일 내용을 읽어 dataURL 형식의 문자열로 저장함
			reader.readAsDataURL(this.files[0]); //files는 객체..
			
			//파일 읽어들이기를 성공했을 때 호추로디는 이벤트 핸들러
			reader.onload=function(e) {
				//$('img').attr('src', str); //실제 경로로 하면 안되고 url을 넣어주어야함
				//이미지 Tag의 src속성에 읽어들인 File내용을 지정
				$('img').attr('src', e.target.result);
			};
		});
	});
</script>
</head>
<body>
	<!-- 
  input요소의 type속성의 값이 "file"이면
  method="post"
  enctype="multipart/form-data"
  설정한다.
 -->
	<form name="frm" action="insertMain" method="post"
		enctype="multipart/form-data">
		<!-- multipart/form-data는 파라미터를 request로 못받음 HttpServletRequest 사용불가-->

		<p>
			<img width="100" height="100" />
		</p>
		<p>
			<span>파일</span> <input type="file" name="filepath" id="filepath" />
		</p>
		<input type="submit" value="commit" />
	</form>
</body>
</html>







