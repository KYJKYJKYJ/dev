$(document).ready(function() {
	$('#notice_write_btn').on('click', notice_write);
});

function notice_write(){
	$.ajax({
		type:'GET',
		dataType: 'text',
		url:'notice_write.jsp',
		success:viewMessage
	});
}

function viewMessage(res) {
	$('#notice_table').html(res);
}
