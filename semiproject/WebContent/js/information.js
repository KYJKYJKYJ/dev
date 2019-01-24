$(document).ready(function(){
		$(window).scroll(function() {
						
			var scrollTop = $(window).scrollTop();
			var windowHeight = $(window).height();
			var documentHeight = $(document).height();

			// scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
			if (scrollTop + windowHeight + 30 > documentHeight) {
				fetchList();
			}
		});//end scroll()///////////////	
		fetchList();
});//end ready()///////////////////////////////

var fetchList = function() {
    
	for(var i = 1; i < 11; i++) {
    $.ajax({
    	url : 'information.do?num=' + i,
    	type : 'POST',
    	dataType : 'json',
    	success : function(result) {  
    		$.each(result, function(index, dto) {
    			renderList(dto);	
    		});
    	}
    });
	}
}//end fetchList()/////////////////

var renderList = function(dto) {		
	var div1=$("<div style='padding-top: 50px;'>< " + dto.info_text + " ></div>");
	var div2=$("<div style='border: 5px solid black; width: 910px;'>" +
			"<img src='" + dto.info_upload + "' width=900px height=auto /></div>");
	$(div1).appendTo("#content1");	
	$(div2).appendTo("#content1");
	
	
}//end renderList()/////////////








/*$(document).ready(function() {
   var page = 1;

    //페이지가 로딩이 되면 page에 1씩 더하면서 20개 스크롤 로딩 하고 무한 스크롤 함수 바인딩 
   // 바인딩 : 각종 값들이 확정되어 더 이상 변경할 수 없는 구속(bind) 상태가 되는 것 
   for (var i = 1; i <= 10; i++) {
      page = i;
      
      $("<h1>" + page + " line scroll</h1>").appendTo("#content");

      if (page == 10) {
         $(window).bind("scroll", infinityScroll);
      }
   }
   
   function infinityScroll() {
      // 현재문서의 높이를 구함.
      var documentHeight = $(document).height();
      console.log("documentHeight : " + documentHeight);

      // scrollTop() 메서드는 선택된 요소의 세로 스크롤 위치를 설정하거나 반환
      // 스크롤바가 맨 위쪽에 있을때 , 위치는 0
      console.log("window의 scrollTop() : " + $(window).scrollTop());
      // height() 메서드는 브라우저 창의 높이를 설정하거나 반환
      console.log("window의 height() : " + $(window).height());

      // 세로 스크롤위치 max값과 창의 높이를 더하면 현재문서의 높이를 구할수있음.
      // 세로 스크롤위치 값이 max이면 문서의 끝에 도달했다는 의미
      var scrollHeight = $(window).scrollTop() + $(window).height();
      console.log("scrollHeight : " + scrollHeight);

      if (scrollHeight == documentHeight) { // 문서의 맨끝에 도달했을때 내용 추가
         for (var i = 1; i <= 10; i++) {
            // page = page + 1;
            page++;
            // $("<h1> infinity scroll </h>").appendTo("body");
            $("<h1>" + page + " line scroll</h1>").appendTo("#content");
         }
      }
   }
});*/
/*
$(document).ready(function() {
   $(window).bind("scroll", infinityScroll);
   
   function infinityScroll() {
      var scrollHeight = $(window).scrollTop() + $(window).height();
      var documentHeight = $(document).height();
      
      if (scrollHeight == documentHeight) { // 문서의 맨끝에 도달했을때 내용 추가
         for (var i = 1; i <= 10; i++) {
            $.ajax({
               type: 'get',
               dataType: 'text',
               url: '../load',
               data: 'num=' + i,
               success: function load(res) {
                  var div=$('<div>test</div>');
                  $(div).appendTo("#here");
                  $(res).appendTo("#here");
               }
            });
         }
      }
   }
});*/