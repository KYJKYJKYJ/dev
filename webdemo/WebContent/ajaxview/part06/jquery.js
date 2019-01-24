var titleNum;

$(document).ready(function() {
			// 댓글입력
	$('#btnInput').on('click',function() {
		// 화면이 이동하면 안되기 때문에 ajax로 해야함
		$.ajax({
			type : 'POST',
			dataType : 'text',
			url : 'commentInput',
			data : 'num=' + titleNum + '&content='+ $('#textInput').val(),
			// 정상적으로 성공되었으면 메세지 뿌려주기~
			success:inputMessage
		});
	});// 댓글 입력 끝!

		// 수정버튼에 동적이벤트 등록
		$(document).on('click', '[value="수정"]', function() {
			$('#divUpdate').css({'display' : 'block'});
			$('#commentAdd').css({'display' : 'none'});

			// 현재 이벤트 발생할 곳에서 부모를 가져오기(추가한 div)
			var selEle = $(this).parent();

			// p자식요소를 보여주기??
			$('#textCol').val(selEle.children('p:nth-child(1)').text());
			$('#textUpdate').val(selEle.children('p:nth-child(2)').text());

			});

			// 댓글 수정 버튼
			$('#btnUpdate').on('click',function() {
				$.ajax({
					type : 'POST',
					dataType : 'text',
					url : 'commentUpdate',
					data : 'col=' + $('#textCol').val() + '&content='+ $('#textUpdate').val() + '&num='+ titleNum,
					success:updateMessage

				});
			});

			// 댓글 수정 응답
			function updateMessage(res) {
				$('#commentList').empty();
				listView(res);
				$('#divUpdate').css({'display':'none'});
				$('#commentAdd').css({'display':'block'});

			};// end updateMessage()
			
			
			$(document).on('click','[value="삭제"]',function(){
				var selEle=$(this).parent();
				$('#textCol').val(
						selEle.children('p:nth-child(1)').text());
				$.ajax({
					type:'GET',
					dataType : 'text',
					url:'commentDelete?col='+$('#textCol').val()+'&num='+titleNum,
					success:deleteMessage
				});
			});
		}); // end ready()

//댓글 삭제응답
function deleteMessage(res) {
	$('#commentList').empty();
	listView(res);

}// end deleteMessage()

// 댓글 삽입 응답
function inputMessage(res) {
	// commentList에 있는 자식들을 삭제하기
	$('#commentList').empty();
	

	// listView를 호출하면서 res값을 넘겨주기(res = num값)
	listView(res);
	$('#textInput').val("");

	
};// end inputMessage()

// 댓글 리스트 요청
function listView(num) {
	titleNum = num;
	$.ajax({
		type : 'GET',
		dataType : 'json',
		url : 'commentList?num=' + num,
		success : viewMessage
	});
}// end listView

// 댓글 리스트 응답
function viewMessage(res) {
	// 받아오는 값 확인하기 / json이라서 object로 나옴... 확인해보려면 dataType를 'text'로 수정해준다.
	// alert(res);

	for (index in res) {
		var div = $('<div></div>');
		$('#commentList').append(div);
		var p1 = $('<p>' + res[index].col + '</p>');
		$(div).append(p1);
		var p2 = $('<p>' + res[index].content + '</p>');
		$(div).append(p2);

		// 
		var inputupdate = $('<input type = "button" value = "수정"/>');
		$(div).append(inputupdate);
		var inputdelete = $('<input type="button" value = "삭제"/>');
		$(div).append(inputdelete);
	}

}// end viewMessage()
