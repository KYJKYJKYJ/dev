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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<script type="text/javascript">
	var urno='';
	
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
			//annotation사용시 new Date(), newDate 빼야함
			//$('.timeline').append('<li class="time_sub" id="'+value.rno+'"><p>'+value.replyer+'</p><p>'+value.replytext+'</p><p>'+new Date(value.regdate)+'</p><p><button id="'+value.rno+'">delete</button><button id="'+value.rno+'">update</button></p></li>');
			var source = '<li class="time_sub" id="{{rno}}"><p>{{replyer}}</p><p>{{replytext}}</p><p>{{newDate regdate}}</p><p><button id="{{rno}}">delete</button> <button id="{{rno}}">update</button></p></li>';
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
		
		$.ajax({
			type:'POST',
			dataType:'json',
			url:'replyInsertList.do',
			data:"bno=${boardDTO.bno}&replyer="+$('#newReplyWriter').val()
					+"&replytext="+$('#newReplyText').val(),
			success:reply_list_result
		});
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
