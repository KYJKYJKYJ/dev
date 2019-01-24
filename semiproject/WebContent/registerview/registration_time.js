$(document).ready(function(){
	$('#test').on('click',selectProcess);
		//선택후 DB에서 비교-> register에서 예약됐는지 확인 =>일치하는 값이 있다면 해당시간을 none으로
});

function selectProcess(){
	$.ajax({
		type:'GET',
		dataType:'text', 
		url:'../ReTimeActionn',
		data:'sports='+$('#sports').val()+'&datepicker='+ $('#datepicker').val(),
		success:function(res){
			//alert($('#sports').val()+$('#datepicker').val());
			$('#time').html(res);
		}
	});
}//end process
