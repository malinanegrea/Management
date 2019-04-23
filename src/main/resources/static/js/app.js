/**
 * 
 */
$(document).ready(function() {

	$('.table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(app, status) {
			$('.myForm #identifier').val(app.identifier);
			//$(".myForm #identifier").prop("readonly", true);
			$('.myForm #name').val(app.name);
			$('.myForm #technology').val(app.technology);
			$('.myForm #version').val(app.version);
		});
		$('.myForm #exampleModal').modal();

	});

	$('.nBtn').on('click', function(event) {
		event.preventDefault();
		$('.mySecondForm #name').val('');
		$('.myForm #technology').val('');
		$('.myForm #version').val('');
		$('.mySecondForm #exampleModal').modal();

	});
	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();
	});
});