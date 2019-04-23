/**
 * 
 */

$(document).ready(function() {

	$('.table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		
			 $.get(href, function(user, status) {
				$('.myForm #identifier').val(user.identifier);
				$(".myForm #identifier").prop("readonly", true);
				$('.myForm #name').val(user.name);
				$('.myForm #username').val(user.username);
				$('.myForm #password').val(user.password);
				//$('.myForm #applications').val(user.applications);
				//$(".myForm #applications").prop("readonly", true);
			});
			$('.myForm #exampleModal').modal();
	
	});

	$('.nBtn').on('click', function(event) {
		event.preventDefault();
		$('.mySecondForm #name').val('');
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