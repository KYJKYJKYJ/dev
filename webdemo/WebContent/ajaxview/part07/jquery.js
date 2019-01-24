var isEnd = false;
var cnt=0;
var pm=1;
$(document).ready(function(){
		$(window).scroll(function() {
			
			
			var scrollTop = $(window).scrollTop();
			var windowHeight = $(window).height();
			var documentHeight = $(document).height();
			console.log("documentHeight:" + documentHeight +
					    " | scrollTop:" +scrollTop +
					    " | windowHeight: " + windowHeight);

			// scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
			if (scrollTop + windowHeight + 30 > documentHeight) {
				pm++;
				console.log("pm:"+pm);
				fetchList();
			}
		});//end scroll()///////////////
		
		fetchList();
});//end ready()///////////////////////////////

	var fetchList = function() {
		if (isEnd == true) {
			return;
		}

		// 방명록 리스트를 가져올 때 시작 번호
		// renderList 함수에서 html 코드를 보면 <li> 태그에 data-no 속성이 있음.
		// ajax에서는 data- 속성의 값을 가져오기 위해 data() 함수를 제공.
		var startNo = $("#list-guestbook li").last().data("no")+1 || 1;
           
		$.ajax({
			url : 'datascroll?startRow='+startNo+'&cntRow=10',
			type : 'POST',
			dataType : 'json',
			success : function(result) {
				//alert(result)
				// 컨트롤러에서 가져온 방명록 리스트는 result에 담겨오도록 했다.
				// 남은 데이터가 10개 이하일 경우 무한 스크롤 종료

				var length = result.length;
				cnt+=length;
				if (length < 10) {
					isEnd = true;
				}

				$.each(result, function(index, vo) {
					renderList(vo);
				});
			}
		});
	}//end fetchList()/////////////////

	var renderList = function(vo) {		
		// 리스트 liElement을 정의
		var liElement = $("<li data-no='"+ cnt +"'></li>");  
		liElement.append($("<p>"+ vo.employee_id+"</p>"));
		liElement.append($("<strong>" + vo.first_name + "</strong>"));
		liElement.append($("<p>" + vo.salary+"</p>")); 
		liElement.append($("<a href='#' data-no='"+ vo.employee_id +"'>삭제</a>"));
			
		$("#list-guestbook").append(liElement);		
	}//end renderList()/////////////