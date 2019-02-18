<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>boardView</title>
<style type="text/css">
.modifyShow {
	display: block;
	position: absolute;
	/*  top: 150px; */
	left: 200px;
	width: 400px;
	height: 150px;
	z-index: 1000;
	border: 1px solid black;
	background-color: yellow;
	text-align: center;
}

.modifyHide {
	visibility:hidden;
	width:0px; 
	height:0px;	
}

.fileDrop {
	width: 500px;
	height: 100px;
	border: 1px dotted blue;
	overflow: auto;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<script type="text/javascript">
	var urno='';
	var fileList='';
	
	$(document).ready(function(){
		//수정 모달 숨기기
		$('#modifyModal').addClass('modifyHide');
		//댓글 입력 버튼
		$('#replyAddBtn').on('click',reply_list);
		//댓글 수정, 삭제 버튼 (동적 이벤트)
		$(document).on('click', '.timeline button',reply_update_delete);
		//모달창 닫기버튼
		$('#btnClose').on('click', function() {
			$('#modifyModal').removeClass('modifyShow');
			$('#modifyModal').addClass('modifyHide'); //닫기 할 때는 클래스 반대로
			$(document).on('click','.timeline button',reply_update_delete);
			urno = '';
		});
		//모달창 수정버튼
		$('#btnModify').on('click', reply_update_send);
		
		//내PC 첨부파일 시작
		var userfile='';
		$('#userpc').on('click', function() {
			userfile=$('<input type="file", id="userfile" />')
			userfile.click();
			userfile.change(function() {
				var partname=$(userfile[0]).val()
				.substring($(userfile[0]).val().lastIndexOf("\\")+1);
				//console.log("partname", partname);
				var str='<p><input type="checkbox"/>'+partname+'</p>';
				$('.fileDrop').empty(); // 초기화
				$('.fileDrop').append(str);
				var dataList=userfile[0].files[0];
				
				fileList=dataList; // 선언하지 않고 사용하면 전역변수로 자동으로 선언되는데 이 방법은 좋은 방법이 아니다.
			});
		});
		//내PC 첨부파일 끝
		
		//첨부파일 드래그 시작
		var obj=$('.fileDrop');
		obj.on('dragover', function(e) {
			e.preventDefault(); // 기본 이벤트 전파 방지, 그렇지 않으면 그냥 소스코드로 파일이 떠버림
			$(this).css('border', '2px solid #0B85A1');
		});
		
		obj.on('drop', function(e) {
			e.preventDefault(); // 기본 이벤트 전파 방지, 그렇지 않으면 다운로드 받게 됨
			$(obj).empty();
			var files = e.originalEvent.dataTransfer.files;
			obj.append('<p><input type="checkbox" />'+files[0].name+'</p>');
			fileList=files[0];
		});
		//첨부파일 드래그 끝
		
		//첨부파일 삭제 시작
		$(document).on('click', '.fileDrop input', function() {
			if($(this).prop('checked')) {
				$(this).parent().remove();
				fileList='';
			}
		});
		//첨부파일 삭제 끝
	});
	
	//댓글 수정내역 보내기
	function reply_update_send() {
		$.ajax({
			type: 'GET',
			dataType: 'json',
			url: 'replyUpdate.do?bno=${boardDTO.bno}&rno='+urno+'&replytext='+$('#updateReplyText').val(),
			success: reply_list_result
		});
		
		//수정 창 값 초기화
		$('#updateReplyText').val('');
		//수정 후 창 닫기
		$('#modifyModal').removeClass('modifyShow');
		$('#modifyModal').addClass('modifyHide'); //닫기 할 때는 클래스 반대로
		$(document).on('click','.timeline button',reply_update_delete);
		urno = '';
	}
	
	//댓글 삭제
	function reply_update_delete() {
		if($(this).text()=='delete'){
			var drno = $(this).prop("id");
			$.ajax({
				type:'GET',
				dataType:'json',
				url:'replyDelete.do?bno=${boardDTO.bno}&rno='+drno,
				success:reply_list_result
			});
		}else if($(this).text()=='update'){
			urno = $(this).prop('id');
			console.log('urno= '+urno);
			var utext = $(this).parents('li').children('p:nth-child(2)').text();
			$('#updateReplyText').val(utext);
			
			var stop = $(window).scrollTop();
			$('#modifyModal').css('top', 50+stop);
			/* $('#modifyModal').removeClass('modifyHide');
			$('#modifyModal').addClass('modifyShow'); */
			$('#modifyModal').removeClass('modifyHide').addClass('modifyShow');
			$(document).off('click','.timeline button'); // 버튼에 이벤트를 해제하는 off
		}
	}
	
	//newDate: 함수의 결과값을 받기위한 변수명, timeValue: regdate값을 받기위한 변수
	Handlebars.registerHelper("newDate", function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	
	function reply_list_result(res) {
		//alert(res.length);
		//기존에 있던 댓글 삭제
		$('.timeline .time_sub').remove();
		//댓글 개수 업데이트
		$('#replycntSmall').text('['+res.length+']');
		//댓글 리스트 가져오기
		$.each(res, function(index, value){
	         if(value.rupload != null){
	            var start = value.rupload.indexOf('_')+1;
	            var end = value.rupload.length;
	            var rup = value.rupload.substring(start, end);
	            var source = '<li class="time_sub" id="{{rno}}"><p>{{replyer}}</p><p>{{replytext}}</p><p>{{newDate regdate}}</p><p>'+rup+'</p><p><button id="{{rno}}">delete</button> <button id="{{rno}}">update</button></p></li>';
	         } else {
	            //annotation사용시 new Date(), newDate 빼야함
	            //$('.timeline').append('<li class="time_sub" id="'+value.rno+'"><p>'+value.replyer+'</p><p>'+value.replytext+'</p><p>'+new Date(value.regdate)+'</p><p><button id="'+value.rno+'">delete</button><button id="'+value.rno+'">update</button></p></li>');
	            var source = '<li class="time_sub" id="{{rno}}"><p>{{replyer}}</p><p>{{replytext}}</p><p>{{newDate regdate}}</p><p><button id="{{rno}}">delete</button> <button id="{{rno}}">update</button></p></li>';
	         }
	         var template = Handlebars.compile(source);
	         $('.timeline').append(template(value));
	   });
	}
	
	function reply_list() {
		if($('#newReplyWriter').val()==''){
			alert('writer를 작성하세요.');
			return false;
		}
		
		if($('#newReplyText').val()==''){
			alert('Reply text를 작성하세요.');
			return false;
		}
		
		//첨부파일
		var form_data = new FormData();
		form_data.append('bno', '${boardDTO.bno}');
		form_data.append('replyer', $('#newReplyWriter').val());
		form_data.append('replytext', $('#newReplyText').val());
		
		//첨부파일은 배열로 처리가 됨, 첨부파일이 있는지 없는지부터 확인
		// //https://www.javascripture.com/FormData#Constructors
		//if($('#filename')[0].files[0] != undefined) {
		//	form_data.append('filename', $('#filename')[0].files[0]);
			              //replyDTO의 filename
		//}
		
		if(fileList != '') {
			form_data.append('filename', fileList);
		}
		
		$.ajax({
			type:'POST',
			dataType:'json',
			url:'replyInsertList.do',
			data: form_data,
			// 인코딩 타입을 지정하지 않으면 application이다. 
	        // 첨부파일이 있을때는 multipart/form_data 로 지정해주어야 한다.
			enctype: 'multipart/form-data',
			contentType: false,
			processData: false, //첨부파일 시 기본적으로 자동으로 처리가 되도록 하면 안됨, 첨부파일이 있을 때는 일반적인 방법으로 파라미터를 넘기면 안된다 
			success:reply_list_result
		});
		
		$('#newReplyWriter').val('');
		$('#newReplyText').val('');
		$('.fileDrop').empty();
	}
</script>
</head>
<body>
	<div class="wrap">
		<!-- class="box-body" 시작 -->
		<div class="box-body">
			<div class="form-group">
				<label>Title</label> 
				<input type="text"	name='title' class="form-control" 
				       value="${boardDTO.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="3"
					readonly="readonly">${boardDTO.content}</textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input type="text"
					name="writer" class="form-control" 
					value="${boardDTO.writer}" readonly="readonly">
			</div>
		</div>
		<!-- class="box-body" 끝 -->
		
		<!--class="box-footer" 시작  -->
		<div class="box-footer">
			<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			<button type="submit" class="btn btn-primary" id="goListBtn">GO LIST </button>
		</div>
		<!-- class="box-footer" 끝 -->
		<hr/>
		
		<!-- box box-success 시작 -->
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
		  
			<div class="box-body">
				<label for="newReplyWriter">Writer</label> 
				<input	class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
				<label for="newReplyText">Reply Text</label> 
				<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
				<!-- <label for="filename">Upload</label> 
				<input type="file" id="filename" name="filename" /> -->
				
				<div>
					<span id="userpc" style="cursor:pointer">내PC</span>
				</div>
				<div class='fileDrop'></div>
			</div>
		
			<div class="box-footer">
				<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
			</div>		
		</div>
		<!-- box box-success 끝 -->
		<hr/>
		
	  <ul class="timeline">				
		<li class="time-label" id="repliesDiv">
	 	  <span class="bg-green">Replies List 
	 	  <small id='replycntSmall'> 
	 	   [ ${fn:length(boardDTO.replyList)} ] 
	 	  </small></span>
	 	</li>
	 	
	   <c:forEach items="${boardDTO.replyList}" var="replyDTO">
		<li class="time_sub"  id="${replyDTO.rno}">
		 <p>${replyDTO.replyer}</p>
		 <p>${replyDTO.replytext}</p>
		 <p><fmt:formatDate pattern="yyyy/M/d" dateStyle="short"
			    			value="${replyDTO.regdate}" /></p>
		 
		 <!-- 첨부파일  -->
		 <c:if test="${replyDTO.rupload!=null}">
		 	<p>
		 		<c:set var="numload" value="${fn:indexOf(replyDTO.rupload,'_')+1}" />
                <c:set var="strlength" value="${fn:length(replyDTO.rupload)}" />
                     ${fn:substring(replyDTO.rupload,numload,strlength)}
		 		<!-- function 에서 substring은 시작값 명시 다음 꼭 길이값이 있어야 한다 (길이값 인덱스미만 까지)-->
		 	</p>
		 </c:if>
		 
		 <p>
		   <button id="${replyDTO.rno}">delete</button>
		   <button id="${replyDTO.rno}">update</button></p>			 	 
	   </li>
	  </c:forEach> 
	  </ul>
	</div>
	
	<!-- Model -->
		<!-- Modal -->
		<div id="modifyModal">			
			<p>
				<label for="updateReplyText">Reply Text</label> 
				<input class="form-control" type="text" 
				       placeholder="REPLY TEXT" id="updateReplyText">
			</p>
			<p>			    
				<button id="btnModify">Modify</button>
				<button id="btnClose">Close</button>
			</p>
		</div>	
</body>
</html>
