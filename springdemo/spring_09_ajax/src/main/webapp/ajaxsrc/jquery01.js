$(document).ready(function() {
	$('#btn').on('click', process);
});

function process() {
	$.ajax({
		type: 'GET',
		url: 'customer.do?name=' + $('#name').val(),
		dataType: 'text',
		success:function(res) {
			$('div').html(res);
		}
	});
}