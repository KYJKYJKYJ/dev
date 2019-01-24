$(document).ready(function(){
   $('#btn').on('click',process);
});////////////////////////////

function process(){
   $.ajax({
      type:'GET',
      dataType:'text',
      url:'customer?name='+$('#name').val(),
      success:function(res){
    	  //alert(res);
         $('div').html(res);
      }
   });
}//end process()///////////////////////////////