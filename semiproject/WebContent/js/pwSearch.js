$(document).ready(function(){
	$('#pwSearchbtn').on('click',process);
});

function process(){
	//alert(param);
	$.ajax({
		type:'GET',
		dataType:'text',
		data:'user_id='+$('#user_id').val()+'&user_email='+$('#user_email').val(),
		url:'../PwSearchgo',
		success:function pass(res){
			alert(res);
		}
	});
	alert("비밀번호를 검색했습니다");
}

