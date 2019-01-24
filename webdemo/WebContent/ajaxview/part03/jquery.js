$(document).ready(function(){
	$('#btn').on('click',process);
});///////////////////////////

function process(){
	var param=$('form').serialize();
	$.ajax({
		type:'POST',
		dataType:'text',
		//data:'id='+$('$id').val()+'&pass='+$('#pass').val(),
		data:param,
		url:'loginProcess',
		success:function(res){
			$('div').html(res);
		}
	});
}	//end process()/////////////////////