$(document).ready(function() {
   $('#searchbtn').on('click', process);
});// ///////////////////////////////////

function process() {
   //var param = $('form').serialize();
   $.ajax({
      type : 'GET',
      dataType : 'text',
      data : 'user_name='+$('#user_name').val()+'&user_email='+$('#user_email').val(),
      url : '../IDsearch',
      success : function(res) {
         alert(res);
      }
   });
   alert("ID를 검색했습니다.");
}// end process//////////////////////////