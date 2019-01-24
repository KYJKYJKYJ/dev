$(document).ready(function() {
   $('#btn').on('click', process);
});// ////////////////////////

function process() {
   $.ajax({
      type : 'GET',
      dataType : 'text',
      url : 'searchProcess?data='+$('#data').val(),
      success : viewMessage
   });
}// end process()//////////

function viewMessage(result) {
	$("#wrap").html(result);
}

/*
 * var str=$("form").serialize(); //form에 있는 객체 데이터를 직렬화 serialize() : 데이터들을 하나의
 * 문자형태로 전송(queryString) e.g. id = kim&pass = 1234
 */