/**
 * 
 */
$(document).ready(function() {

	$('.nBtn').on('click', function(event) {
		event.preventDefault();
		$('.mySecondForm #').val('');
		$('.mySecondForm #username').val('');
		$('.mySecondForm #password').val('');
		$('.mySecondForm #exampleModal').modal();
	
	});
	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();
	});	
});